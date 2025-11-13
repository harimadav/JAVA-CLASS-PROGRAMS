package excepetion_handling;
public class try_exp {

		  public static void main(String[ ] args) {
		    try {
		      int[] myNumbers = {1, 2, 3};
		      System.out.println(myNumbers[10]);
		    } catch (Exception e) {                        // Expection is bulid in number
		      System.out.println("Something went wrong.");
		    }
		  }
		}

		


