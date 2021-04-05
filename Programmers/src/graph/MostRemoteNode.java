package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MostRemoteNode {

	static int count = 0;
	static boolean[] visited; // 방문 여부 확인, 전부 false
	static Queue<Integer> que = new LinkedList<>(); // bfs를 위한 대기열
	static Queue<Integer> countQue = new LinkedList<>(); // 레벨을 판단하기 위한 자료
	static int[] answer; // 레벨과 방문노드를 저장하기 위함
	static int max;

	public static int solution(int n, int[][] edge) {
		visited = new boolean[n + 1];
		answer = new int[n+1];
		
		countQue.add(0);
		que.add(1);
		answer[1] = 0;

		bfs(n, edge);			
		
		// Arrays.stream(answer).forEach(System.out::println);
		// System.out.println();

		return (int) Arrays.stream(answer).filter(i -> max == i).count();
	}

	public static void bfs(int n, int[][] edge) {
		if(que.size()==0) {
			return;
		}
		
		int startPoint = que.poll();
		count = countQue.poll(); // level 시작
		visited[startPoint] = true; // 방문했음

		for (int len = 0; len < edge.length; len++) {

			if (edge[len][0] == startPoint && visited[edge[len][1]] == false && !que.contains(edge[len][1])) {
				que.add(edge[len][1]);
				countQue.add(count+1);
				answer[edge[len][1]] = count+1;
			}

			if (edge[len][1] == startPoint && visited[edge[len][0]] == false && !que.contains(edge[len][0])) {
				que.add(edge[len][0]);
				countQue.add(count+1);
				answer[edge[len][0]] = count+1;
			}
		}
		
		if(max<count) {
			max = count;
		}
		
		bfs(n, edge);
		
	}

	// 실행 메소드
	public static void main(String[] args) {
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(solution(6, edge));
	}

}
