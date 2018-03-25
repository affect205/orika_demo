package ru.alexside.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
@Entity(name = "OM_CONTACT_HEADERS")
public class Contact {

    private static final String SEQUENCE_NAME = "OM_CONTACT_HEADERS_S";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME, allocationSize = 1, sequenceName = SEQUENCE_NAME)
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String type;

    @Column
    private String name;

    @Column
    private String companyName;

    @Column
    private String description;

    @OneToMany(mappedBy = "contactHeader")
    private List<String> details = new ArrayList<>();
}
