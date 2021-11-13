package com.accuweather.weather.infrastucture.jpa.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COUNTRY")
public class JpaCountry {
    @Id
    Long id;
    String name;
    Integer PostalCode;


}
