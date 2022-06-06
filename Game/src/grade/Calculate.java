package grade;

import java.util.Arrays;

public class Calculate{
	int[] total, rank;
	double[] avg;
	int[][] score;
	
	Calculate(int[][] score) {
		this.score = score;
		this.total = new int[score.length];
		this.rank = new int[score.length];
		this.avg = new double[score.length];
		total();
		avg();
		rank();
	}
	// 총점
	public void total() {
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; ++j) {
				total[i] += score[i][j];
			}
		}
	}
	// 평균
	public void avg() {
		for (int i = 0; i < score.length; i++) {
			avg[i] = Math.round(total[i] /score[i].length * 10) / 10.0;
		}
	}
	// 순위
	public void rank() {
		Arrays.fill(rank, 1);
		for (int i = 0; i < total.length; i++) {
			for (int j = 0; j < total.length; j++) {
				if (total[i] < total[j]) {
					rank[i] = rank[i] + 1;
				}
			}
		}
	} 
}
