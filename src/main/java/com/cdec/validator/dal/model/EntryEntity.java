package com.cdec.validator.dal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EntryEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "node")
    private String node;

    @Column(name = "language")
    private String language;

    @Column(name = "inlink_title")
    private String inlinkTitle;

    @Column(name = "context")
    private String context;

    @Column(name = "wikipedia_title")
    private String wikipediaTitle;

    @Column(name = "wikipedia_description")
    private String wikipediaDescription;

}
