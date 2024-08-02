package dw.BookManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "ISBN", unique = true, nullable = false)
    private String ISBN;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "date_publication")
    private LocalDate date_publication;

    @Column(name = "stock", nullable = false)
    private Long stock;
}