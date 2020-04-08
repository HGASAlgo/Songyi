class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int exp = name.length() - 1; // 처음부터 끝까지 셀 경우(최대값)
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            answer += ('Z'- c + 1) > c - 'A' ? c - 'A' : ('Z' - c + 1); // A부터 세거나 Z부터(거꾸로)세서 더 작은 값 추출
            if(c == 'A'){
                int nextIdx = i+1;
                int countA = 0;
                while (nextIdx < name.length() &&
                       name.charAt(nextIdx) == 'A'){
                    countA ++;
                    nextIdx++;
                }
                int tmp = (i-1)*2 + (name.length() -1 -i - countA) ;
                if(exp > tmp) exp = tmp;
            }
        }

        answer += exp;
        return answer;
    }
}
