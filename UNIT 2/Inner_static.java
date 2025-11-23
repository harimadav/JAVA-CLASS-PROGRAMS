package Inner_class;

class OuterClass {
    int x = 10;

    static class InnerClass {
        int y = 5;  // default constructor is available
    }
}

public class Inner_static {
    public static void main(String[] args) {
        OuterClass.InnerClass myInner = new OuterClass.InnerClass();
        System.out.println(myInner.y);
    }
}
