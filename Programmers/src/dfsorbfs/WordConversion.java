package dfsorbfs;

public class WordConversion {

	static int minValue;

	public static int solution(String begin, String target, String[] words) {

		// 유효성 검사
		boolean vali = false;

		for (String word : words) {
			if (word.equals(target)) {
				vali = true;
			}
		}

		if (!vali) {
			return 0;
		}

		// dfs 진행
		boolean[] visted = new boolean[words.length];
		minValue = words.length;

		dfs(begin, target, words, visted, 0);

		return (words.length + 1 <= minValue) ? 0 : minValue;
	}

	// dfs
	public static void dfs(String begin, String target, String[] words, boolean[] visited, int count) {

//		System.out.println(begin + "/" + target + "/" + count);

		if (begin.equals(target) && count < minValue) {
//			System.out.println("목표값 달성");
			minValue = count;
		}

		// 한 바퀴 돌기
		for (int i = 0; i < words.length; i++) {

			if (!visited[i] && isDiffOneChar(begin, words[i])) {
				// 방문했음을 표시했고, 카운트 값도 하나 추가하였음
				visited[i] = true;

				// 다음 값을 시작값으로 다시 회귀 - count + 1이 핵심
				dfs(words[i], target, words, visited, count + 1);

				// 세부적인 dfs가 끝나면 다시 방문이 가능함
				visited[i] = false;

			}
		}
	}

	public static boolean isDiffOneChar(String word1, String word2) {

		int count = 0;

		for (int i = 0; i < word1.length(); i++) {
			count += (word1.charAt(i) != word2.charAt(i)) ? 1 : 0;
			if (count > 1) {
				return false;
			}
		}

		return true;
	}

	// 실행 메소드
	public static void main(String[] args) {
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution("hit", "cog", words));
	}
}
