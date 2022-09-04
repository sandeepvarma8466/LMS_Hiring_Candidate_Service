package com.example.hiringcandidateservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class HiringCandidateNotFoundException extends RuntimeException {
    private int statuscode;
    private String message;

    public HiringCandidateNotFoundException(String message, int statuscode) {
        super(message);
        this.statuscode = statuscode;
        this.message = message;
    }
}
