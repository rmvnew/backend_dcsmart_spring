package com.dcsmart.dcsmart.repository;

import com.dcsmart.dcsmart.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone ,Long> {


    @Query(value = "SELECT * FROM phone WHERE person_id = :id and is_active = true",nativeQuery = true)
    Optional<Phone> findByPerson(@Param("id") Long id);


    @Query(value = "SELECT * FROM phone WHERE phone_number = :phone_number AND is_active = true",nativeQuery = true)
    Optional<Phone> phoneExists(@Param("phone_number") String phone_number);

    @Query(value = "SELECT * FROM phone WHERE phone_number = :phone_number AND is_active = true and phone_id <> :id",nativeQuery = true)
    Optional<Phone> phoneExistsInOtherAcount(@Param("phone_number") String phone_number,@Param("id") Long id);
}
