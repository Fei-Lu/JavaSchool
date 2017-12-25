/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author xuebo
 */
public interface SortedSetAndMap {
    
    public static void test(){
        
        outputHashSet();
        outputTreeSet();
        
        outputSortedSet();
        outputSortedSet2();
        outputSortedSet3();
        
        outputSortedMap();
        outputSortedMap2();
    }
   
    
    
    //Collection不能进行双向输出，Set接口与Collection接口定义一致，所以本身也不能双向输出。
    //HashSet：使用散列的方式存放，本身没有顺序，无序指的是存取无序，不是储存数据无序
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
        
        System.out.println("**********************");
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
            
            System.out.println("**********************");
            
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
        
        System.out.println("**********************");
        
                
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
        System.out.println("**********************");
        
        
    }
    
    //SortedSet 排序状态   
    //Comparator comparator（）返回当前Set使用的Comparator;或者返回null  
    //SortedSet是按对象的比较函数对无素排序的  
    public static void outputSortedSet3(){  
        
        SortedSet<String> sorted=new TreeSet<String>();  
        Collections.addAll(sorted,"one two three four five six seven eight".split(" "));  
        System.out.println(sorted);  
        
        String low=sorted.first();  
        String high=sorted.last();  
        System.out.println(low);  
        System.out.println(high);  
        Iterator<String> it=sorted.iterator();  
        for(int i=0;i<=6;i++)  
        {  
            if(i==3)low=it.next();  
            if(i==6) high=it.next();  
            else  
                it.next();  
        }  
        System.out.println(low);  
        
        System.out.println(high); 
        
        System.out.println(sorted.subSet(low,high));  
        
        System.out.println(sorted.headSet(high));//小于 ToElement元素的组成 
        
        System.out.println(sorted.tailSet(low));//大于等于  
        
        System.out.println("**********************");
        System.out.println("**********************");
    }  
    
      public static void outputSortedMap(){  
        HashMap<String,String> map=new HashMap<String, String>();    
          map.put("3","55");    
          map.put("2", "22");    
          map.put("1", "33");    
          for (Entry<String,String> entry: map.entrySet()) {    
           System.out.println("排序之前:"+entry.getKey()+" 值"+entry.getValue());    
               
          }    
          System.out.println("===============");    
          SortedMap<String,String> sort=new TreeMap<String,String>(map);    
          Set<Entry<String,String>> entry1=sort.entrySet();    
          Iterator<Entry<String,String>> it=entry1.iterator();    
          while(it.hasNext())    
          {    
           Entry<String,String> entry=it.next();    
           System.out.println("排序之后:"+entry.getKey()+" 值"+entry.getValue());    
          }   
    }   
      
      
    public static void outputSortedMap2() {  
        Map<Double, String> map = new TreeMap<Double, String>(  
                new Comparator<Double>() {  
                    public int compare(Double obj1, Double obj2) {   
                        return obj2.compareTo(obj1);  
                    }  
                });  
                map.put(2.33, "ccccc");  
                map.put(2.0, "aaaaa");  
                map.put(3.0, "bbbbb");  
                map.put(4.0, "ddddd");  
          
        Set<Double> keySet = map.keySet();  
        Iterator<Double> iter = keySet.iterator();  
        while (iter.hasNext()) {  
            Double key = iter.next();  
            System.out.println(key + ":" + map.get(key));  
        }  
    }  
}
