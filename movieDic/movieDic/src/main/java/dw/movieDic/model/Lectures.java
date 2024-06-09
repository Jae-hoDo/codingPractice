package dw.movieDic.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lectures")
public class Lectures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long lectureId;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "major", nullable = false, length = 100)
    private String major;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "image", nullable = false, length = 255)
    private String image;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(name = "lecture_url", nullable = false, length = 255)
    private String lectureUrl;
}
