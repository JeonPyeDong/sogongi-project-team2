
import java.util.Scanner;
public class Student {

	String name;
	static String[] sub;
	String code;
	static String passwd;
	
	
	static void passwdChange() { //��й�ȣ ����
		System.out.println("�����ϰ� ���� ��й�ȣ�� �Է��ϼ���");
		Scanner sc=new Scanner(System.in);
		String newpasswd=sc.next();
		System.out.println("�� �� �� �Է��ϼ���");
		Scanner s=new Scanner(System.in);
		String again=s.next();
		if(newpasswd==again)  //������ ��й�ȣ�� �� �� �Է��� �� ���� ������ Ȯ��
			passwd=newpasswd;
		else {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");  //��ġ���� ���� �� �ٽ� ����
			passwdChange();
			
		}
		
	}
	static void showClass(String ID) {
		
		for(int i=0;i<sub.length;i++)             //�������� ���� ���
			System.out.print(sub[i]+", ");
	}

	}

