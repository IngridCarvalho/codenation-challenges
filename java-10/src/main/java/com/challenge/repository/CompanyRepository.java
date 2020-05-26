package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    Optional<Company> findById(Long id);

    List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);

    List<Company> findByCandidatesIdUserId(@Param("userId") Long userId);
}
