
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;


/**
 *
 * @author AyKo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* We implement Double Queue List */
        myQueue<myQueue> listQueueForReverseQueue = new myQueue<myQueue>();
        myQueue<myQueue> listQueueForReverse=new myQueue<myQueue>();

        /* read csv file into Queue into Queue */
        try {
            Scanner sc = new Scanner(new File("test.csv"));
            while (sc.hasNext()) {
                String arr[]=sc.next().split(",");

                myQueue<Object> temp = new myQueue<Object>();
                myQueue<Object> temp2 = new myQueue<Object>();
                listQueueForReverseQueue.add(temp);
                listQueueForReverse.add(temp2);
                for (int i = 0; i < arr.length; i++) {
                    temp.add(arr[i]);
                    temp2.add(arr[i]);
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Open Err "+e.toString());
        }


        /* 1=) reverse method TEST */
        listQueueForReverse.reverse();
        int sizeQueueList=listQueueForReverse.size();
        for (int i = 0; i < sizeQueueList; i++) {
            listQueueForReverse.get(i).reverse();
        }

        /* @TEST Tekrar Tersini aliyor mu */
        listQueueForReverse.reverse();
        listQueueForReverse.reverse();

        /* 2=) reverseQueue TEST */
        listQueueForReverseQueue.reverseQueue(listQueueForReverseQueue);

        sizeQueueList=listQueueForReverseQueue.size();
        for (int i = 0; i < sizeQueueList; i++) {
            listQueueForReverseQueue.get(i).reverseQueue(listQueueForReverseQueue.get(i));
        }

        /* @TEST Tekrar Tersini aliyor mu */
        listQueueForReverseQueue.reverseQueue(listQueueForReverseQueue);
        listQueueForReverseQueue.reverseQueue(listQueueForReverseQueue);

        /* DoubleQueueToString with poll ( it made clean queue ) */
        String output = doubleQueueToString(listQueueForReverse);
        output += doubleQueueToString(listQueueForReverseQueue);




        fileWriter("testResult_2.csv",output);

    }
    public static String doubleQueueToString(Queue<myQueue> listQueue)
    {
        String output="";
        int listSize=listQueue.size();
        for (int i = 0; i < listSize; i++) {
            Queue temp=listQueue.poll();
            int queueSize=temp.size();
            output+=temp.poll();
            for (int j = 1; j < queueSize; j++) {
                output+=","+temp.poll();
            }
            output+="\n";
        }
        return output;
    }

    // File Writer Function
    public static boolean fileWriter(String fileName,String text)
    {
        BufferedWriter bufferWriter=null;
        try
        {
            FileWriter fileWriter = new FileWriter(fileName);
            bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(text);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("For Write Operation File couldnt create or it is in use");
        }
        catch (IOException e)
        {
            System.out.println("For Write Operation IO Exception");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (bufferWriter != null) {
                try {
                    bufferWriter.close();
                }
                catch (IOException e) {
                    System.out.println("For Write Operation File couldnt close");
                }
            }
            return true;
        }
    }


}
