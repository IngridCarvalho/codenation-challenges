package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {

    Optional<Candidate> findById(CandidateId id);

    @Query("select c from Candidate c " +
            "where c.id.user.id = :userId " +
            "and c.id.acceleration.id = :accelerationId " +
            "and c.id.company.id = :companyId")
    Optional<Candidate> findByUserIdAndCompanyIdAndAccelerationId(@Param("userId") Long userId,
                                                                  @Param("companyId") Long companyId,
                                                                  @Param("accelerationId") Long accelerationId);

    @Query("select c from Candidate c "+
            "join c.id.company cp " +
            "where cp.id = :companyId")
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

    @Query("select c from Candidate c "+
            "join c.id.acceleration a " +
            "where a.id = :accelerationId")
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);
}
