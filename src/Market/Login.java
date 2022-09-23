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
		System.out.println("ID�� �Է��ϼ���");
		String id=in.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
		String pw=in.nextLine();
		boolean flag=true;
		for(int i=0; i<mm.mlist.size(); i++) {
			if(mm.mlist.get(i).id.equals(id)&&mm.mlist.get(i).pw.equals(pw)) {
				//id�� pw��� ��ġ�ؾ� �α����� ��
				flag=false;
				System.out.println("�α��� �Ϸ�!");
				for(;;) {
					System.out.println("�޴� ��ȣ�� �Է��ϼ���");
					System.out.println("1. ����������");
					System.out.println("2. ȸ������ ����");
					System.out.println("3. �����ϱ�");
					System.out.println("4. ���ǰ���");
					System.out.println("5. �α׾ƿ�");
					int no=in.nextInt();//�α��� �� ����� �ּҰ��� ���� a�� ����
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
						System.out.println("������ �����ϴ�."); 
						//��� ����Ʈ�� �ε��� 2���� ����� ����� ������ ��
						//3�� ���ķ� ȸ�������� ����� ������ ����
						}
						
					}else if(no==5) {
						System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
						break;
					}
				}
				
			}
		}
		if (flag) {
			System.out.println("ID�� ��й�ȣ�� Ȯ���ϼ���");
		}
	}
	
	
	
	public void prt(Member a) {
		System.out.println("ID: "+a.id);
		System.out.println("�̸�: "+a.name);
		System.out.println("����: "+a.age);
	}



	public void goshopping(Member a) {
		for(;;) {
			System.out.println("1. �����ϱ�");
			System.out.println("2. ��ٱ��� ����");
			System.out.println("3. ��ٱ��� ����");
			System.out.println("4. �����޴�");
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
		System.out.println("1. ������ ���� ����");
		System.out.println("2. ��ٱ��� ��ü ����");
		int no=in.nextInt();
		in.nextLine();
		if(no==1) {
			shopPrt(a);
			System.out.println("������ ������ �̸��� �Է��ϼ���");
			String delName=in.nextLine();
			boolean flag=true;
			for(int i=0; i<a.basket.size(); i++) {				
				if(a.basket.get(i).buyGoods.name.equals(delName)) {
					a.basket.remove(i);
					flag=false;
					System.out.println(delName+"��(��) �����Ǿ����ϴ�.");
				}
			}
			if(flag) {
				System.out.println(delName+"��(��) ��ٱ��Ͽ� �����ϴ�.");
			}
			
		}else if(no==2) {
			a.basket.clear();
			System.out.println("��ٱ��ϰ� ��������ϴ�.");
		}

	}


	private void shopPrt(Member a) {
		for(int i=0; i<a.basket.size(); i++) {
			a.basket.get(i).prt();
		}
		if(a.basket.size()==0) {
			System.out.println("��ٱ��ϰ� ������ϴ�.");
		}
		
	}

	private void shopping(Member a) {
		// TODO Auto-generated method stub
		gm.GoodsList();
		System.out.println("������ ��ȣ �Է�");
		int no=in.nextInt();
		in.nextLine();
		if(no<gm.mlist.size()) {
			boolean flag=true;
			for(int i=0; i<a.basket.size(); i++) {
				if(a.basket.get(i).buyGoods.name==gm.mlist.get(no).name) {
					System.out.println("�����Է�");
					int no1=in.nextInt();
					in.nextLine();
					a.basket.get(i).buycnt+=no1;
					gm.mlist.get(no).cnt-=no1;
					flag=false;
					
				}		
		}if(flag) {
			BasketGoods bg=new BasketGoods();
			bg.buyGoods=gm.mlist.get(no);
			System.out.println("�����Է�");
			int no1=in.nextInt();
			in.nextLine();
			bg.buycnt=no1;
			gm.mlist.get(no).cnt-=no1; //������ ������ŭ ��� ����
			a.basket.add(bg);
		}
		}
		else {
			System.out.println("�ش��ϴ� ��ǰ�� �����ϴ�.");
		}
	}

	public void modi(Member a) {
		System.out.println("������ �����ұ��?");
		System.out.println("1. �̸� ����");
		System.out.println("2. ��й�ȣ ����");
		System.out.println("3. ���� ����");
		System.out.println("4. �����޴�");
		int no=in.nextInt();
		in.nextLine();
		if(no==1) {
			System.out.println("�������� �����ұ��?");
			String newName=in.nextLine();
			a.name=newName;
			System.out.println("�̸� ������ �Ϸ�Ǿ����ϴ�.");
		}else if(no==2) {
			System.out.println("�������� �����ұ��?");
			String newPw=in.nextLine();
			a.pw=newPw;
			System.out.println("��й�ȣ ������ �Ϸ�Ǿ����ϴ�.");
		}else if(no==3) {
			System.out.println("�������� �����ұ��?");
			int newAge=in.nextInt();
			in.nextLine();
			a.age=newAge;
			System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
		}else if(no==4) {
			return;
		}
		

				
		
	}
}
