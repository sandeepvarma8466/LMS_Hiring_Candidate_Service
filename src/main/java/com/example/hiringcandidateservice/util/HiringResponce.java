package com.example.hiringcandidateservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HiringResponce {
    private int errorcode;
    private String message;
    private Object token;
}
