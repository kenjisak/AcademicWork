import java.util.Scanner;
public class StudentRoster {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int studentn;
		System.out.print("Please enter the number of students in your class: ");
		studentn=input.nextInt();
		
		String[] student= new String[studentn];
		input.nextLine();
		
		System.out.println("Enter the name of your students:");
		for (int i = 0;i < student.length; i++){
			
			student[i]=input.nextLine();
		}
			System.out.println("Student Roster: ");
		for (int i = 0;i < student.length; i++){
			
			System.out.println(student[i]);
		}
		input.close();
	}

}
