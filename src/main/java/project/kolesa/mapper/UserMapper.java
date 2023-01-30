package project.kolesa.mapper;

import org.mapstruct.Mapper;
import project.kolesa.dto.UserDto;
import project.kolesa.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);

    List<UserDto> toDtoList(List<User> users);
    List<User> toEntityList(List<UserDto> userDtoList);
}
