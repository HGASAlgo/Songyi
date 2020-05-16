class Solution {
	    public int solution(int[] numbers, int target) {
	        int answer = 0;
	        answer = dfs(numbers, 0, 0, target);
	        return answer;
	    }
	    
	    //	종료조건은 모든 깊이 즉, 배열에 모든 요소를 접근했을 때이며
	    //	점화식은 해당 인덱스의 요소를 더할지 혹은 빼는 모든 경우를 구하는 것
	    //	배열에 있는 요소가 하나의 노드, 배열의 인덱스는 깊이
	    public int dfs(int[] numbers, int node, int sum, int target) {
	    	//  각 깊이에 대해 모두 탐색하고, 모든 경우의 수를 탐색함
	        if(node == numbers.length) {	
	           if(sum == target)
	               return 1;
	           return 0;
	        }
	        return dfs(numbers, node+1, sum+numbers[node], target)
	            //	node를 하나씩 탐색하며 node들을 합해줌
	            + dfs(numbers, node+1, sum-numbers[node], target);
	            //  node를 하나씩 탐색하며 node들을 빼줌
	    }
}
