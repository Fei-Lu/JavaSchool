/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoyue;

import java.io.IOException;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author Aoyue
 */
public class Collection {
    

    
    public Collection () {
//        this.args = (Set<String>) new ArrayList<String>(c);
//        this.outputForeach();
//        this.outputArray();
//        this.outputIterator();

//        this.findDups();
//        this.testaaaa();

/*******Map Interface****/
        this.basicOperations ();
        this.freq ();
        this.collectionView ();
        this.entrySet ();
//        this.anagrams ();
    };
 
    public void outputForeach() {
//        List<String> list=new Collection<String>();
//     list.add("Hello");
//     list.add("World");
//     list.add("HAHAHAHA");
//     //第一种遍历方法使用foreach遍历List
//     for (String str : list) {            //也可以改写for(int i=0;i<list.size();i++)这种形式
//        System.out.println(str);
//     }
    }

    public void outputArray() {
//        String[] strArray=new String[list.size()];
//     list.toArray(strArray);
//     for(int i=0;i<strArray.length;i++) //这里也可以改写为  foreach(String str:strArray)这种形式
//     {
//        System.out.println(strArray[i]);
//     }
    }

    public void outputIterator() {
        
    }

    public void findDups() {
     //To change body of generated methods, choose Tools | Templates.
      String[] args = {};
      Set<String> distinctWords = Arrays.asList(args).stream()
		.collect(Collectors.toSet()); 
        System.out.println(distinctWords.size()+ 
                           " distinct words: " + 
                           distinctWords);
     
    }
    
    public void basicOperations () {
      Map<String,String> map=new HashMap<String,String>();
        //method put 
        map.put("01", "jinshuai");
        System.out.println(map.put("01", "chenxiao002"));
        map.put("02", "xujun003");
        map.put("03", "xuebo004");
        map.put(null, "yyyy");
        map.put("04", "qqquqq");
        //判断有没有key
        System.out.println(map.containsKey("02"));
        //判断 有这有 这个value
        System.out.println(map.containsValue("ffff"));
        //获取
        System.out.println(map.get("03"));
        System.out.println(map.get(null));
        System.out.println(map.get("fdsfdsf"));
        System.out.println(map.remove("02"));//返回value的值
        System.out.println(map.remove("0fdsfd"));
        System.out.println(map);//是无序的
  
    }
    public void freq() {
      //map实现类型 HashMap  TreeMap  LinkedHashMap  分别用这3种实现，来看最终输出结果。
         Map<String, Integer> m = new LinkedHashMap<String, Integer>();
 
        // Initialize frequency table from command line
        String[] args = {"if","it","is","to","be","it","is","up","to","me","to","delegate"};
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }
 
        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
    }
    
    public void collectionView () {
        Map m = new HashMap();
        //method put  将指定的值与此映射中的指定键关联
        m.put(1, "jack");
        m.put(2, "rose");
        m.put(3, "lucy");
        
        System.out.println(m);
        //method entrySet 
        Set s = m.entrySet();
        System.out.println(s);
        //method keySet
        s = m.keySet();
        System.out.println(s);

        for (Object key : s) {
            System.out.println(key);
            System.out.println(m.get(key));
        }
        
        java.util.Collection c = m.values();
        System.out.println(c);
        
        //iterator
        // Set s = m.entrySet();
//        Iterator it = s.iterator();
//        while(it.hasNext()){
//            Map.Entry me = (Entry) it.next();
//            System.out.println(me.getKey()+"  "+me.getValue());
//        }

        //使用iterator输出Map, 
        //1.通过keySet得到Map集合多有key的Set集合
        //2.调用Set的Iterator方法，此时每个Iterator对象是key值
        //3.通过Map的getValue(key)得到value值
        Iterator it = s.iterator();
        s = m.keySet();//得到的是key的集合
        it = s.iterator();//然后将key迭代出来
        while(it.hasNext()){
            int i = (int)it.next();
            System.out.println(i+"   "+m.get(i));
        }


    }
    
    
    public void entrySet () {
        TreeMap<Student,String> map=new TreeMap<Student,String>(new StudentNameCom());
        
        map.put(new Student("lisi01",21), "上海");//覆盖第一个值
        map.put(new Student("lisi02",23), "深圳");
        map.put(new Student("a",56), "北京");
        map.put(new Student("lisi04",22), "武汉");
        map.put(new Student("lisi03",24), "天津");
        map.put(new Student("a",33), "北京");
        map.put(new Student("lisi01",21), "北京");
        System.out.println("======keySet方法======");
        //第一种遍历方式
        Set<Student> keySet=map.keySet();
        Iterator<Student> it=keySet.iterator();
        while(it.hasNext()){
            Student stu=it.next();
            String add=map.get(stu);
            System.out.println(stu.getName()+"..."+stu.getAge()+"...."+add);
        }
        System.out.println("======entrySet方法======");
        //第二种遍历方式
        Set<Map.Entry<Student, String>> entrySet=map.entrySet();
        Iterator<Map.Entry<Student, String>> iter=entrySet.iterator();
        while(iter.hasNext()){
            Map.Entry<Student, String> student=iter.next();
            Student stu=student.getKey();
            String add=student.getValue();
            System.out.println(stu.getName()+"..."+stu.getAge()+"...."+add);
        }
    }

}
class StudentNameCom implements Comparator<Student>{

    @Override
    public int compare(Student stu1, Student stu2) {
        int num=stu1.getName().compareTo(stu2.getName());
        if(num==0){
            return new Integer(stu1.getAge()).compareTo(new Integer(stu2.getAge()));
        }
        return num;

    }
//    public void anagrams () {
//        String[] agrs= {};
//        int minGroupSize = Integer.parseInt(args[1]);
//
//        // Read words from file and put into a simulated multimap
//        Map<String, List<String>> m = new HashMap<String, List<String>>();
//
//        try {
//            Scanner s = new Scanner(new File(args[0]));
//            while (s.hasNext()) {
//                String word = s.next();
//                String alpha = alphabetize(word);
//                List<String> l = m.get(alpha);
//                if (l == null)
//                    m.put(alpha, l=new ArrayList<String>());
//                l.add(word);
//            }
//        } catch (IOException e) {
//            System.err.println(e);
//            System.exit(1);
//        }
//
//        // Print all permutation groups above size threshold
//        for (List<String> l : m.values())
//            if (l.size() >= minGroupSize)
//                System.out.println(l.size() + ": " + l);
//    }
//
//    private static String alphabetize(String s) {
//        char[] a = s.toCharArray();
//        Arrays.sort(a);
//        return new String(a);
//    }
//    

 
}


/**
 * 学生属性：姓名，年龄
 * 注意姓名和年龄相同的视为同一个学生
 * 1.描述学生
 * 2.定义map容器，将学生做为键，地址作为值、值入
 * 3.获取map集合的元素
 */

//学生类
class Student implements Comparable<Student>{
    private String name;
    private int age;
    
    //让对象本身具备比较性
    @Override
    public int compareTo(Student s){
        int num=new Integer(this.age).compareTo(new Integer(s.age));
        if(num==0){
            return this.name.compareTo(s.name);
        }
        return num;
    }
    
    /*
     * 重写hash
     */
    @Override
    public int hashCode(){
        return name.hashCode()+age*33;
    }
    /*
     * 重写equals
     */
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Student)){
            throw new ClassCastException("类型不匹配");
        }
        Student stu=(Student)obj;
        return this.name.equals(stu.name)&&this.age==stu.age;
        
    }
    
    public Student() {
        super();
    }
    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void show(){
        System.out.println(this.name+"...."+this.age);
    }
    
}
