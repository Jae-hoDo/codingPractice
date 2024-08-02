package dw.BookManagementSystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "ISBN", unique = true, nullable = false)
    @Size(min = 10, max = 13, message = "ISBN은 최소 10자리 이상, 최대 13자리 이하여야 한다.")
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "year_publication")
    private Integer yearPublication;

    @Column(name = "stock", nullable = false)
    private Long stock;
}