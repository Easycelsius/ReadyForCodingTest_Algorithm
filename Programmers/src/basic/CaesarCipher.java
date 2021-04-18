package basic;

public class CaesarCipher {

	public static String solution(String s, int n) {

		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			
			int c = s.charAt(i);
			if(s.charAt(i)==' ') {
				c = ' ';
			} else if(s.charAt(i)>='a'&&s.charAt(i)<='z'&&s.charAt(i)+n>'z') {
				c = s.charAt(i)+n-26;
			} else if(s.charAt(i)>='A'&&s.charAt(i)<='Z'&&s.charAt(i)+n>'Z') {
				c = s.charAt(i)+n-26;
			} else if( s.charAt(i)>='a'&&s.charAt(i)<='z' || s.charAt(i)>='A'&&s.charAt(i)<='Z' ) {
				c = s.charAt(i)+n;
			}

			answer += ((char)c) + "";
		}
		
		return answer;
	}

	// 실행 메소드
	public static void main(String[] args) {
		String s = 	"AaZz";
		int n = 25;
		System.out.println(solution(s, n)); //ZzYy
	}

}
