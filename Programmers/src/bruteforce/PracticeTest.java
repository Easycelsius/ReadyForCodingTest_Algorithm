/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 모의고사(https://programmers.co.kr/learn/courses/30/lessons/42840)
 * 레벌 : 레벨 1
 * 시작 날짜 : 2021-01-16
 * 종료 날짜 : 2021-01-16
 * 
 * 기획
 * Step 1. 학생들이 기재한 답에 대한 배열을 무한정 늘릴 수 없으니 나눗셈의 특성을 이용하기
 * Step 2. 최대 정답 수를 구한 후, 중복값 존재한는 확인, sorting을 이용해 답을 추출
 * 
 * 후기
 *  - ArrayList를 배우지 않았던 때라 상당히 어려움이 있었음
 *  - 또한, 인덱스 변수를 새롭게 추가해서 효율적으로 답을 구성하여야 했으나, 생각이 나지 않아 불가피하게 Big M method와 같은 방식으로 정렬을 통해 큰 수를 제외하게 만들었음
 *  - 추후 같은 문제를 풀게 된다면 배열 생성 횟수를 줄이고, 효율적으로 답을 추출할 수 있을 것으로 분석됨
 */

package bruteforce;

import java.util.Arrays;

public class PracticeTest {

	public static int[] solution(int[] answers) {

		int[] student1 = { 1, 2, 3, 4, 5 };
		int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] student3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] score = { 0, 0, 0 }; // 학생들이 맞춘 답

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == student1[i % student1.length]) {
				score[0] = score[0] + 1;
			}

			if (answers[i] == student2[i % student2.length]) {
				score[1] = score[1] + 1;
			}

			if (answers[i] == student3[i % student3.length]) {
				score[2] = score[2] + 1;
			}
		}

		// 최대값 구하기, score = 맞춘값, max
		int max = 0;
		for (int i : score) { // {5, 5, 0}
			if (i > max) {
				max = i;
			}
		}

		// 최대값으로 배열 선언
		int count = 0; // 최대 정답자 수
		int[] sequence = { 0, 0, 0 };

		for (int i = 0; i < score.length; i++) {
			if (score[i] == max) { // {0, 3, 3}
				count += 1;
				sequence[i] = i + 1; // {100000, 2, 3}
			} else {
				sequence[i] = 4; // big M method
			}
		}

		Arrays.sort(sequence); // {2, 3, 10000000}

		int[] answer = new int[count]; // 최대 정답자 수에 근거한 배열 크기 선언

		for (int i = 0; i < answer.length; i++) {
			answer[i] = sequence[i]; // 최대 정답자 수 answer[0] = sequence [0] = 2
			// answer[1] = sequence[1] = 3
		}

		// Arrays.sort(answer); // answer 정렬
		return answer; // answer = {2, 3}
	}

	//실행 메소드
	public static void main(String[] args) {
		int[] answers = { 1, 3, 2, 4, 2 }; // [1,2,3]
		System.out.println(solution(answers));
	}

}
