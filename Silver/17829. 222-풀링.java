#include <iostream> 
#include <time.h>
#include <vector> 
#include <algorithm> 
using namespace std; 

#define MAX 1024 // (N*N) 행렬의 최대 크기 
#define MIN 2 // (N*N) 행렬의 최소 크기

int main(void) 
{ 
	int N; //  이미지를 풀링을 적용할 행렬의 크기 (N*N)
	cin >> N; // 행렬의 크기 입력

	if (N < MIN || N > MAX) // N의 입력 범위 검사 (2 <= N <= 1024)
	{
		cout << "행렬의 크기에 대한 입력 값 범위를 초과했습니다." << endl;
		return -1; // 프로그램 종료.
	}
	
	int arr[N][N]; // 최초 행렬 (N*N) 선언

	for (int i = 0; i < N; i++) // 행(Row)의 크기 N만큼 입력 받는다.
	{	
		for (int j = 0; j < N; j++) // 열(Column)의 크기 N만큼 입력 받는다.
		{
			cin >> arr[i][j]; // 입력 받은 값을 최초 행렬에 전달한다.
			if (arr[i][j] < (-10000) || arr[i][j] > 10000) // 행렬의 원소의 입력 범위 검사 (-10000 <= N <= 10000)
			{
				cout << "행렬의 원소에 대한 입력 값 범위를 초과했습니다." << endl;
				return -1; // 프로그램 종료.
			}
		}
	}
	vector<vector<int>> temp; // 이중 벡터 구조를 활용하여 풀링을 적용한 결과를 저장한다.
	for (int k = 0; k < (N / 2); k++) // ((N/2)*(N/2)) 크기의 벡터를 생성한다.
		temp.push_back(vector<int>(N / 2));

	do
	{ 
		for (int y = 0; y < N; y += 2) // (2*2) 정사각형의 행(Row)
		{ 
			for (int x = 0; x < N; x += 2) // (2*2) 정사각형의 열(Column)
				{ 
					vector<int> v(4); // (2*2) 정사각형에 해당하는 4개의 원소를 저장할 벡터 생성
					v[0] = arr[y][x]; // Ex. arr[0][0], [0][2] ...
					v[1] = arr[y][x + 1]; // Ex. arr[0][1], [0][3] ...
					v[2] = arr[y + 1][x]; // Ex. arr[1][0], [1][2] ...
					v[3] = arr[y + 1][x + 1]; // Ex. arr[1][1], [1][3] ...
					sort(v.begin(), v.end()); // 정사각형의 원소 오름차순 정렬
					temp[y/2][x/2] = v[2]; // 두 번째로 큰 수(v[2])만 남긴다.
				}	 
		}
		N /= 2; // (N*N) 행렬에 대해 풀링을 적용한 경우, 행렬의 크기는 ((N/2)*(N/2))가 된다.
		for (int i = 0; i < N; i++) // 줄어든 행렬의 크기에 맞춰, 풀링의 결과값에 해당하는 값들을 대입한다.
		{
			for (int j = 0; j < N; j++) 
				arr[i][j] = temp[i][j]; // 풀링의 결과값에 해당하는 값들을 최초행렬에 전달한다.
		} 
	}while (N != 1);  // 행렬의 크기가 (1*1)이 될때까지 반복

	cout << arr[0][0] << endl; // 풀링을 반복해서 적용하여 (1*1) 행렬에 남은 최종적인 값 출력
	return 0; 
}
