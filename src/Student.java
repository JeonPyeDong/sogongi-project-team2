import java.util.Scanner;

public class Student {
	private String studentId;
	private String studentName;
	private String[] studentSubject = new String[6];
	private String studentPassword;
	
	public Student(String id, String name, String[] subject) {
		this.studentPassword = "1234";
	    this.studentId = id;
	    this.studentName = name;
	    this.studentSubject = subject;
	}
	public String getStudentId() {
		return studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public String[] getStudentSubject() {
		return studentSubject;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentId(String id) {
		this.studentId = id;
	}
	public void setStudentName(String name) {
		this.studentName = name;
	}
	public void setStudentSubject(String[] subject) {
		this.studentSubject = subject;
	}
	public void setStudentPassword(String password) {
		this.studentPassword = password;
	}
	//학생 비밀번호 변경 메소드.
	public void studentPasswordChange() {
		System.out.println("-----------------");
		Scanner scan = new Scanner(System.in);
		System.out.print("새로운 비밀번호를 입력하시오.>> ");
		String password1 = scan.next();
		if(password1.equals(getStudentPassword())) {//새 비밀번호와 기존 비밀번호가 중복인지 확인
			while(password1.equals(getStudentPassword())) {
				System.out.print("중복된 비밀번호입니다. 다시: ");
				password1 = scan.next();
			}
			while(true) {     //2차 확인
				System.out.print("한번 더 입력하세요. >> ");
				String password2 = scan.next();
				if(password2.equals(password1)) {
					setStudentPassword(password2);
					System.out.println("비밀번호가 변경되었습니다. "+password2);
					break;
				}
			}
		}
		else {
			while(true) {     //2차 확인
				System.out.print("한번 더 입력하세요. >> ");
				String password2 = scan.next();
				if(password2.equals(password1)) {
					setStudentPassword(password2);
					System.out.println("비밀번호가 변경되었습니다. "+password2);
					break;
				}
			}
		}
		studentLogin();
	}
	//학생 본인이 수강중인 수업 열람 메소드.
	public void showStudent() {
		System.out.println("-----------------");
		System.out.println("학번: "+studentId+"  이름: "+studentName);
		System.out.print("수강과목: ");
		System.out.print("[ ");
		for(int i = 0; i < studentSubject.length; i++)
			System.out.print(studentSubject[i]+" ");
		System.out.println("]");
		studentLogin();
	}
	//학생으로 로그인 했을 때 선택.
	public void studentLogin() {
		System.out.println("-----------------");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 수강중인 수업 열람");
		System.out.print("입력 >> ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		switch(input) {
		case 1:        //학생 비밀번호 변경
			studentPasswordChange();
			break;
		case 2:        //학생 본인이 수강중인 수업 열람
			showStudent();
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			studentLogin();
		}
	}
	//Id를 전달 받으면 전체 학생 객체배열에서 중복되는 학번이 있는지 찾는 메소드
	//로그인 시 아이디가 일치한지 확인하는 메소드
	public boolean isEqualStudentId(String id, Student[] stu) {
		boolean check = false; 
		for(int i = 0; i < stu.length; i++) {
			if(id.equals(stu[i].getStudentId()))
				check = true;
		}
		return check;
	}
	//로그인 시 비밀번호가 일치한지 확인하는 메소드
	public boolean isEqualStudentPassword(String password, Student[] stu) {
		boolean check = false; 
		for(int i = 0; i < stu.length; i++) {
			if(password.equals(stu[i].getStudentPassword()))
				check = true;
		}
		return check;
	}
	
}
