package practice;

import java.util.Arrays;
import java.util.Scanner;

public class BaseBall {

	public static void main(String[] args) {

		int[] com = new int[3]; // 컴퓨터의 랜덤값을 받을 배열 com
		int[] user = new int[3]; // 사용자의 랜덤값을 받을 배열 user

		int strike = 0;
		int ball = 0; // 변수 strike와 ball 초기화

		// <1>: 컴퓨터에 중복없이 3자리 값을 저장한다.
		for (int i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 10);
			for (int j = 0; j < i; j++) {
				if (com[j] == com[i]) { // 중복방지 com[j]와 com[i]의 배열값이 같을 경우
					i--; // i를 1만큼 감소시키고 새로운 배열값을 만든다.
					break; // for문을 빠져나온다.
				}
			}
		}
		System.out.println(Arrays.toString(com)); // 컴퓨터답을 미리확인하는용

		// <2>: 사용자에게 중복없이 3자리 값을받아온다.
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 야구게임을 시작합니다.");
		System.out.println("숫자 사이 구분은 스페이스로 합니다.");
		System.out.println("0~9까지의 3자리 정수를 중복없이 입력하세요 >>");

		while (true) {
			for (int i = 0; i < user.length; i++) {
				user[i] = sc.nextInt(); // 사용자가 입력하는 값을 user[] 배열에 저장
				for (int j = 0; j < i; j++) {
					if (user[j] == user[i]) {
						System.out.printf("중복 값을 입력했습니다."); // 처음에 test겸 중복값을 입력하면
						i--; // 중복값입력했습니다가 2번뜨는오류 -> println 을 print f로 바꿈
						break;
					}
				} // 중복값을 처음에 입력하고 나서 다시 값을 입력하면 제대로 판정이 되지않는오류 (미해결)

			}
			// <3>: 컴퓨터 3자리 수 vs. 유저의 3자리 수를 비교한다.

			for (int i = 0; i < com.length; i++) {
				for (int j = 0; j < user.length; j++) {

					if (com[i] == user[j] && i == j) {
						strike++; // 값과 인덱스가 모두 같으면 strike
					} else if (com[i] == user[j] && i != j) {
						ball++; // 값은 같고 인덱스가 다르면 ball
					}
				}
			}

			System.out.println(strike + "스트라이크" + ball + "볼");
			if (strike == 3) // 3스트라이크면 게임을 종료하고 if문 탈출

			{

				System.out.println("정답입니다. 게임을 종료합니다.");
				break;
			}
			strike = 0;// strike와 ball은 다시 0으로초기화
			ball = 0;
		}
	}
}