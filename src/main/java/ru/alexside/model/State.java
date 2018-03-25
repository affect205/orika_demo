package ru.alexside.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 25.03.2018.
 */
@Getter
@Setter
@Entity
@Table(name = "OM_STATES")
public class State {

    private static final String SEQUENCE_NAME = "SEQ_OM_STATES_ID";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME, allocationSize = 1, sequenceName = SEQUENCE_NAME)
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StateCodes code;

    @Column
    private String stateName;

    @Enumerated(EnumType.STRING)
    private PoType stateType;

    @Column
    private Boolean initialState;
}
