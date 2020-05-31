package com.lecture.resource;

import com.lecture.db.DatabaseClass;
import com.lecture.model.Book;
import com.lecture.model.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookResource {
    private Map<Long, Library> libraries = DatabaseClass.getLibraries();

    public List<Book> getAllBooks(long libraryId) {
        Map<Long, Book> books = libraries.get(libraryId).getBooks();
        return new ArrayList<Book>(books.values());
    }
    public Book getBook(long libraryId, long bookId) {
        Map<Long,Book> books = libraries.get(libraryId).getBooks();
        Book book= books.get(bookId);
        return book;
    }
    public Book addBook(long libraryId, Book book) {
        Map<Long,Book> books = libraries.get(libraryId).getBooks();
        book.setId(books.size() + 1);
        books.put(book.getId(),book);
        return book;
    }
    public Book updateBook(long libraryId, Book book) {
        Map<Long,Book> books = libraries.get(libraryId).getBooks();
        if(book.getId() <= 0) {
            return null;
        }
        books.put(book.getId(), book);
        return book;
    }
    public Book removeBook(long libraryId, long bookId) {
        Map<Long,Book> books = libraries.get(libraryId).getBooks();
        return books.remove(bookId);
    }

}
