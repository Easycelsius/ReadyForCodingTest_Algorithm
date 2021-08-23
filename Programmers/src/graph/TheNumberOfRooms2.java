package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TheNumberOfRooms2 {
	
	public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int hashCode() {
            return Objects.hash(x,y);
        }

        public boolean equals(Object o) {
            return this.x == ((Pair) o).x && this.y == ((Pair) o).y;
        }
    }

	public static int solution(int[] arrows) {

		// 변수 선언
		int cnt = 0;

		// 방향 관련 배열 선언
		Pair pointHC = new Pair(0, 0);
		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

		// 방문 여부 관련 선언
		// key = 시작 node의 hashcode, value = 연결된 node들의 hashcode
		HashMap<Pair, ArrayList<Pair>> visitied = new HashMap<>();

		// 로직 처리
		for (int arrow : arrows) {
			for (int i = 0; i <= 1; i++) { // 교차점 처리를 위한 스케일업(반복 2번)

				// 이동 진행
				Pair newPointHC = new Pair(pointHC.x + dx[arrow], pointHC.y + dy[arrow]);

				// 처음 방문하는 경우 = map에 키값이 없는 경우
				if (!visitied.containsKey(newPointHC)) {
					// 리스트에 연결점 추가
					visitied.put(newPointHC, makeEdgeList(pointHC));
					
					if(visitied.get(pointHC) == null) { // 기존점도 없다면 업데이트
						visitied.put(pointHC, makeEdgeList(newPointHC));
					} else { // 기존점이 있다면 추가하기
						visitied.get(pointHC).add(newPointHC);
					}	

				// 재방문했고 간선을 처음 통과하는 경우
				} else if (visitied.containsKey(newPointHC) && !(visitied.get(newPointHC).contains(pointHC))) {
					System.out.println("통과" + newPointHC + "/" + pointHC);
					visitied.get(newPointHC).add(pointHC);
					visitied.get(pointHC).add(newPointHC);
					cnt++;
				}

				// 이동 완료
				pointHC = newPointHC;
			}
		}

		return cnt;
	}

	// 밸류값에 넣기 위한 리스트 만들기
	public static ArrayList<Pair> makeEdgeList(Pair pointHC) {
		ArrayList<Pair> edge = new ArrayList<>();
		edge.add(pointHC);
		return edge;
	}

	public static void main(String[] args) {
		int[] arrows = { 6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0 };

		System.out.println(solution(arrows));
	}
}