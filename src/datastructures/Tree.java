/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import static java.lang.System.in;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author sharanya
 */
public class Tree {

    Map cache = new HashMap();
    int data = 0;
    Tree left = null;
    Tree right = null;

    public Tree(int x) {
        data = x;
        left = null;
        right = null;

    }

    public Tree insert(int x) {
        Tree t = this;

        if (t == null) {
            return new Tree(x);
        }
        if (x < t.data) {
            if (t.left == null) {
                t.left = new Tree(x);
            } else {
                t.left = t.left.insert(x);
            }
        } else if (t.right == null) {
            t.right = new Tree(x);
        } else {
            t.right = t.right.insert(x);
        }

        return t;
    }

    void printTree(Tree root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.data);
            printTree(root.right);
        }

    }

    void decode(String S) {

    }
    
    
    public int maxsumNonContiguous(int[] arr){
     /* Empty array */
    int incl = arr[0];
    ArrayList a1= new  ArrayList<Object>();
        ArrayList a2= new  ArrayList<Object>();
       // Array a= new  Array();
        int excl = 0;
        int excl_new;
        int i;
 a1.add(excl);
        for (i = 1; i < arr.length; i++)
        {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;
 
            /* current max including i */
            incl = excl + arr[i];
            a2.add(incl-excl);
            a1.add(excl_new-excl);
            excl = excl_new;
          
        }
        System.out.println(a1.toString()+"\n"+a2.toString());
        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
        
        
        
     
 }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList llobj = new LinkedList();
        llobj.add("1. Alive is  awesome");  
        llobj.add("2. Love yourself"); 
        System.out.println("LinkedList object output :"+llobj);   
 llobj.get(0);
      Stack s= new Stack();
      s.push(2);
      s.push(4);
        System.out.println(s.pop());

        Tree tree1 = new Tree(30);
        tree1 = tree1.insert(20);
        tree1 = tree1.insert(100);
        tree1 = tree1.insert(32);
        tree1 = tree1.insert(28);
        tree1 = tree1.insert(19);
        tree1 = tree1.insert(10);
        tree1.printTree(tree1);
        Queue<Integer> q = new LinkedList<>();
        Queue<Character> a = new LinkedList<>();
        String S = "010101";
        System.out.println(Integer.MAX_VALUE);
        S.substring(0, 4);
        GfG g = new GfG();

        System.out.println(g.isInterLeave("aab", "axy", "aaxaby"));
        System.out.println(g.isInterLeave("X", "XY", "XYXX"));

        String v1 = "abc12kl";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < v1.length(); i++) {
            char c = v1.charAt(i);
            if (Character.isDigit(c)) {
                builder.append(c);
            }
        }

        int i1 = Integer.parseInt(builder.toString());
        System.out.println(builder);

        String v2 = "" + i1 + "";
        String v3 = "" + (i1 + 2) + "";
        System.out.println(v1.replace(builder, v3));

        int[] A = {14, 9, 2, 15 };
System.out.println("Sub array:"+ tree1.maxsumNonContiguous(A));

        for (int i = 1; i < 4; i++) {
            int j = i - 1;
            int key = A[i];
            while (j >= 0 && key < A[j]) {
                A[j + 1] = A[j];
                j = j - 1;
                     }
            A[j + 1] = key;
            for (int ii = 0; ii < 4; ii++) {
                System.out.print(A[ii] + " ");
            }
            System.out.println();
        }
         String input;
      char[] output;
        Scanner sc= new Scanner(System.in);
        input=sc.nextLine();
      output=input.toCharArray();
      output[0]=(char) (output[0]-32);
      for(int i=0; i<input.length();i++)
      {
      System.out.print(output[i]);
      }
        
        
    }

}

class GfG {

    public boolean isInterLeave(String a, String b, String c) {
        //Your code here
        int i = 0;
        if (c.charAt(i) == a.charAt(0)) {
            System.out.println("Entered here 1" + c.substring(i, a.length()));
            if (c.substring(i, a.length()).equals(a)) {
                System.out.println("Entered here 2" + c.substring(i + a.length(), c.length()));
                if (c.substring(i + a.length(), c.length()).equals(b) && (c.length() == a.length() + b.length())) {
                    System.out.println("Entered here 3");
                    return true;
                }
            }
        }

        if (c.charAt(i) == b.charAt(0)) {
            if (c.substring(i, b.length()).equals(b)) {
                  System.out.println("Entered here 5"+ c.substring(i+b.length(),c.length()));

                if (c.substring(i + b.length(), c.length()).equals(a) && (c.length() == a.length() + b.length())) {
                    System.out.println("Entered here 6");return true;
                }
            }
        }
        return false;

    }
}
