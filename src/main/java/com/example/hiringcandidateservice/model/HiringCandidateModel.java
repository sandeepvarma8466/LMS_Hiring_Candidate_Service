package com.example.hiringcandidateservice.model;

import com.example.hiringcandidateservice.dto.HiringCandidateDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hiring_details")
@Data
@NoArgsConstructor
public class HiringCandidateModel {
    @Id
    @GenericGenerator(name = "hiring_details", strategy = "increment")
    @GeneratedValue(generator = "hiring_details")
    private Long id;
    private String cicId;
    private String fullName;
    private String email;
    private String mobileNum;
    private String hiredDate;
    private String degree;
    private Double aggrPer;
    private String city;
    private String state;
    private String jobLocation;
    private String status;
    private String passedOutYear;
    private String creatorUser;
    private String candidateStatus;
    private LocalDateTime creationTimeStamp;
    private LocalDateTime updatedTimeStamp;
   /* @OneToOne*/
    private String bankDeatils;

    public HiringCandidateModel(HiringCandidateDTO hiringDTO) {
        this.cicId = hiringDTO.getCicId();
        this.fullName = hiringDTO.getFullName();
        this.email = hiringDTO.getEmail();
        this.mobileNum = hiringDTO.getMobileNum();
        this.hiredDate = hiringDTO.getHiredDate();
        this.degree = hiringDTO.getDegree();
        this.aggrPer = hiringDTO.getAggrPer();
        this.city = hiringDTO.getCity();
        this.state = hiringDTO.getState();
        this.jobLocation = hiringDTO.getJobLocation();
        this.status = hiringDTO.getStatus();
        this.passedOutYear = hiringDTO.getPassedOutYear();
        this.creatorUser = hiringDTO.getCreatorUser();
        this.candidateStatus = hiringDTO.getCandidateStatus();
        this.creationTimeStamp = LocalDateTime.now();
        this.updatedTimeStamp = LocalDateTime.now();
    }
}
