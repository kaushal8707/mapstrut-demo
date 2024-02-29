package sb.mapper.demo.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sb.mapper.demo.dto.UserDTO;
import sb.mapper.demo.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "email", target = "emailId")
    @Mapping(source = "phoneNo", target = "contactNo")
    UserDTO toDTO(User user);
    @Mapping(source = "emailId", target = "email")
    @Mapping(source = "contactNo", target = "phoneNo")
    User toEntity(UserDTO userDTO);

    List<UserDTO> toDTOList(List<User> user);
}
