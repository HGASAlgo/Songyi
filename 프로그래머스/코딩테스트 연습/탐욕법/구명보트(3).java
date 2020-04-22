import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int i = 0;
        int j;
        int answer = 0;
        
        // 무게순서대로 정렬
        Arrays.sort(people);
        
        // 최소값과 최대값을 짝지어서 합이 limit보다 크면 최대값은 혼자 타야함 아니면 두명이 같이 하나의 보트를 탐
        for(j = people.length-1; j > i; j--) {
            if(people[i] + people[j] > limit)
                answer++;
            else {
                answer++;
                i++;
            }
        }
        
        //  혼자 남았으면 혼자 보트를 탐
        if(i == j)
            answer++;
        return answer;
    }
}
