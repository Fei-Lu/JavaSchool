/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinshuai;

/**
 *
 * @author 靳帅
 */
public class Backward implements  java.lang.CharSequence{
    
    String myString;
    public Backward(String myString){
        
    }

    public String getString(String myString){
           myString=this.myString;
           String newString=myString.toString();
           return(newString);
    }
   
    public String toString(String a){
       
        char[] b = a.toCharArray(); 
        String c=new String();
         for (int i=b.length-1; i>=0; i--) {  
            c += b[i]; 
         }
         System.out.println(c);
            return c;
    } 

    @Override
    public int length() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char charAt(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
       
}
