import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int exitFlag = 0;
		int saveFlag = 0; // 저장 후 변경이 있는지 확인하는 변수 0이면 변경후 미저장
		Professor whoPro = new Professor(null, null, null);
		Student whoStu = new Student(null, null, args);
		Scanner s = null;
		try {
			s = new Scanner(System.in);
			while (exitFlag == 0) {
				printMenu(); // 메뉴 출력
				int input = s.nextInt();
				switch (input) {
				case 1:
					//logInToProfessor(s);
					logProfessor(whoPro);
					System.out.println(whoPro.getName() + "교수님, 환영합니다!");
					saveFlag = 0;
					break;
				case 2:
					//logInToStudent(s);
					//logStudent();
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

	static void printMenu() {
		System.out.println("=== 소프트웨어공학과 수강과목 관리 프로그램 ===");
		System.out.println("1. 교수로 로그인");
		System.out.println("2. 학생으로 로그인");
		System.out.println("0. 프로그램 종료");
		System.out.print("입력 >> ");
	}

/*
	static void logInToProfessor(Scanner s) {
		String name;
		String password;
		System.out.println("-- 교수로 로그인 --");
		System.out.println("이름을 입력하세요.");
		System.out.print("입력 >> ");
		name = s.next();
		if (Professor.Professor(name)) {
			System.out.println("비밀번호를 입력하세요.");
			System.out.print("입력 >> ");
			password = s.next();
			if (Professor.Professor(password)) {
				System.out.println("교수님 환영합니다!");       // 교수 이름 불러와서 이름 000교수님 환영합니다 될 수 있게 하고 싶엉
				// 무엇을 보게 하고 싶은지 출력
 			}
			else
				System.out.println("E : 비밀번호가 틀렸습니다.");
		}
		else
			System.out.println("E : 존재하지 않는 교수입니다.");
	}
	
	static void logInToStudent(Scanner s) {
		String id;
		String passwd;
		System.out.println("-- 학생으로 로그인 --");
		System.out.println("학번을 입력하세요");
		System.out.println("입력 >> ");
		id = s.next();
		if (Student.student(id)) {
			System.out.println("비밀번호를 입력하세요.");
			System.out.println("입력 >> ");
			passwd = s.next();
			if (Student.student(passwd)) {
				System.out.println("학우님 환영합니다!");         //학생 이름 불러와서 000학우님 환영합니다 이렇게 하고 싶음 마찬가지로
				// 수강과목 출력
			}
			else
				System.out.println("E : 비밀번호가 틀렸습니다.");
		}
		else
			System.out.println("E : 존재하지 않는 학생입니다.");
	}
*/

private static Professor logProfessor(Professor whoPro){
Professor[] PF;
PF = new Professor[6];
Scanner sc = new Scanner(System.in);
String logid;
String logpw;
boolean idpass = false;
boolean pwpass = false;

System.out.println("ID를 입력하세요 >> ");
logid = sc.nextLine();
System.out.println("비밀번호를 입력하세요 >> ");
logpw = sc.nextLine();
 
		for(Professor i : PF){
			if(logid.equals(i.getName())) idpass = true;
			if(logpw.equals(i.getPassword())) pwpass = true;
			whoPro = i;
			break;
		}

	if(idpass && pwpass) {
	System.out.println("로그인 성공!");	
	}
	return whoPro;
 } 			// logProfessor() 끝

/*
private static Student logStudent(){
Student[] ST;
ST = new Student[];
Scanner sc = new Scanner(System.in);
String logid;
String logpw;
boolean idpass = false;
boolean pwpass = false;

System.out.println("ID를 입력하세요 >> ");
logid = sc.nextLine();
System.out.println("비밀번호를 입력하세요 >> ");
logpw = sc.nextLine();
 
		for(Professor i : PF){
			if(logid.equals(i.getStudentId())) idpass = true;
			if(logpw.equals(i.getStudentPassword())) pwpass = true;
			whoStu = i;
			break;
		}

	if(idpass && pwpass) {
	System.out.println("로그인 성공!");	
	}
	return whoStu;
 }			 // logStudent() 끝 
 */
}
