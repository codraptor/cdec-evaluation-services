package com.cdec.validator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entry {

    private String id;
    private String node;
    private String language;
    private String inlinkTitle;
    private String context;
    private String updatedBy;
    private String response;
    private Timestamp updatedTime;
    private String wikipediaTitle;
    private String wikipediaDescription;

}
