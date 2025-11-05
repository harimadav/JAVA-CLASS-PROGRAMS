package clonning;


	class cloning implements Cloneable {

		  // declare variables
		  String name;
		  int version;
		  public static void main(String[] args) {

		    // create an object of Main class
		    cloning obj1 = new cloning();

		    // initialize name and version using obj1
		    obj1.name = "Java";
		    obj1.version = 14;

		    // print variable
		    System.out.println(obj1.name);        // Java
		    System.out.println(obj1.version);     // 14

		    try {

		      // create a clone of obj1
		      cloning obj2 = (cloning)obj1.clone();

		      // print the variables using obj2
		      System.out.println(obj2.name);      // Java
		      System.out.println(obj2.version);   // 14

		      // changing value of name
		      // using obj2
		      obj2.name = "Python";
		      System.out.println(obj2.name);      // Python

		      // check if value associated 
		      // with obj1 is changed
		      System.out.println(obj1.name);      // Java
		    }
		    catch (Exception e) {
		      System.out.println(e);
		    }

		  }
		}


//assert is the keywrod introduced in the java