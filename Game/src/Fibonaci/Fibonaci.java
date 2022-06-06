package Fibonaci;

public class Fibonaci {

	public static void main(String[] args) {
		// 피보나치 수열 규칙: 1모든 항은 바로 앞 두항의 합인 수열이다

		// Fi_Print f = new Fi_Print(20); --> 배열길이 20만큼 수열생성하 		
		Fi_Print f = new Fi_Print();  // 랜덤으로 배열길이 지정되어 수열 생성
		f.sequence_print(); 
		f.shuffle_print(); 
	
	}
}
