package fis.trainning.demo.springdatajpa.repository;

import fis.trainning.demo.springdatajpa.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface BookRepository extends CrudRepository<Book, Serializable> {
    public Book findByBookId(int bookId);
}
