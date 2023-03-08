package com.abdullah.Java6MovieAppMvc.dto.response;

import com.abdullah.Java6MovieAppMvc.repository.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {
    private Long id;
    private String name;
    private String surName;
    private String email;
    private String phone;
    private UserType userType;
//    private List<Long> favGenres;
//    private List<Long> favMovies;
//    private List<Long> comments;
}
