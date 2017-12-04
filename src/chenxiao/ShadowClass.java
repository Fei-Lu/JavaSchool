/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chenxiao;

/**
 *
 * @author cauxu
 */
public class ShadowClass {
    public static int x=3;
    public int y=5;
    static class staticclass{
        public int x=4;
        void testVariable(int x){
            System.out.println("this.x="+this.x);
            System.out.println("ShadowClass.staticclass.this.x="+ShadowClass.staticclass.this.x);
            //System.out.println("ShadowClass.this.x="+ShadowClass.this.x); //static class 不能调用outerclass的非静态变量
            System.out.println(x);
        }
        void toValue(){
            System.out.println(this);
        }
    }
    class innerclass{
        void print(){
        System.out.println(y);  
        }
    }
    void toOuterClassValue(){
        System.out.println(this);
        }
}
