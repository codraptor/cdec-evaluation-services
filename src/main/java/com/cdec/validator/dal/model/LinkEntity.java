package com.cdec.validator.dal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "links")
@NoArgsConstructor
@AllArgsConstructor
public class LinkEntity {

    @Id
    @Column(name = "id")
    private String id;

//    @Column(name = "node")
//    private String node;
//
//    @Column(name = "language")
//    private String language;

    @Column(name = "inlink_title")
    private String inlinkTitle;

    @Column(name = "context")
    private String context;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "response")
    private String response;

    @Column(name = "updated_time", length = 200)
    private Timestamp updatedTime;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="node", referencedColumnName="node"),
            @JoinColumn(name="language", referencedColumnName="language")
    })
    private WikidataEntity wikidata;

}
