package dw.movieDic.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lectures")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private long lectureId;
    @Column(length = 100)
    private String title;
    @Column(length = 100)
    private String major;
    @Column
    private int price;
    @Column(length = 65535)
    private String image;
    @Column(length = 65535)
    private String text;
    @Column(name = "lecture_url", length = 65535)
    private String lectureUrl;
}
