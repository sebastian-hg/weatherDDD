package com.accuweather.weather.infrastucture.jpa.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "WEATHER_CONDITION")
public class JpaWeatherCondition {
    @Id
    private Long id;
    private Double temperature;
    private Double wind;
    private Double humidity;
    private LocalDateTime time;

}
