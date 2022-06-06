package week1;

public class Parameter_3 {
	static Dog methodA(Dog myDog) {
		// 같은 이름의 변수로 new 사용해서 객체를 생성하게 되면 타입은 같지만
		// 새로운 주소번지를 갖게 된다.
		// 이것은 서로 다른 객체라는 의미로 받아 들여야 한다
		myDog = new Dog();
		System.out.println("methodA 안에서 myDog " + myDog);
		
		
		return null;
	}
	public static void main(String[] args) {
		Dog myDog = new Dog();
		System.out.println("main 안에서 myDog " + myDog);
		methodA(myDog);
	}
}
