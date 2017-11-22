/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

/**
 *
 * @author xuebo
 */
class Fruits {
//    String Name = "Sweet";
    String Color = "Red";
    boolean taste = true;
    boolean beautiful = true;
    void Letmetaste(boolean newTaste){
     
        if (newTaste){
            System.out.println("Delicious");
        }
    }
    void Letmesee(boolean newBeautiful){
        if(newBeautiful){
            System.out.println("Very nice");
        }
    }

}
public class FruitsDemo{
    public static void main(String[] args){
        System.out.println("JavaSchoolDay03:");
        Fruits apple1 = new Fruits();
        Fruits apple2 = new Fruits();
        apple1.Letmetaste(true);
        apple2.Letmesee(true); 
//        String outfileS = "";
//        try {
//            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
//            bw.write("Xuebo");
//            bw.flush();
//            bw.close();
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
    }
}
//public class HelloWorldlalala {
//    public static void main(String[] args){
//        System.out.println("Hello World lalala");
//        String outfileS = "";
//        try {
//            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
//            bw.write("Xuebo");
//            bw.flush();
//            bw.close();
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//    public static void main(String[] args){
//        MyOuterClassDemo outer = new MyOuterClassDemo();
//        outer.innerInstance();
//    }
//}
//    public static void main(String[] args){
//        MyOuterClassDemo.MyInnerClassDemo inner = new MyOuterClassDemo().new MyInnerClassDemo();
//        inner.seeOuter();
//    }
//    
    
    
    
//String outfileS = "D:\\zxb\\UniquenessScore\\data\\maizetest.fa";
//        try {
//            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
//            bw.write("D:\\zxb\\UniquenessScore\\data\\maize.test");
//            bw.flush();
//            bw.close();
//        }
//        catch(Exception e) {
//            e.printStackTrace();