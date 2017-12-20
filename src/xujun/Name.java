package xujun;

/**
 *
 * @author Jun Xu
 */
import java.util.*;
import java.util.Date;

public class Name implements Comparable<Name> {//The Name interface represents a generic name -- an ordered sequence of components.
    private final String firstName, lastName;

    public Name(String firstName, String lastName) {
        if (firstName == null || lastName == null)
            throw new NullPointerException();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String firstName() { return firstName; }
    public String lastName()  { return lastName;  }

    public boolean equals(Object o) {
        if (!(o instanceof Name))
            return false;
        Name n = (Name) o;
        return n.firstName.equals(firstName) && n.lastName.equals(lastName);
    }

    public int hashCode() {
        return 31*firstName.hashCode() + lastName.hashCode();
    }

    public String toString() {
	return firstName + " " + lastName;
    }

    public int compareTo(Name n) {
        int lastCmp = lastName.compareTo(n.lastName);
        return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
    }
    
    static final Comparator<Employee> SENIORITY_ORDER = new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e2.hireDate().compareTo(e1.hireDate());
                
            }
    };
    
    
    
    
    public static void swap(int[] arr, int x, int y) {
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    /* public static <E> void swap(List<E> a, int i, int j) {
        E tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }  */
       
    public static void selectSort(int[] arr){
        for(int x=0;x<arr.length-1;x++){
            for(int y=x+1;y<arr.length;y++){
                if(arr[x]>arr[y]){    
                   int temp=arr[x];
                   arr[x]=arr[y];
                   arr[y]=temp;
     //              swap(arr,x,y);
                }
            }
        }
    }
    
    public static void bubbleSort(int[] arr){
         for(int x=0;x<arr.length-1;x++){
            for(int y=0;y<arr.length-1-x;y++){
                if(arr[y]>arr[y+1]){    
                   int temp=arr[y];
                   arr[y]=arr[y+1];
                   arr[y+1]=temp;
     //              swap(arr,y,y+1);
                }
            }
        }
    }
    public static void printArray(int[] arr){
        System.out.print("[");
        for(int x=0;x<arr.length-1;x++){
            System.out.print(arr[x]+",");
        }
        System.out.println("]");
    }
    

    
    
    public static void main(String[] args) {
        
        List<Employee> e = new ArrayList<Employee>();
        Collections.sort(e, SENIORITY_ORDER);//Sorts the specified list according to the order induced by the specified comparator
        System.out.println(e);
        
        
        Name nameArray[] = {
            new Name("John", "Smith"),
            new Name("Karl", "Ng"),
            new Name("Jeff", "Smith"),
            new Name("Tom", "Rich")
        };
 

        List<Name> names = Arrays.asList(nameArray);//Returns a fixed-size list backed by the specified array.返回指定数组支持的固定大小的列表.
        Collections.sort(names);//按照natural sequence 对name进行排序
        System.out.println(names);
        System.out.println();
         
        int[] arr={11,12,22,13,14,2,5,6};
        printArray(arr);
        selectSort(arr);
        printArray(arr);
        System.out.println();
        
        int[] abb={15,78,45,12,63,4,2,5,7};
        printArray(abb);
        bubbleSort(abb);
        printArray(abb);
        System.out.println();
        
        
    }
 }


    
