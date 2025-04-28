// ConsoleApplication3.cpp : 이 파일에는 'main' 함수가 포함됩니다. 거기서 프로그램 실행이 시작되고 종료됩니다.  
//  

#include <iostream>  
#include <vector>  
#include <algorithm>


using namespace std;  
int T;  
int n;  

int main()  
{     
   cin >> T;  
   for (int t = 0; t < T; t++)  
   {   
       int result = 1;
       cin >> n;  
       vector<pair<int, int>> score(n);

       for (int i = 0; i < n; i++)  
       {  
           cin >> score[i].first >> score[i].second;  
       }  
      
	   sort(score.begin(), score.end());

	   int min = score[0].second;

	   for (int i = 1; i < n; i++)
	   {
		   if (score[i].second < min)
		   {
			   result++;
			   min = score[i].second;
		   }
	   }
	   cout << result << endl;
   }  
   return 0;
}
