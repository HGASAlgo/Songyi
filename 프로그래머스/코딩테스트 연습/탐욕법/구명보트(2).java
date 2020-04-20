import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
	    int cnt = 0;	// 구한 사람 수
	    int x = 0;
	    int size = people.length;
	    int y = size - 1;
	    Arrays.sort(people); //	무게 순서대로 배열
	        
	    while(cnt != size) {	// 모든 사람 구출할때까지
	        if(people[x] == 0) { //	이미 구한 사람이면 다음 사람 순서로 넘어감
	        	x++;
	        	y = size-1;
	        }
	       	//	이미 구한 사람을 제외하고 두 사람 몸무게 합이 limit이하일 때
	        else if(people[y] != 0 && people[x] + people[y] <= limit){ 
	        	people[x] = 0;	//	구한 사람은 0으로 바꿔줌
	        	people[y] = 0;
	        	cnt += 2;
	        	answer++;	// 구명보트 개수
	        	x++;
	        	y = size-1;
	        			
	        }
            //	맨 마지막 순서 사람이 혼자 남았을 때
	        else if(people[x] != 0 && x == size-1) {
	        	cnt++;
	        	answer++;
	        	break;
	        }
            else if((size - cnt == 1) && people[x] != 0) {
	        		people[x] = 0;
	        		cnt++;
	        		answer++;
	        		break;
	        	}
	        		
            //	남은 사람이 limit의 반보다 크고(= 무조건 혼자 타야함) 다음 사람과 합이 limit보다 클 때
	        else if(people[x+1] > (limit/2) && people[x] + people[y] > limit){	
                //	남은 인원을 각각 다른 보트에 태우기
	        	for(int i = x; i <= y; i++) {
	        		people[i] = 0;
	        		cnt++;
	        		answer++;
	        	}
                break;
	        }
	        else
	        	y--;
	        	
	        	
	    }
        return answer;
    }
}
