package ru.alexside.dto;

import lombok.Data;
import ru.alexside.model.CostType;

import java.math.BigDecimal;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
public class CostFull {
    private Long id;
    private Long gpoServiceId;
    private String costGroupId;
    private CostType costType;
    private BigDecimal totalCost;
    private BigDecimal rateCost;
    private BigDecimal penaltyCost;
    private Long receivedAmount;
}
