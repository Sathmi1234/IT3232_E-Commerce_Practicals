class Book {
    String title;

    public Book(String title) {
        this.title = title;
    }

    public void displayInfo() {
        System.out.println("Book: " + title);
    }
}

class PrintedBook extends Book {
    public PrintedBook(String title) {
        super(title);
    }

    public void displayInfo() {
        System.out.println("Printed Book: " + title);
    }
}

class EBook extends Book {
    public EBook(String title) {
        super(title);
    }

    public void displayInfo() {
        System.out.println("E-Book: " + title);
    }
}

class AudioBook extends Book {
    public AudioBook(String title) {
        super(title);
    }

    public void displayInfo() {
        System.out.println("Audio Book: " + title);
    }
}

public class Question7 {
    public static void main(String[] args) {
        Book book1 = new PrintedBook("Java Basics");
        Book book2 = new EBook("Python Guide");
        Book book3 = new AudioBook("C++ Mastery");

        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();
    }
}
