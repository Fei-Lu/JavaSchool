/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoyue;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import static javafx.beans.binding.Bindings.and;

/**
 *
 * @author Aoyue
 */
class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(new Integer(i));
        }
    }
//     public void writeList() throws IOException {
//	// The FileWriter constructor throws IOException, which must be caught.
//        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
//
//        for (int i = 0; i < SIZE; i++) {
//            // The get(int) method throws IndexOutOfBoundsException, which must be caught.
//            out.println("Value at: " + i + " = " + list.get(i));
//        }
//        out.close();
//    }    
    public void writeList() {
    PrintWriter out = null;
    try {
        System.out.println("Entered try statement");
        out = new PrintWriter(new FileWriter("OutFile.txt"));
        for (int i = 0; i < SIZE; i++) {
            out.println("Value at: " + i + " = " + list.get(i));
        }
    }
    catch (IndexOutOfBoundsException e) {
    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
} catch (IOException e) {
    System.err.println("Caught IOException: " + e.getMessage());
}
    
    //catching 可以用一个异常处理来同时处理多个异常类型，catch参数默认为final，在ex中，其为final类型
   /* catch (IOException|SQLException ex) {
    logger.log(ex);
    throw ex;
}*/
   finally {
    if (out != null) { 
        System.out.println("Closing PrintWriter");
        out.close(); 
    } else { 
        System.out.println("PrintWriter not open");
    } 
} 
    
 }
     public static void main(String[] args) {  
        ListOfNumbers listOfNumbers1 = new ListOfNumbers();  
        try {  
            listOfNumbers1.writeList();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
    /*
    
    */
    
}

//Explanation above: 
//try语句块有3种退出方法，1 try statement fails. 由 FileWriter statement or 
//数组越界引起的IO异常； 2 正常退出





/******************The try-with-resources Statement**********************/
/*BufferedReader类实现了interface AutoCloseable,并且在try语句中声明，所以无论try
//以何种方式完成，都会被关掉。结果就是，该类的readline抛出IO异常
//static String readFirstLineFromFile(String path) throws IOException {
//    try (BufferedReader br =
//                   new BufferedReader(new FileReader(path))) {
//        return br.readLine();
//    }
//}
//另一种方法，就是用finally语句块代替try-with-resources。 
//finally抛出异常，使readFirstLineFromFileWithFinallyBlock方法抛出异常，
//try语句的异常被抑制。对比而言，在上一段代码中，try-with-resources异常被抑制。
static String readFirstLineFromFileWithFinallyBlock(String path)
                                                     throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(path));
    try {
        return br.readLine();
    } finally {
        if (br != null) br.close();
    }
}


/*****declare one or more resources in a try-with-resources statement.***/
//public static void writeToFileZipFileContents(String zipFileName,
//                                           String outputFileName)
//                                           throws java.io.IOException {
//
//    java.nio.charset.Charset charset =
//         java.nio.charset.StandardCharsets.US_ASCII;
//    java.nio.file.Path outputFilePath =
//         java.nio.file.Paths.get(outputFileName);

    // Open zip file and create output file with 
    // try-with-resources statement

//    try (
//        java.util.zip.ZipFile zf =
//             new java.util.zip.ZipFile(zipFileName);
//        java.io.BufferedWriter writer = 
//            java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
//    ) {
//        // Enumerate each entry
//        for (java.util.Enumeration entries =
//                                zf.entries(); entries.hasMoreElements();) {
//            // Get the entry name and write it to the output file
//            String newLine = System.getProperty("line.separator");
//            String zipEntryName =
//                 ((java.util.zip.ZipEntry)entries.nextElement()).getName() +
//                 newLine;
//            writer.write(zipEntryName, 0, zipEntryName.length());
//        }
//    }
//}



/*****************The throw Statement****************************
 * 抛出异常对象，EmptyStackException is not a checked exception, 
 * so pop is not required to state that it might occur.
 */

//public Object pop() {
//    Object obj;
//
//    if (size == 0) {
//        throw new EmptyStackException();
//    }
//
//    obj = objectAt(size - 1);
//    setObjectAt(size - 1, null);
//    size--;
//    return obj;
//}


/********************Chained Exceptions*****************************
 * when an IOException is caught, a new SampleException exception 
 * is created with the original cause attached and the chain of
 * exceptions is thrown up to the next higher level exception handler.
*/
//try {
//
//} catch (IOException e) {
//    throw new SampleException("Other IOException", e);
//}



/**************A stack trace**************************不是太懂，具体怎么使用**/
//catch (Exception cause) {
//    StackTraceElement elements[] = cause.getStackTrace();
//    for (int i = 0, n = elements.length; i < n; i++) {       
//        System.err.println(elements[i].getFileName()
//            + ":" + elements[i].getLineNumber() 
//            + ">> "
//            + elements[i].getMethodName() + "()");
//    }
//}

/*************Logging API******************/
//try {
//    Handler handler = new FileHandler("OutFile.log");
//    Logger.getLogger("").addHandler(handler);
//    
//} catch (IOException e) {
//    Logger logger = Logger.getLogger("package.name"); 
//    StackTraceElement elements[] = e.getStackTrace();
//    for (int i = 0, n = elements.length; i < n; i++) {
//        logger.log(Level.WARNING, elements[i].getMethodName());
//    }
//}


//public static void cat(File file) {
//    RandomAccessFile input = null;
//    String line = null;
//
//    try {
//        input = new RandomAccessFile(file, "r");
//        while ((line = input.readLine()) != null) {
//            System.out.println(line);
//        }
//        return;
////    } catch(FileNotFoundException fnf) {
////        System.err.format("File: %s not found%n", file);
////    } catch(IOException e) {
////        System.err.println(e.toString());
//    } finally {
//        if (input != null) {
//            try {
//                input.close();
//            } catch(IOException io) {
//            }
//        }
//    }
//}

