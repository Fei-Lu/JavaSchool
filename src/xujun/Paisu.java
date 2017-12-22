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
public class Paisu {
    
    public static void main(String[] args) {
        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);
        int i=10;
        String s = String.valueOf(i);
        System.out.println(s);
    }
public void toBinary(int i){
       trans(i,1,1);
}

    private void trans(int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*public class jianJi{
   public void main(String args[]){
   int i=8;
   toBinary(i);
}
}*/
}
 



