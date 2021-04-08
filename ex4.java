package com.mycompany.pocs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {
        
        try 
        {
            
            HelloWorld hw = new HelloWorld();

            Method printItMethod = HelloWorld.class.getMethod("printIt");
            printItMethod.invoke(hw, null);
        } 
        catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}

class HelloWorld
{
    public void printIt()
    {
        System.out.println("Hello World");
	String password = "cenas";
    }
}


///olaole
