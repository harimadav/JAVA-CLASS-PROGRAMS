
import java.util.*;
public class logic_building {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String a=sc.nextLine();
		System.out.println(a);
		int b=a.length();
		System.out.println(b);
		if (b%2==0) {
			System.out.println("even");
			
		}
		else {
			String c =sc.nextLine();
			System.out.println(a+c);
		
		}
		String rev="";
		for (int i=0; i<b;i++) {
			
			char ch =a.charAt(i);
			int ascii = (int) ch;
			System.out.print(ch+""+ascii);
			
			
		}
		System.out.println(rev);
		
        
		
		
	}

}
