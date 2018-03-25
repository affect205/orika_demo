package ru.alexside.dto;

import lombok.Data;
import ru.alexside.model.StateCodes;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
public class StateFull {
    private Long id;
    private String stateName;
    private StateCodes code;
    private String stateType;
}
