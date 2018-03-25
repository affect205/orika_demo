package ru.alexside.dto;

import lombok.Data;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
public class StopFull {

    private Long id;

    private String stopGroupId;

    private String address;

    private Double longitude;

    private Double latitude;

    private Integer stopOrder;

    private Integer stopType;

    private Duration waitTime;

    private ZonedDateTime openTime;

    private ZonedDateTime closeTime;

    private List<ContactFull> contacts;

    private Duration layoverTime;
}
