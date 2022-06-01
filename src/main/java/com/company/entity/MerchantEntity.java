package com.company.entity;

import com.company.enums.MerchantStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "merchant")
public class MerchantEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String cardNumber;
    @Column
    private Integer parsentage;
    @Column
    @Enumerated(EnumType.STRING)
    private MerchantStatus status;
    @Column
    private String phone;
    @Column
    private String password;

    @Column(name = "attach_id")
    private String attachId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attach_id", insertable = false, updatable = false)
    private AttachEntity attach;

    @Column(name = "category_id")
    private String categoryId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;

}
