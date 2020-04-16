import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int cnt = 0;
        int weight = 0;
        int i = 0;
        Arrays.sort(people);
        
        while(cnt != people.length) {
            if(i <= people.length-1 && weight + people[i] <= limit) {
                weight += people[i];
                i++;
                cnt++;
            }
            else {
                answer++;
                weight = 0;
            }
        }
        answer += 1;
        return answer;
    }
}
