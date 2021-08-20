package hash;

import java.util.HashMap;

public class Athletes {

	// hashmap 선언
	static HashMap hm = new HashMap<>();

	public static String solution(String[] participant, String[] completion) {

		// 반복문 수행
		for (int i = 0; i < participant.length; i++) {

			compute(participant[i]);

			if (i < completion.length) {
				compute(completion[i]);
			}

		}

		// 형변환 후 끝내기
		return String.valueOf(hm.keySet().iterator().next());
	}

	// hashMap Compute Function
	public static void compute(String player) {
		hm.compute(player, (k, v) -> v != null ? null : 1);
	}

//실행 메소드
	public static void main(String[] args) {

		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "josipa", "filipa", "marina", "nikola" };

		System.out.println(solution(participant, completion));
	}

}
