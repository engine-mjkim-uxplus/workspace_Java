package practice;

import java.util.Arrays;
import java.util.Random;

public class Random_Game {
	int[] ranarr; // 랜덤하게 채번한 수의 배열 
	int hap_plus; //양수합
	int hap_minus; //음수합
	
	Random_Game() {

	}

	// 매개값 하나를 받아 랜덤 배열의 길이를 설정하는 생성자
	Random_Game(int i) {
		this.ranarr = new int[i];
		random();
		hap();
	}

	// -10 ~ 10의 정수 랜덤하게 뽑아 ranarr[] 값 초기화 메소드
	private void random() {
		for (int i = 0; i < ranarr.length; i++) {
			ranarr[i] = (int) (Math.random() * 21) - 10;
		}
	}

	// 랜덤 배열의 음수의 합, 양수의 합 구하는 메소드
	public void hap() {
		for (int i = 0; i < ranarr.length; i++) {
			if (ranarr[i] < 0) {
				hap_minus += ranarr[i];
			} else
				hap_plus += ranarr[i];
		}

	}
	// 랜덤배열, 음수합, 양수합 출력 메소드
	public void hap_Print() {
		System.out.println("배열 : " + Arrays.toString(ranarr));
		System.out.println("음수합 = " + hap_minus);
		System.out.println("양수합 = " + hap_plus);
	}

}
