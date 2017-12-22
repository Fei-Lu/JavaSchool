package xujun;

/**
 *
 * @author Jun Xu
 */
import java.util.*;
import java.util.Date;
import java.lang.Integer;

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
 //1.选择排序      
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
//2.冒泡排序    
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
    

    
    
  //3.快速排序  
    public static int getMiddle(int[] numbers, int low,int high)
    {
        int temp = numbers[low]; //数组的第一个作为中轴
        while(low < high){
            while(low < high && numbers[high] >= temp){//遍历一下把数组里面大于第一个数的分为一组
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while(low < high && numbers[low] < temp){
                low++;
            }
            numbers[high] = numbers[low] ; //比中轴大的记录移到高端
        }
        numbers[low] = temp ; //中轴记录到尾
        return low ; // 返回中轴的位置
    }
    public static void quickSort(int[] numbers,int low,int high){
        if(low < high){
            int middle = getMiddle(numbers,low,high); //将numbers数组进行一分为二
            quickSort(numbers, low, middle-1);   //对低字段表进行递归排序
            quickSort(numbers, middle+1, high); //对高字段表进行递归排序
        }
    }
    public static void quick(int[] numbers){
        if(numbers.length > 0)   //查看数组是否为空{
            quickSort(numbers, 0, numbers.length-1);
    }
   
 //4.插入排序
    public static void insertSort(int[] numbers){
        int temp = 0 ;
        int j =  0;

        for(int i = 0 ; i < numbers.length ; i++){
            temp = numbers[i];
            //假如temp比前面的值小，则将前面的值后移
            for(j = i ; j > 0 && temp < numbers[j-1] ; j --){
                numbers[j] = numbers[j-1];
            }
            numbers[j] = temp;
        }
    }
    
    //5.希尔排序
    public static void shellSort(int[] data) {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半 
        for (int increment = data.length / 2; increment > 0; increment /= 2){
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i; j >= increment; j -= increment) {
                    if(temp > data[j - increment]){//如想从小到大排只需修改这里
                        data[j] = data[j - increment];
                    }
                else {
                    break;
                }
                } 
            data[j] = temp;
        }
        }
    }
    
    //6.归并排序
    public static int[] sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            sort(nums, low, mid);
            // 右边
            sort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }
    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];//限定了temp这个数组的长度 保证与int[] num 这个数组的长度相同 但不像arr一样从0开始
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {//保证左指针在右指针的左边
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }     
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }
    
    //7.堆排序
    public static void buildMaxHeap(int[] data, int lastIndex){
         //从lastIndex处节点（最后一个节点）的父节点开始 
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点 
            int k=i;
            //如果当前k节点的子节点存在  
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引 
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){  
                    //若果右子节点的值较大  
                    if(data[biggerIndex]<data[biggerIndex+1]){  
                        //biggerIndex总是记录较大子节点的索引  
                        biggerIndex++;  
                    }  
                }  
                //如果k节点的值小于其较大的子节点的值  
                if(data[k]<data[biggerIndex]){  
                    //交换他们  
                    swap(data,k,biggerIndex);  
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值  
                    k=biggerIndex;  
                }else{  
                    break;  
                }  
            }
        }
    }
    
    //8.基数排序
     public static void radixSort(int[] data, int radix, int d) {  //radix 基数
        // 缓存数组  
        int[] tmp = new int[data.length];  
        // buckets用于记录待排序元素的信息  
        // buckets数组定义了max-min个桶  
        int[] buckets = new int[radix];    
        for (int i = 0, rate = 1; i < d; i++) {    
            // 重置count数组，开始统计下一个关键字  
            Arrays.fill(buckets, 0);//fill(int[] a, int val) Assigns the specified int value to each element(all) of the specified array of ints.  
            // 将data中的元素完全复制到tmp数组中  
            System.arraycopy(data, 0, tmp, 0, data.length);//Class System Method arraycopy data:sorce array 0:starting position temp:destination array 0:starting position data.length:length   
            // 计算每个待排序数据的子关键字  
            for (int j = 0; j < data.length; j++) {  
                int subKey = (tmp[j] / rate) % radix;  
                buckets[subKey]++;  
            }  
            for (int j = 1; j < radix; j++) {  
                buckets[j] = buckets[j] + buckets[j - 1];  
            }  
           // 按子关键字对指定的数据进行排序  
            for (int m = data.length - 1; m >= 0; m--) {  
                int subKey = (tmp[m] / rate) % radix;  
                data[--buckets[subKey]] = tmp[m];  
            }  
            rate *= radix;  
        }  
    }  
 
    public static void main(String[] args) {
        Name nameArray[] = {
            new Name("John", "Smith"),
            new Name("Karl", "Ng"),
            new Name("Jeff", "Smith"),
            new Name("Tom", "Rich")
        };
        List<Name> names = Arrays.asList(nameArray);//Returns a fixed-size list backed by the specified array.返回指定数组支持的固定大小的列表.
        Collections.sort(names);//按照natural sequence 对name进行排序
        System.out.println(names);
        Name newname1=new Name("lao","zhu");
        Name newname2=new Name("xiao","zhu");
        int aa=newname1.compareTo(newname2);
        System.out.println(aa);
        System.out.println();
        
        List<Employee> e = new ArrayList<Employee>();
        Collections.sort(e, SENIORITY_ORDER);//Sorts the specified list according to the order induced by the specified comparator
        System.out.println(e);
        System.out.println();
         
        int[] arr={11,12,22,13,14,2,5,6};
        printArray(arr);
        selectSort(arr);
        System.out.print("选择排序后：");
        printArray(arr);
        System.out.println();
        
        int[] abb={15,78,45,12,63,4,2,5,7};
        printArray(abb);
        bubbleSort(abb);
        System.out.print("冒泡排序后：");
        printArray(abb);
        System.out.println();
        
        printArray(abb);
        quick(abb);
        System.out.print("快速排序后：");
        printArray(abb);
        System.out.println();
        
        int[]c={69,789,4561,2335,789521,456479799,52879244};
        printArray(c);
        insertSort(c);        
        System.out.print("插入排序后：");
        printArray(c);
        shellSort(c);
        printArray(c);
        
        int[] d={12,45,56,1,24,5,7};
        printArray(d);
        shellSort(d);
        System.out.print("希尔排序后：");
        printArray(d);
        System.out.println();
        
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64};  
        //循环建堆  
        for(int i=0;i<a.length-1;i++){  
            //建堆  
            buildMaxHeap(a,a.length-1-i);  
            //交换堆顶和最后一个元素  
            swap(a,0,a.length-1-i);  
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
        
        int[] data = new int[] { 1100, 192, 221, 12, 23 };  
        printArray(data);  
        radixSort(data, 10, 4);  
        System.out.print("基数排序后：");  
        printArray(data);  
        
    }
}

    
