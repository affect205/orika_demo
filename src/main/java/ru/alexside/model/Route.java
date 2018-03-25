package ru.alexside.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
@Entity
@Table(name = "OM_ROUTES")
public class Route {
    @Id
    @SequenceGenerator(name = "SEQ_OM_ROUTES_ID", allocationSize = 1, sequenceName = "SEQ_OM_ROUTES_ID")
    @GeneratedValue(generator = "SEQ_OM_ROUTES_ID", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String points;
}
