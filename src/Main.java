import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int exitFlag = 0;
		int saveFlag = 0; // 저장 후 변경이 있는지 확인하는 변수 0이면 변경후 미저장

		Scanner s = null;
		try {
			s = new Scanner(System.in);
			while (exitFlag == 0) {
				printMenu(); // 메뉴 출력
				int input = s.nextInt();
				switch (input) {
				case 1:
					//교수로 로그인
					saveFlag = 0;
					break;
				case 2:
					//학생으로 로그인
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
					System.out.println("메뉴에 있는 번호를 입력해주세요");
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
}