package fis.trainning.demo.springdatajpa.service;

import fis.trainning.demo.springdatajpa.entity.Book;
import org.springframework.stereotype.Component;

@Component
public interface BookService {
    public Book saveBook(Book book);
    public Book findByBookId(int bookId);
}
