package com.integrallis.example;

import java.util.Collection;
import java.util.Iterator;

/**
 * This class is used to demonstrate some of the upgrades to Java 5.
 * 
 * By itself it will not run. You will have to alter the main method to select the method you 
 * want to run or you can call the methods from a seperate class.
 * 
 * @author joseph f. nusairat
 *
 */
public class Java5Sample {

    public void sumWGenerics(Collection<Integer> col) {
        
        int sum = 0;
        for (Iterator<Integer> it = col.iterator(); it.hasNext() ;) {
            Integer temp = it.next();
            sum += temp.intValue();
        }
        System.out.println(sum);        
    }
    
    public void sumWOGenerics(Collection col) {
        
        int sum = 0;
        for (Iterator it = col.iterator(); it.hasNext() ;) {
            Integer temp = (Integer)it.next();
            sum += temp.intValue();
        }
        System.out.println(sum);        
    }
    
    public void otherGenerics() throws InstantiationException, IllegalAccessException {
        String s = String.class.newInstance();
    }
    
    public void sumWGenericsAndForLoop(Collection<Integer> col) {
        
        int sum = 0;
        for (Integer i : col) {
            sum += i.intValue();
        }
        System.out.println(sum);        
    }
    
    public void sumWGenericsAndForLoop(Integer[] col) {
        
        int sum = 0;
        for (Integer i : col) {
            sum += i.intValue();
        }
        System.out.println(sum);        
    }
    
    public Integer addWAutoboxing(Collection<Integer> col) {
        
        int sum = 0;
        for (Integer i : col) {
            sum += i;
        }
        System.out.println(sum);
        return sum;
    }
    
    enum Week { Monday, Tuesday, Wedensday, Thursday, Friday, Saturday, Sunday};
    
    public int sums(Integer[] values) {
        int sum = 0;
        
        for(int val : values) {
            sum += val;
        }
        
        return sum;
    }
    
    public static int sum (Integer... values) {
        int sum = 0;
        
        for(int val : values) {
            sum += val;
        }
        
        return sum; 
    }
    
    public static void main(String[] args) { 
         
       
        int sum = sum(new Integer[] {1,2,3});
        int sum2 = sum(1,2,3);
        System.out.println(sum);
        
    
    }
    
}
