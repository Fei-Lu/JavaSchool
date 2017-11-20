/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yao;
import java.lang.CharSequence;
import java.lang.Object;
import java.lang.StringBuilder;
/**
 *
 * @author yaozhou
 */
public class StringBackwards implements java.lang.CharSequence  {
    String oriS;
    
    char index;
    public StringBackwards(String newString){
        this.oriS = newString;
    }
    @Override
    public int length() {
        return oriS.length();
    }

    @Override
    public char charAt(int index) {
        return oriS.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return oriS.subSequence(start, end); 
    }
    
    public String getBackwardSequence(){
        StringBuilder bwS = new StringBuilder();
        String bw;
        int len = oriS.length();
        int j ;
        char temp;
        String tempS;
        for (int i = 0; i < len; i++ ){
            j = len - i -1;
            temp = oriS.charAt(j);
            tempS = Character.toString(temp);
            bwS.append(tempS);
        }
        bw = bwS.toString();
        return bw;
    } 
}
