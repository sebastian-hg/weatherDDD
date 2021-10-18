package com.accuweather.weather.infrastucture.jpa.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COUNTRY")
public class JpaCountry {
    @Id
    Long id;
    String name;
    Integer PostalCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaCountry that = (JpaCountry) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(PostalCode, that.PostalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, PostalCode);
    }

    @Override
    public String toString() {
        return "JpaCountry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", PostalCode=" + PostalCode +
                '}';
    }
}
