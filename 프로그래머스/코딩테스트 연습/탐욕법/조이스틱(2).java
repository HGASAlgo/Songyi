class Solution {
    public int solution(String name) {
        char[] names = name.toCharArray();
        int answer = 0;
        int min = name.length() - 1;	// 처음부터 끝까지 움직일 경우(최대값)
        
        // 상,하로 움직이는 경우 세기
        for(int i = 0; i < names.length; i++){
            answer += ('Z'- names[i] + 1) > names[i] - 'A' ? names[i] - 'A' : ('Z' - names[i] + 1);
        }
        
        // 거꾸로 움직여서 세는 경우
        int moveCnt = 1;	// 맨 처음에 뒤로 움직일 때 카운트
        for(int i = 1; i < names.length; i++) {
            if(names[i] != 'A') {
                moveCnt = names.length - i;
                break;
            }
        }
        
        if(min >= moveCnt) min = moveCnt;	// 최소 카운트값 갱신
        
        // 앞부터 세는 경우
        moveCnt = names.length - 1;
        
        for(int i = names.length - 1; i > 0; i--) {
            if(names[i] != 'A') {
                moveCnt = i;
                break;
            }
        }
        if(min > moveCnt) min = moveCnt;	// 최소 카운트값 갱신
        
        answer += min;
        
        return answer;
    }
}
