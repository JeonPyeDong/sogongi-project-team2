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
		
		System.out.println("-- 학생 추가 --");
		System.out.println("학번은 다른 학생과 중복될 수 없습니다.");
		System.out.print("학번 입력 >> ");
		studentId = s.next();
		System.out.print("이름 입력 >> ");
		studentName = s.next();
		System.out.print("과목 입력 >> ");
		studentSubject = s.next();
		System.out.printf(" [%s], [%s], [%s] 추가완료 ", studentId, studentName,studentSubject);
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
