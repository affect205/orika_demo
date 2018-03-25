package ru.alexside.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by Alex on 25.03.2018.
 */
@Data
public class ClaimFull {
    private Long id;
    private Long claimGroupId;
    private String description;
    private String claimStatus;
    private LocalDateTime createdDate;
}
