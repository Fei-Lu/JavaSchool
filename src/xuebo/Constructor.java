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
class SuperClass {
  private int n;
  SuperClass(){
    System.out.println("SuperClass()");
  }
  SuperClass(int n) {
    System.out.println("SuperClass(int n)");
    this.n = n;
  }
}
class SubClass extends SuperClass{
  private int n;
  
  SubClass(){
    super(300);
    System.out.println("SubClass");
  }  
  
  public SubClass(int n){
    System.out.println("SubClass(int n):"+n);
    this.n = n;
  }
}


