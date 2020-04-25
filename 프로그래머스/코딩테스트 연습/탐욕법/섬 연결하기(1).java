import java.util.Arrays;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
	    int[] t = new int[costs.length];	// 다리를 연결할 때 드는 비용을 저장할 배열
	    int j = 0;
	        
        //	다리를 연결할 때 드는 비용을 배열에 저장
	    for(int i = 0; i < costs.length; i++) {
            t[i] = costs[i][j+2];
        }
        
        // 오름차순으로 정렬
        Arrays.sort(t);
        
        // 최소 n-1개의 다리를 건설할 수 있고 가장 작은 비용 순서대로 앞에서 n-1개만 뽑아서 더함
        for(int i = 0; i < n-1; i++) {
            answer += t[i];
        }
        
        return answer;
    }
}
