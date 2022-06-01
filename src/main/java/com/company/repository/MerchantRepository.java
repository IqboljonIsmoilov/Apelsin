package com.company.repository;

import com.company.entity.MerchantEntity;
import com.company.enums.MerchantStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantRepository extends JpaRepository<MerchantEntity, String> {
    Optional<MerchantEntity> findByNameAndStatus(String name, MerchantStatus status);
}