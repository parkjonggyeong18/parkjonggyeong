#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>
#include <cstdio>
#include <string>
#include <deque>
#include <stack>
#define P pair<int,int>
#define F first
#define S second
#define LL long long

using namespace std;

int N;
int map[4][4];
int check[4][4];
P Move[2] = {{1, 0}, {0, 1}};

bool bfs(int X, int Y){
    queue<P> q;
    check[X][Y] = 1;
    q.push({X, Y});
    while(!q.empty()){
        int x = q.front().F;
        int y = q.front().S;
        q.pop();
        if(map[x][y] == -1) return true;
        for(int i = 0; i < 2; i++){
            int xx = x + Move[i].F * map[x][y];
            int yy = y + Move[i].S * map[x][y];
            if(xx >= 1 && xx <= N && yy >= 1 && yy <= N){
                if(check[xx][yy] == 1) continue;
                check[xx][yy] = 1;
                q.push({xx, yy});
            }
        }
    }
    return false;
}

void solve(){
    if(bfs(1, 1)) cout << "HaruHaru";
    else cout << "Hing";
}

int main() {
	cin >> N;
	for(int i = 1; i <= N; i++){
	    for(int j = 1; j <= N; j++){
	        cin >> map[i][j];
	    }
	}
	solve();
	return 0;
}