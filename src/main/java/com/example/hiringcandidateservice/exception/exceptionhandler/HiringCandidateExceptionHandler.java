package com.example.hiringcandidateservice.exception.exceptionhandler;

import com.example.hiringcandidateservice.exception.HiringCandidateNotFoundException;
import com.example.hiringcandidateservice.util.HiringResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HiringCandidateExceptionHandler {
    @ExceptionHandler(HiringCandidateNotFoundException.class)
    public ResponseEntity<HiringResponce> response(HiringCandidateNotFoundException adminNotFoundException) {
        HiringResponce adminResponce = new HiringResponce();
        adminResponce.setErrorcode(400);
        adminResponce.setMessage(adminNotFoundException.getMessage());
        return new ResponseEntity<>(adminResponce, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<HiringResponce>
    defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        HiringResponce hiringResponce = new HiringResponce();
        hiringResponce.setErrorcode(500);
        hiringResponce.setMessage(e.getMessage());
        return new ResponseEntity<HiringResponce>(hiringResponce, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
