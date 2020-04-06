import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    	int okMember = n - lost.length; // 전체 수에서 체육복 잃어버린 인원 빼기(나중에 빌린 인원 더하기)
		
		List<Integer> lostList = new ArrayList<Integer>(); // 체육복 잃어버린 학생 리스트
		for (int i : lost) lostList.add(i);

		List<Integer> reserveList = new ArrayList<Integer>(); // 체육복 여분 가진 학생 리스트
		for (int i : reserve) reserveList.add(i);
		
        for(int i=0; i<lostList.size(); i++) { // 체육복 잃어버렸지만 여분 있는 학생 리스트에서 제거
			for(int j=0; j<reserveList.size(); j++) {
				if(lostList.get(i) == reserveList.get(j)) {
					lostList.remove(i);
					reserveList.remove(j);
                    i--;
					okMember++;
					break;
				}
			}
		}
    
		for (int i = 0; i < lostList.size(); i++) { // 잃어버린 학생 앞 뒤 학생이 여분 있으면 빌려준다.
			int lostNum = lostList.get(i);
			for (int j = 0; j < reserveList.size(); j++) {
				int reserveNum = reserveList.get(j);
				if (lostNum == reserveNum - 1 || lostNum == reserveNum + 1) {
					reserveList.remove(j);
					okMember++;
					break;
				}
			}
		}

		return okMember;
	}
    
}
