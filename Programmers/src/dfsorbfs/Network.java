/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 네트워크(https://programmers.co.kr/learn/courses/30/lessons/43162)
 * 레벌 : 레벨 3
 * 시작 날짜 : 2021-03-07
 * 종료 날짜 : 2021-03-09
 * 
 * 기획
 * Step 1. 어레이리스트를 방문한 노드로 표현
 * Step 2. 재귀를 통해 dfs를 구현하고 방문한 노드들은 어레이리스트에 추가
 * Step 3. 반복을 통해 어레이스트에 없는 항목을 찾아 네트워크 다시 찾기
 * 
 * 후기
 *  - 양방향성을 가진 그래프이기 때문에 스택을 사용할 필요가 없었고
 *  - 재귀함수를 올바르게 사용하기 까지 오랜 시간이 걸렸음
 */


package dfsorbfs;

import java.util.ArrayList;

public class Network {

	static ArrayList<Integer> list = new ArrayList<>();
	static int group = 0;

	public static int solution(int n, int[][] computers) {

		// 어레이스트에 있는 거면 제외
		// 없을 시에는 끝까지 감, 카운트 추가

		for (int i = 0; i < n; i++) {
			if (!list.contains(i)) {
				operator(n, computers, i);
				group += 1;
			}
		}
		return group;
	}

	public static void operator(int n, int[][] computers, int i) {

		list.add(i);

		for (int j = 0; j < n; j++) {
			if (!list.contains(j) && computers[i][j] == 1) {
				operator(n, computers, j);
			}
		}
	}

	// 실행 메소드
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		System.out.println(solution(n, computers));
	}

}
