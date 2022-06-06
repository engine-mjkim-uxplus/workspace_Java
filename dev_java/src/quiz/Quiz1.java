package quiz;

import javax.swing.JOptionPane;

//사용자로 부터 입력받는 값을 읽어 오는데 필요한 다이얼로그 화면

// 100kg -> 17kg 
// 100*(17/100) => 계산 결과는 반드시 정수이다. 아니다 실수가 나올 수 도 있다
// 답(달의 몸무게)을 담는 변수가 하나 필요하다 - 이것의 타입은 double타입으로 한다
// 당신의 몸무게를 담을 변수가 필요하다 - int or double


public class Quiz1 {

	public static void main(String[] args) {
		
		String userWeight = null; // 사용자 몸무게 저장할 변수 (입력값)
		userWeight = JOptionPane.showInputDialog("당신의 몸무게는 얼마입니까?");  
		// 달의 몸무게를 담을 변수 선언
		// 메소드의 파라미터에 String을 주면 double으로 형변환을 해주는 메서드
		double earth_weight = Double.parseDouble(userWeight);
		double moon_weight = earth_weight*0.17;
		// 사용자 몸무게 *  (17/100)
		System.out.println(earth_weight);
		System.out.println(moon_weight);
		
		int i = 1;
	
	}

}
