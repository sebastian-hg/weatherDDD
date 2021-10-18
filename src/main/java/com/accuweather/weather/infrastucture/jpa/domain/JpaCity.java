package com.accuweather.weather.infrastucture.jpa.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CITY")
public class JpaCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToOne
    @JoinColumn (name = "CITY_COUNTRY")
    JpaCountry jpaCountry;
    @ManyToOne
    @JoinColumn(name = "CITY_CONDITION")
    JpaWeatherCondition jpaWeatherCondition;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaCity jpaCity = (JpaCity) o;
        return Objects.equals(id, jpaCity.id) && Objects.equals(name, jpaCity.name) && Objects.equals(jpaCountry, jpaCity.jpaCountry) && Objects.equals(jpaWeatherCondition, jpaCity.jpaWeatherCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, jpaCountry, jpaWeatherCondition);
    }

    @Override
    public String toString() {
        return "JpaCity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jpaCountry=" + jpaCountry +
                ", jpaWeatherCondition=" + jpaWeatherCondition +
                '}';
    }
}
