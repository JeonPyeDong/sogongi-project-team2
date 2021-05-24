import java.util.Scanner;

public class Student {
	private String studentId;
	private String studentName;
	private String[] studentSubject = new String[6];
	private String studentPassword;
	private String studentHobby;
	private String studentIntroduce;
	
	public Student() {
		this.studentId=" ";
		for(int i = 0; i < studentSubject.length; i++) {
			studentSubject[i] = " ";
		}	
	}
	public Student(String id, String name, String[] subject, String password) {
		this.studentPassword = password;
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
	public String getStudentHobby() {
		return studentHobby;
	}
	public String getStudentIntroduce() {
		return studentIntroduce;
	}
	public void setStudentId(String id) {
		this.studentId = id;
	}
	public void setStudentName(String name) {
		this.studentName = name;
	}
	// public void setStudentSubject(String subject) {
	// 	this.studentSubject[Main.currentAccount] = subject;
	// }
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
				System.out.print("중복된 비밀번호입니다.\n다시: ");
				password1 = scan.next();
			}
			System.out.println("2차 확인");
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
			System.out.println("2차 확인");
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
		logInStudent();
	}
	//학생 본인이 수강중인 수업 열람 메소드.
	public void showStudent() {
		System.out.println("-----------------");
		System.out.println("학번: "+studentId+"  이름: "+studentName);
		System.out.print("수강과목: [ ");
		for(int i = 0; i < studentSubject.length; i++)
			System.out.print(studentSubject[i]+" ");
		System.out.println("]\n");
		logInStudent();
	}
	//학생 본인을 소개하는 말 설정 메소드.
	public void introduceStudent() {
		System.out.println("-----------------");
		Scanner scan = new Scanner(System.in);
		System.out.println("취미: "+studentHobby);
		System.out.println("한줄 소개: "+studentIntroduce+"\n");
		System.out.println("소개하는 말을 변경하시겠습니까?");
		System.out.println("1. 예");
		System.out.println("2. 아니오");
		System.out.print("입력 >> ");
		int input = scan.nextInt();
		while(true) {
			switch(input) {
			case 1:
				System.out.println("\n소개하는 말 변경.");
				System.out.print("취미 >> ");
				String hobby = scan.next();
				System.out.print("본인을 소개하는 말을 적으세요.\n>> ");
				String introduce = scan.next();
				studentHobby = hobby;
				studentIntroduce = introduce;
				System.out.println("설정이 완료되었습니다.");
				break;
			case 2:
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해 주세요.");
				System.out.println("1. 예");
				System.out.println("2. 아니오");
				System.out.print("입력 >> ");
				input = scan.nextInt();
				continue;
			}
			break;
		}
		logInStudent();
	}
	//학생으로 로그인 했을 때 선택.
	public int logInStudent() {
		int check_idx = -1;
		System.out.println("-----------------");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 수강중인 수업 열람");
		System.out.println("3. 본인을 소개하는 말 설정");
		System.out.println("0. 뒤로가기(로그아웃)");
		System.out.print("입력 >> ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		switch(input) {
		case 0:        //로그아웃
			check_idx = 1;
			break;
		case 1:        //학생 비밀번호 변경
			studentPasswordChange();
			break;
		case 2:        //학생 본인이 수강중인 수업 열람
			showStudent();
			break;
		case 3:        //학생 본인을 소개하는 말 설정
			introduceStudent();
			break;
		default:       
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력해 주세요. ");
			logInStudent();
			break;
		}
		return check_idx;
	}
	//Id를 전달 받으면 전체 학생 객체배열에서 중복되는 학번이 있는지 찾는 메소드.
	public static boolean isEqualStudentId(String id, Student[] stu) {
		boolean check = false; 
		for(int i = 0; i < stu.length; i++) {
			if(id.equals(stu[i].getStudentId()))
				check = true;
		}
		return check;
	}
	//로그인 시 학생 아이디가 일치한지 확인하는 메소드.
	public static int indexEqualStudentId(String id, Student[] stu) {
		for(int i = 0; i < stu.length; i++) {
			if(id.equals(stu[i].getStudentId())) {
				return i;     // 중복이 있다.
			}
		}
		return -1;     // 중복이 없다.
	}
	//로그인 시 학생 비밀번호가 일치한지 확인하는 메소드.
	public boolean isEqualStudentPassword(String password) {
		boolean check = false;
		if(password.equals(this.getStudentPassword()))
			check = true;
		return check;
	}

	public boolean hasSubject(String subject){
		for(int i = 0; i< studentSubject.length; i++){
			if(studentSubject[i].equals(subject)){
				return true;
			} else {
				return false;
			}	
		}
		return false;
	}

	public void enrollSubject(int code, String subject){
		studentSubject[code] = subject;
	}
}
