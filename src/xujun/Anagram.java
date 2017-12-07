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

public class Anagram {
//anagram n. 相同字母异序词，易位构词，变位词
    public static boolean areAnagrams(String string1,
                                      String string2) {

        String workingCopy1 = removeJunk(string1);//输出的为eniaLdnaomsoC
        String workingCopy2 = removeJunk(string2);//输出的为noosnaelcdiaM

	    workingCopy1 = workingCopy1.toLowerCase();//enialdnaomsoc
	    workingCopy2 = workingCopy2.toLowerCase();//noosnaelcdiam

	    workingCopy1 = sort(workingCopy1);
	    workingCopy2 = sort(workingCopy2);

        return workingCopy1.equals(workingCopy2);
/*bingo equals是对内容以及哈希值的比较 即所有的对象都拥有标识(内存地址)和状态(数据）
  equals的默认输出是flase （分析之后 将workingCopy2中的s改成m就可以看出来）
  使用时的注意事项：
  1、自反性：对于任何非空引用值 x，x.equals(x) 都应返回 true。

  2、对称性：对于任何非空引用值 x 和 y，当且仅当 y.equals(x) 返回 true 时，x.equals(y) 才应返回 true。

  3、传递性：对于任何非空引用值 x、y 和 z，如果 x.equals(y) 返回 true，并且 y.equals(z) 返回 true，那么 x.equals(z) 应返回 true。

  4、一致性：对于任何非空引用值 x 和 y，多次调用 x.equals(y) 始终返回 true 或始终返回 false，前提是对象上 equals 比较中所用的信息没有被修改。

  5、 对于任何非空引用值 x，x.equals(null) 都应返回 false。  
*/

    }

    protected static String removeJunk(String string) {
        int i, len = string.length();
        StringBuilder dest = new StringBuilder(len);
  		char c;

	    for (i = (len - 1); i >= 0; i--) {
	        c = string.charAt(i);
	        if (Character.isLetter(c)) {
//isLetter(char ch) （char类型被autoboxing成Character对象里面的方法）Determines if the specified character is a letter.
		        dest.append(c);
	        }
	    }

        return dest.toString();
    }

    protected static String sort(String string) {
	    char[] charArray = string.toCharArray();
//将string这个对象转换成了char类型 charArray={'s','t','r','i','n','g'}
	    java.util.Arrays.sort(charArray);
//Arrays是一个class 里面有一个sort方法 根据传入参数的不同 可以产生不同的效果
//sort(char[] a) Sorts the specified array into ascending numerical order.将这些指定的数组按照升序排列
//workingCopy1=aacdeilmnoo workingCopy2=aacdeilnoos

        return new String(charArray);
    }

    public static void main(String[] args) {
        String string1 = "Cosmo and Laine:";
        String string2 = "Maid, clean soon!";

        System.out.println();
        System.out.println("Testing whether the following "
                         + "strings are anagrams:");
        System.out.println("    String 1: " + string1);
        System.out.println("    String 2: " + string2);
        System.out.println();
//以上只是一些简单的输出语句
        if (areAnagrams(string1, string2)) {
            System.out.println("They ARE anagrams!");
        } else {
            System.out.println("They are NOT anagrams!");
        }
        System.out.println();
    }
}
    

