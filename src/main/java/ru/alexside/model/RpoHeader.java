package ru.alexside.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
@EqualsAndHashCode(exclude = {"gpoHeader"})
@ToString(exclude = {"gpoHeader"})
@Entity
@Table(name = "OM_RPO_HEADERS")
public class RpoHeader {
    @Id
    @SequenceGenerator(name = "SEQ_OM_RPO_HEADERS_ID", allocationSize = 1, sequenceName = "SEQ_OM_RPO_HEADERS_ID")
    @GeneratedValue(generator = "SEQ_OM_RPO_HEADERS_ID", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String proNumber;
    @ManyToOne
    private GpoHeader gpoHeader;
    @Column(name = "ZIP5_FROM")
    private String zip5From;
    @Column(name = "ZIP5_TO")
    private String zip5To;
    @Column
    private String stopGroupId;
    @Column
    private String costGroupId;
    @Column
    private String claimGroupId;
    @Column
    private String logGroupId;
    @ManyToOne
    private State state;
    @ManyToOne
    private Route route;
    @OneToMany
    @JoinColumn(name = "costGroupId", referencedColumnName = "costGroupId")
    private List<Cost> costs;
    @OneToMany(mappedBy = "claimGroupId")
    private List<Claim> claims;
    @Column
    private LocalDateTime postTime;
    @Column
    private UUID transportTypeUuid;
    private RpoType type;
    @Column
    private BigDecimal totalCost;
    @Column
    private BigDecimal fuelCost;
    @Column
    private BigDecimal lineHaulCost;
    @Column
    private BigDecimal teamDriveCost;

    @OneToMany(mappedBy = "rpoHeaderId")
    private List<Service> services;
}
