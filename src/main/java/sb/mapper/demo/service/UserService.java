package sb.mapper.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.mapper.demo.dto.UserDTO;
import sb.mapper.demo.entity.User;
import sb.mapper.demo.mapper.UserMapper;
import sb.mapper.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;


    public User saveUser(UserDTO userDTO) {
        return userRepository.save(userMapper.toEntity(userDTO));
    }

    public UserDTO getUserById(Long id) {

        return userRepository.findById(id)
                .map(userMapper::toDTO )
                .orElse(new UserDTO());
    }

    public List<UserDTO> getUserList() {
        List<User> users = 	userRepository.findAll();
        return  userMapper.toDTOList(users);
    }

}