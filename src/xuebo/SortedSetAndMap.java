/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author yaozhou
 */
public interface SortedSetAndMap {
    
    public static void test(){
        
        outputHashSet();
        outputTreeSet();
        outputSortedSet();
        outputSortedSet2();
        
    }
   
    
    
    //Collection不能进行双向输出，Set接口与Collection接口定义一致，所以本身也不能双向输出。
    //HashSet：使用散列的方式存放，本身没有顺序
    public static void outputHashSet(){
        
        Set<String> allSet = new HashSet<String>() ;  
        
        allSet.add("Bbbb") ;   // add  
        allSet.add("Aftr") ;   // add 
        allSet.add("Cdeee") ;   // add 
        allSet.add("C") ;   // repetition 
        allSet.add("C") ;   // repetition 
        allSet.add("E") ;   // add 
        allSet.add("D") ;   // add
        
        System.out.println(allSet) ;  
    }
    
    
    //TreeSet类的内容是可以排序的，如果任意给出一个自定义的类，观察能否进行排序操作
    public static void outputTreeSet(){
        Set<String> allSet = new TreeSet<String>() ;  
            allSet.add("A") ;
            allSet.add("B") ;   
            allSet.add("C") ;    
            allSet.add("C") ;    
            allSet.add("C") ;    
            allSet.add("D") ;    
            allSet.add("E") ;   
            
            System.out.println(allSet) ;  

//            System.out.println(allSet.first());

//            System.out.println(allSet.last());

            //num < 4
//            System.out.println(allSet.headSet(4));

            //>=5
//            System.out.println(allSet.tailSet(5));

            //(-3,4]
//            System.out.println(allSet.subSet(-3 , 4));
    }
    
    
    //1、public Comparator<? super E> comparator()  普通 返回与排序有关联的比较器。
    //2、public E first()  普通 返回集合中的第一个元素。
    //3、public SortedSet<E> headSet(E toElement) 普通  返回从开始到指定元素的集合。
    //4、public E last()   普通 返回最后一个元素。
    //5、public SortedSet<E> subSet(E fromElement, E toElement) 普通  返回指定对象间的元素。
    //6、public SortedSet<E> tailSet(E fromElement) 普通  从指定元素到最后。
    public static void outputSortedSet(){
        
        SortedSet<String> allSet = new TreeSet<String>() ;  //   
        allSet.add("A") ;   
        allSet.add("B") ;   
        allSet.add("C") ;   
        allSet.add("C") ;   
        allSet.add("C") ;   
        allSet.add("D") ;   
        allSet.add("E") ;    
        
        System.out.println("第一个元素：" + allSet.first()) ; 
        
        System.out.println("最后一个元素：" + allSet.last()) ; 
        
        System.out.println("headSet元素：" + allSet.headSet("C")) ;  
        
        System.out.println("tailSet元素：" + allSet.tailSet("C")) ;  
        
        System.out.println("subSet元素：" + allSet.subSet("B","D")) ;  
        
                
    }
    
    
    
    public static void outputSortedSet2(){
        
        SortedSet<String> allSet = new TreeSet<String>() ;  //   
        allSet.add("A") ;   
        allSet.add("B") ;   
        allSet.add("C") ;   
        allSet.add("C") ;   
        allSet.add("C") ;   
        allSet.add("D") ;   
        allSet.add("E") ;    
        allSet.add("E") ; 
        allSet.add("F") ; 
        allSet.add("G") ; 
        allSet.add("H") ; 
        allSet.add("I") ; 
        allSet.add("J") ; 
        allSet.add("K") ; 
        allSet.add("L") ; 
        
        int count = allSet.subSet("A", "D").size();
        System.out.println(count);
        
        count = allSet.subSet("A", "D\0").size();
        System.out.println(count);
        
        count = allSet.subSet("A\0", "D").size();
        System.out.println(count);
        
        allSet.subSet("A", "D").clear();
        System.out.println(allSet);
        
        for (char ch = 'A'; ch <= 'L'; ) {
        String from = String.valueOf(ch++);
        String to = String.valueOf(ch);
        System.out.println(from + ": " + allSet.subSet(from, to).size());
        }
        
        
    }
    
//    public void testSortedSet(){
//
//        TreeSet nums = new TreeSet();
//        
//        nums.add(5);
//        nums.add(2);
//        nums.add(10);
//        nums.add(-9);
//
//        System.out.println(nums);
//
//        System.out.println(nums.first());
//
//        System.out.println(nums.last());
//
//        //num < 4
//        System.out.println(nums.headSet(4));
//
//        //>=5
//        System.out.println(nums.tailSet(5));
//
//        //(-3,4]
//        System.out.println(nums.subSet(-3 , 4));         
//    }
//    
    
}
