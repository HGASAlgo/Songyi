import java.util.*;
class Solution {
    public int solution(int[][] routes) {
	int answer = 0;	//	카메라 개수
	int camera = -30001;	// 카메라 설치된 위치
        
      	// 차량의 진출 지점을 기준으로 오름차순 정렬, 먼저 나간 차량부터 체크 하면 뒤에 걸리지 않은 차량들만 체크하면 됨
	Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        
      	//  카메라가 설치된 위치가 진입 지점보다 전에 있으면 진출 지점에 카메라를 설치
      	//  진입 지점 보다 나중에 있으면 어차피 그 전에 설치한 카메라를 지날 수 밖에 없음
      	for(int[] route: routes) {
        	if(camera < route[0]) {
			camera = route[1];
          		answer++;
        	}
	}
	return answer;
   }
}
