package com.day5;

import javax.swing.JOptionPane;

//사용자로 부터 입력받는 값을 읽어 오는데 필요한 다이얼로그 화면

class Moon {
	static double Gv;	
	Moon(){
		Gv = Earth.Gv * 0.17;
	}
	
}

class Earth {
	static int Gv;
	
	Earth(){
		Gv = 1;
	}
}

public class InputDialog_1 {

	public static void main(String[] args) {
		
		String inputValue = null;
		inputValue = JOptionPane.showInputDialog("당신의 몸무게는?"); // showInputDialog()의 반환값이 String이다 
		double Weight = Double.valueOf(inputValue);
		System.out.println("지구몸무게 : " + (Weight * Earth.Gv));
		System.out.println("달 몸무게 : " + (Weight * Moon.Gv + "kg"));

	}

}

