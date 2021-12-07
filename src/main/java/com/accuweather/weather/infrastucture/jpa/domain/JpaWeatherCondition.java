package com.accuweather.weather.infrastucture.jpa.domain;

import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private Long id=0L;
    private Double temperature;
    private Double wind;
    private Double humidity;
    private LocalDateTime time;

}
