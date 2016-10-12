package com.system.algorithm.crypto;

/**
 * rc  算法实现。
 * 其总  rc4_init 可以做生成随机数组的算法
 */
public class RC4 {
    static final int SIZE = 256;
    static void rc4Init(int s[],char key[])
    {
        int length = key.length;
        int i=0,j=0;
        int k[]=new int[SIZE];
        int tmp=0;
        for(i=0;i<SIZE;i++) {
            s[i]=i;
            k[i]=key[i%length];
        }
        for(i=0;i<SIZE;i++) {
            j=(j+s[i]+k[i])%SIZE;
            tmp=s[i];
            s[i]=s[j];//交换s[i]和s[j]
            s[j]=tmp;
        }
    }


    static void rc4Cry(int s[],char data[]){
        int i = 0, j = 0, t = 0;
        int k=0;
        int tmp = 0;

        for(k=0;k<data.length;k++){
            i = (i+1) % SIZE;
            j=(j+s[i])% SIZE;

            //swap
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;

            //增加取值的随机度
            t = (s[i]+s[j])%SIZE;
            data[k] ^= s[t];
        }
    }

}
