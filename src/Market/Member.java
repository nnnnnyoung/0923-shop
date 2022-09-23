package Market;

import java.util.ArrayList;

public class Member {
	
	String name;
	String id;
	String pw;
	int age;
	ArrayList<BasketGoods> basket=new ArrayList<>();
	
	public void join(String name,String id,	String pw,int age) {
		this.name=name;
		this.id=id;
		this.pw=pw;
		this.age=age;
	}
	
	public void memberInfo() {
		System.out.println("이름: "+this.name);
		System.out.println("ID: "+this.id);
		System.out.println("나이: "+this.age);
	}
	
}
