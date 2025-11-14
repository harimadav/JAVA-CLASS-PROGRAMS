package excepetion_handling;
public class try_throw {
		  static void checkAge(int age) {
		    if (age < 18) {
		      throw new ArithmeticException("Access denied - You must be at least 18 years old.");
		    }
		    else {
		      System.out.println("Access granted - You are old enough!");
		    }
		  }

		  public static void main(String[] args) {
		    try{
		    	checkAge(15); // Set age to 15 (which is below 18...)
		    }
		    catch (ArithmeticException e) {
		    	System.out.println("eror"+e.getMessage());
			  
		  }
		}
}

