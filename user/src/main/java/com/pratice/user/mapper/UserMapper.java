package com.pratice.user.mapper;

import com.pratice.user.DTO.UserDTO;
import com.pratice.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANT = Mappers.getMapper(UserMapper.class);
    User mapUserDtoToUser(UserDTO userDTO);
    UserDTO mapUserToUserDto(User user);

}
