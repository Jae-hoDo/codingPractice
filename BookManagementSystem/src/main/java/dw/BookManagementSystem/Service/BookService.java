package dw.BookManagementSystem.Service;

import dw.BookManagementSystem.Model.Book;
import dw.BookManagementSystem.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Book updateBook(String oldIsbn, Book updatedBook) {
        Optional<Book> existingBook = bookRepository.findById(oldIsbn);
        if (existingBook.isPresent()) {
            if (!oldIsbn.equals(updatedBook.getIsbn())) {
                bookRepository.deleteById(oldIsbn);
                return bookRepository.save(updatedBook);
            } else {
                Book bookToUpdate = existingBook.get();
                bookToUpdate.setIsbn(updatedBook.getIsbn());
                bookToUpdate.setTitle(updatedBook.getTitle());
                bookToUpdate.setAuthor(updatedBook.getAuthor());
                bookToUpdate.setYearPublication(updatedBook.getYearPublication());
                bookToUpdate.setStock(updatedBook.getStock());

                return bookRepository.save(bookToUpdate);
            }
        }
        return null;
    }
}