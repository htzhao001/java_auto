package com.htzhao.CommonUtils;

import javax.print.DocFlavor;
import java.lang.Math;
import java.util.Random;

import java.lang.String;

public class GetRandomNum {

    /**
     * 获取指定长度随机数字
     *
     * @param length 长度大于等于1位，小于等于16位
     * @return 随机数字（字符串类型）
     */
    public static String getRandomNum(int length) {
        int num_length;
        if (length >= 16) {
            num_length = 16;
        } else if (length <= 0) {
            num_length = 1;
        } else {
            num_length = length;
        }
        String num = "";
        num = String.valueOf(Math.random());
        StringBuilder num_ = new StringBuilder(num);
        int index = num_.indexOf(".");
        num_.deleteCharAt(index);
        String num_final = num_.substring(num_.length() - num_length, num_.length());

        return num_final;
    }

    /**
     * 得到一位指定范围的随机数字
     *
     * @param min 范围最小值
     * @param max 范围最大值
     * @return 随机数
     */
    public static int getOneRandomNum(int min, int max) {
        int num = 0;
        Random random = new Random();
        num = random.nextInt(max - min + 1) + min;

        return num;
    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 随机生成下一次的生成类型为大写还是小写
            String chr_type = random.nextInt(2) == 1 ? "a" : "A";

            int char_num;
            if (chr_type.equals("a")) {
                char_num = getOneRandomNum(65, 90);
            } else {
                char_num = getOneRandomNum(97, 122);
            }

            // 把数字强制转换成字符
            sb.append((char) char_num);
        }
        return sb.toString();
    }
}
