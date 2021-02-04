/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 베스트앨범(https://programmers.co.kr/learn/courses/30/lessons/42579?language=java)
 * 레벌 : 레벨 3
 * 시작 날짜 : 2021-01-30
 * 종료 날짜 : 2021-02-03
 * 
 * 기획
 * Step 1. 장르별 누적값을 확인하고 정렬을 통해 장르의 순위 확인
 * Step 2. 해당 장르의 순위를 바탕으로 동일 인덱스를 가진 배열들의 값을 따로 추출
 * 			- 각 추출한 값을 정렬하여 장르 내 조회수 높은 음악을 다른 배열에 저장
 * 			- 총 플레이 횟수가 높은 장르를 먼저 돌면서 답안을 추출해 내는 작업을 반복함으로 원하는 결과값 도출 가능
 * 
 * 후기
 *  - 방향만 다섯번째 다시 잡고 진행
 *  - 자료형이 자유롭지 않은 자바의 경우, 키 값을 설정하는게 매우 중요
 *  - 처음에 인덱스를 고유값으로하여 이중홰쉬를 구현하려 하였으나, 정렬 등의 문제로 어려움을 겪음
 *  - 이중 해쉬가 어려워 각 배열을 키값을 인덱스로 한 해쉬를 구현하려 하였으나, 해쉬 특성상 순서가 없음으로 정렬한 값을 다시 활용하는데 어려움을 겪음
 *  - 각 고유값 마다 새로운 리스트를 작성하는 방향을 고려했지만 (Ex: 0 = [장르, 플레이횟수]) 리스트 내 자료형이 분리되면, DTO를 구성해야 한다는 점에서 볼륨이 커질 것을 우려하여 포기
 *  - 결과적으로 주어진 값이 int 2개, string 1개였기 때문에 String을 우선적으로 처리하여 키값으로 활용하였고, 대분류로 활용하면서 코드 길이가 짧아졌음
 *  - 해당 문제는 해쉬에 대한 이해와 정렬에 대한 기술적인 부분이 필요한 문제였으며, 이중 해쉬, 자료형변환에 익숙하다면 상대적으로 쉽게 접근할 수 있었을 것으로 분석함
 */

package hash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BestAlbum5 {

	public static int[] solution(String[] genres, int[] plays) {
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<String, Integer> genresKeys = new HashMap<>();
		HashMap<Integer, Integer> indexAndPlay = new HashMap<>();

		// 장르별 누적값
		for (int i = 0; i < plays.length; i++) {
			if (!genresKeys.containsKey(genres[i])) { // 키값이 없다면 그냥 추가
				genresKeys.put(genres[i], plays[i]); // 장르 : 횟수
			} else if (genresKeys.containsKey(genres[i])) { // 키값이 있다면 기존 값에서 합치기
				int sum = genresKeys.get(genres[i]) + plays[i]; // 기존 장르의 횟수 값 + 새로운 횟수 = 누적 횟수
				genresKeys.put(genres[i], sum); // 키 : 누적 횟수
			}
		}

		// 장르간 합산 후 밸류 값으로 내림차순 정렬, 키-장르 / 밸류-플레이 누적 값
		List<Entry<String, Integer>> sortedGenresKeys = genresKeys.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

		// 각 인덱스를 이용해 지정하기
		for (Entry<String, Integer> genresSequence : sortedGenresKeys) { // 정렬된 장르를 하나씩 꺼내서
			for (int i = 0; i < plays.length; i++) {
				if (genres[i].equals(genresSequence.getKey())) { // 키와 동일한 것만
					indexAndPlay.put(i, plays[i]); // 해당 HashMap에 추가 : 키-인덱스, 밸류-플레이수
				}

			}

			// 키-인덱스, 밸류-플레이수를 먼저 플레이수로 내림차순하고 키값으로 오름차순하였음
			List<Map.Entry<Integer, Integer>> sortedIndexAndPlay = indexAndPlay.entrySet().stream().sorted(
					Map.Entry.<Integer, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
					.collect(Collectors.toList());

			// 일단 인덱스 0번과 1번을 추가 - 한 곡만 있는 경우 인덱스를 초과해서 에러가 생김으로 이를 캐치
			try {
				answer.add((int) sortedIndexAndPlay.get(0).getKey());
				answer.add((int) sortedIndexAndPlay.get(1).getKey());
			} catch (IndexOutOfBoundsException e) {

			}

			// 리턴을 위한 해쉬였기 때문에 다시 초기화
			indexAndPlay.clear();
		}

		// 최종 답안(ArrayList)를 int[] 형태로 변환
		int[] intAnswer = new int[answer.size()];
		for (int i = 0; i < intAnswer.length; i++) {
			intAnswer[i] = answer.get(i).intValue();
		}

		// 답안 반환
		return intAnswer;
	}

	// 실행 메소드
	public static void main(String[] args) {

		// 자체 테스트 케이스 : [4,1,5,3,0]
		String[] genres = { "classic", "pop", "classic", "classic", "pop", "jpop" };
		int[] plays = { 500, 600, 150, 800, 2500, 3000 };

		System.out.println(solution(genres, plays));
	}

}
