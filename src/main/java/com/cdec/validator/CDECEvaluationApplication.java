package com.cdec.validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CDECEvaluationApplication {

//    private static final Gson GSON = new Gson();
//
//    private DatabaseService databaseService;
//
//    @Autowired
//    public CDECEvaluationApplication(DatabaseService databaseService) {
//        this.databaseService = databaseService;
//    }

    public static void main(String[] args) {
        SpringApplication.run(CDECEvaluationApplication.class, args);
    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        JsonReader reader = new JsonReader(
//                new InputStreamReader(
//                        new FileInputStream("data/xlec-v1.json"), "UTF-8"));
//
//        int count = 0;
//        reader.beginObject();
//
//        while (reader.hasNext()) {
//
//            String node = reader.nextName();
//            Cluster cluster = GSON.fromJson(reader, Cluster.class);
//            System.out.println(node);
//            cluster.setNode(node);
//
//            databaseService.addCluster(cluster);
//
//            count++;
//            System.out.println(count);
//
//        }
//
//        reader.endObject();
//        reader.close();
//
//    }

}
