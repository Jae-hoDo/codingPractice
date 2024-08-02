package dw.BookManagementSystem.Repository;

import dw.BookManagementSystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
