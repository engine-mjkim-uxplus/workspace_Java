package com.day21;

// 1부터 100까지의 난수를 랜덤으로 출력하고, 각 수의 빈도수를 구하는 예제
public class BinDoTemplate {
	public BinDoTemplate() {
		int nanSus[] = new int[100];
		int pCount[] = new int[10];
		// insert here
		initArray(nanSus, nanSus.length);
		numberCount(nanSus, nanSus.length, pCount);
		print10PerLine(nanSus, nanSus.length);
		printResult(pCount, 10);
	}

	// 배열의 초기화
	void initArray(int nanSus[], int size) {
		// insert here
		for (int i = 0; i < nanSus.length; i++) {
			nanSus[i] = (int) (Math.random() * 10);
		}

	}

	// 빈도 검사 nanSus에 들어 있는 숫자의 빈도를 pCount에 저장함
	void numberCount(int nanSus[], int size, int pCount[]) {
		// insert here
		int nIndex = 0;
		// 채번된 100가지의 숫자에 대해 판정을 해야 한다
		for (int i = 0; i < size; i++) {
			// 카운트 하기 위해서 일단 배열의 값을 담았다.
			// 채번된 숫자가 배열[pCount]의 인덱스에 담긴다.
			nIndex = nanSus[i];
			// pCount는 100개의 숫자에 대한 빈도수를 관리하는 1차 배열이다.
			pCount[nIndex]++; // ★★★ 같은 값 나오면 같은 인덱스에 값++ 즉 count가 1 늘어난다.
		}
	}

	// 배열 출력 한 줄에 10개씩 출력하고 줄바꿈 하기
	void print10PerLine(int nanSus[], int size) {
		System.out.printf("원본 : 	");
		for (int i = 0; i < size; i++) {
			System.out.printf("%3d", nanSus[i]);
			if (i % 10 == 9)
				System.out.printf("\n	");
		}
	}

	// 빈도 출력 빈도 배열과 인덱스를 함께 출력
	void printResult(int pCount[], int size) {
		System.out.println("\n ");
		System.out.print("숫자: ");
		for (int i = 0; i < size; i++) {
			System.out.printf("%3d", i); // 0~9까지의 숫자를 나열하여 출력
		}
		System.out.print("\n ");
		System.out.print("개수: ");
		for (int i = 0; i < size; i++) {
			System.out.printf("%3d", pCount[i]);
		}
	}

	public static void main(String[] args) {
		new BinDoTemplate();
	}

}