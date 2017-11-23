/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yao;

/**
 *
 * @author yaozhou
 */
public class DataStructure {
    private final static int SIZE = 5;
    private int[] arrayOfInts = new int[SIZE];
    public DataStructure(){
        for (int i = 0; i < SIZE; i++){
            arrayOfInts[i] = i;
        }
    }
}
