class Solution {
    public String solution(String number, int k) {
        String answer = "";
	        String[] str2 = null;
	        str2 = number.split("");
	        int[] num_arr= new int[str2.length];	// 10
	       
	        //	str2를 num_array로 변환 
	        for(int i = 0; i < str2.length; i++) {
	        	int n = Integer.parseInt(str2[i]);
	        	num_arr[i] = n;
	        }
	        
	        
	        int i = 1;
	        int removeCnt = 0;
	        int winIdx = 0;	// 비교 숫자(큰 숫자)
	        
        	// 제거된 수가 k개가 되면 중지
	        while(removeCnt != k && i < num_arr.length) {
		    	if(num_arr[winIdx] > num_arr[i]) {	// 비교 숫자가 현재 숫자보다 클 때
		    		num_arr[i] = 0;	// 현재 숫자를 0으로 제거
		        	removeCnt++;	// 제거된 수 카운트
	                if(num_arr[i] == num_arr[i+1]) {	//	현재 숫가 다음 숫자와 같을 때
	                    winIdx = i+2;	// 비교 숫자를 동일한 문자 다음 숫자로 설정
	                    i = i + 3;	// 현재 숫자를 비교 숫자 오른쪽에 설정
	                }
	                //else 
	               		//winIdx = i-1;	// 비교 숫자 유지
	                i++; // 현재 숫자 오른쪽으로 이동
	                
	                
	       		}
	            else if(num_arr[winIdx] < num_arr[i]) {	// 현재 숫자가 비교 숫자보다 클 때
		           	num_arr[winIdx] = 0; // 비교 숫자를 0으로 제거
		           	removeCnt++;	// 제거 숫자 카운트
	                if(num_arr[i] == num_arr[i+1]) {	// 현재 숫자와 다음 숫자가 같을 때
	                    winIdx = i + 2;	// 비교 숫자를 동일한 문자 다음 숫자로 설정
	                	i = i + 3;	// 현재 숫자를 비교 숫자 오른쪽에 설정
	            	}
	                else {
	                	winIdx =i;
	                	i++;	// 현재 숫자 오른쪽으로 이동
                    }
	            }
	            
		    }
	        
        	// 0을 제외한 나머지를 문자열로 합침
	        for(int j = 0; j < num_arr.length; j++) {
	            if(num_arr[j] != 0) {
	            	answer += num_arr[j];
	            	System.out.print(num_arr[j]);
	            }

	        }
	        
	        return answer;   
    }
}
