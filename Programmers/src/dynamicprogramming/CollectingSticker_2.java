package dynamicprogramming;

public class CollectingSticker_2 {
	public static int solution(int sticker[]) {
		
		if(sticker.length<=1) {
			return (sticker.length==1)? sticker[0] : 0;
		}
		
		if(sticker.length<=3) {
			return (sticker.length==2)? Math.max(sticker[0], sticker[1]) : Math.max( sticker[2], Math.max(sticker[0], sticker[1]));
		}
		
		int[] dp1 = new int[sticker.length];
		int[] dp2 = new int[sticker.length];
		int maxDp1;
		int maxDp2;
		
		dp1[0] = sticker[0];
		dp1[1] = sticker[1];
		dp1[2] = sticker[2] + dp1[0];
		
		dp2[0] = 0;
		dp2[1] = sticker[1];
		dp2[2] = sticker[2];
		dp2[3] = sticker[3] + dp2[1];
		
		for(int i=3; i<sticker.length; i++) {
			dp1[i] = sticker[i] + Math.max(dp1[i-2], dp1[i-3]);
			if(dp1[sticker.length-1]==dp1[i]) {
				dp1[i] = 0;
			}
		}
		
		maxDp1 = Math.max(dp1[sticker.length-3], dp1[sticker.length-2]);

		for(int i=3; i<sticker.length; i++) {
			dp2[i] = sticker[i] + Math.max(dp2[i-2], dp2[i-3]);
		}
		
		maxDp2 = Math.max(dp2[sticker.length-1], dp2[sticker.length-2]);

        return Math.max(maxDp1, maxDp2);
    }
	
	// 실행 메소드
		public static void main(String[] args) {
			int[] v = {14, 6, 5, 11, 3, 9, 2, 10}; //36
			System.out.println(solution(v));
		}

}
