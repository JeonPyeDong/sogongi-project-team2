import java.util.Scanner;

public class Professor {
	private String subject;
	private String name;
	private String password;
	public Professor(String n, String s, String p) {
		this.name = n;
		this.subject = s;
		this.password = p;
	}
	public String getSubject() {
		return this.subject;
	}
	public String getName() {
		return this.name;
	}
	public String getPassword(){
		return this.password;
	}
	public void setSubject(String sub) {
		this.subject = sub;
	}
	public void setName(String n) {
		this.name = n;
	}
	public void setPassword(String passwd) {
		this.password = passwd;
	}
	// ������ student ��ü�� ��ȯ�ϴ� class
	public Student addStudent() {
		Scanner sc = new Scanner(System.in);
		String studentId;
		String studentName;
		String studentSubject;
		Student newstudent = new Student();
		
		System.out.println("-- �л� �߰� --");
		System.out.print("�й� �Է� >> ");
		studentId = sc.next();
		while(true) {
			// studentId�� �����ϸ� ��ü �л��迭���� �ߺ��Ǵ� �й��� �ִ��� ã�� �޼ҵ�. ��ȯ Ÿ���� boolean �� ����.
			// �й��� �ߺ��� �Ǹ�,
			if(!true) {	
				System.out.println("�й��� �ߺ��Ǿ����ϴ�. �ٽ� �Է����ּ���.");
				System.out.print("�й� �Է� >> ");
				studentId = sc.next();	
			} else {
				System.out.println("�й� ��ϿϷ�.");
				break;
			}
		}
		
		System.out.print("�л� �̸� �Է� >> ");
		studentName = sc.next();
		// ���⼭ ������ ��� ������? ������ �ϳ��� �ް� �޼ҵ带 �ϳ� �� ������?
		System.out.print("���� ���� �Է� >> ");
		studentSubject = sc.next();
		
		//new student�� �Է¹��� ���� ����.
		System.out.printf("�й� : [%s]%n�̸� : [%s]%n����� : [%s]%n", studentId, studentName,studentSubject);
		return newstudent;
	}
	
	 public void deleteStudent(Student[] delstudentarray){
	}	
	
}
