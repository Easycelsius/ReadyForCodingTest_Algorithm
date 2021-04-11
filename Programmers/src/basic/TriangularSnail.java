package basic;

import java.util.ArrayList;

public class TriangularSnail {

	public static int[] solution(int n) {

		// 답안을 넣을 어레이리스트 선언
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int nClone = n;

		// 이중배열 선언
		int[][] array = new int[n][n];

		// 달팽이 시작지점
		int startPoint = 1;

		// 배열 내부 인덱스

		int x = -1;
		int y = 0;

		// 이중 포문으로 이중 배열 순회 i, j는 큰 의미 없음
		while (n > 0) {
			for (int i = 0; i < n; i++) {
				x++;
				array[x][y] = startPoint;
				startPoint++;
			}
			
			n--;

			for (int i = 0; i < n; i++) {
				y++;
				array[x][y] = startPoint;
				startPoint++;
			}
			
			n--;
			
			for (int i = 0; i < n; i++) {
				x--;
				y--;
				array[x][y] = startPoint;
				startPoint++;
			}
			
			n--;
		}
		
		for(int i=0; i < nClone; i++) {
			for(int j=0; j <= i; j++) {
				answer.add(array[i][j]);
			}
		}
		
		// System.out.println(answer);

		return answer.stream().mapToInt(i -> i).toArray();
	}

	// 실행
	public static void main(String[] args) {

		System.out.println(solution(4));
		System.out.println(solution(5));
		System.out.println(solution(6));

	}

}
