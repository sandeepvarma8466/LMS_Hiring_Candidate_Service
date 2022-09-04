package com.example.hiringcandidateservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class HiringCandidateDTO {
    @Pattern(regexp = "^[A-Z0-9]{2}$", message = "Invalid cicId")
    private String cicId;
    @Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "Hiring Candidate FullName Invalid")
    private String fullName;
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email Id")
    private String email;
    @Pattern(regexp = "^[1-9]{2}\\s{1}[1-9]{1}[0-9]{9}$", message = "Invalid Mobile Number")
    private String mobileNum;
    @NotNull(message = "hired date should not be empty")
    private String hiredDate;
    @NotBlank(message = "degree cannot be empty")
    private String degree;
    @NotNull(message = "aggregete percentage cannot be emmpty")
    private Double aggrPer;
    @Pattern(regexp = "^[A-Z][A-Za-z]{2,}$", message = "city name invalid")
    private String city;
    @Pattern(regexp = "^[A-Z][A-Za-z]{2,}$", message = "state name invalid")
    private String state;
    @Pattern(regexp = "^[A-Z][A-Za-z]{2,}$", message = "job location name invalid")
    private String jobLocation;
    @NotBlank(message = "status cannot be empty")
    private String status;
    @NotBlank(message = "passedout year cannot be empty")
    private String passedOutYear;
    private String creatorUser;
    @NotBlank(message = "candidate status cannot be blank")
    private String candidateStatus;
}
