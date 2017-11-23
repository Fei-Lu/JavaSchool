/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yao;

/**
 *
 * @author yaozhou
 */
public class LocalClassExample {
    static String regularExpression = "[^0-9]";
    
    public static void validatePhenoNumber(String phoneNumber1,
        String phoneNumber2){
        
        final int numberLength  = 11;
        class PhoneNumber {
            String formattedPhoneNumber = null;
            PhoneNumber(String phoneNumber){
                String currentNumber = phoneNumber.replaceAll("relularExpression","");
                if (currentNumber.length()==numberLength){
                    formattedPhoneNumber = currentNumber;
                }else{
                    formattedPhoneNumber = null;
                }
            }
                       
         
        
        }
        
    }
}
