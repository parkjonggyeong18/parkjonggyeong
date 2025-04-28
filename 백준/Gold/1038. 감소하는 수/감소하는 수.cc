#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<long long> nums;

void backtracking(long long num, int lastDigit) {
    nums.push_back(num);

    for (int nextDigit = lastDigit - 1; nextDigit >= 0; nextDigit--) {
        backtracking(num * 10 + nextDigit, nextDigit);
    }
}

int main() {
    cin >> n;

    for (int i = 0; i <= 9; i++) {
        backtracking(i, i);
    }

    sort(nums.begin(), nums.end());

    if (n < nums.size()) {
        cout << nums[n] << endl;
    }
    else {
        cout << -1 << endl;
    }

    return 0;
}
