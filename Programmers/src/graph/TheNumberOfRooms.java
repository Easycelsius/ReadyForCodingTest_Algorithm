package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class TheNumberOfRooms {

	public static int solution(int[] arrows) {

		// 변수 선언
		int cnt = 0;

		// 방향 관련 배열 선언
		int[] point = { 0, 0 };
		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

		// 방문 여부 관련 선언
		// key = 시작 node, value = 연결된 node들
		HashMap<int[], ArrayList<int[]>> visitied = new HashMap<>();

		// 로직 처리
		for (int arrow : arrows) {
			for (int i = 0; i <= 1; i++) { // 교차점 처리를 위한 스케일업(반복 2번)

				// 이동 진행
				int[] newPoint = { point[0] + dx[arrow], point[1] + dy[arrow] };

				// 처음 방문하는 경우 = map에 키값이 없는 경우
				if (!containsKeyInMap(visitied, newPoint)) {
					// 리스트에 연결점 추가
					visitied.put(newPoint, makeEdgeList(point));
					visitied.put(point, makeEdgeList(newPoint));

					// 재방문했고 간선을 처음 통과하는 경우
				} else if (containsKeyInMap(visitied, newPoint)
						&& !(containsInList(returnListFromMap(visitied, newPoint), point))) {
					System.out.println(newPoint[0] + "/" + newPoint[1]);
					returnListFromMap(visitied, newPoint).add(point);
					returnListFromMap(visitied, point).add(newPoint);
					cnt++;
				}

				// System.out.println(vistied.get(newPoint).contains(point));

				// 이동 완료
				point = newPoint;
			}
		}

		return cnt;
	}

	// 밸류값에 넣기 위한 리스트 만들기
	public static ArrayList<int[]> makeEdgeList(int[] point) {
		ArrayList<int[]> edge = new ArrayList<>();
		edge.add(point);
		return edge;
	}

	// 키값 비교
	public static boolean containsKeyInMap(HashMap<int[], ArrayList<int[]>> visitied, int[] point) {
		for (int[] key : visitied.keySet()) {
			if (key[0] == point[0] && key[1] == point[1]) {
				return true;
			}
		}
		return false;
	}

	// 키로 리스트 값 반환하기
	public static ArrayList<int[]> returnListFromMap(HashMap<int[], ArrayList<int[]>> visitied, int[] point) {
		for (Entry<int[], ArrayList<int[]>> entry : visitied.entrySet()) {
			if (entry.getKey()[0] == point[0] && entry.getKey()[1] == point[1]) {
				return entry.getValue();
			}
		}
		return null;
	}

	// 리스트값 비교
	public static boolean containsInList(ArrayList<int[]> al, int[] point) {
		for (int[] p : al) {
			if (p[0] == point[0] && p[1] == point[1]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arrows = { 6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0 };

		System.out.println(solution(arrows));
	}
}