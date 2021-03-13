package basic;

import java.util.Arrays;

public class JadenCase2 {
	static String answer ="";
	static boolean space = true;
	public static String solution(String s) {
		String[] arr = s.toLowerCase().split(""); 
		Arrays.stream(arr)
		.forEach(str ->{
			answer += (space==true) ? str.toUpperCase() : str;
			space = str.equals(" ") ? true : false;
		});
		return answer;	
	}
	public static void main(String[] args) {
//		String s = "3people       unFollowed me     ";
		String s = "people       unFollowed me     ";
		System.out.println(solution(s));
	}
}
