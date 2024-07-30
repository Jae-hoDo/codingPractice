package dw.bookManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "ISBN", length = 13, unique = true, nullable = false)
    private Long ISBN;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "date_publication")
    private LocalDate date_publication;

    @Column(name = "stock", nullable = false)
    private Long stock;

    @PrePersist
    protected void onCreate() {
        this.date_publication = LocalDate.now();
    }
}
