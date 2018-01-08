/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fei;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author feilu
 */
public class IOExample {
    
    public IOExample () {
        //this.byteStreamTest();
        //this.characterStreamTest();
        //this.copylineTest();
        //this.scanTest();
        //this.scanTranslationTest();
        //this.consoleTest();
        this.path();
    }
    
    public void requried () {
        //see IOUtils
    }
    
    public void path () {
        Path path = Paths.get("/home/joe/foo");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());
        
        
        try {
            Path ip = Paths.get("/Users/feilu/Documents/analysisL/a.txt");
            Path op = Paths.get("/Users/feilu/Documents/analysisL/b.txt");
            byte[] b = null;
            b = Files.readAllBytes(ip);
            Files.write(op, b);
            
            SeekableByteChannel sbc = Files.newByteChannel(ip);
            ByteBuffer buf = ByteBuffer.allocate(10);
            buf.clear();
            // Read the bytes with the proper encoding for this platform.  If
            // you skip this step, you might see something that looks like
            // Chinese characters when you expect Latin-style characters.
            String encoding = System.getProperty("file.encoding");
            int a = sbc.read(buf);
            while (a > 0) {
                
//                buf.rewind();
//                System.out.println(Charset.forName(encoding).decode(buf));
                buf.flip();
                System.out.println(Charset.forName(encoding).decode(buf));
                a = sbc.read(buf);
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void consoleTest () {
        class Password {
    
            public void test () throws IOException {

                Console c = System.console();
                if (c == null) {
                    System.err.println("No console.");
                    System.exit(1);
                }

                String login = c.readLine("Enter your login: ");
                char [] oldPassword = c.readPassword("Enter your old password: ");

                if (verify(login, oldPassword)) {
                    boolean noMatch;
                    do {
                        char [] newPassword1 = c.readPassword("Enter your new password: ");
                        char [] newPassword2 = c.readPassword("Enter new password again: ");
                        noMatch = ! Arrays.equals(newPassword1, newPassword2);
                        if (noMatch) {
                            c.format("Passwords don't match. Try again.%n");
                        } else {
                            change(login, newPassword1);
                            c.format("Password for %s changed.%n", login);
                        }
                        Arrays.fill(newPassword1, ' ');
                        Arrays.fill(newPassword2, ' ');
                    } while (noMatch);
                }

                Arrays.fill(oldPassword, ' ');
            }

            // Dummy change method.
            boolean verify(String login, char[] password) {
                // This method always returns
                // true in this example.
                // Modify this method to verify
                // password according to your rules.
                return true;
            }

            // Dummy change method.
            void change(String login, char[] password) {
                // Modify this method to change
                // password according to your rules.
            }
        }
        try {
            new Password().test();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void scanTranslationTest () {
        class ScanSum {
            public void test () throws IOException {

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
        }
        try {
            new ScanSum().test();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void scanTest () {
        class ScanXan {
            public void test() throws IOException {

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
        }
        try {
            new ScanXan().test();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void copylineTest () {
        class CopyLines {
            public void test() throws IOException {

                BufferedReader inputStream = null;
                PrintWriter outputStream = null;

                try {
                    inputStream = new BufferedReader(new FileReader("xanadu.txt"));
                    outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

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
        }
        try {
            new CopyLines().test();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void characterStreamTest () {
        class CopyCharacters {
            public void test () throws IOException {

                FileReader inputStream = null;
                FileWriter outputStream = null;

                try {
                    inputStream = new FileReader("xanadu.txt");
                    outputStream = new FileWriter("characteroutput.txt");

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
        }
        try {
            new CopyCharacters().test();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void byteStreamTest () {
        class CopyBytes {
            public void test () throws IOException {
                String dir = System.getProperty("user.dir");
                System.out.println("current dir = " + dir);
                FileInputStream in = null;
                FileOutputStream out = null;

                try {
                    in = new FileInputStream("xanadu.txt");
                    out = new FileOutputStream("outagain.txt");
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
        }
        try {
            new CopyBytes().test();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
