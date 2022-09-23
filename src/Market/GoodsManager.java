package Market;

import java.util.ArrayList;
import java.util.Scanner;


public class GoodsManager {
	
	ArrayList<Goods> mlist=new ArrayList<>();
	
	Scanner in=new Scanner (System.in);
	
	
	GoodsManager(){
//		for(;;) {
//			menu(); {
//				int num=in.nextInt();
//				in.nextLine();
//				if(num==1) {
//					inputGoods();
//				}else if(num==2) {
//					GoodsList();
//				}else if(num==3) {
//					modiGoods();
//				}else if(num==4) {
//					delGoods();
//				}else if(num==5) {
//					searchGoods();
//				}else if(num==6) {
//					break;
//				}					
//			}
//		}
	}
	

	private void searchGoods() {
		// TODO Auto-generated method stub
		System.out.println("검색할 단어를 입력해주세요");
		String shName=in.nextLine();
		for(int i=0; i<mlist.size(); i++) {
			if(mlist.get(i).name.contains(shName)) {
				mlist.get(i).prt();
			}
		}
	}


	private void delGoods() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 상품의 이름을 입력하세요");
		String delName=in.nextLine();
		boolean flag=true;
		for(int i=0; i<mlist.size(); i++) {
			if(mlist.get(i).name.equals(delName)) {
				mlist.remove(i);
				//i번 앞으로 한칸씩 당겨진다.
				System.out.println("삭제완료");
				flag=false;
				break;
			}	
		}
		if(flag) {
			System.out.println("해당하는 상품이 존재하지 않습니다.");
		}
	}


	private void modiGoods() {
		// TODO Auto-generated method stub
		System.out.println("수정할 상품의 이름을 입력하세요");
		String modiName=in.nextLine();
		boolean flag=true;
		for(int i=0; i<mlist.size(); i++) {
			if(mlist.get(i).name.equals(modiName)) {
				System.out.println("이름을 무엇으로 수정할까요?");
				String newName=in.nextLine();
				mlist.get(i).name=newName;
				System.out.println("아이디를 무엇으로 수정할까요?");
				String newId=in.nextLine();
				mlist.get(i).id=newId;
				System.out.println("재고 얼마로 수정할까요?");
				int newCnt=in.nextInt();
				in.nextLine();
				mlist.get(i).cnt=newCnt;
				System.out.println("단가를 얼마로 수정할까요?");
				int newPrice=in.nextInt();
				in.nextLine();
				mlist.get(i).price=newPrice;
				flag=false;
				break;
			}
		}
		if(flag) {
			System.out.println("일치하는 상품이 없습니다.");
		}
		
	}


	public void GoodsList() {
		// TODO Auto-generated method stub
		for(int i=0; i<mlist.size(); i++) {
			System.out.println(i+"번 정보");
			mlist.get(i).prt();
			System.out.println("--------");
		}
	}


	private void menu() {
		// TODO Auto-generated method stub
			System.out.println("메뉴 번호를 입력하세요");
			System.out.println("1. 상품등록");
			System.out.println("2. 전체보기");
			System.out.println("3. 상품수정");
			System.out.println("4. 상품삭제");
			System.out.println("5. 상품검색");
			System.out.println("6. 이전메뉴");
			System.out.println("메뉴선택");
			
	}


	private void inputGoods() {
		// TODO Auto-generated method stub
		Goods newGoods=new Goods();
		System.out.println("이름 입력");
		String name=in.nextLine();
		System.out.println("아이디 입력");
		String id=in.nextLine();
		System.out.println("재고 입력");
		int cnt=in.nextInt();
		in.nextLine();
		System.out.println("가격 입력");
		int price=in.nextInt();
		in.nextLine();
		newGoods.st(name, id, cnt, price);
		mlist.add(newGoods);		
	}


	public void start() {
		// TODO Auto-generated method stub
		for(;;) {
			menu(); {
				int num=in.nextInt();
				in.nextLine();
				if(num==1) {
					inputGoods();
				}else if(num==2) {
					GoodsList();
				}else if(num==3) {
					modiGoods();
				}else if(num==4) {
					delGoods();
				}else if(num==5) {
					searchGoods();
				}else if(num==6) {
					break;
				}					
			}
		}
		
	}
	
	
	
	
}











