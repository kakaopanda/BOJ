import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int array[][];
	static int array_command[][];
	static int command[];
	static int N, M, R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		array_command = new int[N][M];
		command = new int[R];
		
		for(int i=0; i<N; i++) {
			st =  new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st =  new StringTokenizer(br.readLine()," ");
		for(int i=0; i<R; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int r=0; r<R; r++) {
			operation(command[r]);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void operation(int option) {
		int temp;
		int array_first[][];
		int array_second[][];
		int array_third[][];
		int array_fourth[][];
		switch(option) {
		case 1:
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					array_command[i][j] = array[N-i-1][j];
				}
			}
			transfer();
			break;
		case 2:
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					array_command[i][j] = array[i][M-j-1];
				}
			}
			transfer();
			break;
		case 3:
			array_command = new int[M][N];
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					array_command[i][j] = array[N-j-1][i];
				}
			}
			array = new int[M][N];
			temp = N;
			N = M;
			M = temp;
			transfer();
			break;
		case 4:
			array_command = new int[M][N];
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					array_command[i][j] = array[j][M-i-1];
				}
			}
			array = new int[M][N];
			temp = N;
			N = M;
			M = temp;
			transfer();
			break;
		case 5:
			array_first = new int[N/2][M/2];
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_first[i][j] = array[i][j];
				}
			}
			array_second = new int[N/2][M/2];
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_second[i][j] = array[i][j+M/2];
				}
			}
			array_third = new int[N/2][M/2];
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_third[i][j] = array[i+N/2][j+M/2];
				}
			}
			array_fourth = new int[N/2][M/2];			
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_fourth[i][j] = array[i+N/2][j];
				}
			}
			
			// 4 -> 1
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_command[i][j] = array_fourth[i][j];
				}
			}
			// 1 -> 2
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_command[i][j+M/2] = array_first[i][j];
				}
			}
			// 2 -> 3
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_command[i+N/2][j+M/2] = array_second[i][j];
				}
			}
			// 3 -> 4
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_command[i+N/2][j] = array_third[i][j];
				}
			}
			transfer();
			break;
		case 6:
			array_first = new int[N/2][M/2];
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_first[i][j] = array[i][j];
				}
			}
			array_second = new int[N/2][M/2];
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_second[i][j] = array[i][j+M/2];
				}
			}
			array_third = new int[N/2][M/2];
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_third[i][j] = array[i+N/2][j+M/2];
				}
			}
			array_fourth = new int[N/2][M/2];			
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_fourth[i][j] = array[i+N/2][j];
				}
			}
			
			// 2 -> 1
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_command[i][j] = array_second[i][j];
				}
			}
			// 3 -> 2
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_command[i][j+M/2] = array_third[i][j];
				}
			}
			// 4 -> 3
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_command[i+N/2][j+M/2] = array_fourth[i][j];
				}
			}
			// 1 -> 4
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					array_command[i+N/2][j] = array_first[i][j];
				}
			}
			transfer();
			break;
		}
	}
	
	static void transfer() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				array[i][j] = array_command[i][j]; 
			}
		}
	}
}
