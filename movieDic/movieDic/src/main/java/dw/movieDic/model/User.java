package dw.movieDic.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @Column(name = "user_id", length = 100)
    private String userId;
    @Column(name = "password")
    private String password;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "email", length = 255, nullable = false)
    private String email;
    @Column(name="date_joined", updatable = false)
    private LocalDateTime dateJoined;
    @Column(name = "user_name", length = 255, nullable = false)
    private String userName;
    @ManyToOne
    @JoinColumn(name = "user_authority", referencedColumnName = "authority_name")
    private Authority authority;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public enum Gender {
        MALE,
        FEMALE;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(
                new SimpleGrantedAuthority(authority.getAuthorityName()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

