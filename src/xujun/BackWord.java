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
public class BackWord implements CharSequence {
    String a=null;
    char[] b =null;
    BackWord(){
     String a;
     }
    public BackWord(String a){
       this.a = a;
    }
    public void backOutPut(String a){
       char[] b=a.toCharArray();
        for(int i=b.length-1;i>=0;i--){
          System.out.print(b[i]);
        }
    }
    
   /* public void backOutPut(int i){
        for(int i=a.length()-1;i>=0;i--){
            System.out.println(cha);
        }
  */
            

    

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

    void backOutPut(char e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
        
        
 
    



    

