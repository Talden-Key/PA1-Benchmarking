import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Benchmark{
    public static int MaximumNumber;
    public static int MinimunNumber;
    public static int MedianNubmer;
    public static LinkedList<Integer> list;
    public static int num;

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
    
    // Create a LinkedList
    list = new LinkedList<>();
  
    // Read all the number in file
    while (scan.hasNextInt()) {
        Integer num = scan.nextInt();
        
        //find min 
        MinimunNumber = findMin(num);
        //find max
        MaximumNumber = findMax(num);
    
    // if the head is empty than add
    if (list.peek() == null || list.peek() >= num ) {
    list.add(num);
    list.add(null);
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
    int size = list.size()-1;
    int leftMidIndex = list.get(size/2);
    int rightMidIndes = list.get(size/2 +1);
    int median;
    if (size%2 == 0) {
        median = (leftMidIndex + rightMidIndes)/2;
    }else {
        median = list.get(size/2);
    }
    MedianNubmer = median;
    System.out.println(list);
    System.out.println(MinimunNumber);
    System.out.println(MaximumNumber);
    System.out.println(MedianNubmer);
    
    
}

/*  add number from file to LinkedList in sorted order
public static void addToLinkedList( Integer num) {
}*/

// Find Min value
public static int findMin(int num) {
    int min = 100000000;
    if ( num < min) {
        min = num;
    }
return min;
}
// Find Max value
public static int findMax(int num) {
    int max =0;
    if (num > max) {
        max = num;
    }
    return max;
}

// Find Median Value
// =====> median <======
public static int findMedian(LinkedList list) {
    
    return 0;
}

//Find the time  it take to insert, min , max, median.



}
