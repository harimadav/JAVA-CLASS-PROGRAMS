package keywrods;


//Parent class
public class sup_method {
 public void disp() {
     System.out.println("RIT");
 }
}

//Child class
class two extends sup_method {
 @Override
 public void disp() {
     System.out.println("REC");
     super.disp(); // call parent class method
 }

 public static void main(String[] args) {
     two O = new two();
     O.disp();
 }
}

