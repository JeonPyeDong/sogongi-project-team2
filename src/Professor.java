import java.util.Scanner;



public class Professor {
	public String subject;
	public String name;
	public String password;
	public Professor(String s, String n, String p) {
		this.name = n;
		this.subject = s;
		this.password = p;
	}
	static Student addStudent(Scanner s) {
		Scanner sc = new Scanner(System.in);
		String studentId;
		String studentName;
		String studentSubject;
		Student nst = new Student();
		
		System.out.println("-- �л� �߰� --");
		System.out.println("�й��� �ٸ� �л��� �ߺ��� �� �����ϴ�.");
		System.out.print("�й� �Է� >> ");
		studentId = s.next();
		System.out.print("�̸� �Է� >> ");
		studentName = s.next();
		System.out.print("���� �Է� >> ");
		studentSubject = s.next();
		System.out.printf(" [%s], [%s], [%s] �߰��Ϸ� ", studentId, studentName,studentSubject);
		return nst;
	}
	
	static void deleteStudent(Scanner s) {
		
	}
  public static void main(String[] args) 
  {
	  Student[] classroom = new Student[100];
	  
	  Scanner sc = new Scanner(System.in);
	  addStudent(sc);
  }
}
