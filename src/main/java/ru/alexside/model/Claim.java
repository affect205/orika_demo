package ru.alexside.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
@Entity
@Table(name = "OM_CLAIMS")
public class Claim {
    @Id
    @SequenceGenerator(name = "SEQ_OM_CLAIMS_ID", allocationSize = 1, sequenceName = "SEQ_OM_CLAIMS_ID")
    @GeneratedValue(generator = "SEQ_OM_CLAIMS_ID", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private Long claimGroupId;
    @Column
    private String description;
    @Column
    private String claimStatus;
    @Column
    private LocalDateTime createdDate;
}
