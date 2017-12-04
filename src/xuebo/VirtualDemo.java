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
class Salary extends Employee
{
   private double salary; // 全年工资
   public Salary(String name, String address, int number, double salary) {
       super(name, address, number);
       setSalary(salary);
   }
   public void mailCheck() {
       System.out.println("Salary 类的 mailCheck 方法 ");
       System.out.println("邮寄支票给：" + getName()
       + " ，工资为：" + salary);
   }
   public double getSalary() {
       return salary;
   }
   public void setSalary(double newSalary) {
       if(newSalary >= 0.0) {
          salary = newSalary;
       }
   }
   public double computePay() {
      System.out.println("计算工资，付给：" + getName());
      return salary/52;
   }
}
class EmployeeTest {
       static void getprint() {
       Salary s = new Salary("员工 A", "北京",2,360);
       Employee e = new Salary("员工 B", "上海",3,240);
       System.out.println("使用 Salary 的引用调用 mailCheck -- ");
       s.mailCheck();
       System.out.println("\n使用 Employee 的引用调用 mailCheck--");
       e.mailCheck(); 
    }
}
public class VirtualDemo{
    public VirtualDemo(){
        this.TestClass();
    }

    private void TestClass() {
        EmployeeTest.getprint();
    }
}


