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
	// 생성된 student 객체를 반환하는 class
	public Student addStudent() {
		Scanner sc = new Scanner(System.in);
		String studentId;
		String studentName;
		String studentSubject;
		Student newstudent = new Student();
		
		System.out.println("-- 학생 추가 --");
		System.out.print("학번 입력 >> ");
		studentId = sc.next();
		while(true) {
			// studentId를 전달하면 전체 학생배열에서 중복되는 학번이 있는지 찾는 메소드. 반환 타입은 boolean 을 가짐.
			// 학번이 중복이 되면,
			if(!true) {	
				System.out.println("학번이 중복되었습니다. 다시 입력해주세요.");
				System.out.print("학번 입력 >> ");
				studentId = sc.next();	
			} else {
				System.out.println("학번 등록완료.");
				break;
			}
		}
		
		System.out.print("학생 이름 입력 >> ");
		studentName = sc.next();
		// 여기서 과목을 모두 받을지? 과목은 하나만 받고 메소드를 하나 더 만들지?
		System.out.print("수강 과목 입력 >> ");
		studentSubject = sc.next();
		
		//new student에 입력받은 정보 저장.
		System.out.printf("학번 : [%s]%n이름 : [%s]%n과목명 : [%s]%n", studentId, studentName,studentSubject);
		return newstudent;
	}
	
	 public void deleteStudent(Student[] delstudentarray){
	}	
	
}
