/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoyue;

/**
 *
 * @author Aoyue
 */
//定义一个 遮蔽测试 类
//屏蔽 在对象继承过程中，在子类中可以直接使用由父类继承下来的方法和属性；但是如果子类中
//又声明了相同名称的属性的话，那么当你直接使用的时候就是在使用自己的属性，而不是继承自父类
//的属性了，这种情形我们称为shadow；如果还是要使用父类的属性，那就需要用super关键字。
public class ShadowTest {
    

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
