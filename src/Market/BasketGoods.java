package Market;

public class BasketGoods {
	
	Goods buyGoods;
	int buycnt;

	
	public void prt() {
		System.out.println("--��������--");
		System.out.println("��ǰ�̸� "+buyGoods.name);
		System.out.println("��ǰ���� "+this.buycnt);
		System.out.println("��ǰ���� "+buyGoods.price);
		System.out.println("�� ���� "+buyGoods.price*buycnt);
		System.out.println("------------------");
		
		
		
	}
	
}
