/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chenxiao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cauxu
 */
public class Unboxing {
    public static void main(String[] arg){
        Integer i=new Integer(-4);
        Double j=new Double(3.0);
        long il=i.longValue();
        System.out.println(i.compareTo(-4));//数值相等则输出0，不等则输出-1
        System.out.println(j.compareTo(6.0));
        System.out.println(i.equals(j));
        int a=i.intValue();//调用intValue function unboxing
        System.out.println(absoluteValue(a));
        List<Double> ld=new ArrayList<>();
        ld.add(3.1415936);//autoboxing Passed as a parameter to a method that expects an object of the corresponding wrapper class
        System.out.println(ld.get(0));//unboxing through the function "get()"
        
        //instance method in Integer class
        //int x=Integer.decode("xue");//static method
       // double b=i.doubleValue();
       // String st=Integer.toString(25);
        
        //PrintSteam 
        long lo=612045;
        System.out.format("%d%n", lo);
        System.out.format("%04d%n",lo);
        //System.out.format("%.3f%n", lo);
        System.out.println("say \"hello\" to me");
        
    }
    public static int absoluteValue(Integer i){//autoboxing
        return (i<0) ? -i:i;
    }
    
    
    
    
}
