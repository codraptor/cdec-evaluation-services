package com.cdec.validator.dal.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class WikidataEntityId implements Serializable {

    @Column(name = "node")
    private String node;

    @Column(name = "language")
    private String language;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WikidataEntityId that = (WikidataEntityId) o;
        return node.equals(that.node) && language.equals(that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, language);
    }

    @Override
    public String toString() {
        return "WikidataEntityId{" +
                "node='" + node + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

}
