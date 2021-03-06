import java.util.Scanner;

public class Main {
	public static Professor[] professorList = new Professor[6];
	public static Student[] studentList = new Student[100];
	public static int professorListCount = 0;
	public static int studentListCount = 0;
	public static int currentAccount = -1; // 로그인된 계정의 인덱스넘버로 활용할 예정. 로그인된 계정이 없다면 -1로 기본값.

	static void setUpProfessor() {
		String initpasswd = "1234";
		professorList[0] = new Professor("정희용", "선형대수학", initpasswd, 0);
		professorList[1] = new Professor("김경백", "리눅스시스템", initpasswd, 1);
		professorList[2] = new Professor("이귀상", "논리회로", initpasswd, 2);
		professorList[3] = new Professor("김승원", "소프트웨어공학기초프로젝트", initpasswd, 3);
		professorList[4] = new Professor("강대욱", "자바프로그래밍", initpasswd, 4);
		professorList[5] = new Professor("임형석", "이산수학", initpasswd, 5);
	}

	static void setUpStudent() {
		for (int i = 0; i < 100; i++) {
			studentList[i] = new Student();
		}
	}

	// 초기 메뉴를 print 하는 메뉴
	static void printMenu() {
		System.out.println("=== 소프트웨어공학과 수강과목 관리 프로그램 ===");
		System.out.println("1. 교수로 로그인");
		System.out.println("2. 학생으로 로그인");
		System.out.println("0. 프로그램 종료");
		System.out.print("입력 >> ");
	}

	// 교수로 로그인 했을 때 선택
	public static int logInProfessor() {
		int check_idx = -1; // -1 이면 로그인 유지
		System.out.println("-----------------");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 삭제");
		System.out.println("3. 학생 정보 수정");
		System.out.println("4. 학생 정보 표시");
		System.out.println("5. 비밀번호 변경");
		System.out.println("6. 학생 검색");
		System.out.println("0. 로그아웃");
		System.out.print("입력 >> ");
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		switch (input) {
			case 0: //
				check_idx = 1; // 1 이면 로그아웃
				break;
			case 1: // 학생 추가
				showStudentList();
				System.out.println();
				studentListCount = professorList[currentAccount].addStudent(studentList, studentListCount); // studentList를
																											// 매개변수로 넘김.
				break;
			case 2: // 학생 삭제
				showStudentList();
				System.out.println();
				professorList[currentAccount].deleteStudent(studentList);
				break;
			case 3: // 학생 정보수정
				showStudentList();
				System.out.println();
				professorList[currentAccount].modifyStudent(studentList);
				break;
			case 4:
				showStudentList();
				break;
			case 5:
				professorList[currentAccount].changePassword();
				break;
			case 6:
				searchStudent();
				break;
			default:
				System.out.println("잘못된 입력입니다. ");
				System.out.println("다시 입력해 주세요. ");
				break;
		}
		return check_idx;
	}

	public static void showStudentList() {
		System.out.println();
		System.out.println("============== 전남대학교 소프트웨어공학과 ==============");
		System.out.printf("%7s%7s---------------수강과목---------------%n", "학번", "이름");
		for (int i = 0; i < studentListCount; i++) {
			System.out.printf("%7s%7s", studentList[i].getStudentId(), studentList[i].getStudentName());
			for (int j = 0; j < 6; j++) {
				if (studentList[i].getStudentSubject()[j] == "") {
					continue;
				} else {
					System.out.printf("%s ", studentList[i].getStudentSubject()[j]);
				}
			}
			System.out.printf("%n");
		}
		System.out.println();
	}

	public static void searchStudent() {
		int searchResultIndex = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("찾으려는 학생의 학번 혹은 이름을 입력해주세요.");
		String searchId = sc.next();
		for (int i = 0; i < studentListCount; i++) {
			if (searchId.equals(studentList[i].getStudentId())) {
				System.out.printf("학번 : %s 이름 : %s%n",
					studentList[i].getStudentId(),
					studentList[i].getStudentName()
				);
				System.out.printf("취미 : %s%n한줄로 하는 자기소개 : %s%n%n", 
				studentList[i].getStudentHobby(),
				studentList[i].getStudentIntroduce());
				
				searchResultIndex = i;
				break;
			}
		}

		if (searchResultIndex == -1) {
			int count = 0;
			for (int i = 0; i < studentListCount; i++) {
				if (searchId.equals(studentList[i].getStudentName())) {
					System.out.printf("학번 : %s 이름 : %s%n",
					studentList[i].getStudentId(),
					studentList[i].getStudentName()
					);
					System.out.printf("취미 : %s%n한줄로 하는 자기소개 : %s%n%n", 
					studentList[i].getStudentHobby(),
					studentList[i].getStudentIntroduce()
					);
					count++;
				}
			}
			System.out.printf("총 %d 건의 검색결과를 출력하였습니다.%n", count);
		}

		

	}

	public static void main(String[] args) {

		int exitFlag = 0;
		int saveFlag = 0; // 저장 후 변경이 있는지 확인하는 변수 0이면 변경후 미저장
		setUpProfessor();
		setUpStudent();
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
						System.out.print("입력 >> ");
						String name = s.next();
						currentAccount = Professor.indexEqualProfessorName(name, professorList);
						while (true) {
							if (currentAccount == -1) {
								System.out.println("요청하신 이름이 존재하지 않습니다. 다시입력해주세요.");
								System.out.print("입력 >> ");
								name = s.next();
								currentAccount = Professor.indexEqualProfessorName(name, professorList);
							} else {
								break;
							}
						}
						System.out.printf("%s 교수님 %n비밀번호를 입력해주세요. ", name);
						System.out.print("\n입력 >> ");
						String professorPassword = s.next();
						while (true) {
							if (!professorList[currentAccount].isEqualProfessorPassword(professorPassword)) {
								System.out.println("비밀번호가 일치하지 않습니다. 다시 시도 해주세요.");
								System.out.print("입력 >> ");
								professorPassword = s.next();
							} else {
								System.out.println("-----------------");
								System.out.println(professorList[currentAccount].getName() + "교수님, 환영합니다.");
								break;
							}
						}
						int exit = -1;
						while (true) {
							if (exit == -1) {
								exit = logInProfessor();
							} else {
								break;
							}
						}
						saveFlag = 0;
						break;

					case 2:
						System.out.println("안녕하세요. 학우님");
						System.out.println("학번을 입력하세요.");
						System.out.print("입력 >> ");
						String id = s.next();
						currentAccount = Student.indexEqualStudentId(id, studentList);
						while (true) {
							if (currentAccount == -1) {
								System.out.println("요청하신 이름이 존재하지 않습니다. 다시입력해주세요.");
								System.out.print("입력 >> ");
								id = s.next();
								currentAccount = Student.indexEqualStudentId(id, studentList);
							} else {
								break;
							}
						}
						System.out.printf("%s 학우님 %n비밀번호를 입력해주세요. ", studentList[currentAccount].getStudentName());
						System.out.print("\n입력 >> ");
						String studentPassword = s.next();
						while (true) {
							if (!studentList[currentAccount].isEqualStudentPassword(studentPassword)) {
								System.out.println("비밀번호가 일치하지 않습니다. 다시 시도 해주세요.");
								System.out.print("입력 >> ");
								studentPassword = s.next();
							} else {
								System.out.println(studentList[currentAccount].getStudentName() + "학우님, 환영합니다.");
								break;
							}
						}
						int exit2 = -1;
						while (true) {
							if (exit2 == -1) {
								exit2 = studentList[currentAccount].logInStudent();
							} else {
								break;
							}
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
			e.printStackTrace();
			System.out.println("예외 발생(프로그램 종료)" + " " + e.getMessage());
			// 예외경로와 무슨 예외를 던졌는지 알게끔 수정함.
		} finally {
			s.close();
		}

	}
}
