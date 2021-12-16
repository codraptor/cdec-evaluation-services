package com.cdec.validator.dal.service;

import com.cdec.validator.dal.model.EntryEntity;
import com.cdec.validator.dal.repository.LinkRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.sql.DataSource;
import java.sql.Timestamp;

@Service
public class LinkDao {

    private LinkRepository linkRepository;
    private final EntityManagerFactory entityManagerFactory;
    private final DataSource dataSource;

    @Autowired
    public LinkDao(LinkRepository linkRepository,
                   EntityManagerFactory entityManagerFactory,
                   DataSource dataSource) {

        this.linkRepository = linkRepository;
        this.entityManagerFactory = entityManagerFactory;
        this.dataSource = dataSource;

    }

    public void updateResponse(String id, String response, String updatedBy, Timestamp updatedTime) {
        linkRepository.updateResponse(id, response, updatedBy, updatedTime);
    }

    public EntryEntity getLink(String username) {

        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();

        javax.persistence.Query query = session.createNativeQuery("select l.id, l.node, l.language, l.inlink_title, " +
                "l.context, w.wikipedia_title, w.wikipedia_description from links l join wikidata w on " +
                "(l.node = w.node and l.language = w.language) join user_languages ul on ul.language = l.language " +
                "join user_details u on u.user_id = ul.user_id where l.response is null and u.username = '" + username + "' LIMIT 1", EntryEntity.class);

        try {

            EntryEntity result = (EntryEntity) query.getSingleResult();
            return result;

        } catch (NoResultException e) {
            return null;
        } finally {
            session.close();
        }

    }

}
