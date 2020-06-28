package com.htzhao.testcase;

import com.htzhao.CommonUtils.GetRandomNum;
import org.testng.annotations.Test;

public class randomTest {
    @Test
    public void getNumTest(){
        System.out.println(GetRandomNum.getOneRandomNum(3,5));
    }

    @Test
    public void getSomeNumTest(){
        System.out.println(GetRandomNum.getRandomNum(10));
    }

    @Test
    public void getStringRandomTest(){
        System.out.println(GetRandomNum.getRandomString(50));
    }
}
