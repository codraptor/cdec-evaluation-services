package com.cdec.validator.dal.repository;

import com.cdec.validator.dal.model.LinkEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@Repository
@Transactional
public interface LinkRepository extends CrudRepository<LinkEntity, String> {

    @Modifying
    @Query("update LinkEntity link set link.response = :response, link.updatedTime = :updatedTime, link.updatedBy =:updatedBy " +
            "where link.id = :id")
    void updateResponse(@Param("id") String id,
                        @Param("response") String response,
                        @Param("updatedBy") String updatedBy,
                        @Param("updatedTime") Timestamp updatedTime);

}
