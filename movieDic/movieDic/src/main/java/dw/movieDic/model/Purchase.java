package dw.movieDic.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private long purchaseId;
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "purchase_time")
    private LocalDateTime purchaseTime;
}
