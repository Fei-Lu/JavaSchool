/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

/**
 *
 * @author Xuebo Zhao
 */
public class ShadowingDemo {
    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowingDemo.this.x = " + ShadowingDemo.this.x);
        }
    }
    public static void main(String... args) {
        ShadowingDemo st = new ShadowingDemo();
        ShadowingDemo.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
