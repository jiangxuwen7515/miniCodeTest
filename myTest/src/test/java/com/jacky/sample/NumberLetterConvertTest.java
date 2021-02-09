package com.jacky.sample;

import org.junit.Test;

/**
 * 测试类.
 *
 * @author jiangxuwen
 * @date 2021/2/9 14:07
 */
public class NumberLetterConvertTest {

    @Test
    public void testPrint() {
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        new NumberLetterConvert().print(arr);
    }
}
