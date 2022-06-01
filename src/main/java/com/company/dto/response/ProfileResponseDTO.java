package com.company.dto.response;

import com.company.dto.request.ProfileRequestDTO;
import com.company.enums.ProfileStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProfileResponseDTO extends ProfileRequestDTO {
    private String id;
    private LocalDateTime createdDate;
    private ProfileStatus status;
}