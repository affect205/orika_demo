package ru.alexside.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
@Entity
@Table(name = "OM_GPO_HEADERS")
public class GpoHeader {
    @Id
    @SequenceGenerator(name = "SEQ_OM_GPO_HEADERS_ID", allocationSize = 1, sequenceName = "SEQ_OM_GPO_HEADERS_ID")
    @GeneratedValue(generator = "SEQ_OM_GPO_HEADERS_ID", strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(mappedBy = "gpoHeader")
    private List<RpoHeader> rpoHeaders = new ArrayList<>();
    @OneToOne
    private Contact shipper;
    @Column(name = "ZIP5_FROM")
    private String zip5From;
    @Column(name = "ZIP5_TO")
    private String zip5To;
    @OneToMany
    @JoinColumn(name = "stopGroupId", referencedColumnName = "stopGroupId")
    private List<Stop> stops = new ArrayList<>();
    @Column
    private String stopGroupId;
    @Column
    private String costGroupId;
    @Column
    private String claimGroupId;
    @Column
    private String logGroupId;
    @ManyToOne(fetch = FetchType.EAGER)
    private State state;
    @Column
    private Long termsId;
    @ManyToOne
    private Route route;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "gpoHeader")
    private List<Service> services;
    @Column
    private Long contractId;
    @Column
    private BigDecimal totalDistance;
    @Column
    private Long totalTime;
    @Column
    private Integer totalWeight;
    @Column
    private Double weightUom;
    @Column
    private Integer totalLength;
    @Column
    private Integer totalWidth;
    @Column
    private Integer totalHeight;
    @Column
    private String proNumber;
    @Column
    private String transportTypeUuid;
    @Column
    private String specialInstructions;
    @Column
    private Integer unitQty;
    @Column
    private Integer temperatureLow;
    @Column
    private Integer temperatureHigh;
    @Column
    private BigDecimal teamDriveParameter;
    @Column
    private BigDecimal sumInsured;
    @Column
    private Boolean manualProcessing;
    @Column
    private String transportRequestJson;
    @Column
    private String acceptedSolutionJson;
    @Enumerated(EnumType.STRING)
    private PoType poType = PoType.GREEN_PO;
    @Column
    private String specialFlags = "NO";
    @Column
    private Boolean teamDrive;
    @Column
    private BigDecimal totalCost;
    @Column
    private BigDecimal fuelCost;
    @Column
    private BigDecimal lineHaulCost;
    @Column
    private BigDecimal feeCost;
    @Column
    private BigDecimal teamDriveCost;
}

