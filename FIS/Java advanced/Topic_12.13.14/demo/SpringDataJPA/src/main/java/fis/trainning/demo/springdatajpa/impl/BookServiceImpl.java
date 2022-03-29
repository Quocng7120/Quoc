package fis.trainning.demo.springdatajpa.impl;

import fis.trainning.demo.springdatajpa.entity.Book;
import fis.trainning.demo.springdatajpa.entity.Story;
import fis.trainning.demo.springdatajpa.repository.BookRepository;
import fis.trainning.demo.springdatajpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookServiceImpl")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {

        Story story = book.getStory();
        story.setBook(book);
        book = bookRepository.save(book);
        return book;

    }

    public Book findByBookId(int bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return book;
    }
}
