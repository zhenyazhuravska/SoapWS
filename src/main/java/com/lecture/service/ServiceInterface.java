package com.lecture.service;

import com.lecture.model.Book;
import com.lecture.model.Library;

import javax.jws.WebMethod;
import java.util.List;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebService;

@WebService(name = "IPPT", targetNamespace = "http://www.soapws.example.com")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)

public interface ServiceInterface {

    @WebMethod
    @WebResult(name = "Library")
    List<Library> getLibraries();

    @WebMethod
    @WebResult(name = "Library")
    Library addLibrary(@WebParam(name = "Info") Library library);

    @WebMethod
    @WebResult(name = "Library")
    Library updateLibrary(@WebParam(name = "libraryId") long LibraryId, @WebParam(name = "Info") Library library);

    @WebMethod
    boolean deleteLibrary(@WebParam(name = "libraryId") long libraryId);

    @WebMethod
    @WebResult(name = "Library")
    Library getLibrary(@WebParam(name = "libraryId") long libraryId);

    @WebMethod
    @WebResult(name = "Book")
    List<Book> getAllBooks(@WebParam(name = "libraryId") long libraryId);

    @WebMethod
    @WebResult(name = "Book")
    Book getBook(@WebParam(name = "libraryId") long library, @WebParam(name = "bookId") long bookId);

    @WebMethod
    @WebResult(name = "Book")
    Book addBook(@WebParam(name = "libraryId") long libraryId,@WebParam(name = "Info") Book book);

    @WebMethod
    @WebResult(name = "Book")
    Book updateBook(@WebParam(name = "libraryId") long libraryId, @WebParam(name = "bookId")  long bookId,@WebParam(name = "Info") Book book);

    @WebMethod
    boolean deleteBook(@WebParam(name = "libraryId") long libraryId, @WebParam(name = "bookId")  long bookId);


}

