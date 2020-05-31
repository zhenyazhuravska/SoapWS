package com.lecture.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "Library")
@XmlType(propOrder = {"id", "name", "street"})
public class Library {
    private long id;
    private String name;
    private String street;

    public Library() {

    }
    public Library(long id, String name, String street) {
        this.id = id;
        this.name = name;
        this.street = street;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    private Map<Long, Book> books = new HashMap<>();


    @XmlTransient
    public Map<Long, Book> getBooks() {
        return books;
    }
    public void setBooks(Map<Long, Book> books) {
        this.books = books;
    }
}
