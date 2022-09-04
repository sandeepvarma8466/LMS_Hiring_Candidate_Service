package com.example.hiringcandidateservice.service;

import com.example.hiringcandidateservice.dto.HiringCandidateDTO;
import com.example.hiringcandidateservice.model.HiringCandidateModel;

import java.util.List;

public interface IHiringCandidateService {
    HiringCandidateModel addHiring(HiringCandidateDTO hiringCandidateDTO, String token);

    HiringCandidateModel updateHiringDetails(Long id, HiringCandidateDTO hiringCandidateDTO, String token);

    List<HiringCandidateModel> getAllHiredCandidates(String token);

    HiringCandidateModel getHiringDetails(Long id, String token);

    HiringCandidateModel deleteCandidate(Long id, String token);
}
