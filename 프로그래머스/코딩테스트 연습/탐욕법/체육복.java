class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;	// 체육수업을 들을 수 있는 학생 최댓값
        int extra_lost = 0;	// 여벌의 체육복을 가진 학생 중 체육복을 잃어버린 학생 수
		int brw_cnt = 0;	// 여벌의 체육복을 빌린 학생 수
        
        // 여벌 체육복을 가진 학생이 체육복을 잃어버리면 빌려줄 수 없게 만든다(-1로 바꿈)
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    extra_lost++;
                    lost[i] = -1;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        
        // 옷을 빌려주고 -1로 만들어 다른 학생들에게 중복으로 빌려주지 않게 한다
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                    brw_cnt++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        // 전체 학생 수에서 체육복을 잃어버린 학생 수를 뺀다.
        // 여벌옷을 가진 학생이 도난 시 그 수를 더하고, 옷을 빌린 학생 수를 더한다.
        
        answer = n - lost.length + brw_cnt;
        return answer;
    }
   
}
