package com.cdec.validator.model.response;

import com.cdec.validator.model.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginResponse {

    private String jwt;
    private ResponseStatus status;
    private String message;
    private String code;

}
