import java.util.Scanner;

public class Professor {
	private String subject;
	private String name;
	private String password;
	private int studentNumber;

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

	public String getSubject() {
		return this.subject;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}
	
	public int getStudentNumber() {
		return this.studentNumber;
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
	
	public void setStudentNumber(int i) {
		this.studentNumber = i;
	}

	// 학생을 생성하는 메소드. 생성된 student[] 객체를 반환한다.
	public Student[] addStudent() {
		Scanner sc = new Scanner(System.in);
		String studentId;
		String studentName;
		Student[] newstudent = new Student[100];
		for(int i = 0; i < 100; i++) {
			newstudent[i] = new Student();
		}
		int index = getStudentNumber(); // 학생객체배열의 인덱스를 불러옴.
		int retry = 0; // 학생추가 메소드를 반복하는 기능을 구현하기 위해 필요한 변수
		while(true) {
			if(retry == 0) {
				System.out.println("-- 학생 추가 --");
				System.out.print("학번 입력 >> ");
				studentId = sc.next();
				 while (true) {
					// studentId를 전달하면 전체 학생배열에서 중복되는 학번이 있는지 찾는 메소드. 반환 타입은 boolean 을 가짐.
					// 학번이 중복이 되면,
					if (Student.isEqualStudentId(studentId,newstudent)) {
						System.out.println("학번이 중복되었습니다. 다시 입력해주세요.");
						System.out.print("학번 입력 >> ");
						studentId = sc.next();
					} else {
						newstudent[index].setStudentId(studentId); // 학번저장
						System.out.println("학번 등록완료.");
						break;
					}	
		}
				
				System.out.print("학생 이름 입력 >> ");
				studentName = sc.next();
				newstudent[index].setStudentName(studentName); // 이름 저장
				newstudent[index].setStudentSubject(this.subject); // 현재 로그인된 교수님의 과목으로 저장
				System.out.println((index+1)+"번 째 학생 추가 하였습니다.");
				System.out.printf("학번 : [%s]%n이름 : [%s]%n과목명 : [%s]%n", newstudent[index].getStudentId(), newstudent[index].getStudentName(), this.subject);
				System.out.println("다시 한번 학생을 추가 하시겠습니까?");
				System.out.println("0. 예"); 
				System.out.println("1. 아니요");
				retry = sc.nextInt(); 
				while(true) {
				switch(retry) {
				
				case 0 :
					break;
					
				case 1 :
					break;
					
				default :
					System.out.println("다시 입력하여 주세요.");
					retry = sc.nextInt();

					if(retry == 0 || retry == 1) {break;} // 1과 0이 아닌 다른 수를 입력하면 반복하게 만듬.
					
					else {continue;}
								}
				break;
							}
				index++; 
				 setStudentNumber(index); // 1 더한 index 값을 setter를 통해 설정함.
			} 
			
			else {break;} // retry가 1이면 종료
		}
		return newstudent; // loginProfessor로 넘어감.
			}

	// 학생의 과목을 삭제하는 메소드. 교수의 과목을 받아올 필요가 없다.
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
				String[] k = s[index].getStudentSubject();
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
		if(passwd.equals(this.getPassword())){
			return true;
		}
		else{
			return false;
		}
	}

	// 학생의 정보를 수정하는 메소드. 미완
	public void modifyStudent(Student[] s) {
		// main 클래스에서 학생객체배열을 생성하고 넘겨 줘야 함.
		System.out.println("수정 하려는 학생의 학번을 입력해 주세요 : ");
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
				break; // 종료.
			} else {
				System.out.println("0. 이름수정");
				System.out.println("1. 학번수정");
				int s1 = input.nextInt();
				switch (s1) {
					case 0:
						System.out.println("수정하려는 학생의 이름을 입력해 주세요.");
						String newName = input.next();
						s[index].setStudentName(newName);
						break;
					case 1:
						System.out.println("수정하려는 학생의 학번을 입력해 주세요.");
						String newId = input.next();
						s[index].setStudentId(newId);
						break;
					default:
						System.out.println("0과 1 중 하나만 선택해 주세요.");
				}
			}
			System.out.printf("학번 : [%s]%n이름 : [%s]%n과목명 : [%s]%n", s[index].getStudentId(), s[index].getStudentName(),
					this.getSubject());
			System.out.println("해당 학생이 교수님의 과목에서 수정 되었습니다.");
			break;
		}

		return;
	}

}
