package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {
	Scanner in=new Scanner(System.in); 
	ArrayList <Member> mlist=new ArrayList <>();
	

	public void newJoin() {
		Member newMember=new Member();
		System.out.println("이름을 입력하세요");
		String name=in.nextLine();
		System.out.println("ID를 입력하세요");
		String id=in.nextLine();
		boolean flag=true;
		for(int i=0; i<mlist.size(); i++) {
			if(mlist.get(i).id.equals(id)) {
				System.out.println("중복된 아이디입니다.");
				flag=false;
			}
		}
		if(flag) {
			System.out.println("비밀번호를 입력하세요");
			String pw=in.nextLine();
			System.out.println("나이를 입력하세요");
			int age=in.nextInt();
			in.nextLine();
			if(age<14) {
				System.out.println("14세 미만 가입불가");
				return;
			}else {
				newMember.join(name, id, pw, age);
				mlist.add(newMember);
				System.out.println("회원가입을 축하합니다!");
			}
		}
		return;

	}
	
	

	
	
	
}
