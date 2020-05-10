import java.util.*;
class Solution {
    public int solution(int[] weight) {
        int answer = 0;
        int sum = 0;	//	sum까지 무게를 측정할 수 있음
        Arrays.sort(weight);
		
    //	현재 올리려는 저울추의 무게가 sum + 1(지금까지 올린 추의 무게의 합+1)보다 크면 sum+1이 측정할 수 없는 최소값이 됨 
		for(int i = 0; i < weight.length; i++) {
            if(weight[i] <= sum + 1) {
                sum += weight[i];
            }
            else
                break;
    }
    
		answer = sum + 1;
    return answer;
    
    }
}
