package com.example.hiringcandidateservice.repository;

import com.example.hiringcandidateservice.model.HiringCandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiringCandidateRepository extends JpaRepository<HiringCandidateModel, Long> {
}
