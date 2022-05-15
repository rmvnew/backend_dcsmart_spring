package com.dcsmart.dcsmart.repository;

import com.dcsmart.dcsmart.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone ,Long> {
}
