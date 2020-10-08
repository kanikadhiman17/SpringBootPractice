package com.kanika.spring.example.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseDTO<T> {
    private int status;
    private String message;
    private int count;
    private String api_element;
    List<T> result;
}