/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author sharanya
 */
public class MaxHeap {

    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 4];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        Heap[++size] = element;
        int current = size;

        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= Heap.length; i++) {
            System.out.print(Heap[i]);
            System.out.println();
        }
    }

    public void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }

    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        maxHeapify(FRONT);
        return popped;
    }

    void printBalancedParantheses(int numLeft, int numRight, char a[], int index, int length) {
        if (index >= length) {
            for (int i = 0; i < length; i++) {
                System.out.printf("%c", a[i]);
            }
            System.out.println("");
        }
        if (numLeft < length / 2) {
            a[index] = '{';
            printBalancedParantheses(numLeft + 1, numRight, a, index + 1, length);
        }
        if (numRight < numLeft) {
            a[index] = '}';
            printBalancedParantheses(numLeft, numRight + 1, a, index + 1, length);
        }
    }

    void reverseString(String str) {
        int startIdx = 0;
        int endIdx = str.length();
        endIdx = endIdx - 1;
        while (startIdx != endIdx || startIdx>endIdx) {
            StringBuilder sb = new StringBuilder(str);
            char l = sb.charAt(startIdx), r = sb.charAt(endIdx);
            sb.setCharAt(startIdx, r);
            sb.setCharAt(endIdx, l);
            str = sb.toString();
            startIdx++;
            endIdx--;
        }
        System.out.println(str);
    }

    public static void main(String... arg) {
       // System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(14);
        

       // maxHeap.maxHeap();

 // maxHeap.print();
        //      System.out.println("The max val is " + maxHeap.remove());
        char[] a = new char[6];
       // maxHeap.printBalancedParantheses(0, 0, a, 0, 6);
        String s1, s2, s3;
        s1 = null;
        s2 = "hi";
        s3 = "helo";
//        maxHeap.reverseString(s1);
        //System.out.println(s1);
        // maxHeap.reverseString(s2);
        System.out.println(s2);
        maxHeap.reverseString(s3);

        System.out.println(s3);
        String[] arr = {"K1", "K2", "K3", "K4", "K5", "K6", "K7", "K8"};

        Queue q= new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
            
        }

        System.out.println(q.toString());
        while (q.size() != 2) {
            q.remove();
            //String t = q.remove();
          //  q.add(t);
        }
        q.remove();
        System.out.println(q.remove());

    }

}
