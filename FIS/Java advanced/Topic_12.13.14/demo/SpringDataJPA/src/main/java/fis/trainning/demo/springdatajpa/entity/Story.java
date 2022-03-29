package fis.trainning.demo.springdatajpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int storyId;

    @Column(name = "Story_name")
    private String storyName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Book_id")
    @JsonBackReference
    private Book book;

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
