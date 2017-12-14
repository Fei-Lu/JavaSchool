/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xuebo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Xuebo Zhao
 */
class SessionDTO implements Serializable {  
    private static final long serialVersionUID = 1L;  
    private transient int data; // Stores session data  
  
    //Session activation time (creation, deserialization)  
    private transient long activationTime;   
  
    public SessionDTO(int data) {  
        this.data = data;  
        this.activationTime = System.currentTimeMillis();  
    }  
  
    private void writeObject(ObjectOutputStream oos) throws IOException {  
        oos.defaultWriteObject();  
        oos.writeInt(data);  
        System.out.println("session serialized");  
    }  
  
    private void readObject(ObjectInputStream ois) throws IOException,  
            ClassNotFoundException {  
        ois.defaultReadObject();  
        data = ois.readInt();  
        activationTime = System.currentTimeMillis();  
        System.out.println("session deserialized");  
    }  
  
    public int getData() {  
        return data;  
    }  
  
    public long getActivationTime() {  
        return activationTime;  
    }  
}  
public class SerializeTester implements Serializable {  
    public static void main(String... strings) throws Exception {  
        File file = new File("out.ser");  
  
        ObjectOutputStream oos = new ObjectOutputStream(  
            new FileOutputStream(file));  
        SessionDTO dto = new SessionDTO(1);  
        oos.writeObject(dto);  
        oos.close();  
  
        ObjectInputStream sb = new ObjectInputStream(  
            new FileInputStream(file));  
        SessionDTO rb = (SessionDTO) sb.readObject();  
  
        System.out.println("data : " + rb.getData()  
            + " activation time : " + rb.getActivationTime());  
        sb.close();  
    }  
}  
