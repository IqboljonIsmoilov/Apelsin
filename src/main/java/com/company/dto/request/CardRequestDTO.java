package com.company.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CardRequestDTO {


    private String name;
    private String number;
    private String expDate;

   // private Long balance;
    @NotBlank(message = "The profile Id should not be empty")
    private String profileId;
}