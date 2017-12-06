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
        Integer i=new Integer(4);
        System.out.println(absoluteValue(i));
        List<Double> ld=new ArrayList<>();
        ld.add(3.1415936);
        System.out.println(ld.get(0));//unboxing through the function "get()"
    }
    public static int absoluteValue(int i){
        return (i<0) ? -i:i;
    }
}
