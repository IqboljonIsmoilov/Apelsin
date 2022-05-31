package com.company.repository;

import com.company.entity.SmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsRepository extends JpaRepository<SmsEntity, String> {
}
