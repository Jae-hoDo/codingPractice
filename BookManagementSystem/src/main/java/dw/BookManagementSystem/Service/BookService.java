package dw.BookManagementSystem.Service;

import dw.BookManagementSystem.Model.Book;
import dw.BookManagementSystem.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 데이터베이스의 도서 정보 조회
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}