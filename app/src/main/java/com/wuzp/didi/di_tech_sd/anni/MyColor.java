package com.wuzp.didi.di_tech_sd.anni;

import android.support.annotation.IntDef;

/**
 * @author wuzhenpeng03 (wuzhenpeng03@didichuxing.com)
 */
public class MyColor {

    public static final int RED = 1;
    public static final int GREEN = 2;
    public static final int BLUE = 3;

    @IntDef({RED, GREEN, BLUE})
    public @interface IntColor {

    }

    public void testColor(@IntColor int color) {

    }

    //简单的注解使用
    public void test() {
        testColor(RED);
    }
}
