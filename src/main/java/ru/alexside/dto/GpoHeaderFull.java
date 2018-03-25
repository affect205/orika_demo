package ru.alexside.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import ru.alexside.model.PoType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GpoHeaderFull {

    private Long id;

    private List<RpoHeaderFull> rpoHeaders = new ArrayList<>();

    private ContactFull shipper;

    private String zip5From;

    private String zip5To;

    private List<StopFull> stops;

    private StateFull state;

    private Long termsId;

    private RouteFull route;

    private List<CostFull> costs;

    private List<ClaimFull> claims;

    private List<ServiceFull> services;

    private Long contractId;

    private BigDecimal totalDistance;

    private Long totalTime;

    private Integer totalWeight;

    private Double weightUom;

    private Integer totalLength;

    private Integer totalWidth;

    private Integer totalHeight;

    private OffsetDateTime createdDate;

    private String proNumber;

    private String specialInstructions;

    private Integer unitQty;

    private Integer temperatureLow;

    private Integer temperatureHigh;

    private BigDecimal teamDriveParameter;

    private Boolean manualProcessing;

    private PoType poType;

    private Boolean teamDrive;

    private BigDecimal totalCost;

    private BigDecimal fuelCost;

    private BigDecimal lineHaulCost;

    private BigDecimal feeCost;

    private BigDecimal teamDriveCost;
}
