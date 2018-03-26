package ru.alexside.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
public class RpoHeaderFull {

    private Long id;

    private String type;

    private String proNumber;

    private Long carrierId;

    private Long gpoId;

    private String zip5From;

    private String zip5To;

    private String stopGroupId;

    private String claimGroupId;

    private String costGroupId;

    private String logGroupId;

    private List<StopFull> stops;

    private StateFull state;

    private RouteFull route;

    private List<CostFull> costs;

    private List<ClaimFull> claims;

    private LocalDateTime postTime;

    private String transportType;

    private BigDecimal totalCost;

    private BigDecimal fuelCost;

    private BigDecimal lineHaulCost;

    private BigDecimal teamDriveCost;

    private List<ServiceFull> services;
}
