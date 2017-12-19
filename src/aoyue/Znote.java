/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoyue;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Aoyue
 */
public class Znote {
   
// 清单2：遍历Collection对象的传统方式
/* 建立一个Collection */
    String[] strings = {"A","B","C","D"};
    Collection stringList = java.util.Arrays.asList(strings);
/* 开始遍历 */
//for (Iterator itr = stringList.iterator();itr.hasNext ();) {
   // Object str = itr.next();
    //System.out.println(str);
}   

    //第二种for循环

//不严格的说，Java的第二种for循环基本是这样的格式：

//for (循环变量类型 循环变量名称 : 要被遍历的对象) 循环体

//借助这种语法，遍历一个数组的操作就可以采取这样的写法：
//清单3：遍历数组的简单方式
/* 建立一个数组 */
//int[] integers = {1,2,3,4};
/* 开始遍历 */
//for (int i : integers){
//    System.out.println(i);
//}        

//清单4：遍历数组的简单方式的等价代码
/* 建立一个数组 */
//int[] integers = {1,2,3,4};
/* 开始遍历 */
//for (int j = 0; j<integers.length; j++)="" {

//System.out.println(integers[j]);/* 依次输出“1”、“2”、“3”、“4” */

//}

//清单5：遍历Collection的简单方式


