package com.abdullah.Java6MovieAppMvc.mapper;

import com.abdullah.Java6MovieAppMvc.dto.request.MovieCommentCreateRequestDto;
import com.abdullah.Java6MovieAppMvc.dto.request.UserRegisterRequestDto;
import com.abdullah.Java6MovieAppMvc.dto.response.LoginResponseDto;
import com.abdullah.Java6MovieAppMvc.repository.entity.MovieComment;
import com.abdullah.Java6MovieAppMvc.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);

    User toUser(final UserRegisterRequestDto dto);

    LoginResponseDto toLoginResponseDto(final User user);

    MovieComment toMovieCommen(final MovieCommentCreateRequestDto dto);


}
