package com.system.algorithm.crypto;

/**
 * Created by yumo on 16/10/12.
 */
public class RC4Test {
    static char []DATA = new char[1024];

    static {
        for(int i=0;i<1024;i++){
            DATA[i]= (char)(i%256);
        }

    }

    static final int SIZE = 256;


    public static void main(String args[]){
        String key = "MIIBuwIBAAKBgQCgVD3DA8jM+TNpOeGvaIyIzN4oQooq1na668gJnTfDpA0BvAmO" +
                "PjxZQyIhCDHAt5WJAFv64nhbakC6epB5NobARgi7IfLLH1v9ErCeY9fqP0jaTUIJ" +
                "mk2J4itj4nJCwLEtSe1w413IImOenpHmoUkKhj9q/cFVsDF9XzDIbU8dAwIVAJ13" +
                "Hm8KgREdCYXVoDc+SthejpthAoGBAJLUO0+lhY1cVmnpEJSUGPWPdtTT6vNHSBoR" +
                "Kbqe7ORL2bIE55ZKBtHzG7p9G8IWZtatiUFdeFU5E3rcDQ/IItEfW1bAE76ImmCm" +
                "id89AaZkSb8ZgdUeSIOT6fqAGS6O2GjwNDGcCfQMUD4OLN+vfwdNblOKbdp7Pq2e" +
                "SL+jB6sIAoGAVDY8+SNtMkDHGckFJoI/KYjk14M49NSHD4ZRp85cbPnV8sjc6fBi" +
                "iXzebca5t9cS/sWhqqfr+P2+vnYqWIzMznF4Yg0sGk5EBDgolMe5FOeAED5B3/AY" +
                "Rn2dnX1CPy9/56HqldTzF0txyC16SJCgaRcFjdl0v0mZQH75VD8jKd0CFDgUwUoq" +
                "WKzbrlFYsrsOExrrtiqd";

        int sbox[] = new int[SIZE];
        RC4.rc4Init(sbox, key.toCharArray());
        for(int i=0;i<sbox.length;i++){
            System.out.print(sbox[i]+" ");
            if(i%16==0){
                System.out.println("");
            }
        }

        int sbox1[] = new int[SIZE];
        for(int i=0;i<SIZE;i++){
            sbox1[i] = sbox[i];
        }

        System.out.println();
        String data = "你好吗，我很好，我来自中国";
        System.out.println("原始文本：" + data);
        char []datac =data.toCharArray();
        RC4.rc4Cry(sbox, datac);

        System.out.println("加密后的结果");
        System.out.println(datac);

        RC4.rc4Cry(sbox1, datac);
        System.out.println("解密结果");
        System.out.println(datac);


        //rc4 性能测试
        long start = System.nanoTime();
        for(int i=0;i<100000;i++){
            RC4.rc4Cry(sbox, DATA);

            RC4.rc4Cry(sbox1, DATA);

        }

        System.out.println((System.nanoTime()-start)/100000);



    }

}
