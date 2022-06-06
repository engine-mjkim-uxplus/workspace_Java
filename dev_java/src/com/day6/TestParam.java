package com.day6;

class param {
	int ival; 
}

public class TestParam {
		void effectParam(param p) {
			p = new param(); // 새로운 주소값이 p에 복사된거다. 기존의 ival을 500가지고 있는 p 객체가 아닌 다른 객체가 됨(0*200번지)
							 // 즉 연결이 기존 객체와의 연결이 끊기고 새로운 객체의 주소가 p에 대입된다. 
							 //여기서의 p는 지역변수로 retrun값이 없으므로 static으로 값이 들어가지 않는다.
			p.ival = 300;
			System.out.println("sub ival : " + p.ival);
		}
	public static void main(String[] args) {
		TestParam tp = new TestParam();
		param p = new param();
		p.ival = 500; 
		tp.effectParam(p);
		System.out.println("main ival : " + p.ival); // main 메서드의 p(0*100번지) 출력

		
	}

}


/*  12번 : 나 자신에 대한 인스턴스화이다
 	왜 인스턴스화를 했나?  - 15번의 effectParam메소드를 호출 하기 위해서 (non-static은 static에서 호출이 불가 하므로)
 	14번에서는 13번에서 인스턴스화 된 클래스의 전변인 ival 변수에 
 	초기값인 0 대신 500으로 덮어쓰기가 발생함
	아직은 출력하는 문장을 마나지 못함
	15번 effectParam의 메소드를 경유하게 되는데 이때 13번에서 정의된 객체의 주소번지를 가지고 7번으로 진입합니다.
	7번의 지변 p와 13번 p의 주소번지는 같다.
	따라서 8번의 ival변수의 300은 13번에서 만들어진 원본 클래스의 전변이 변경 되는 것입니다.
	
*/
