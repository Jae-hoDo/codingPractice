package dw.bookManagementSystem.Service;

import dw.bookManagementSystem.Model.Book;
import dw.bookManagementSystem.Repository.BookRepository;
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
