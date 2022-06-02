package com.company.dto.response;

import com.company.dto.request.CardRequestDTO;
import com.company.enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardHttpResponseDTO extends CardRequestDTO {
    private String id;
    private String number;
    private LocalDateTime createdDate;
    private CardStatus status;
    private LocalDate expiryDate;
    private ProfileResponseDTO profile;
    private String phone;
}