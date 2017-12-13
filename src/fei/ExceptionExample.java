/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fei;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author feilu
 */
public class ExceptionExample {
    
    public ExceptionExample () {
        //this.checkedAndUncheckedtest();
        //this.standardFormattest();
        //catchErrorTest();
        this.requried();
    }
    
    public void requried () {
        try {
            
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        try {
            
        }
        catch (Throwable e) { //Error or Exception
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public void catchErrorTest () {
//        int[] b = new int[1];
//        b[1] = 2;
        try {
            int[] a = new int[1];
            a[1] = 2;
        }
        catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        finally {
            System.out.println("fine");
        }
        System.out.println("Keep going");
    }
    
    public void putAlltogetherTest () {
        class ListOfNumbers {

            private List<Integer> list;
            private static final int SIZE = 10;
            
            
            public void writeList() {
                PrintWriter out = null;

                try {
                    System.out.println("Entering" + " try statement");

                    out = new PrintWriter(new FileWriter("OutFile.txt"));
                    for (int i = 0; i < SIZE; i++) {
                        out.println("Value at: " + i + " = " + list.get(i));
                    }
                } 
                catch (IndexOutOfBoundsException e) {
                    System.err.println("Caught IndexOutOfBoundsException: "
                                       +  e.getMessage());

                } 
                catch (IOException e) {
                    System.err.println("Caught IOException: " +  e.getMessage());

                } 
                finally {
                    if (out != null) {
                        System.out.println("Closing PrintWriter");
                        out.close();
                    } 
                    else {
                        System.out.println("PrintWriter not open");
                    }
                }
            }

        }
    }
    
    public static void viewTable(Connection con) throws SQLException {

        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";

        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String coffeeName = rs.getString("COF_NAME");
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");

                System.out.println(coffeeName + ", " + supplierID + ", " + 
                                   price + ", " + sales + ", " + total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } 
        finally {
            if (br != null) br.close();
        }
    }
    
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }
    public void standardFormattest () {
        class ListOfNumbers {

            private List<Integer> list;
            private static final int SIZE = 10;

            public void writeList() {
                PrintWriter out = null;
                try {
                    System.out.println("Entered try statement");
                    out = new PrintWriter(new FileWriter("OutFile.txt"));
                    for (int i = 0; i < SIZE; i++) {
                        out.println("Value at: " + i + " = " + list.get(i));
                    }
                }
//                catch (IndexOutOfBoundsException e) {
//                    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
//                } catch (IOException e) {
//                    System.err.println("Caught IOException: " + e.getMessage());
//                }
                catch (IOException|IndexOutOfBoundsException ex) {
                    ex.getMessage();
//                    logger.log(ex);
//                    throw ex;
                }
                finally {
                    if (out != null) { 
                        System.out.println("Closing PrintWriter");
                        out.close(); 
                    } else { 
                        System.out.println("PrintWriter not open");
                    } 
                } 
            }

        }
    }
    
    public void checkedAndUncheckedtest () {
        class ListOfNumbers {

            private List<Integer> list;
            private static final int SIZE = 10;

            public ListOfNumbers () {
                list = new ArrayList<Integer>(SIZE);
                for (int i = 0; i < SIZE; i++) {
                    list.add(new Integer(i));
                }
            }

            public void writeList(){
                // The FileWriter constructor throws IOException, which must be caught.
                //PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));

                for (int i = 0; i < SIZE; i++) {
                    // The get(int) method throws IndexOutOfBoundsException, which must be caught.
                    //out.println("Value at: " + i + " = " + list.get(i));
                }
                //out.close();
            }
            


        }
    }
}
