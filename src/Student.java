
import java.util.Scanner;
public class Student {

	String name;
	static String[] sub;
	String code;
	static String passwd;
	
	
	static void passwdChange() { //비밀번호 변경
		System.out.println("변경하고 싶은 비밀번호를 입력하세요");
		Scanner sc=new Scanner(System.in);
		String newpasswd=sc.next();
		System.out.println("한 번 더 입력하세요");
		Scanner s=new Scanner(System.in);
		String again=s.next();
		if(newpasswd==again)  //변경할 비밀번호를 두 번 입력해 두 개가 같은지 확인
			passwd=newpasswd;
		else {
			System.out.println("비밀번호가 일치하지 않습니다.");  //일치하지 않을 시 다시 진행
			passwdChange();
			
		}
		
	}
	static void showClass(String ID) {
		
		for(int i=0;i<sub.length;i++)             //수강중인 과목 출력
			System.out.print(sub[i]+", ");
	}

	}

