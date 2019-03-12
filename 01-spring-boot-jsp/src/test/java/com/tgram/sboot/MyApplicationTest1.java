package com.tgram.sboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyApplicationTest1 {

    // 测试Java8的Stream流的使用
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
}
