package com.company.dto;

import com.company.dto.response.AttachResponseDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class MerchantDTO {
    private String id;
    private LocalDateTime createdDate;
    private String name;
    private String cardNumber;
    private Integer parsentage;
    private String phone;
    private String categoryId;
    private AttachResponseDTO attachDTO;
}
