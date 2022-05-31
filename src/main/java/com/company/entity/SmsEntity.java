package com.company.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class SmsEntity {

    @Column
    private String content;
    @Column
    private String phone;
}
