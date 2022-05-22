package com.dcsmart.dcsmart.repository;

import com.dcsmart.dcsmart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM tb_user AS U INNER JOIN person AS P ON U.person_id =" +
            " P.person_id INNER JOIN tb_profile AS PP ON U.profile_id = PP.profile_id " +
            "WHERE P.person_name like %:name% and U.is_active = true",nativeQuery = true)
    Optional<User> findByName(String name);

    Optional<User> findById(Long id);

    @Query(value = "SELECT * FROM tb_user WHERE is_active = true",nativeQuery = true)
    List<User> findAllActives();

    @Query(value = "select is_active from tb_user where is_active = false",nativeQuery = true)
    Optional<Boolean> findInactive(Long id);

}
