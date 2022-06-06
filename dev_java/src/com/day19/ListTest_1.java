package com.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest_1 {
	List<String> list = new ArrayList<>();
	
	public ListTest_1() {
		System.out.println("디폴트 생성자 호출 ");
	}
	
	public ListTest_1(int i) {
		System.out.println("파라미터가 int인 생성자 호출");
		list.add("토마토");
		list.add("딸기");
		list.add("바나나");
		list.add("토마토");
		list.add("딸기");
		list.add("바나나");
		
	}
	
	
	
	public static void main(String[] args) {

	ListTest_1 lt = new ListTest_1(); // 디폴트 생성자 호출
	// 문제제기 - 디폴트 생성자에는 ArrayList
	int cnt = lt.list.size(); //0출력  
	lt = new ListTest_1(10);
	cnt = lt.list.size();// 3출력
	
	
	// 내부 중복요소 제거(1)
	for(int i=0; i < lt.list.size();i++) {
		for(int j=1; j < lt.list.size();j++) {
		if(lt.list.get(i).equals(lt.list.get(j))) {
			lt.list.remove(i);
		}
		}
	}
	System.out.println(lt.list);
	
	// 내부 중복요소 제거(2)
	//Collection set = new HashSet(lt.list);
	//set.forEach(i->System.out.print(i + ","));
	//lt.list.forEach(i->System.out.print(i + ","));
	}
	

}
/*
 * 인스턴스화 유형 3가지
 * 왜 하는거니? 클래스 내부에 정의된 변수, 메소드(static있고 없는)
 * 첫번째 유형 - 기초
 * 선언부와 생성부가 같은 타입이다. - 다형성을 기대할 수 없다
 * Sonata myCar = new Sonata();
 * MallardDuck herDuck = new MallardDuck();
 * 
 * 두번쨰 유형 - 메소드의 리턴타입으로 객체를 생성받는다
 * A a= 주소번지.methodA();
 * 변수와 메소드를 누릴 수 있다 - 다른 클래으싀 메소드를 호출 - 재사용 할 수 있다
 * 
 * 변수는 같은타입만 담을 수 있다 - 단점
 * 배열도 같은타입만 담을 수 있다
 * 그래서 객체 배열이 나왔다. Sonata myCar[] = new Sonata[5]
 * 중간에 끼워 넣기가 불가하다.
 * 늘였다 줄였다가 안된다
 * 그런데 List는 다른타입도 담을 수 있고 끼워넣기도 가능하고
 * add하면 계속 방이 늘어나고 remove(3)방이 줄어든다
 * Object이면 모두 담을 수 있다. 타입이 달라도 
 * 
 * 
 * 세번째 유형 - 다형성을 기대할 수 있다
 * List nameList = new ArrayList();
 * 제네릭 - 내안에 있는 타입을 명시한다.
 * List<String> nameList2 = new ArrayList<Stirng>();
 * 생성부에 오는 명시적인 타입은 생략 가능하다. 대신<> 다이아몬드 연산자를 붙여야 한다.
 * List<String nameList2 = new ArrayList2<>();
 * 
 * get (int i): Object - API
 * 오른쪽에 오는 타입이 왼쪽에 오는 타입보다 절대로 반드시 큰 타입은 불가하다
 * 만일 강제로 타입을 바꾸고 싶으면 캐스팅 연산자를 사용 할 것
 * String name = (String) nameList.get(2)
 * 제네릭을 사용하는 경우에도 다이아몬드 연산자 안에 타입을 적어 놓았으므로
 * 명시적으로 알 수 있다 따라서 강제 형전환이 필요 없다
 * String name = nameList2.get(2);
 * 
 */



