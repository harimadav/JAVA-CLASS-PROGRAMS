package abstraction;


abstract class one {
    abstract void disp();
    abstract void f();   // Must be abstract if no body is given
}

class two extends one {
    void disp() {
        System.out.println("RIT");
    }
    void f() {
        System.out.println("REC");
    }
}

public class abst {
    public static void main(String[] args) {
        two O = new two();
        O.disp();
        O.f();
    }
}
