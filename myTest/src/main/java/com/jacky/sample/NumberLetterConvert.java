package com.jacky.sample;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 实现数字-字母映射实现.
 *
 * @author jiangxuwen
 * @date 2021/2/9 1:12
 */
public class NumberLetterConvert {

    private static Map<Integer, List<String>> map = Maps.newConcurrentMap();

    static {
        map.put(0, Lists.<String> newArrayList());
        map.put(1, Lists.<String> newArrayList());
        map.put(2, ImmutableList.<String> of("A", "B", "C"));
        map.put(3, ImmutableList.<String> of("D", "E", "F"));
        map.put(4, ImmutableList.<String> of("G", "H", "I"));
        map.put(5, ImmutableList.<String> of("J", "K", "L"));
        map.put(6, ImmutableList.<String> of("M", "N", "O"));
        map.put(7, ImmutableList.<String> of("P", "Q", "R", "S"));
        map.put(8, ImmutableList.<String> of("T", "U", "V"));
        map.put(9, ImmutableList.<String> of("W", "X", "Y", "Z"));
    }

    public void print(Integer[] arr) {
        List<List<String>> allList = Lists.newArrayList();
        for (Integer item : arr) {
            List<String> letterList = map.get(item);
            allList.add(letterList);
        }
        calculateCombination(allList, 0, new String[allList.size()]);
    }

    /**
     * 写法二，递归计算所有组合
     * 
     * @param inputList
     *            所有数组的列表，数组用List<Integer>存储
     * @param beginIndex
     *            代表每一个数组的在inputList中的索引
     * @param arr
     *            用于保存每一次递归生成的组合
     */
    public void calculateCombination(List<List<String>> inputList, int beginIndex, String[] arr) {
        if (beginIndex == inputList.size()) {
            // 在这里进行你自己的处理，比如打印组合的结果
            for (String i : arr) {
                if (null != i) {
                    System.out.print(i + ",");
                }
            }
            System.out.println();
            return;
        }
        List<String> listStr = inputList.get(beginIndex);
        if (CollectionUtils.isEmpty(listStr)) {
            inputList.remove(beginIndex);
            for (String c : inputList.get(beginIndex)) {
                arr[beginIndex] = c;
                calculateCombination(inputList, beginIndex + 1, arr);
            }

        } else {
            for (String c : inputList.get(beginIndex)) {
                arr[beginIndex] = c;
                calculateCombination(inputList, beginIndex + 1, arr);
            }
        }

    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        new NumberLetterConvert().print(arr);
    }
}
