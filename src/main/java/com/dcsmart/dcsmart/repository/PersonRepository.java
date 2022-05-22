package com.dcsmart.dcsmart.repository;

import com.dcsmart.dcsmart.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {



}
