package com.lecture.service;

import com.lecture.model.Library;
import com.lecture.resource.BookResource;
import com.lecture.resource.LibraryResource;

import javax.jws.WebService;
import java.util.List;
import com.lecture.model.Book;

@WebService(endpointInterface = "com.lecture.service.ServiceInterface", portName = "IPPTServicePort", serviceName = "IPPTService")
public class Service implements ServiceInterface {

    LibraryResource libraryResource = new LibraryResource();
    BookResource bookResource = new BookResource();

    @Override
    public List<Library> getLibraries() {
        return libraryResource.getAllLibraries();
    }
    @Override
    public Library addLibrary(Library library) {
        return libraryResource.addLibrary(library);
    }
    @Override
    public Library updateLibrary( long id, Library library) {
        library.setId(id);
        return libraryResource.updateLibrary(library);
    }
    @Override
    public boolean deleteLibrary(long id) {
        libraryResource.removeLibrary(id);
        return true;
    }
    @Override
    public Library getLibrary(long id) {
        return libraryResource.getLibrary(id);
    }
    @Override
    public List<Book> getAllBooks(long libraryId) {
        return bookResource.getAllBooks(libraryId);
    }
    @Override
    public Book getBook(long libraryId, long bookId) {return bookResource.getBook(libraryId, bookId);}
    @Override
    public Book addBook(long libraryId, Book book) {
        return bookResource.addBook(libraryId, book);
    }
    @Override
    public Book updateBook(long libraryId, long id, Book book) {
        book.setId(id);
        return bookResource.updateBook(libraryId, book);
    }
    @Override
    public boolean deleteBook(long libraryId, long bookId) {
        bookResource.removeBook(libraryId, bookId);
        return true;
    }



}
