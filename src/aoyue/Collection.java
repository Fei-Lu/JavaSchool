/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoyue;

import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Aoyue
 */
public class Collection {
     Set<String> args;
    private int c;
    
    public Collection () {
        this.args = (Set<String>) new ArrayList<String>(c);
//        this.outputForeach();
//        this.outputArray();
//        this.outputIterator();
//        this.findDups();
//        this.testaaaa();
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
//      Set<String> distinctWords = Arrays.asList(args).stream()
//		.collect(Collectors.toSet()); 
//        System.out.println(distinctWords.size()+ 
//                           " distinct words: " + 
//                           distinctWords);
     
    }
    public void testaaaa() {
        System.out.println("helloworld!");
    }
    
}


