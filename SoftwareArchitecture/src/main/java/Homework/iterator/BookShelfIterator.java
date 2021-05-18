package Homework.iterator;

public class BookShelfIterator implements Iterator {
    private final BookShelf bookShelf;
    private int index;
    public BookShelfIterator(BookShelf bookShelf){
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public Object end(){
        return bookShelf.getBook(bookShelf.getLength()-1);
    }

    @Override
    public Object next(){
        if (hasNext()) {
            return bookShelf.getBook(index++);
        }
        return null;
    }

    @Override
    public Object last(){
        if(hasLast()) {
            return bookShelf.getBook(--index);
        }
        return null;
    }

    @Override
    public Object begin(){
        return bookShelf.getBook(0);
    }

    @Override
    public boolean hasNext(){
        return index < bookShelf.getLength();
    }

    @Override
    public boolean hasLast(){
        return index > 0;
    }
}
