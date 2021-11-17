package com.cdec.indexer.dal;

import com.cdec.indexer.model.Cluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class DatabaseService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCluster(Cluster cluster) {

        insertNode(cluster.getNode());

        cluster.getWikipediaTitles()
                .forEach(page ->
                        insertTitle(cluster.getNode(), page.getLang(), page.getTitle())
                );

        cluster.getInlinks().forEach(inlink ->
                insertInLink(cluster.getNode(), inlink.getLang(), inlink.getTitle(), inlink.getMention())
        );

    }

    private int insertNode(String node) {

        String sql = "INSERT INTO nodes VALUES ('" + node + "')";
        return jdbcTemplate.update(sql);

    }

    private Boolean insertTitle(String node, String language, String text) {

        String sql = "INSERT INTO titles(node,lan,text) VALUES (?,?,?)";

        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

                ps.setString(1, node);
                ps.setString(2, language);
                ps.setString(3, text);

                return ps.execute();

            }
        });

    }

    private Boolean insertInLink(String node, String language, String title, String mention) {

        String sql = "INSERT INTO inlinks(node,lan,title,mention) VALUES (?,?,?,?)";

        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

                ps.setString(1, node);
                ps.setString(2, language);
                ps.setString(3, title);
                ps.setString(4, mention);

                return ps.execute();

            }
        });

    }

}
