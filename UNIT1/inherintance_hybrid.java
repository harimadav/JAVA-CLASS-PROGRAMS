//Parent class
package innherintance;

//Base class
class Person {
 void displayPerson() {
     System.out.println("I am a Person");
 }
}

//Single inheritance: Student inherits Person
class Student extends Person {
 void displayStudent() {
     System.out.println("I am a Student");
 }
}

//Another base role using Interface (to avoid multiple inheritance issue)
interface TeacherRole {
 void displayTeacherRole();
}

//Hybrid inheritance: TeachingAssistant inherits Student (class) 
//and also implements TeacherRole (interface)
class TeachingAssistant extends Student implements TeacherRole {
 public void displayTeacherRole() {
     System.out.println("I can also Teach");
 }

 void displayTA() {
     System.out.println("I am a Teaching Assistant");
 }
}

//Main class
public class inherintance_hybrid {
 public static void main(String[] args) {
     TeachingAssistant ta = new TeachingAssistant();

     // Calling methods from different hierarchies
     ta.displayPerson();      // From Person
     ta.displayStudent();     // From Student
     ta.displayTeacherRole(); // From TeacherRole (interface)
     ta.displayTA();          // Own method
 }
}
