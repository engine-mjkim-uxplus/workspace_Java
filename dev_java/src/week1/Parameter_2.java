package week1;

public class Parameter_2 {
	static void methodA(Dog a) {
		Dog yourDog = new Dog(); // 0*200
		System.out.println("methodA의 myDog.leg ==> "+a.leg); 
		a.leg = 2;
	}
	public static void main(String[] args) {
		Dog myDog = new Dog();
		myDog.leg = 4;   
		methodA(myDog); // 주소값 0*100
		System.out.println("main myDog.leg ==> "+myDog.leg);
	}
}
