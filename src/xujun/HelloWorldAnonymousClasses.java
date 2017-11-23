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
public class HelloWorldAnonymousClasses {
  
    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
        // When you implement an interface, there is no constructor, 
        //so you use an empty pair of parentheses, as in there.
    }
  
    public void sayHello() {
        
        class EnglishGreeting implements HelloWorld {
            //interface不用读取 只覆盖方法
            String name = "xujun";
            public void greet() {
                greetSomeone(name);
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
                //自动转换成String类型 与toString的功能相似（很强大）
            }
        }
      
        HelloWorld englishGreeting = new EnglishGreeting();
        //They enable you to declare and instantiate a class at the same time.
        //匿名类 可以同时创建对象（实例化）以及定义方法体的内容而且方法体没有名字。
        //The syntax of an anonymous class expression is like the invocation of a constructor, 
        //except that there is a class definition contained in a block of code
        //匿名类的语法与构造器相似，只不过是少了对于类的定义在语句块里。
        HelloWorld frenchGreeting = new HelloWorld() {
        //走完这一步之后直接进入行，调用greeetSomeone方法并且括号里面一定要是字符串类型(进行赋值)，如果是调用greet函数 里面就不能定义参数
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };
        // the anonymous class expression is part of the statement that instantiates the frenchGreeting object. 
        //(This explains why there is a semicolon after the closing brace.)匿名类是对实例化的对象的声明，这也就解释了为什么花括号后面要带分号。
        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };
        englishGreeting.greet();
        frenchGreeting.greetSomeone(" ");
        spanishGreeting.greet();
    }

    public static void main(String... args) {
        HelloWorldAnonymousClasses myApp =
            new HelloWorldAnonymousClasses();
        myApp.sayHello();
        CharSequence a=new CharSequence(){
            @Override
            public int length() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public char charAt(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public CharSequence subSequence(int start, int end) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        }; 
        /*
        annoymous class：只能够new interface和能够被继承的类（所以final类不可以new）
        String b=new String(){
            
        };
        */
     }  
}

