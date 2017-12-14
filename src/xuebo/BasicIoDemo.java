/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import static java.lang.ProcessBuilder.Redirect.Type.READ;
import static java.lang.ProcessBuilder.Redirect.Type.WRITE;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.CONTINUE;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Xuebo Zhao
 */
public class BasicIoDemo {

    private static DataOutputStream out;
    private static DataInputStream in;
    public static void test() throws IOException{
       outputCopyBytes();
       outputCopyCharacters();
       outputCopyLines();
       outputScanningBreakingInputIntoTokens();
       outputScanningTranslatingIndividualToken();
       outputPrintandPrintlnMethods();
       outputTheFormatMethod();
       outputDataStreams();
//       outputBufferedReader(); 
//       outputReadLine();
       outputStartPath();
       outputPathOperations();
       outputCheckingFileorDirectory();
//     copyGeneralFile("D:\\FeiLub\\a.txt", "D:\\FeiLub\\New.txt");   
//     copyGeneralFile("D:\\FeiLub\\Test20171214", "D:\\FeiLub");   
//     deleteGeneralFile("D:\\FeiLub\\a.txt");   
//     deleteGeneralFile("D:\\FeiLub\\Test20171214");  
//     cutGeneralFile("D:\\FeiLub\\a.txt", "D:\\FeiLub");  
//     cutGeneralFile("D:\\FeiLub\\Test20171214", "D:\\FeiLub"); 
//         outputRandomAccessFiles();
       
    }
    
    public static void outputCopyBytes() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outputCopyBytes.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
    
  
    
    public static void outputCopyCharacters() throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("outputCopyCharacters.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    
    public static void outputCopyLines() throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("outputCopyLines.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    
    public static void outputScanningBreakingInputIntoTokens() throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
    
    public static void outputScanningTranslatingIndividualToken() throws IOException {

        Scanner s = null;
        double sum = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
            s.useLocale(Locale.US);

            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    sum += s.nextDouble();
                } else {
                    s.next();
                }   
            }
        } finally {
            s.close();
        }

        System.out.println(sum);
    }
    
    public static void outputPrintandPrintlnMethods() {
        int i = 2;
        double r = Math.sqrt(i);
        
        System.out.print("The square root of ");
        System.out.print(i);
        System.out.print(" is ");
        System.out.print(r);
        System.out.println(".");

        i = 5;
        r = Math.sqrt(i);
        System.out.println("The square root of " + i + " is " + r + ".");
    }
    
    //formats two values with a single format invocation
    //d formats an integer value as a decimal value.
    //f formats a floating point value as a decimal value.
    //n outputs a platform-specific line terminator.
    //x formats an integer as a hexadecimal value.
    //s formats any value as a string.
    //tB formats an integer as a locale-specific month name
    //Precision,Width,Flags,Argument Index
    public static void outputTheFormatMethod() {
        int i = 2;
        double r = Math.sqrt(i);
        
        System.out.format("The square root of %d is %f.%n", i, r);
        System.out.format("%f, %1$+020.10f %n", Math.PI);
    }

    static final String dataFile = "invoicedata";
    static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
    static final int[] units = { 12, 8, 13, 29, 50 };
    static final String[] descs = {
        "Java T-shirt",
        "Java Mug",
        "Duke Juggling Dolls",
        "Java Pin",
        "Java Key Chain"
    };
    public static void outputDataStreams() throws FileNotFoundException, IOException {
        out = new DataOutputStream(new BufferedOutputStream(
              new FileOutputStream(dataFile)));
            for (int i = 0; i < prices.length; i ++) {
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
                out.flush();
            }
            out.close();
        in = new DataInputStream(new
            BufferedInputStream(new FileInputStream(dataFile)));
            double price = 8;
            int unit = 10;
            String desc = "Java T-shirt";
            double total = 0.0;
        try {
            while (true) {
                price = in.readDouble();
                unit = in.readInt();
                desc = in.readUTF();
                System.out.format("You ordered %d" + " units of %s at $%.2f%n",
                    unit, desc, price);
                total += unit * price;
                System.out.println(total);
            }
        } 
        catch (EOFException e) {
        }              
    }
    
//        public static void outputBufferedReader() throws IOException{
//        char c ;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("q means quit");
//        do {
//           c = (char) br.read();
//           System.out.println(c);
//        } while(c != 'q');
//        }
//    
//    public static void outputReadLine() throws IOException{
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    String str;
//    System.out.println("Enter lines of text.");
//    System.out.println("Enter 'end' to quit.");
//        do {
//         str = br.readLine();
//        System.out.println(str);
//        } while(!str.equals("end"));
//    }
    
    public static void outputStartPath() throws IOException {
    
        File f = new File("C:\\Users\\Xuebo Zhao.LULAB-PC-03\\Documents\\NetBeansProjects\\a.txt");
        FileOutputStream fop = new FileOutputStream(f);
        // 构建FileOutputStream对象,文件不存在会自动新建

        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk

        writer.append("中文输入");
        // 写入到缓冲区

        writer.append("\r\n");
        //换行

        writer.append("English");
        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

        writer.close();
        //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉

        fop.close();
        // 关闭输出流,释放系统资源

        FileInputStream fip = new FileInputStream(f);
        // 构建FileInputStream对象

        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        // 构建InputStreamReader对象,编码与写入相同

        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
          sb.append((char) reader.read());
          // 转成char加到StringBuffer对象中
        }
        System.out.println(sb.toString());
        reader.close();
        // 关闭读取流

        fip.close();
        // 关闭输入流,释放系统资源

  }
    
    public static void outputPathOperations(){
        
        Path path = Paths.get("C:\\Users\\Xuebo Zhao.LULAB-PC-03\\Documents\\NetBeansProjects\\a.txt");
        
        System.out.format("toString: %s%n", path.toString());
        
        System.out.format("getFileName: %s%n", path.getFileName());
        
        System.out.format("getName(0): %s%n", path.getName(0));
        
        System.out.format("getNameCount: %d%n", path.getNameCount());
        
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        
        System.out.format("getParent: %s%n", path.getParent());
        
        System.out.format("getRoot: %s%n", path.getRoot()); 
        
        //a relative path is specified
        //Path path = Paths.get("sally\\bar");
        
        //Removing Redundancies From a Path  /home/./joe/foo   /home/sally/../joe/foo
        
        //Converting a Path    System.out.format("%s%n", p1.toUri());
        
        //Comparing Two Paths 
        //Path path = ...;
        //Path otherPath = ...;
        //Path beginning = Paths.get("/home");
        //Path ending = Paths.get("foo");
        
    }
   
    public static void outputCheckingFileorDirectory(){
        File file=new File("C:\\Users\\Xuebo Zhao.LULAB-PC-03\\Documents\\NetBeansProjects\\a.txt");      
            if(!file.exists())      
            {      
                try {      
                    file.createNewFile();      
                } catch (IOException e) {        
                    e.printStackTrace();      
                }      
            }   
        File file2 =new File("C:\\Users\\Xuebo Zhao.LULAB-PC-03\\Documents\\NetBeansProjects");         
        if  (!file .exists()  && !file .isDirectory())        
        {         
            System.out.println("//not exist");    
            file .mkdir();      
        } else     {    
            System.out.println("//exist");    
        }  
        
            //Checking Whether Two Paths Locate the Same File
            //Path p1 = ...;
            //Path p2 = ...
            //if (Files.isSameFile(p1, p2))
            
    }
    
    //copy
    public static boolean copyGeneralFile(String srcPath, String destDir) {  
        boolean flag = false;  
        File file = new File(srcPath);  
        if (!file.exists()) {  
            System.out.println("File or Directory does not exist!");  
            return false;  
        }  
        if (file.isFile()) { // 源文件  
            System.out.println("copyFile!");  
            flag = copyFile(srcPath, destDir);  
        } else if (file.isDirectory()) {  
            System.out.println("copyFile!");  
            flag = copyDirectory(srcPath, destDir);  
        }  
  
        return flag;  
    }  
    
    private static boolean copyFile(String srcPath, String destDir) {  
        boolean flag = false;  
  
        File srcFile = new File(srcPath);  
        if (!srcFile.exists()) { // 源文件不存在  
            System.out.println("File does not exist!");  
            return false;  
        }  
        // 获取待复制文件的文件名  
        String fileName = srcPath  
                .substring(srcPath.lastIndexOf(File.separator));  
        String destPath = destDir + fileName;  
        if (destPath.equals(srcPath)) { // 源文件路径和目标文件路径重复  
            System.out.println("File path overlapping!");  
            return false;  
        }  
        File destFile = new File(destPath);  
        if (destFile.exists() && destFile.isFile()) { // 该路径下已经有一个同名文件  
            System.out.println("File with the same name!");  
            return false;  
        }  
  
        File destFileDir = new File(destDir);  
        destFileDir.mkdirs();  
        try {  
            FileInputStream fis = new FileInputStream(srcPath);  
            FileOutputStream fos = new FileOutputStream(destFile);  
            byte[] buf = new byte[1024];  
            int c;  
            while ((c = fis.read(buf)) != -1) {  
                fos.write(buf, 0, c);  
            }  
            fis.close();  
            fos.close();  
  
            flag = true;  
        } catch (IOException e) {  
            //  
        }  
  
        if (flag) {  
            System.out.println("File copy success!");  
        }  
  
        return flag;  
    }  
    
    private static boolean copyDirectory(String srcPath, String destDir) {  
        System.out.println("start copy Directory!");  
        boolean flag = false;  
  
        File srcFile = new File(srcPath);  
        if (!srcFile.exists()) { // 源文件夹不存在  
            System.out.println(" Directory does not exist!");  
            return false;  
        }  
        // 获得待复制的文件夹的名字，比如待复制的文件夹为"E://dir"则获取的名字为"dir"  
        String dirName = getDirName(srcPath);  
        // 目标文件夹的完整路径  
        String destPath = destDir + File.separator + dirName;  
        // System.out.println("目标文件夹的完整路径为：" + destPath);  
  
        if (destPath.equals(srcPath)) {  
            System.out.println("Directory path overlapping!");  
            return false;  
        }  
        File destDirFile = new File(destPath);  
        if (destDirFile.exists()) { // 目标位置有一个同名文件夹  
            System.out.println("Directory with the same name!");  
            return false;  
        }  
        destDirFile.mkdirs(); // 生成目录  
  
        File[] fileList = srcFile.listFiles(); // 获取源文件夹下的子文件和子文件夹  
        if (fileList.length == 0) { // 如果源文件夹为空目录则直接设置flag为true，这一步非常隐蔽，debug了很久  
            flag = true;  
        } else {  
            for (File temp : fileList) {  
                if (temp.isFile()) { // 文件  
                    flag = copyFile(temp.getAbsolutePath(), destPath);  
                } else if (temp.isDirectory()) { // 文件夹  
                    flag = copyDirectory(temp.getAbsolutePath(), destPath);  
                }  
                if (!flag) {  
                    break;  
                }  
            }  
        }  
  
        if (flag) {  
            System.out.println("Directory copy success!");  
        }  
  
        return flag;  
    }  
    private static String getDirName(String dir) {  
        if (dir.endsWith(File.separator)) { // 如果文件夹路径以"//"结尾，则先去除末尾的"//"  
            dir = dir.substring(0, dir.lastIndexOf(File.separator));  
        }  
        return dir.substring(dir.lastIndexOf(File.separator) + 1);  
    }  
    
    //delete
    public static boolean deleteGeneralFile(String path) {  
        boolean flag = false;  
  
        File file = new File(path);  
        if (!file.exists()) { // 要删除的文件不存在  
            System.out.println("File does not exist！");  
        }  
  
        if (file.isDirectory()) { // 如果是目录，则单独处理  
            flag = deleteDirectory(file.getAbsolutePath());  
        } else if (file.isFile()) {  
            flag = deleteFile(file);  
        }  
  
        if (flag) {  
            System.out.println("delete success!");  
        }  
  
        return flag;  
    }  
    
    private static boolean deleteFile(File file) {  
        return file.delete();  
    }

    private static boolean deleteDirectory(String path) {  
        boolean flag = true;  
        File dirFile = new File(path);  
        if (!dirFile.isDirectory()) {  
            return flag;  
        }  
        File[] files = dirFile.listFiles();  
        for (File file : files) { // 删除该文件夹下的文件和文件夹  
            // Delete file.  
            if (file.isFile()) {  
                flag = deleteFile(file);  
            } else if (file.isDirectory()) {// Delete folder  
                flag = deleteDirectory(file.getAbsolutePath());  
            }  
            if (!flag) { // 只要有一个失败就立刻不再继续  
                break;  
            }  
        }  
        flag = dirFile.delete(); // 删除空目录  
        return flag;  
    }  
   
    //cut
    public static boolean cutGeneralFile(String srcPath, String destDir) {  
        if (!copyGeneralFile(srcPath, destDir)) {  //复制失败导致剪切失败
            System.out.println("cut fail!");  
            return false;  
        }  
        if (!deleteGeneralFile(srcPath)) {  //删除源文件(文件夹)失败导致剪切失败
            System.out.println("cut fail!");  
            return false;  
        }  
  
        System.out.println("cut success!");  
        return true;  
    }  
    
//     public static void outputRandomAccessFiles(){
//            File file = new File("C:\\Users\\Xuebo Zhao.LULAB-PC-03\\Documents\\NetBeansProjects\\a.txt"); 
//            String s = "I was here!\n";
//            byte data[] = s.getBytes();
//            ByteBuffer out = ByteBuffer.wrap(data);
//
//            ByteBuffer copy = ByteBuffer.allocate(12);
//
//            try (FileChannel fc = (FileChannel.open(file, READ, WRITE))) {
//                // Read the first 12
//                // bytes of the file.  
//            int nread;
//            do {
//                nread = fc.read(copy);
//            } while (nread != -1 && copy.hasRemaining());
//
//            // Write "I was here!" at the beginning of the file.
//            fc.position(0);
//            while (out.hasRemaining())
//                fc.write(out);
//            out.rewind();
//
//            // Move to the end of the file.  Copy the first 12 bytes to
//            // the end of the file.  Then write "I was here!" again.
//            long length = fc.size();
//            fc.position(length-1);
//            copy.flip();
//            while (copy.hasRemaining())
//                fc.write(copy);
//            while (out.hasRemaining())
//                fc.write(out);
//        } catch (IOException x) {
//            System.out.println("I/O Exception: " + x);
//        }

//     }
     
    
}
