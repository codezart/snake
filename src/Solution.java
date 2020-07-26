//import java.io.*;
//import java.util.*;
//class Node{
//    int data;
//    Node next;
//    Node(int d){
//        data=d;
//        next=null;
//    }
//
//}
//class Solution
//{
//
//    public static Node removeDuplicates(Node head) {
//        //Write your code here
//        Node cur_el = head;
//
//        while(cur_el != null){
//            while(cur_el.next != null && cur_el.data == cur_el.next.data){
//                Node temp = cur_el.next;
//                cur_el.next = cur_el.next.next;
//                temp.next = null;
//            }
//            cur_el = cur_el.next;
//        }
//
//        return head;
//    }
//
//    public static  Node insert(Node head,int data)
//    {
//        Node p=new Node(data);
//        if(head==null)
//            head=p;
//        else if(head.next==null)
//            head.next=p;
//        else
//        {
//            Node start=head;
//            while(start.next!=null)
//                start=start.next;
//            start.next=p;
//
//        }
//        return head;
//    }
//    public static void display(Node head)
//    {
//        Node start=head;
//        while(start!=null)
//        {
//            System.out.print(start.data+" ");
//            start=start.next;
//        }
//    }
//    public static void main(String args[])
//    {
//        Scanner sc=new Scanner(System.in);
//        Node head=null;
//        int T=sc.nextInt();
//        while(T-->0){
//            int ele=sc.nextInt();
//            head=insert(head,ele);
//        }
//        head=removeDuplicates(head);
//        display(head);
//
//    }
//}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        // Define and put 0 as values
        Integer[] a = new Integer[n];
        
        int num_of_operations = queries.length;

        //main code
        int first_index;
        int last_index;
        int summand;
        int k;
        int max = a[0];
        for(int i=0;i<num_of_operations; ++i){

            first_index = queries[i][0] -1;
            last_index = queries[i][1] -1;
            summand = queries[i][2];

            k = first_index;
            while(k <= last_index){
                a[k] += summand;
                if(max < a[k])
                    max = a[k];
                k++;
            }
        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner bufferedWriter = new Scanner(System.in);

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(String.valueOf(result));


        bufferedWriter.close();

        scanner.close();
    }
}
