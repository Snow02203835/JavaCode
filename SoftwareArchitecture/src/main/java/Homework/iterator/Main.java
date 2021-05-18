package Homework.iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("三体"));
        bookShelf.appendBook(new Book("流浪地球"));
        bookShelf.appendBook(new Book("全频段阻塞干扰"));
        Iterator iterator = bookShelf.iterator();
        System.out.println("First Book's name: " + ((Book)iterator.begin()).getName());
        System.out.println("Last Book's name: " + ((Book)iterator.end()).getName());
        while (iterator.hasNext()){
            Book book = (Book)iterator.next();
            System.out.println("Book's name: " + book.getName());
        }
        while (iterator.hasLast()){
            Book book = (Book)iterator.last();
            System.out.println("Book's name: " + book.getName());
        }

    }
}
