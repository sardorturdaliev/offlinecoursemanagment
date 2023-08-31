package uz.crud.crudinstructor.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Data
//@NoArgsConstructor
//@Table(name = "Author")
//public class Author {
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "zipcode_id")
//    private Zipcode zipcode;
//
//    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Book> books = new ArrayList<>();
//
//
//    public Author(String name, Zipcode zipcode, List<Book> books) {
//        this.name = name;
//        this.zipcode = zipcode;
//        this.books = books;
//    }
//
//    public  void addBook(Book book){
//        books.add(book);
//    }
//
//    private void removeBook(Book book){
//        books.remove(book);
//    }
//
//
//}
