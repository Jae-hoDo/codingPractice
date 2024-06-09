package dw.movieDic.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private long boardId;

    @Column(name = "board_name", nullable = false, unique = true, length = 100)
    private String boardName;

    @OneToMany(mappedBy = "board")
    private Set<Post> posts;
}
