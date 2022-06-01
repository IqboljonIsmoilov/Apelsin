package com.company.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantRequestDTO {
    private String name;
    private String cardNumber;
    private Integer parsentage;
    private String phone;
    private String password;
    private String attachId;
    private String categoryId;
}
