import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Benchmark{
    // Create a linkedlist
    public static LinkedList<Integer> list;
    public static int num;
    // Min, Max, Median data
    public static int MaximumNumber;
    public static int MinimunNumber;
    public static int MedianNubmer;
    // Time to complete each task
    public static long startTime;
    public static long endTime;
    public static long insertTask;
    public static long findMaxTask;
    public static long findMinTask;
    public static long findMedianTask;

public static void main(final String[] args) {
    File file = null;
    Scanner scan = new Scanner(System.in);

    // take file name from the command line or ask the user input
    if (0 < args.length) {
        file = new File(args[0]);
    } else {
        // prompting the user to enter a file name
        System.err.println("Invalid arguments count:" + args.length);
        System.out.println("Enter the name of the file");
        file  = new File(scan.next());
        System.exit(0);
    }

    // Read the file
    try{
        scan = new Scanner(file);
    }catch (FileNotFoundException ex){
        System.out.println("Please restart the program and try again");
    }
    
    // Record time for insert task.
    startTime = System.currentTimeMillis();
    // Create a LinkedList
    list = new LinkedList<>();
    // Read all the number in file
    while (scan.hasNextInt()) {
        Integer num = scan.nextInt();
        
    // if the head is empty than add
    if (list.peek() == null || list.peek() >= num ) {
        if(list.peek() == null){
            list.add(null);
        }
    list.addFirst(num);
    }else {
        // tranverse through the list and compare with each element
        int position = 0;
        while( list.get(position) != null && num > list.get(position)) {
            // if the next node is null then add num.
            if (list.get(position+1) == null && num > list.get(position)){
                list.set(position+1, num);
                list.add(null);
                position = list.size()-1;
            // if number is less than number in the list squeeze in 
            } else if (num <= list.get(position+1)){
                list.add(position+1, num);
                position = list.size()-1;
            }else {
                 position++;
            }
        }
    }
    }
    // end Record and find task time.
    endTime = System.currentTimeMillis();
    insertTask = endTime - startTime;


    // record time for finding Median
    startTime = System.currentTimeMillis();
    // declare variable to help find Median
    int size = list.size()-1;
    int leftMidIndex = list.get(size/2);
    int rightMidIndes = list.get(size/2 +1);
    int median;
    // If the linkedlist size is odd then the middle number is median.
    if (size%2 == 0) {
        median = (leftMidIndex + rightMidIndes)/2;
    }else {
        median = list.get(size/2);
    }
    MedianNubmer = median;
    // end Record and find task time.
    endTime = System.currentTimeMillis();
    findMedianTask = endTime - startTime;


    // Record time to find Max
    startTime = System.currentTimeMillis();
    int min = 100000000;
    num = 0;
    while(list.get(num) != null){
        if ( list.get(num) < min) {
            MinimunNumber = list.get(num);
        }
        num++;
    }
    //Calculate the time
    endTime = System.currentTimeMillis();
    findMinTask = endTime - startTime;


    // Record time to find Min
    startTime = System.currentTimeMillis();
    int max = 100000000;
    num=0;
    while(list.get(num) != null){
        if ( list.get(num) < min) {
            MaximumNumber = list.get(num);
        }
        num++;
    }
    //Calculate time.
    endTime = System.currentTimeMillis();
    findMaxTask = endTime - startTime;

    // print out
    System.out.println(list);
    System.out.println("The smallest number is " + MinimunNumber);
    System.out.println("The biggest number is " + MaximumNumber);
    System.out.println(" The Median number is " + MedianNubmer);
    System.out.println("The time it took to insert all the number is " + insertTask);
    System.out.println("The time it took to find Max is " + findMaxTask);
    System.out.println("The time it took to find Min is " + findMinTask);
    System.out.println("The time it took to find Median is " + findMedianTask);
    System.out.println("All the time is in Milisecond");

    
    
}

}
