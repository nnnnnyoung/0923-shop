package Market;

import java.util.Scanner;

public class MainMenu {

	MemberManager mm= new MemberManager();
	Scanner in=new Scanner(System.in);
	Login ll= new Login(mm);

	
	MainMenu(){
		for(;;) {
			menu();{
				int selMenu=in.nextInt();
				in.nextLine();
				if(selMenu==1) {
					mm.newJoin();
				}else if(selMenu==2) {
					ll.login();
				}
			}
		}
	}
	
	
	
	
	
	public void menu() {
		System.out.println("메뉴 번호를 입력하세요");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		
	}
		
		


}
