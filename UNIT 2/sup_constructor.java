package keywrods;

public class sup_constructor {
    // Constructor of parent class
    sup_constructor(){
        System.out.println("RIT");
    }

    // Child class extending parent class
    class two extends sup_constructor {
        two() {
            super();   // calls parent constructor
            System.out.println("REC");
        }
    }

    public static void main(String[] args) {
        // First create object of outer class
        sup_constructor outer = new sup_constructor();

        // Then create object of inner class
        two O = outer.new two();
        
    }
}

