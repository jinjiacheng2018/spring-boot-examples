package com.tgram.sboot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.tgram.sboot.model.Employee;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

// @RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MyApplicationTest1
{
    
    /**
     * 测试Java8的Stream流的使用
     */
    @Test
    public void test1()
    {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 使用流进行筛选(获取集合中的偶数)
        List<Integer> nums2 = nums.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
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
        int i = 3;
        
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));   //==在比较基本数据类型时只比较内容，对象会比较地址
        System.out.println(g == i);
    }
    
    /**
     * Test3
     */
    @Test
    public void test3()
    {
        Boolean i1 = true;
        Boolean i2 = true;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        
        System.out.println("--------------");
        
        Integer i3 = 100;   // i3=128
        Integer i4 = 100;   // i4=128
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));
    }
    
    /**
     * Test4
     */
    @Test
    public void test4()
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("\n");
        // num相当于list.get(i),即集合循环拿出来的元素
        list.forEach(num -> System.out.print(num + " "));
        
        /*
         * // Java8的forEach循环
         * publistBeans.forEach(bean -> {
         * bean.setImgList(
         * imageMapper.selectImageByTypeIdAndType(bean.getPublishId(),
         * TypeUtils.PUBLISH_BANNER_IMAGE));
         * });
         * // 转换后的for循环
         * for (int i = 0; i < publistBeans.size(); i++) {
         * // 设置图片集合
         * publistBeans.get(i).setImageList(
         * // 获取publisId查询图片集合
         * imageMapper.selectImageByTypeIdAndType(publistBeans.get(i).
         * getPublishId(), TypeUtils.PUBLISH_BANNER_IMAGE))
         * );
         * }
         */
    }
    
    /**
     * Test5
     */
    @Test
    public void test5()
    {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.forEach(num -> System.out.print(num + " "));
        
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squaresList.forEach(seq -> System.err.print(seq + " "));
    }
    
    /**
     * Test6
     */
    @Test
    public void test6()
    {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串的数量：" + count);
    }
    
    /**
     * Test7
     */
    @Test
    public void test7()
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("HelloWorld");
            }
        };
        
        Thread thread = new Thread(runnable);
        thread.start();
    }
    
    /**
     * Test8
     */
    @Test
    public void test8()
    {
        // 使用Lambda表达式
        Runnable runnable = () -> {
            System.out.println("Hello,World!!!");
        };
        
        Thread thread = new Thread(runnable);
        thread.start();
    }
    
    /**
     * Test9
     * Java8新增的日期API对象
     */
    @Test
    public void test9()
    {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        
        LocalDate localDate1 = LocalDate.of(2016, 10, 26);
        LocalTime localTime1 = LocalTime.of(02, 22, 56);
        LocalDateTime localDateTime1 = LocalDateTime.of(2016, 10, 26, 12, 10, 55);

        System.err.println(localDate1);
        System.err.println(localTime1);
        System.err.println(localDateTime1);
    }
}
