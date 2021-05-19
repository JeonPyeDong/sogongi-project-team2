import java.util.Scanner;

public class Main {
	public static Professor[] professorList = new Professor[6];
	public static Student[] studentList = new Student[100];
	public static int professorListCount = 0;
	public static int studentListCount = 0;
	public static int currentAccount = -1; // 로그인된 계정의 인덱스넘버로 활용할 예정. 로그인된 계정이 없다면 -1로 기본값.

	static void setUpProfessor() {
		String initpasswd = "1234";
		professorList[0] = new Professor("정희용", "선형대수학", initpasswd);
		professorList[1] = new Professor("김경백", "리눅스시스템", initpasswd);
		professorList[2] = new Professor("이귀상", "논리회로", initpasswd);
		professorList[3] = new Professor("김승원", "소프트웨어공학기초프로젝트", initpasswd);
		professorList[4] = new Professor("강대욱", "자바프로그래밍", initpasswd);
		professorList[5] = new Professor("임형석", "이산수학", initpasswd);
	}

	// 초기 메뉴를 print 하는 메뉴
	static void printMenu() {
		System.out.println("=== 소프트웨어공학과 수강과목 관리 프로그램 ===");
		System.out.println("1. 교수로 로그인");
		System.out.println("2. 학생으로 로그인");
		System.out.println("0. 프로그램 종료");
		System.out.print("입력 >> ");
	}

	public static void main(String[] args) {

		int exitFlag = 0;
		int saveFlag = 0; // 저장 후 변경이 있는지 확인하는 변수 0이면 변경후 미저장
		setUpProfessor();
		Scanner s = null;
		try {
			s = new Scanner(System.in);
			while (exitFlag == 0) {
				printMenu(); // 메뉴 출력
				int input = s.nextInt();
				switch (input) {
					case 1:
						System.out.println("안녕하세요. 교수님");
						System.out.println("이름을 입력하세요.");
						String name = s.nextLine();
						if(Professor.isEqualProfessorName(name, professorList)) {
							System.out.println("비밀번호를 입력하세요.");
							String password = s.nextLine();
							if(Professor.isEqualProfessorPassword(password, professorList)) {
								// currentAccount를 로그인된 계정의 인덱스넘버로 바꾸고 싶은데 모르겠음
								System.out.println(professorList[currentAccount].getName() + " 교수님 환영합니다!");
								// studentLogin처럼 Professor도 저런거 만들어줄 수 있음?
							}
							else {
								System.out.println("잘못된 비밀번호입니다.");
							}
						}
						else {
							System.out.println("잘못된 이름입니다.");
						}
						saveFlag = 0;
						break;
					case 2:
						System.out.println("안녕하세요. 학우님");
						System.out.println("학번을 입력하세요.");
						String id = s.nextLine();
						if(Student.isEqualStudentId(id, studentList)) {
							System.out.println("비밀번호를 입력하세요.");
							String password = s.nextLine();
							if(Student.isEqualStudentPassword(password, studentList)) {
								// currentAccount를 로그인된 계정의 인덱스넘버로 바꾸고 싶어
								System.out.println(studentList[currentAccount].getStudentName() + " 학우님 환영합니다!");
								studentList[currentAccount].studentLogin();
							}
							else {
								System.out.println("잘못된 비밀번호입니다.");
							}
						}
						else {
							System.out.println("잘못된 이름입니다.");
						}
						saveFlag = 0;
						break;
					case 0:
						if (saveFlag == 0) {
							System.out.println("변경 후 저장되지 않았습니다. 정말 종료하시겠습니까? (y/n)");
							String answer = s.next();
							if (answer.equals("y"))
								exitFlag = 1; // 정말 종료
							else {
								System.out.println("종료되지 않았습니다.");
								continue;
							}
						} else
							exitFlag = 1;
						break;
					default:
						System.out.println("메뉴에 있는 번호를 입력해주세요.");
				}
			}
		} catch (Exception e) {
			System.out.println("예외 발생(프로그램 종료)");
		} finally {
			s.close();
		}

	}
}