import java.util.Scanner;

public class Professor {
	private String subject;
	private String name;
	private String password;
	
	public Professor() {
		
	}
	
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
		while (true) {
			// studentId를 전달하면 전체 학생배열에서 중복되는 학번이 있는지 찾는 메소드. 반환 타입은 boolean 을 가짐.
			// 학번이 중복이 되면,
			if (!true) {
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

		// new student에 입력받은 정보 저장.
		System.out.printf("학번 : [%s]%n이름 : [%s]%n과목명 : [%s]%n", studentId, studentName, studentSubject);
		return newstudent;
	}

	public void deleteStudent(Student[] s) {
		// main 클래스에서 학생객체배열을 생성하고 넘겨 줘야 함.
		System.out.println("삭제 하려는 학생의 학번을 입력해 주세요 : ");
		Scanner input = new Scanner(System.in);
		String srt;
		int index = 0;
		// 삭제할 학생의 인덱스를 저장할 변수
		boolean isEqualId = false;
		// 반복문에서 학생을 찾았을 경우 true로 변경

		while (true) {
			// 학번 찾는 반복문
			srt = input.next();
			for (int i = 0; i < s.length; i++) { // 학생배열의 길이만큼 반복
				if (srt.equals(s[i].getStudentId())) { // 입력한 값이 학생의 학번과 같으면 그 인덱스를 저장한다.
					index = i; // 인덱스 저장
					isEqualId = true; // 학생을 찾음
					break;
				}
			}

			if (isEqualId == false) {
				System.out.println("찾으시는 학생의 학번이 존재 하지 않습니다.");
			} else {
				String[] k = s[index].getStudentSubjects();
				for (int i = 0; i < k.length; i++) {
					if (k[i].equals(this.getSubject())) {
						k[i] = "";
						break;
					}
				}
				System.out.printf("학번 : [%s]%n이름 : [%s]%n과목명 : [%s]%n", s[index].getStudentId(),
						s[index].getStudentName(), this.getSubject());
				System.out.println("해당 학생이 교수님의 과목에서 삭제 되었습니다.");
				break;
			}
		}
		return;
	}

	public boolean isEqualProfessorName(String s, Professor[] p) {
		// main 클래스에서 교수객체배열을 생성하고 문자열과 함께 넘겨 줘야 함.
		for (int i = 0; i < p.length; i++) {
			if (p[i].getName() == s) {
				return true;
				// 중복이 있다.
			}
		}
		return false;
		// 중복이 없다.
	}

	public boolean isEqualProfessorPassword(String s, Professor[] p) {
		// main 클래스에서 교수객체배열과 문자열을 매개변수로 받는다.
		for (int i = 0; i < p.length; i++) {
			if (p[i].getPassword() == s) {
				return true;
				// 중복이 있다.
			}
		}
		return false;
		// 중복이 없다.
	}

}
