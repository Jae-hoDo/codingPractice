package dw.movieDic.service;

import dw.movieDic.dto.UserDto;
import dw.movieDic.model.Authority;
import dw.movieDic.model.User;
import dw.movieDic.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public String saveUser(UserDto userDto) {
        Optional<User> userOptional = userRepository.findByUserId(userDto.getUserId());
        if (userOptional.isPresent()) {
            return "이미 등록된 ID 입니다";
        }
        Authority authority = new Authority();
        authority.setAuthorityName("ROLE_USER");
        User user = new User(userDto.getUserId(),
                bCryptPasswordEncoder.encode(userDto.getPassword()),
                userDto.getBirthday(),
                userDto.getUserEmail(),
                LocalDateTime.now(),
                userDto.getUserName(),
                authority,
                userDto.getGender());
        return userRepository.save(user).getUserId();
    }
}
