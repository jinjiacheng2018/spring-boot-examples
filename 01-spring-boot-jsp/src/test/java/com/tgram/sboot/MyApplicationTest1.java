package com.tgram.sboot;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyApplicationTest1 {

    /**
     * 测试Java8的Stream流的使用
     */
    @Test
    public void test1()
    {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // 使用流进行筛选(获取集合中的偶数)
        List<Integer> nums2 = nums.stream().filter(num -> num%2==0).collect(Collectors.toList());
        nums2.forEach(n -> System.out.print(n + " "));

        System.out.print("\n-------------------\n");

        // limit
        List<Integer> nums3 = nums.stream().limit(5).collect(Collectors.toList());
        nums3.forEach(n -> System.out.print(n + " "));

        System.out.print("\n-------------------\n");

        // map
        List<Integer> nums4 = nums.stream().map(n -> n * n).collect(Collectors.toList());
        nums4.forEach(n -> System.out.print(n + " "));
    }

    /**
     * 测试2
     */
    @Test
    public void test2()
    {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        int i=3;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));   //==在比较基本数据类型时只比较内容，对象会比较地址
        System.out.println(g == i);
    }
}
