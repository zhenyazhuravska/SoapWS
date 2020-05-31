package com.lecture.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Book")
@XmlType(propOrder = {"id", "author", "name"})
public class Book {
    private long id;
    private String name;
    private String author;

    public Book(){}

    public Book(long id, String name, String author) {
        this.name = name;
        this.author = author;
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
