package dw.movieDic.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @Column(name = "user_id", length = 100)
    private String userId;
    @Column(name = "user_name", length = 255, nullable = false)
    private String userName;
    @Column(name = "email", length = 255, nullable = false)
    private String email;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "user_authority", referencedColumnName = "authority_name")
    private Authority authority;

}
