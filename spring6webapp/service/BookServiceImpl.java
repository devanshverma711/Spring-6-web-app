package guru.springframework.spring6webapp.service;

import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
private final BookRepo bookRepo;
    public BookServiceImpl(BookRepo bookRepo){
        this.bookRepo = bookRepo;
    }
    @Override
    public Iterable<Book> findAll() {
        return bookRepo.findAll();
    }
}
