package com.accuweather.weather.infrastucture.jpa.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CITY")
public class JpaCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToOne
    @JoinColumn(name = "CITY_COUNTRY")
    JpaCountry jpaCountry;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WEATHER_CONDITION_ID", referencedColumnName = "ID")
    JpaWeatherCondition jpaWeatherCondition;

}
