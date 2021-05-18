package Homework.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    private final List<Book> books;

    public BookShelf(){
        books = new ArrayList<>();
    }
    public void appendBook(Book book){
        books.add(book);
    }
    public Book getBook(int i){
        if(i < 0 || i >= books.size()){
            return null;
        }
        return books.get(i);
    }
    public int getLength(){
        return books.size();
    }
    public Iterator iterator(){
        return new BookShelfIterator(this);
    }

}
