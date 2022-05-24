package com.dcsmart.dcsmart.repository;

import com.dcsmart.dcsmart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT * FROM product WHERE is_active = true",nativeQuery = true)
    List<Product> findAll();

    @Query(value = "SELECT * FROM product WHERE product_name like %:name% and is_active = true",nativeQuery = true)
    Optional<Product> findByName(@Param("name") String name);

}
