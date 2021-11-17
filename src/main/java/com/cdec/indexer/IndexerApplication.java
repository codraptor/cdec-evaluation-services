package com.cdec.indexer;

import com.cdec.indexer.dal.DatabaseService;
import com.cdec.indexer.model.Cluster;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.InputStreamReader;

@SpringBootApplication
public class IndexerApplication implements CommandLineRunner {

    private static final Gson GSON = new Gson();

    private DatabaseService databaseService;

    @Autowired
    public IndexerApplication(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public static void main(String[] args) {
        SpringApplication.run(IndexerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        JsonReader reader = new JsonReader(
                new InputStreamReader(
                        new FileInputStream("data/xlec-v0.json"), "UTF-8"));

        int count = 0;
        reader.beginObject();

        while (reader.hasNext()) {

            String node = reader.nextName();
            Cluster cluster = GSON.fromJson(reader, Cluster.class);
            System.out.println(node);
            cluster.setNode(node);

            databaseService.addCluster(cluster);

            count++;
            System.out.println(count);

        }

        reader.endObject();
        reader.close();

    }

}
