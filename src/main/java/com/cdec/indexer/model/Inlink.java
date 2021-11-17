package com.cdec.indexer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inlink {

    private String lang;
    private String mention;
    private String title;

}
