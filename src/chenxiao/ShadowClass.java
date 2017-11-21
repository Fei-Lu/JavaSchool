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
    public int x=3;
    static class innerclass{
        public int x=4;
        void testVariable(int x){
            System.out.println("this.x="+this.x);
            System.out.println("ShadowClass.innerclass.this.x="+ShadowClass.innerclass.this.x);
            //System.out.println("ShadowClass.this.x="+ShadowClass.this.x);
            System.out.println(x);
        }
        void toValue(){
            System.out.println(this);
        }
    }
    void toOuterClassValue(){
        System.out.println(this);
        }
}
