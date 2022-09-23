package Market;

import java.util.Scanner;

public class Login {

	Scanner in=new Scanner(System.in);
	MemberManager mm=null;
	GoodsManager gm=new GoodsManager();
	BasketGoods bg=new BasketGoods ();
	
	public Login(MemberManager mm) {
		this.mm=mm;
	}
	
	public void login() {
		System.out.println("ID를 입력하세요");
		String id=in.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw=in.nextLine();
		boolean flag=true;
		for(int i=0; i<mm.mlist.size(); i++) {
			if(mm.mlist.get(i).id.equals(id)&&mm.mlist.get(i).pw.equals(pw)) {
				//id와 pw모두 일치해야 로그인이 됨
				flag=false;
				System.out.println("로그인 완료!");
				for(;;) {
					System.out.println("메뉴 번호를 입력하세요");
					System.out.println("1. 내정보보기");
					System.out.println("2. 회원정보 수정");
					System.out.println("3. 쇼핑하기");
					System.out.println("4. 물건관리");
					System.out.println("5. 로그아웃");
					int no=in.nextInt();//로그인 한 멤버의 주소값을 변수 a에 저장
					in.nextLine();
					Member a=mm.mlist.get(i);
					if(no==1) {
						prt(a);
					}else if(no==2) {
						modi(a);
					}else if(no==3) {
						goshopping(a);
					}else if(no==4) {
						if(i<3) {
						gm.start();	
						}else {
						System.out.println("권한이 없습니다."); 
						//멤버 리스트의 인덱스 2까지 저장된 멤버만 권한을 줌
						//3번 이후로 회원가입한 멤버는 권한이 없음
						}
						
					}else if(no==5) {
						System.out.println("로그아웃 되었습니다.");
						break;
					}
				}
				
			}
		}
		if (flag) {
			System.out.println("ID와 비밀번호를 확인하세요");
		}
	}
	
	
	
	public void prt(Member a) {
		System.out.println("ID: "+a.id);
		System.out.println("이름: "+a.name);
		System.out.println("나이: "+a.age);
	}



	public void goshopping(Member a) {
		for(;;) {
			System.out.println("1. 구매하기");
			System.out.println("2. 장바구니 보기");
			System.out.println("3. 장바구니 비우기");
			System.out.println("4. 이전메뉴");
			int no=in.nextInt();
			in.nextLine();
			if(no==1) {
				shopping(a);
			}else if(no==2) {
				shopPrt(a);
			}else if(no==3) {
				Clear(a);
			}else if(no==4) {
				break;
			}
		}
	}

	private void Clear(Member a) {
		// TODO Auto-generated method stub
		System.out.println("1. 선택한 물건 비우기");
		System.out.println("2. 장바구니 전체 비우기");
		int no=in.nextInt();
		in.nextLine();
		if(no==1) {
			shopPrt(a);
			System.out.println("삭제할 물건의 이름을 입력하세요");
			String delName=in.nextLine();
			boolean flag=true;
			for(int i=0; i<a.basket.size(); i++) {				
				if(a.basket.get(i).buyGoods.name.equals(delName)) {
					a.basket.remove(i);
					flag=false;
					System.out.println(delName+"이(가) 삭제되었습니다.");
				}
			}
			if(flag) {
				System.out.println(delName+"은(는) 장바구니에 없습니다.");
			}
			
		}else if(no==2) {
			a.basket.clear();
			System.out.println("장바구니가 비워졌습니다.");
		}

	}


	private void shopPrt(Member a) {
		for(int i=0; i<a.basket.size(); i++) {
			a.basket.get(i).prt();
		}
		if(a.basket.size()==0) {
			System.out.println("장바구니가 비었습니다.");
		}
		
	}

	private void shopping(Member a) {
		// TODO Auto-generated method stub
		gm.GoodsList();
		System.out.println("구매할 번호 입력");
		int no=in.nextInt();
		in.nextLine();
		if(no<gm.mlist.size()) {
			boolean flag=true;
			for(int i=0; i<a.basket.size(); i++) {
				if(a.basket.get(i).buyGoods.name==gm.mlist.get(no).name) {
					System.out.println("수량입력");
					int no1=in.nextInt();
					in.nextLine();
					a.basket.get(i).buycnt+=no1;
					gm.mlist.get(no).cnt-=no1;
					flag=false;
					
				}		
		}if(flag) {
			BasketGoods bg=new BasketGoods();
			bg.buyGoods=gm.mlist.get(no);
			System.out.println("수량입력");
			int no1=in.nextInt();
			in.nextLine();
			bg.buycnt=no1;
			gm.mlist.get(no).cnt-=no1; //구매한 수량만큼 재고가 빠짐
			a.basket.add(bg);
		}
		}
		else {
			System.out.println("해당하는 상품이 없습니다.");
		}
	}

	public void modi(Member a) {
		System.out.println("무엇을 수정할까요?");
		System.out.println("1. 이름 수정");
		System.out.println("2. 비밀번호 수정");
		System.out.println("3. 나이 수정");
		System.out.println("4. 이전메뉴");
		int no=in.nextInt();
		in.nextLine();
		if(no==1) {
			System.out.println("무엇으로 수정할까요?");
			String newName=in.nextLine();
			a.name=newName;
			System.out.println("이름 수정이 완료되었습니다.");
		}else if(no==2) {
			System.out.println("무엇으로 수정할까요?");
			String newPw=in.nextLine();
			a.pw=newPw;
			System.out.println("비밀번호 수정이 완료되었습니다.");
		}else if(no==3) {
			System.out.println("무엇으로 수정할까요?");
			int newAge=in.nextInt();
			in.nextLine();
			a.age=newAge;
			System.out.println("나이 수정이 완료되었습니다.");
		}else if(no==4) {
			return;
		}
		

				
		
	}
}
