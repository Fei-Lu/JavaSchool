/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xujun;

/**
 *
 * @author Jun Xu
 */
public class ComputeResult {
    public static void main(String[] args) {
        String original = "software";
        StringBuilder result = new StringBuilder("hi");
        int index = original.indexOf('a');

/*1。setcharat（int a ，ch）就是用ch来代替原来的位置 结果为 si*/   
        result.setCharAt(0, original.charAt(0));
/*2.se*/result.setCharAt(1, original.charAt(original.length()-1));
/*3.insert 是在所指示插入位点的前面进行插入*/   
        result.insert(1, original.charAt(4));
/*4。substring 是插入一个小的string类型的数据 是前面包含而后面不包含的 所以（1，4）其实只包含3个元素*/   
        result.append(original.substring(1,4));
/*5*/   result.insert(3, (original.substring(index, index+2) + " ")); 

        System.out.println(result);
    }
}

