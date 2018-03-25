package ru.alexside.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
@Entity
@Table(name = "OM_COSTS")
public class Cost {
    @Id
    @SequenceGenerator(name = "SEQ_OM_COSTS_ID", allocationSize = 1, sequenceName = "SEQ_OM_COSTS_ID")
    @GeneratedValue(generator = "SEQ_OM_COSTS_ID", strategy = GenerationType.SEQUENCE)
    private Long id;
    @JoinColumn(name = "costGroupId", referencedColumnName = "costGroupId")
    private String costGroupId;
    @Column
    private Long gpoServiceId;
    @Enumerated(EnumType.STRING)
    private CostType costType;
    @Column
    private BigDecimal totalCost;
    @Column
    private BigDecimal rateCost;
    @Column
    private BigDecimal penaltyCost;
    @Column
    private Long receivedAmount;
}
