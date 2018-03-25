package ru.alexside.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
public class ContactFull {
    private String type;
    private String name;
    private String companyName;
    private String description;
    private List<String> contacts = new ArrayList<>();
}
