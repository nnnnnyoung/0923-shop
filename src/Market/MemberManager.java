package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {
	Scanner in=new Scanner(System.in); 
	ArrayList <Member> mlist=new ArrayList <>();
	

	public void newJoin() {
		Member newMember=new Member();
		System.out.println("�̸��� �Է��ϼ���");
		String name=in.nextLine();
		System.out.println("ID�� �Է��ϼ���");
		String id=in.nextLine();
		boolean flag=true;
		for(int i=0; i<mlist.size(); i++) {
			if(mlist.get(i).id.equals(id)) {
				System.out.println("�ߺ��� ���̵��Դϴ�.");
				flag=false;
			}
		}
		if(flag) {
			System.out.println("��й�ȣ�� �Է��ϼ���");
			String pw=in.nextLine();
			System.out.println("���̸� �Է��ϼ���");
			int age=in.nextInt();
			in.nextLine();
			if(age<14) {
				System.out.println("14�� �̸� ���ԺҰ�");
				return;
			}else {
				newMember.join(name, id, pw, age);
				mlist.add(newMember);
				System.out.println("ȸ�������� �����մϴ�!");
			}
		}
		return;

	}
	
	

	
	
	
}
