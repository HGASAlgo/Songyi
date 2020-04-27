import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        //	오름차순으로 정렬
        Comparator<int[]> c1 = (a,b) -> {
            return a[2]-b[2];
        };
        Arrays.sort(costs, c1);
        
       	boolean[] bridge = new boolean[costs.length];	// 다리를 건설했는지
        boolean[] visit = new boolean[n];	//	섬에 방문했는지
        visit[costs[0][0]] = true;	//	최소 비용의 다리를 건설해주기 위해 섬에 방문
        visit[costs[0][1]] = true;	//	최소 비용의 다리를 건설해주기 위해 섬에 방문
        bridge[0] = true;	//	최소 비용의 다리를 건설함
        int answer = costs[0][2];	// 처음 건설한 다리의 비용 추가
	int island = 2;	// 방문한 섬의 개수를 체크해 줄 변수
        
        while(island < n) {	//	모든 섬을 방문하면 다리를 건설할 필요가 없음(=모든 섬을 방문)
        	for(int i = 1; i < costs.length; i++) {
                //	다리를 건설하지 않았고 섬 두개 중 하나를 방문하지 않았을때
                if(!bridge[i] && ((visit[costs[i][0]] && !visit[costs[i][1]]) || (visit[costs[i][1]] && !visit[costs[i][0]]))) {
                    visit[costs[i][0]] = true;	//	섬에 방문
                    visit[costs[i][1]] = true;	//	섬에 방문
                    bridge[i] = true;	//	다리 건설
                    island++;	// 섬 방문 수 체크
                    answer += costs[i][2];	//	비용 더함
                    break;
                }
            }  
        }
        return answer;
    }
}
