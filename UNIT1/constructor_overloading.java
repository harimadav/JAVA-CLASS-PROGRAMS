package constructor;
	class Book {
	    String title;
	    String author;

	    // Constructor with one argument
	    Book(String t) {
	        title = t;
	        author = "Unknown";
	    }

	    // Constructor with two arguments
	    Book(String t, String a) {
	        title = t;
	        author = a;
	    }

	    void display() {
	        System.out.println("Title: " + title + ", Author: " + author);
	    }
	}

	public class constructor_overloading {
	    public static void main(String[] args) {
	        Book b1 = new Book("Java Basics");            // calls 1st constructor
	        Book b2 = new Book("OOP in Java", "James");   // calls 2nd constructor

	        b1.display();
	        b2.display();
	    }
	}



