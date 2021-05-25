import java.util.Scanner;

public class Professor {
	private String subject;
	private String name;
	private String password;
	private int SUBJECT_CODE;

	public Professor() {
	}

	public Professor(String n, String p) {
		this.name = n;
		this.password = p;
	}

	public Professor(String n, String s, String p) {
		this.name = n;
		this.subject = s;
		this.password = p;
	}

	public Professor(String n, String s, String p, int code) {
		this.name = n;
		this.subject = s;
		this.password = p;
		this.SUBJECT_CODE = code; 
	}

	public String getSubject() {
		return this.subject;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
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

	
	public int addStudent(Student[] newstudent, int idx) {
		Scanner sc = new Scanner(System.in);
		String studentId;
		String studentName;
		int retry = 0; // 학생추가 메소드를 반복하는 기능을 구현하기 위해 필요한 변수
			 while (true) {
				if(retry != 0){break;}
				System.out.println("-- 학생 추가 --");
				System.out.print("학번 입력 >> ");
				studentId = sc.next();
					// studentId를 전달하면 전체 학생배열에서 중복되는 학번이 있는지 찾는 메소드. 반환 타입은 boolean 을 가짐.
					// 학번이 중복이 되면, 두가지로 나뉜다. 
					// 1. 이미 등록된 학생인데, 해당 교수의 수업을 안듣는 경우
					// 2. 이미 등록된 학생에, 해당 교수의 수업을 듣는 경우
				if (Student.isEqualStudentId(studentId, newstudent)) {
					System.out.println("이미 학생 인적사항부에는 등록된 학생입니다.");
					System.out.println("따라서, 해당 수업을 수강 상태로만 바꿉니다.");
					int tempStudentIdx = Student.indexEqualStudentId(studentId, newstudent);
					newstudent[tempStudentIdx].enrollSubject(SUBJECT_CODE, this.getSubject());
					System.out.printf("학번 : [%s]%n이름 : [%s]%n과목명 : [%s]%n", 
					newstudent[tempStudentIdx].getStudentId(), 
					newstudent[tempStudentIdx].getStudentName(), 
					newstudent[tempStudentIdx].getStudentSubject()[SUBJECT_CODE]);
				} else {
					newstudent[idx].setStudentId(studentId); // 학번저장
					System.out.println("학번 등록완료.");
					System.out.print("학생 이름 입력 >> ");
					studentName = sc.next();
					newstudent[idx].setStudentName(studentName); // 이름 저장
					newstudent[idx].enrollSubject(SUBJECT_CODE, this.getSubject()); // 현재 로그인된 교수님의 과목으로 저장
					newstudent[idx].setStudentPassword("1234");
					idx++;
				}	
			System.out.println("다시 한번 학생을 추가 하시겠습니까?");
			System.out.println("0. 예"); 
			System.out.println("1. 아니오");
			retry = sc.nextInt(); 
			} 
			return idx;
	} 	


	// 학생의 과목을 삭제하는 메소드. 교수의 과목을 받아올 필요가 없다.
	public void deleteStudent(Student[] s) {
		// main 클래스에서 학생객체배열을 생성하고 넘겨 줘야 함.
		System.out.println("삭제 하려는 학생의 학번을 입력해 주세요 : ");
		Scanner input = new Scanner(System.in);
		String studentId;
		int index = 0;
		// 삭제할 학생의 인덱스를 저장할 변수
		boolean isEqualId = false;
		// 반복문에서 학생을 찾았을 경우 true로 변경

		while (true) {
			// 학번 찾는 반복문
			studentId = input.next();
			for (int i = 0; i < s.length; i++) { // 학생배열의 길이만큼 반복
				if (studentId.equals(s[i].getStudentId())) { // 입력한 값이 학생의 학번과 같으면 그 인덱스를 저장한다.
					index = i; // 인덱스 저장
					isEqualId = true; // 학생을 찾음
					break;
				}
			}

			if (isEqualId == false) {
				System.out.println("찾으시는 학생의 학번이 존재 하지 않습니다.");
				System.out.println("다시 한번 입력해 주세요.");
			} else {
				s[index].getStudentSubject()[SUBJECT_CODE] = "";
				System.out.printf("학번 : [%s]%n이름 : [%s]%n과목명 : [%s]%n", 
				s[index].getStudentId(),
				s[index].getStudentName(), 
				this.getSubject());
				System.out.println("해당 학생이 교수님의 과목에서 삭제 되었습니다.");
				break;
			}
		}
		return;
	}
	// 교수의 이름이 일치하는지 확인하는 메소드, 인덱스는 별도로 반환하지 않음.
	public static int indexEqualProfessorName(String s, Professor[] p) {
		for (int i = 0; i < p.length; i++) {
			if (s.equals(p[i].getName())) {
				return i;
				// 중복이 있다.
			}
		}
		return -1;
		// 중복이 없다.
	}

	public boolean isEqualProfessorPassword(String passwd) {
		if (passwd.equals(this.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	// 학생의 정보를 수정하는 메소드. 미완
	public void modifyStudent(Student[] s) {
		// main 클래스에서 학생객체배열을 생성하고 넘겨 줘야 함.
		System.out.println("수정 하려는 학생의 학번을 입력해 주세요 : ");
		Scanner input = new Scanner(System.in);
		String studentId;
		boolean isEqualId = false;
		int studentIdx = -1;
		// 반복문에서 학생을 찾았을 경우 true로 변경
		while (true) {
			// 학번 찾는 반복문
			studentId = input.next();
			for (int i = 0; i < s.length; i++) { // 학생배열의 길이만큼 반복
				if (studentId.equals(s[i].getStudentId())) { // 입력한 값이 학생의 학번과 같으면 그 인덱스를 저장한다.
					isEqualId = true; // 학생을 찾음
					studentIdx = i;
					break;
				}
			}

			if (isEqualId == false) {
				System.out.println("찾으시는 학생의 학번이 존재 하지 않습니다.");
				break; // 종료.
			} else {
				System.out.println("0. 이름 수정");
				System.out.println("1. 학번 수정");
				int s1 = input.nextInt();
				switch (s1) {
					case 0:
						System.out.println("수정하려는 학생의 이름을 입력해 주세요.");
						String newName = input.next();
						s[studentIdx].setStudentName(newName);
						break;
					case 1:
						System.out.println("수정하려는 학생의 학번을 입력해 주세요.");
						String newId = input.next();
						s[studentIdx].setStudentId(newId);
						break;
					default:
						System.out.println("0과 1 중 하나만 선택해 주세요.");
				}
			}
			System.out.printf("수정된 내용%n학번 : [%s]%n이름 : [%s]%n", 
				s[studentIdx].getStudentId(),
				s[studentIdx].getStudentName());
			break;
		}

		return;
	}

	public void changePassword(){
		Scanner sc = new Scanner(System.in);
		System.out.println("-----비밀번호 변경-----");
		System.out.print("현재 비밀번호를 입력해주세요:");
		String currentPassword = sc.next();
		String changingPassword;
		String confirmPassword; 
		while(true){
			if(!currentPassword.equals(this.getPassword())){
				System.out.println("현재 비밀번호가 올바르지 않습니다. 다시시도 해주세요.");
				System.out.print("비밀번호 입력 :");
				currentPassword = sc.next();
			} else {
				System.out.println("변경할 비밀번호를 입력해주십시오.");
				break;
			}	
		}
		System.out.print("변경할 비밀번호 입력 :");
		changingPassword = sc.next();
		System.out.println("다시 한번 입력해주세요.");
		System.out.print("재입력 :");
		confirmPassword = sc.next();
		while(true){
			if(changingPassword.equals(confirmPassword)){
				System.out.printf("비밀번호가 %s 에서 %s 로 변경되었습니다.%n",
				currentPassword,
				changingPassword);
				break;
			}else{
				System.out.println("재입력된 비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
				System.out.print("재입력 :");
				confirmPassword = sc.next();
			}
		}
		this.setPassword(confirmPassword);
	}
}
