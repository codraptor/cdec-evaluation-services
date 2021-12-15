package com.cdec.validator.dal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Data
@Entity
@Table(name = "wikidata")
@NoArgsConstructor
@AllArgsConstructor
public class WikidataEntity {

    @EmbeddedId
    private WikidataEntityId id;

    @Column(name = "label")
    private String label;

    @Column(name = "description")
    private String description;

    @Column(name = "wikipedia_title")
    private String wikipediaTitle;

    @Column(name = "wikipedia_description")
    private String wikipediaDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WikidataEntity that = (WikidataEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "WikidataEntity{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", wikipediaTitle='" + wikipediaTitle + '\'' +
                ", wikipediaDescription='" + wikipediaDescription + '\'' +
                '}';
    }
}
