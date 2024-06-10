package dw.movieDic.dto;

import dw.movieDic.model.User;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private String userId;
    private String password;
    private String userName;
    private String userEmail;
    private User.GenderEnum gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}
