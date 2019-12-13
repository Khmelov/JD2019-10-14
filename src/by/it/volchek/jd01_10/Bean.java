package by.it.volchek.jd01_10;

import java.lang.reflect.Method;

public class Bean {
    @Param(a=10,b=15)
    double sum(int left,int right){
        return left+right;
    }
    @Param(a=10,b=15)
    static double max(int left,int right){
        return left<right?right:left;
        }
    @Param(a=10,b=15)
    static double min(int left,int right){
        return left<right?left:right;
    }

    double avg(int left,int right){
        return (right+left)/2.0;
    }

}
