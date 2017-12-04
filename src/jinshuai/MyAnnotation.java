/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinshuai;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author 靳帅
 */

public class MyAnnotation {
    
    public static void main(String[] args){
    }
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Table{
        
    }
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface NoDBColumn{
        
    }
    @Table
    public class newAnnotation{
        
    }
    @NoDBColumn
    public int a;
/*自定义注解*/
    public @interface FruitColor{
        public enum Color{BULE,RED,GREEN};
        Color fruitColor() default Color.GREEN;
        
    }
    public class Apple{
        @FruitColor(fruitColor = FruitColor.Color.GREEN)
        public String appleColor="RED";
    }    
    @interface ClassPreamble {
   String author();
   String date();
   int currentRevision() default 1;
   String lastModified() default "N/A";
   String lastModifiedBy() default "N/A";
   // Note use of array
   String[] reviewers();
}
    @ClassPreamble (
   author = "John Doe",
   date = "3/17/2002",
   currentRevision = 6,
   lastModified = "4/12/2004",
   lastModifiedBy = "Jane Doe",
   // Note array notation
   reviewers = {"Alice", "Bob", "Cindy"}
)
   public class Generation3List  {

// class code goes here

}
    /**
 * Describes the Request-for-Enhancement (RFE) annotation type.
 */
public @interface RequestForEnhancement {
    int id();
    String synopsis();
    String engineer() default "[unassigned]";
    String date() default "[unknown]";
}
}
