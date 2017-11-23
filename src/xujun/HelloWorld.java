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
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//“JavaFX脚本是一种声明式、静态类型编程语言。
//它具有一等函数（first-class functions）、声明式的语法、列表推导（list-comprehensions）
//及基于依赖关系的增量式求值（incremental dependency-based evaluation）等特征。
//”JavaFX脚本为多种多样的操作提供了声明式、无中间程序逻辑的语法，这些操作包括创建2D动画、设置属性或者声明在模式和视图对象之间的绑定依赖关系。

 /*
与大多数依靠程序和显式代码来更新在变量或者属性之间关系的编程语言不同，声明式语言允许数值被声明为另一种方式。
在JavaFX的一个示例：
var a : Number = bind model.attrib/2;
无论何时model.attrib的数值发生改变，a的数值都将自动、透明地更新，更新期间无需调用任何程序。这对于在模式和视图对象之间绑定依赖关系、控制GUI行为是特别有用的。
var就是自定义变量的保留部分
*/
public class HelloWorld extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //start()方法是所有JavaFX应用程序的主入口点 main函数不是必需的（仅对于这一种生命声明式，静态类型的编程语言）
        //The start() method is the main entry point for all JavaFX applications.
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
        
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        //匿名类被定义在了小括号里
        StackPane root = new StackPane();
        root.getChildren().add(btn);
//a hierarchical scene graph of nodes
//the root node is a StackPane object, which is a resizable layout node. 
//This means that the root node's size tracks the scene's size and changes when the stage is resized by a user.
 Scene scene = new Scene(root, 300, 250);
 //A JavaFX application defines the user interface container by means of a stage and a scene.
 //JavaFX应用程序定义了用户界面的容器的一个舞台,一个场景。
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 public static void main(String[] args) {
        launch(args);
        //保护性机构 最终还是会归于start
    }
}