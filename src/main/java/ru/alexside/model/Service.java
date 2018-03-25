package ru.alexside.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
@Entity
@Table(name = "OM_SERVICES")
public class Service {
    @Id
    @SequenceGenerator(name = "SEQ_OM_SERVICES_ID", allocationSize = 1, sequenceName = "SEQ_OM_SERVICES_ID")
    @GeneratedValue(generator = "SEQ_OM_SERVICES_ID", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "GPO_HEADER_ID")
    private GpoHeader gpoHeader;

    @ManyToOne
    @JoinColumn(name = "STOP_POINT_ID")
    private Stop stopPoint;

    @Column
    private UUID serviceUuid;

    @Column
    private Long serviceQty;

    @Column
    private BigDecimal rateCost;

    @Column
    private BigDecimal totalCost;

    /**
     * Заполняется в случае, если у сервиса в MDM параметер ShowToCarrier = true
     */
    @Column
    private Long rpoHeaderId;
}
