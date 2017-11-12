/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

import java.io.BufferedWriter;

/**
 *
 * @author xuebo
 */
public class HelloWorldlalala {
    public static void main(String[] args){
        Card card = new Card(1,13);
        System.out.println("Hello World lalala");
        String outfileS = "";
        try {
            BufferedWriter bw = IOUtils.getTextWriter(outfileS);
            bw.write("Xuebo");
            bw.flush();
            bw.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    }
