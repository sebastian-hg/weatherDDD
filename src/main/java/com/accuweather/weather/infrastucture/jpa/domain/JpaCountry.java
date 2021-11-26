package com.accuweather.weather.infrastucture.jpa.domain;

import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Builder.Default
    private Long id = 0L;
    private Long idSource;
    private String name;
    private Integer postalCode;


}
