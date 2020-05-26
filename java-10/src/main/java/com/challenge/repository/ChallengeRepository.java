package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge, Long> {


    @Query("select c from Challenge c " +
            "join c.accelerations a " +
            "join a.candidates cd " +
            "join cd.id.user user " +
            "where a.id = :accelerationId " +
            "and user.id = :userId")
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId,
                                                  @Param("userId") Long userId);
}
