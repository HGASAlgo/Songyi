import java.util.*;
class Solution {
    public String solution(String number, int k) {
        //	빠른 연산을 위해 StringBuilder사용
        StringBuilder sb = new StringBuilder(number);
        int delCnt = 0;	// 삭제 개수 카운트
        int index = 1;	// 전의 숫자와 비교하므로 1부터 시작
        
        while(delCnt != k) {
            //	index 숫자가 전의 숫자보다 크면 전의 숫자 삭제
            if(index >= 1 && sb.charAt(index) > sb.charAt(index -1)) {
                sb.deleteCharAt(index-1);
                delCnt++;
                index--;	//	숫자가 하나 삭제되어 크기가 줄어들었으므로 index 1 줄임 
            }
            //	index가 마지막 숫자이고 전의 숫자보다 작거나 같으면 삭제
            else if(index == sb.length()-1 && sb.charAt(index) <= sb.charAt(index-1)) {
                sb.deleteCharAt(index);
                delCnt++;
                index--;
            }
            // 그외에는 index 증가(다음 숫자와 비교 위해)
            else {
                index++;
            }
        }
	        
	    return sb.toString();   
    }
}
