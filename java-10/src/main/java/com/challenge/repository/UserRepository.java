package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);

    @Query(value = "select u from User u " +
            "join u.candidates c "+
            "join c.id.acceleration a " +
            "where a.name = :name")
    List<User> findByAccelerationName(@Param("name") String name);

    @Query("select u from User u " +
            "join u.candidates c "+
            "join c.id.company cp " +
            "where cp.id = :id")
    List<User> findByCompanyId(@Param("id") Long id);


}
