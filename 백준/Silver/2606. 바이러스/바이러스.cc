// ConsoleApplication1.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.
//

#include <iostream>
#include <queue>
#include <string>
#include <cstdio>
#include <vector>
#define P pair<int,int>
using namespace std;

int n, m;
vector<int> a[101];
int result;
bool visited[101];
void dfs(int x) {
	visited[x] = true;
	for (int i = 0; i < a[x].size(); i++) {
		int y = a[x][i];
		if (!visited[y]) {
			result++;
			dfs(y);
		}
	}
}

int main()
{	
	cin >> n;
	cin >> m;
	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;
		a[u].push_back(v);
		a[v].push_back(u);
	}
	dfs(1);
	cout << result << endl;
}
