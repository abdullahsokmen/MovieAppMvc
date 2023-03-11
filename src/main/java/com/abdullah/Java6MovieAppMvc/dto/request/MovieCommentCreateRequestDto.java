package com.abdullah.Java6MovieAppMvc.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieCommentCreateRequestDto {
    private Long movieId;
    private Long userId;
    private String content;

}
