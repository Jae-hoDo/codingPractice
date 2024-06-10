package dw.movieDic.service;

import dw.movieDic.dto.UserDto;
import dw.movieDic.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String saveUser(UserDto userDto) {

    }
}
