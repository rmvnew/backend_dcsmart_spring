package com.dcsmart.dcsmart.repository;

import com.dcsmart.dcsmart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM category WHERE is_active = true",nativeQuery = true)
    List<Category> findAll();

    @Query(value = "SELECT * FROM category WHERE category_name like %:name% ",nativeQuery = true)
    Optional<Category> findByName(String name);

}
