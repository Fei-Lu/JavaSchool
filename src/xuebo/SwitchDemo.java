/*
 *hange this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;
//import java.util.Arrays;
//import java.util.Random;
        

/**
 *
 * @author Xuebo Zhao
 */
//public class RandomTest {
////   random selct
//    public static void main(String[] args) {
//        String str = "A";
//        String lalala = str.substring(1);
//        char[] chars = str.toCharArray();
//        String new_str = chars[0]-64+lalala;
//        System.out.println(new_str);
//    }
//}        
// public class RandomTest {
// public static void main(String[] args) {
//  String str = "ACCTGACTTCAAGGTA";
//  byte[] bs = str.getBytes();
//  System.out.println(Arrays.toString(bs));
// }
//}
//public class RandomTest{
//    public static void main(String[] args){
//        try{Symbolist symL = DNATools.
//        }
//    }
//}
public class SwitchDemo{
    int month ;
    String monthString;
    void doSwitch(int month){
        switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
    }
    void doPrint(){
        System.out.println(monthString);
    } 
}

    
    
    
    

