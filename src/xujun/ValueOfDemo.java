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

 public class ValueOfDemo {
     //int size = 1;
      // 定义数组
     float[] args = new float[1];
     
     
    public static void main(String[] args) {
//通过main()方法从控制台接收的参数都是String类型的，如果需要其他类型参数，需要将接收的String类型参数，显式的转换

        // this program requires two 
        // arguments on the command line 
        if (args.length == 2) {
            // convert strings to numbers
            float a = (Float.valueOf(args[0])).floatValue(); 
            float b = (Float.valueOf(args[1])).floatValue();
//valueOf(float f) Returns a Float instance representing the specified float value.基本数据类型的object都有这个功能
//floatValue() Returns the float value of this Float object.

            // do some arithmetic
            System.out.println("a + b = " +
                               (a + b));
            System.out.println("a - b = " +
                               (a - b));
            System.out.println("a * b = " +
                               (a * b));
            System.out.println("a / b = " +
                               (a / b));
            System.out.println("a % b = " +
                               (a % b));
        } else {
            System.out.println("This program " +
                "requires two command-line arguments.");
        }
    }
}   
class adder{
    public static void main(String[] args){
        int sum=0;
        if(args.length==0){
            System.out.println("this is no value.");
        }else{
            for(int x=0;x<=args.length;x++){
                //sum=sum+x;
                sum += Integer.valueOf(args[x]).intValue();
            }
            System.out.println("sum="+sum);
        }
    }
}
