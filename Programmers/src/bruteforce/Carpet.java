/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 카펫(https://programmers.co.kr/learn/courses/30/lessons/42842?language=java)
 * 레벌 : 레벨 2
 * 시작 날짜 : 2021-02-07
 * 종료 날짜 : 2021-02-07
 * 
 * 기획
 * Step 1. 사각형의 넓이와 노란색 박스의 넓이를 비교해가며, 모든의 경우의 수 중에서 적합한 것을 뽑는다
 * 
 * 후기
 *  - 전체 사각형의 넓이가 있고, 노란색 사각형의 넓이를 이용하면 쉽게 풀리는 문제인 것 같다
 *  - 다만, 완전탐색이라 하더라도 세로길이가 가로길이보다 높아질 때는 무의미하므로, 이에 대한 연산을 줄이기 위해서는 이중 for문에서 세로를 먼저 돌린다.
 */

package bruteforce;

public class Carpet {

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2]; // [가로, 세로]
		int sum = brown + yellow;

		for (int column = 3; column < sum; column++) {
			for (int row = 3; row < sum; row++) {

				int yellowColumn = column - 2;
				int yellowRow = row - 2;

//				System.out.println(yellowColumn +" * "+ yellowRow + " = " + yellow);
//				System.out.println(column +" * "+ row + " = " + sum);

				if ((yellowColumn * yellowRow == yellow) && (column * row == sum) && column<=row) {
					answer[0] = row;
					answer[1] = column;
					return answer;
				}
			}
		}
		return answer;
	}

	// 실행 메소드
	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		System.out.println(solution(brown, yellow));
	}

}
