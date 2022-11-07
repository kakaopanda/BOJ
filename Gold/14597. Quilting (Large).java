#include <iostream> 
#include <time.h>
#include <math.h>
#include <algorithm> 
using namespace std;

#define MIN 1 // 포개어진 이미지의 높이(H) 및 너비(W) 최솟값
#define MAX 100 // 포개어진 이미지의 높이(H) 및 너비(W) 최댓값
#define COLOR_MIN 0 // 픽셀의 밝기 최솟값
#define COLOR_MAX 255 // 픽셀의 밝기 최댓값

int H, W; // 포개어진 두 이미지의 높이(H) 및 너비(W)
int SSD[MAX][MAX]; // 경계선 경로에 해당하는 픽셀에 대한 부자연스러움 정도(SSD)를 기록할 배열
int first[MAX][MAX]; // 첫 번째 이미지(B1)의 픽셀 정보(최대 길이(MAX*MAX)로 선언)
int second[MAX][MAX]; // 두 번째 이미지의(B2) 픽셀 정보(최대 길이(MAX*MAX)로 선언)

int SSD_Probing(int x, int y) { 
	// 재귀함수로 경계선 선택이 가능한 모든 경로를 탐색하고, SSD를 산출해낸다. 
	// x는 현재 탐색중인 픽셀의 행이며, y는 현재 탐색중인 픽셀의 열에 해당한다.

	if (x == H)  // 모든 행을 탐색한 경우, 탐색 중단
		return 0;

	else if (SSD[x][y] != 0) // 이미 탐색을 진행한 경로에 대해서는 더 이상 탐색을 진행하지 않는다.
		return SSD[x][y];

	else { // 경로 탐색은 다음의 세 가지 경우를 고려할 수 있다.
		// 1.(다음 행, 동일열)에 해당하는 원소에 대해 탐색 진행 (경계선 픽셀이 일직선으로 내려오는 과정)
		SSD[x][y] = SSD_Probing(x+1, y); 

		// 2.첫 번째 열이 아닌 경우, (다음행, 이전열)에 해당하는 원소에 대해 탐색 진행 (경계선 픽셀이 일직선으로 내려오다 왼쪽으로 꺾이는 과정)
		if (y != 0) SSD[x][y] = min(SSD[x][y], SSD_Probing(x+1, y-1)); 

		// 3.마지막 열이 아닌 경우, (다음행, 다음열)에 해당하는 원소에 대해 탐색 진행 (경계선 픽셀이 일직선으로 내려오다 오른쪽으로 꺾이는 과정)
		if (y != W-1) SSD[x][y] = min(SSD[x][y], SSD_Probing(x+1, y+1));
		
		// 해당 경로의 SSD값을 연산한 뒤 저장한다.
		return SSD[x][y] += pow((first[x][y] - second[x][y]), 2); 
	}
}

int main() {
	int SSD_VALUE = 0; // 최적의 경계선이 가지는 최소의 부자연스러움 정도(SSD)
	cin >> H >> W; // 포개어진 두 이미지의 높이(H) 및 너비(W)를 입력한다.

	if((H < MIN || H > MAX)||(W < MIN || W > MAX)) // H,W값의 입력범위 검사 (1<= H <=100, 1<= W <= 100)
	{
		cout << "포개어진 이미지에 대한 입력 값 범위를 초과했습니다." << endl;
		return -1; // 프로그램 종료.
	}

	for (int i = 0; i < H; i++) { // H줄에 걸쳐서 B1 이미지의 밝기 값을 입력한다.
		for (int j = 0; j < W; j++)
		{
			cin >> first[i][j];
			if (first[i][j] < COLOR_MIN || first[i][j] > COLOR_MAX) // 특정 (행,열)에 위치한 픽셀의 밝기 값에 대한 입력범위 검사 (0<= PIXEL <= 255)
			{
				cout << "픽셀의 밝기값에 대한 입력 값 범위를 초과했습니다." << endl;
				return -1; // 프로그램 종료.
			}
		}
	}

	for (int i = 0; i < H; i++) { // H줄에 걸쳐서 B2 이미지의 밝기 값을 입력한다.
		for (int j = 0; j < W; j++)
		{
			cin >> second[i][j];
			if (second[i][j] < COLOR_MIN || second[i][j] > COLOR_MAX) // 특정 (행,열)에 위치한 픽셀의 밝기 값에 대한 입력범위 검사 (0<= PIXEL <= 255)
			{
				cout << "픽셀의 밝기값에 대한 입력 값 범위를 초과했습니다." << endl;
				return -1; // 프로그램 종료.
			}
		}
	}

	for (int i = 0; i < W; ++i) // 각 행,열에 대해 재귀함수를 수행한다.
		SSD_Probing(0, i); // 첫 번째 행의 첫 번째 열부터 탐색을 수행한다.

	// 첫 번째 행에서부터 시작하는 최적 경로의 SSD 값만 구하면 된다.
	// SSD[0] 이외의 다른 행에 대한 SSD 값 비교는 무의미하다.
	// SSD[0][0..W-1] 까지의 SSD 값만 비교하면 된다.
	for (int i = 0; i < W; i++)
	{
		if (i == 0)
			SSD_VALUE = SSD[0][i]; // SSD_VALUE를 SSD 행렬의 첫 번째 원소로 초기화
		else {
			if (SSD_VALUE > SSD[0][i]) // SSD 행렬의 원소값이 SSD_VALUE 보다 작을 경우, 해당 원소의 값으로 갱신한다(최솟값 탐색).
				SSD_VALUE = SSD[0][i];
		}
	}
	cout << SSD_VALUE << endl;

	return 0;
}