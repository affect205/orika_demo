package ru.alexside.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
public class ServiceFull {
    private Long id;
    private Long stopId;
    private String serviceUuid;
    private Long serviceQty;
    private BigDecimal rateCost;
    private BigDecimal totalCost;
    private Long rpoHeaderId;
}
