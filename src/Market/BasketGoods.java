package Market;

public class BasketGoods {
	
	Goods buyGoods;
	int buycnt;

	
	public void prt() {
		System.out.println("--구매정보--");
		System.out.println("상품이름 "+buyGoods.name);
		System.out.println("상품수량 "+this.buycnt);
		System.out.println("상품가격 "+buyGoods.price);
		System.out.println("총 가격 "+buyGoods.price*buycnt);
		System.out.println("------------------");
		
		
		
	}
	
}
