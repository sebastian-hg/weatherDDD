package com.accuweather.weather.infrastucture.jpa.domain;

import com.accuweather.weather.core.model.City;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Builder
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaWeatherCondition that = (JpaWeatherCondition) o;
        return Objects.equals(id, that.id) && Objects.equals(temperature, that.temperature) && Objects.equals(wind, that.wind) && Objects.equals(humidity, that.humidity) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temperature, wind, humidity, time);
    }

    @Override
    public String toString() {
        return "JpaWeatherCondition{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", wind=" + wind +
                ", humidity=" + humidity +
                ", time=" + time +
                '}';
    }
}
