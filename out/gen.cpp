#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <time.h>
#include <cmath>
using namespace std;

const int N = 10;

int main()
{
    freopen("input", "w", stdout);
    cout << N << endl;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            double rr = -500 + rand() % 1001;
            if (fabs(rr) < 0.0000001)
            {
                rr = 1.0;
            }
            cout << rr << " ";
        }
        cout << endl;
    }
    for (int i = 0; i < N; i++)
    {
        double rr = -500 + rand() % 1001;
        cout << rr << " ";
    }

    return 0;
}