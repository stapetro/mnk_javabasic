package com.mnknowledge;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        //System.out.println( "Hello World 123!" );

        MySorting var  = new MySorting(new int[]{8, 5, 7, 1, 9, 3});
        var.sort();
    }
}
