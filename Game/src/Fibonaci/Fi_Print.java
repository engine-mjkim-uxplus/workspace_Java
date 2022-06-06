package Fibonaci;

import java.util.Arrays;

public class Fi_Print {
	int[] arr;

	Fi_Print() {
		System.out.println("배열의 길이를 지정하지 않아 1~30 중 랜덤으로 길이가 생성 됩니다");
		int ran = (int) (Math.random() * 30) + 1;
		this.arr = new int[ran];
		arrset();
	}

	Fi_Print(int i) {
		this.arr = new int[i];
		arrset();
	}
	
	// arr index[0],[1]을 1로 초기화 
	private void arrset() {
		if (arr[0] == 0 && arr[1] == 0) {
		this.arr[0] = 1;
		this.arr[1] = 1;
		}
	}
	// 수열 순서대로 출력
	public void sequence_print() {
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 2] + arr[i - 1];
		}
		System.out.println(Arrays.toString(arr));
	}
	// 수열 셔플해서 출력
	public void shuffle_print() {
		int tmp;
		for (int i = 0; i < arr.length; i++) { 
			int n = (int) (Math.random() * arr.length);
			tmp = arr[0];
			arr[0] = arr[n];
			arr[n] = tmp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
