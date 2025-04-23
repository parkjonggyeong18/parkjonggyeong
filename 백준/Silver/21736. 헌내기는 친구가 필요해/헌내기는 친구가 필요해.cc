#include <iostream>
#include <queue>
#include <vector>
#include <string>
using namespace std;

int n, m;
vector<string> campus;
bool visited[601][601];
int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

int bfs(int startX, int startY) {
    queue<pair<int, int>> q;
    q.push({ startX, startY });
    visited[startX][startY] = true;

    int peopleCount = 0;

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        if (campus[x][y] == 'P') {
            peopleCount++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && campus[nx][ny] != 'X') {
                visited[nx][ny] = true;
                q.push({ nx, ny });
            }
        }
    }

    return peopleCount;
}

int main() {
    cin >> n >> m;
    campus.resize(n);

    int startX, startY;

    for (int i = 0; i < n; i++) {
        cin >> campus[i];
        for (int j = 0; j < m; j++) {
            if (campus[i][j] == 'I') {
                startX = i;
                startY = j;
            }
        }
    }

    int result = bfs(startX, startY);

    if (result == 0) {
        cout << "TT" << endl;
    }
    else {
        cout << result << endl;
    }

    return 0;
}