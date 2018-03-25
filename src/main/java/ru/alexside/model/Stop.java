package ru.alexside.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
@Entity
@Table(name = "OM_STOPS")
public class Stop {
    @Id
    @SequenceGenerator(name = "SEQ_OM_STOPS_ID", allocationSize = 1, sequenceName = "SEQ_OM_STOPS_ID")
    @GeneratedValue(generator = "SEQ_OM_STOPS_ID", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String stopGroupId;
    @Column
    private String address;
    @Column
    private Double longitude;
    @Column
    private Double latitude;
    @Column
    private Integer stopOrder;
    @Column
    private Integer stopType;
    @Column
    private Duration waitTime;
    @Column
    private Duration layoverTime;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "OM_GPO_CONTACTS",
            joinColumns = {@JoinColumn(name = "STOP_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "CONTACT_HEADER_ID", nullable = false, updatable = false)})
    private List<Contact> contacts = new ArrayList<>();
}
