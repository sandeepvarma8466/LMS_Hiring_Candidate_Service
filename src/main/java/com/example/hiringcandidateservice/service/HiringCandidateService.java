package com.example.hiringcandidateservice.service;

import com.example.hiringcandidateservice.dto.HiringCandidateDTO;
import com.example.hiringcandidateservice.exception.HiringCandidateNotFoundException;
import com.example.hiringcandidateservice.model.HiringCandidateModel;
import com.example.hiringcandidateservice.repository.HiringCandidateRepository;
import com.example.hiringcandidateservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HiringCandidateService implements IHiringCandidateService {
    @Autowired
    HiringCandidateRepository hiringRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    MailService mailService;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public HiringCandidateModel addHiring(HiringCandidateDTO hiringCandidateDTO, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8068/adminmodule/validateuser/" + token,
                Boolean.class);
        if (isUserPresent) {
            HiringCandidateModel hiringCandidateModel = new HiringCandidateModel(hiringCandidateDTO);
            hiringCandidateModel.setBankDeatils(hiringCandidateModel.getBankDeatils());
            hiringRepository.save(hiringCandidateModel);
            String body = "Candidate is Hired succesfully with id " + hiringCandidateModel.getId();
            String subject = "Candidate Hired Succesfully";
            mailService.send(hiringCandidateModel.getEmail(), subject, body);
            return hiringCandidateModel;
        }
        throw new HiringCandidateNotFoundException("Invalid Token", 500);
    }

    @Override
    public HiringCandidateModel updateHiringDetails(Long id, HiringCandidateDTO hiringCandidateDTO, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8068/adminmodule/validateuser/" + token,
                Boolean.class);
        if (isUserPresent) {
            Optional<HiringCandidateModel> isIdPresent = hiringRepository.findById(id);
            if (isIdPresent.isPresent()) {
                isIdPresent.get().setCicId(hiringCandidateDTO.getCicId());
                isIdPresent.get().setFullName(hiringCandidateDTO.getFullName());
                isIdPresent.get().setEmail(hiringCandidateDTO.getEmail());
                isIdPresent.get().setMobileNum(hiringCandidateDTO.getMobileNum());
                isIdPresent.get().setHiredDate(hiringCandidateDTO.getHiredDate());
                isIdPresent.get().setDegree(hiringCandidateDTO.getDegree());
                isIdPresent.get().setAggrPer(hiringCandidateDTO.getAggrPer());
                isIdPresent.get().setCity(hiringCandidateDTO.getCity());
                isIdPresent.get().setState(hiringCandidateDTO.getState());
                isIdPresent.get().setJobLocation(hiringCandidateDTO.getJobLocation());
                isIdPresent.get().setStatus(hiringCandidateDTO.getStatus());
                isIdPresent.get().setPassedOutYear(hiringCandidateDTO.getPassedOutYear());
                isIdPresent.get().setCreatorUser(hiringCandidateDTO.getCreatorUser());
                isIdPresent.get().setCandidateStatus(hiringCandidateDTO.getCandidateStatus());
                isIdPresent.get().setCreationTimeStamp(LocalDateTime.now());
                isIdPresent.get().setUpdatedTimeStamp(LocalDateTime.now());
                hiringRepository.save(isIdPresent.get());
                String body = "CandidateHiring Updated succesfully with id " + isIdPresent.get().getId();
                String subject = "CandidateHiring Updated Succesfully";
                mailService.send(isIdPresent.get().getEmail(), subject, body);
                return isIdPresent.get();
            }
            throw new HiringCandidateNotFoundException("Candiddate Id Not Found", 500);
        }
        throw new HiringCandidateNotFoundException("Invalid Token", 500);
    }

    @Override
    public List<HiringCandidateModel> getAllHiredCandidates(String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8068/adminmodule/validateuser/" + token,
                Boolean.class);
        if (isUserPresent) {
            List<HiringCandidateModel> isCandidtesPresent = hiringRepository.findAll();
            if (isCandidtesPresent.size() > 0) {
                return isCandidtesPresent;
            }
            throw new HiringCandidateNotFoundException("Candiddate Id Not Found", 500);
        }
        throw new HiringCandidateNotFoundException("Invalid Token", 500);
    }

    @Override
    public HiringCandidateModel getHiringDetails(Long id, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8068/adminmodule/validateuser/" + token,
                Boolean.class);
        if (isUserPresent) {
            Optional<HiringCandidateModel> isIdPresent = hiringRepository.findById(id);
            if (isIdPresent.isPresent()) {
                return isIdPresent.get();
            }
            throw new HiringCandidateNotFoundException("Candiddate Id Not Found", 500);
        }
        throw new HiringCandidateNotFoundException("Invalid Token", 500);
    }

    @Override
    public HiringCandidateModel deleteCandidate(Long id, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8068/adminmodule/validateuser/" + token,
                Boolean.class);
        if (isUserPresent) {
            Optional<HiringCandidateModel> isIdPresent = hiringRepository.findById(id);
            if (isIdPresent.isPresent()) {
                hiringRepository.delete(isIdPresent.get());
                return isIdPresent.get();
            }
            throw new HiringCandidateNotFoundException("Candiddate Id Not Found", 500);
        }
        throw new HiringCandidateNotFoundException("Invalid Token", 500);
    }
}
