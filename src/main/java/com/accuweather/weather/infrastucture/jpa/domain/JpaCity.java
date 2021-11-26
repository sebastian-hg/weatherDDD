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
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CITY_COUNTRY")
    private JpaCountry jpaCountry;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WEATHER_CONDITION_ID", referencedColumnName = "ID")
    private JpaWeatherCondition jpaWeatherCondition;

}
