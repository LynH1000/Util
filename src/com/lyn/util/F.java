package com.lyn.util;

import edu.princeton.cs.algs4.StdOut;

public class F {
    static long  i=0;

    public static void main(String[] args) {
	// write your code here
        long memo[];


        for (int N = 0; N < 100; N++) {
            memo=new long[N+1];
            for (int i = 0; i <=N; i++) {
                memo[i]=-1;
            }

            StdOut.println(N+"  "+F(N,memo)+" "+i);
        }

    }

    private static long F(int N,long memo[]) {
        i++;
        long result =memo[N];
        if (result !=-1) {
            return result;
        }

        if (N==0)return 0;
        if (N==1)return 1;

        memo[N]=F(N-1,memo)+F(N-2,memo);
        return memo[N];



    }


}
