package com.ciclo4.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewUserRequest {

    private Integer id;
    private String email;
    private String password;
    private String name;
}
