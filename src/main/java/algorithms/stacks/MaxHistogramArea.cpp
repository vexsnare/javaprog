#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int findMaxArea(vector<int> &ar) {
    stack<int> stk;
    int n = ar.size();
    int area = 0;
    int i = 0;
    while(i < n) {
        if(stk.empty() || ar[stk.top()] <= ar[i])
            stk.push(i++);
        else {
            int t = stk.top(); stk.pop();
            int width = stk.empty() ? i : i - stk.top() - 1;
            area = max(area, ar[t] * width);
        }
    }
    while(!stk.empty()){
        int t = stk.top(); stk.pop();
        int width = stk.empty() ? i : i - stk.top() - 1;
        area = max(area, ar[t] * width);
     }
    return area;
}

int main() {
    int n;
    cin >> n;
    vector<int> ar(n);
    for (int i = 0; i < n; i++) {
        cin >> ar[i];
    }
    cout << findMaxArea(ar) << endl;
    return 0;
}