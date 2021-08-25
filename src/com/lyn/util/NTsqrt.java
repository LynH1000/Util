package com.lyn.util;

public class NTsqrt {

    private static double NTsqrt(int n) {
        double result=0.0;
        if (n<0){
            return Double.NaN;
        }
        double err=1e-15;
        double t=n;
        for (;Math.abs(t-n/t)>err*t;){
            t=(n/t+t)/2;
        }
        return t;
    }



}
