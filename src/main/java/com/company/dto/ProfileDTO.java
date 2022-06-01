package com.company.dto;

import com.company.dto.response.AttachResponseDTO;
import com.company.enums.ProfileRole;
import com.company.enums.ProfileStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDTO {
    private String id;
    private boolean visible;
    private LocalDateTime createdDate;
    private String name;
    private String surname;
    private String phone;
    private String password;
    private ProfileRole role;
    private ProfileStatus status;
    private String jwt;
    private AttachResponseDTO attach;
}
