/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinshuai;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 靳帅
 */
public class Lambda {
     public static void main(String[] args)
   {
       String[] plant = {"a", "b", "c","d","e","f","g",  };      
       List<String> p;  
       p = Arrays.asList(plant);
  
// 以前的循环方式  
for (String plantss : plant) {  
     System.out.print(plantss + "; ");  
}     
// lambda 表达式 
p.forEach((player) -> System.out.print(player + "; "));  
// 双冒号操作符？？什么  
p.forEach(System.out::println);  
              }
}
