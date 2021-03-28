package basic;

import java.util.Arrays;

public class budget {

	static int total = 0;
    public static int solution(int[] d, int budget) {
        return (int) Arrays.stream(d).sorted().filter(i -> {
            total = total + i;
            if(total <= budget){
                return true;
            } else {
                return false;
            }
        }).count();
    }
    
	// 실행 메소드
	public static void main(String[] args) {
		int[] d = {1,3,2,5,4};
		int budget = 9;
		System.out.println(solution(d, budget));
	}


}
