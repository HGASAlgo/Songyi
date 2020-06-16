import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static final int MAX = 6;
	public static int[] arr;
	public static boolean[] visited;
	
	public static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		sb = new StringBuilder();
		
		while(true) {	// input 입력받
			st = new StringTokenizer(br.readLine());
			int numCnt = Integer.parseInt(st.nextToken());	// 로또 번호 개수  
			
			if(numCnt == 0) break;
			arr = new int[numCnt];	// 원소 입력 
			visited = new boolean[numCnt];	// 방문 여부 배열 생성 
			
			int idx = 0;
			while(idx < arr.length) {
				arr[idx++] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < arr.length; i++) {
				if(i + MAX > arr.length) continue;
				visited[i] = true;
				backtracking(i, 1, arr[i] + " ");
				visited[i] = false;
			}
			
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	public static void backtracking(int idx, int cnt, String str) {
		if(idx >= arr.length || idx + MAX - cnt > arr.length) return;
		if(cnt == MAX) {	// 추출된 로또 번호의 원소의 수가 6개면 생성된 로또 번호 문장 출력 
			sb.append(str + "\n");
			return;
		}
		
		for(int i = idx + 1; i < arr.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			backtracking(i, cnt + 1, str + arr[i] + " ");
			visited[i] = false;
		}
	}

}
