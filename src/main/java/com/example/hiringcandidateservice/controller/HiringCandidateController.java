package com.example.hiringcandidateservice.controller;

import com.example.hiringcandidateservice.dto.HiringCandidateDTO;
import com.example.hiringcandidateservice.model.HiringCandidateModel;
import com.example.hiringcandidateservice.service.IHiringCandidateService;
import com.example.hiringcandidateservice.util.HiringResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hiringcandidate")
public class HiringCandidateController {
    @Autowired
    IHiringCandidateService hiringCandidateService;

    @PostMapping("/addhiring")
    public ResponseEntity<HiringResponce> addHiring(@Valid @RequestBody HiringCandidateDTO hiringCandidateDTO,
                                                    @RequestHeader String token) {
        HiringCandidateModel model = hiringCandidateService.addHiring(hiringCandidateDTO, token);
        HiringResponce hiringResponce = new HiringResponce(200,"HiringCandidate inserted successfully",model);
        return new ResponseEntity<>(hiringResponce, HttpStatus.OK);
    }

    @PutMapping("/updatehiring/{id}")
    public ResponseEntity<HiringResponce> updateHiringDetials(@PathVariable("id") Long id,@Valid @RequestBody
    HiringCandidateDTO hiringCandidateDTO, @RequestHeader String token) {
        HiringCandidateModel model = hiringCandidateService.updateHiringDetails(id, hiringCandidateDTO, token);
        HiringResponce hiringResponce = new HiringResponce(200,"HiringCandidate updated successfully",model);
        return new ResponseEntity<>(hiringResponce, HttpStatus.OK);
    }

    @GetMapping("/fetchhiringdetails")
    public ResponseEntity<HiringResponce> getAllHiredCandidates(@RequestHeader String token) {
        List<HiringCandidateModel> model = hiringCandidateService.getAllHiredCandidates(token);
        HiringResponce hiringResponce = new HiringResponce(200,"HiringCandidate fetched successfully",model);
        return new ResponseEntity<>(hiringResponce, HttpStatus.OK);
    }

    @GetMapping("/getdetailsby/{id}")
    public ResponseEntity<HiringResponce> getHiringDetails(@PathVariable("id") Long id, @RequestHeader String token) {
        HiringCandidateModel model = hiringCandidateService.getHiringDetails(id, token);
        HiringResponce hiringResponce = new HiringResponce(200,"HiringCandidate fetched by id successfully",model);
        return new ResponseEntity<>(hiringResponce, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCandidate/{id}")
    public ResponseEntity<HiringResponce> deleteCandidate(@PathVariable("id") Long id, @RequestHeader String token) {
        HiringCandidateModel model = hiringCandidateService.deleteCandidate(id, token);
        HiringResponce hiringResponce = new HiringResponce(200,"HiringCandidate deleted successfully",model);
        return new ResponseEntity<>(hiringResponce, HttpStatus.OK);
    }
}
