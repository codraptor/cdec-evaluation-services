package com.cdec.validator.dal.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class UserLanguageEntityId implements Serializable {

    @Column(name = "user_id")
    private String id;

    @Column(name = "language", nullable = false, length = 20)
    private String language;

}
