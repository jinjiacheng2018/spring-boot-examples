package com.tgram.sboot.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.HashSet;
import java.util.Set;

public class ConvertSpellUtil
{

    /**
     * 传入汉字字符串，拼接成对应的拼音,返回拼音的集合
     * @param src 汉字字符串
     * @return 拼音的集合
     */
    public static Set<String> getPinYinSet(String src)
    {
        Set<String> lstResult = new HashSet<String>();
        char[] t1 = null;  //字符串转换成char数组
        t1 = src.toCharArray();

        //①迭代汉字
        for (char ch : t1)
        {
            String s[] = getPinYin(ch);
            Set<String> lstNew = new HashSet<String>();
            //②迭代每个汉字的拼音数组
            for (String str : s)
            {
                if (lstResult.size() == 0)
                {
                    lstNew.add(str);
                }
                else
                {
                    for (String ss : lstResult)
                    {
                        ss += str;
                        lstNew.add(ss);
                    }
                }
            }
            lstResult.clear();
            lstResult = lstNew;
        }
        return lstResult;
    }

    /**
     * 将单个汉字转换成汉语拼音，考虑到同音字问题，返回字符串数组的形式
     * @param src 字符串
     * @return 拼音字符串数组
     */
    public static String[] getPinYin(char src)
    {
        char[] t1 = { src };
        String[] t2 = new String[t1.length];

        // 设置汉字拼音输出的格式
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);

        // 判断能否为汉字字符
        if (Character.toString(t1[0]).matches("[\\u4E00-\\u9FA5]+"))
        {
            try
            {
                // 将汉字的几种全拼都存到t2数组中
                t2 = PinyinHelper.toHanyuPinyinStringArray(t1[0], t3);
            }
            catch (BadHanyuPinyinOutputFormatCombination e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            // 如果不是汉字字符，则把字符直接放入t2数组中
            t2[0] = String.valueOf(src);
        }
        return t2;
    }

    /**
     * 获取传入中文汉字，转换出对应拼音
     *   注：出现同音字，默认选择汉字全拼的第一种读音
     * @param src 传入中文汉字
     * @return 转换的拼音字符串
     */
    public static String getPinYin(String src)
    {
        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        // 设置汉字拼音输出的格式
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try
        {
            for (int i = 0; i < t0; i++)
            {
                // 判断能否为汉字字符
                // System.out.println(t1[i]);
                if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+"))
                {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);// 将汉字的几种全拼都存到t2数组中
                    t4 += t2[0];// 取出该汉字全拼的第一种读音并连接到字符串t4后
                }
                else
                {
                    // 如果不是汉字字符，间接取出字符并连接到字符串t4后
                    t4 += Character.toString(t1[i]);
                }
            }
        }
        catch (BadHanyuPinyinOutputFormatCombination e)
        {
            e.printStackTrace();
        }
        return t4;
    }

    /**
     * 传入中文汉字字符串，转换出对应拼音字符串
     *   注：如果传入的中文中有任一同音字都会返回字符串信息：false
     * @param src 中文汉字字符串
     * @param hasBlank 是否需要有空格
     * @return 对应拼音字符串
     */
    public static String getNoPolyphone(String src,boolean hasBlank)
    {
        char[] t1 = src.toCharArray();
        String[] t2 ;
        // 设置汉字拼音输出的格式
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        StringBuilder t4 = new StringBuilder();
        int t0 = t1.length;
        try
        {
            for (int i = 0; i < t0; i++)
            {
                // 判断能否为汉字字符
                if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+"))
                {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);// 将汉字的几种全拼都存到t2数组中
                    if (t2 != null)
                    {
                        if(!hasBlank)
                        {
                            t4.append(t2[0]); // 取数组第一个元素拼接成拼音字符串
                        }
                        else
                        {
                            if(i == 0 || i == t0 - 1)
                            {
                                t4.append(t2[0]); //第一个和最后一个不加空格
                            }
                            else
                            {
                                t4.append(" ").append(t2[0]);
                            }
                        }
                    }
                }
                else
                {
                    // 如果不是汉字字符，间接取出字符并连接到字符串t4后
                    t4.append(Character.toString(t1[i]));
                }
            }
        }
        catch (BadHanyuPinyinOutputFormatCombination e)
        {
            e.printStackTrace();
        }

        // 返回拼音字符串(如果全是大写的非中文的字符可以转成全小写，具体看需要)
        return t4.toString().toLowerCase();
    }

    /**
     * 入口方法
     * @param args param
     */
    public static void main(String[] args)
    {
        // 结果：false: diedaimeigehanzidepinyin！！！
        //        true: die dai meige han zi de pin yin！！!
        String polyphone = ConvertSpellUtil.getNoPolyphone("迭代每ge汉字的拼音！！！",true);
        System.out.println(polyphone);

        // 结果：全字母true和false结果一样：    helloworld,i love java!!!
        String polyphone2 = ConvertSpellUtil.getNoPolyphone("    HELLOWORLD,I LOVE JAVA!!!     ",true);
        System.out.println(polyphone2);

        // 结果：true结果：     ni hao shi jie,i love java!!!
        //      false结果：    nihaoshijie,i love java!!!
        String polyphone3 = ConvertSpellUtil.getNoPolyphone("    你好世界,I LOVE JAVA!!!     ",false);
        System.out.println(polyphone3);
    }
}
