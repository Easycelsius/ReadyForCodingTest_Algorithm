/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 튜플(https://programmers.co.kr/learn/courses/30/lessons/64065#)
 * 레벌 : 레벨 2
 * 시작 날짜 : 2021-03-12
 * 종료 날짜 : 2021-03-12
 * 
 * 기획
 * Step 1. 문자열을 리스트화하기
 * Step 2. 리스트화한 문자열의 길이를 추가하기
 * Step 3. 해쉬 맵을 이용해 키 값은 길이, 밸류 값은 어레이리스트로 지정
 * Step 4. 키 값이 작은 순으로 반복문을 돌리며, 어레이리스트의 값을 꺼내서 중복되지 않게 값 넣기
 * Step 5. 어레이리스트를 배열로 만들기
 * 
 * 후기
 *  - 자바내에서 정렬에 대한 활용, 문자열을 바로 리스트화하는 방법 등을 몰라 많이 돌아서 진행함
 *  - 프로그래머스 레벨 2 테스트 60분 제한으로는 못 풀었고, 문제를 아는 상태에서 풀었을 때 코드 작성만 40분 걸림
 *  - 답을 맞추는 것에만 신경을 쓰다보니 코드가 상당히 비효율적임 -> 최적화가 필요
 */

package kakao;

import java.util.ArrayList;
import java.util.Collections;

public class Tuple {

	public static int[] solution(String s) {
		ArrayList<ArrayList> bigList = new ArrayList<>();
		ArrayList<Integer> smallList = new ArrayList<>();

		// 각 ArrayList 구성
		for (String a : s.split("\\},\\{")) {
			a = a.replace("{", "");
			a = a.replace("}", "");
			for (String b : a.split(",")) {
				smallList.add(Integer.parseInt(b));
			}
			bigList.add((ArrayList) smallList.clone());
			smallList.clear();
		}

		// 정렬에 관한 것 매우 중요
		Collections.sort(bigList, (c1, c2) -> c1.size() - c2.size());
		
		System.out.println(bigList);

		// 정답 넣기 smallList 재활용
		for (ArrayList al : bigList) {
			for (int i = 0; i < al.size(); i++) {
				if (!smallList.contains(al.get(i))) {
					smallList.add(((Integer) al.get(i)));
				}
			}
		}
		
		// 배열화
		int[] answer = smallList.stream().mapToInt(i->i).toArray();

		return answer;
	}

	// 실행 메소드
	public static void main(String[] args) {

		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

		System.out.println(solution(s));
	}

}
