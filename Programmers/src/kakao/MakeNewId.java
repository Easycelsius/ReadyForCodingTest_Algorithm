/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 신규 아이디 추천(https://programmers.co.kr/learn/courses/30/lessons/72410)
 * 레벌 : 레벨 1
 * 시작 날짜 : 2021-03-04
 * 종료 날짜 : 2021-03-04
 * 
 * 기획
 *  - 각 단계별로 실행해야할 순서를 문제에서 명확히 하였기 때문에 따로 기획을 진행하지는 않음
 * 
 * 후기
 *  - 
 */

package kakao;

public class MakeNewId {
	public static String solution(String new_id) {
		// 1단계 : 소문자 변환
		new_id = new_id.toLowerCase();

		// 2단계 : 소문자, 숫자, 빼기, 밑줄, 마침표 제외한 모든 문자 제거
		String spLetters = "~!@#$%^&*()=+[{]}:?,<>/";
		
		if (new_id.length() > 0) {
			for (int i = 0; i < spLetters.length(); i++) {
				if (new_id.length() <= 0) {
					break;
				}
				String spLetter = spLetters.substring(i, i + 1);
				new_id = new_id.replace(spLetter, "");
			}
		}
		
		// 3단계 : "."이 2개이 상인 것은 "."으로 만들기 o
		if (new_id.length() > 0) {
			while (true) {
				int before = new_id.length();
				new_id = new_id.replace("..", ".");
				int after = new_id.length();
				if (before == after) {
					break;
				}
			}
		}
		
		// 4단계 : "."이 첫번째, 마지막번째인 경우 처리
		if (new_id.substring(0, 1).equals(".")) {
			new_id = new_id.substring(1);
		}
		
		if(new_id.length()>0) {
			if (new_id.substring(new_id.length() - 1).equals(".")) {
				new_id = new_id.substring(0, new_id.length() - 1);
			}	
		}
		
		// 5단계 : 빈 문자열에 대한 처리
		if (new_id.length() == 0) {
			new_id = "a";
		}

		// 6단계 : 16자리 이상 문자열 처리
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
		}
		
		// 마지막에 "."이 있으면 제거
		if(new_id.length()>0) {
			if (new_id.substring(new_id.length() - 1).equals(".")) {
				new_id.substring(0, new_id.length() - 1);
			}
		}

		// 7단계 : 2자리 이하 수를 증가시키기
		if (new_id.length() <= 2) {
			int index = 0;
			while (new_id.length() < 3) {
				index = new_id.length() - 1;
				if(new_id.length()>0) {
					new_id = new_id + new_id.substring(index, index + 1);
				}
			}
		}
		
		// 마지막에 "."이 있으면 제거
		if(new_id.length()>0) {
			if (new_id.substring(new_id.length() - 1).equals(".")) {
				new_id = new_id.substring(0, new_id.length() - 1);
			}	
		}
		
		return new_id;
	}

	public static void main(String[] args) {
		String s1 = "z-+.^.";
		String s2 = "=.=";
		String s3 = "...!@BaT#*..y.abcdefghijklm"; // "bat.y.abcdefghi"
		String s4 = "abcdefghijklmn.p";
		System.out.println(solution(s4));
	}

}
