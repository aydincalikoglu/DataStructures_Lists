import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        LinkedList priorityQueueTest = new LinkedList();

        try {
            Scanner sc = new Scanner(new File("test.csv"));

            while(sc.hasNext()) {
                String[] arr = sc.next().split(",");
                priorityQueueInterface<Object> temp = new PriorityQueueA();
                priorityQueueInterface<Object> temp2 = new PriorityQueueB();
                priorityQueueTest.add(temp);
                priorityQueueTest.add(temp2);

                for(int i = 0; i < arr.length; ++i) {
                    temp.insert(arr[i]);
                    temp2.insert(arr[i]);
                }
            }

            sc.close();
        } catch (FileNotFoundException var7) {
            System.out.println("File Open Err " + var7.toString());
        }

        String output = "";

        for(int j = 0; j < priorityQueueTest.size(); j += 2) {
            int size = ((priorityQueueInterface)priorityQueueTest.get(j)).size();

            int i;
            for(i = 0; i < size; ++i) {
                if(i != 0) {
                    output = output + ",";
                }

                output = output + ((priorityQueueInterface)priorityQueueTest.get(j)).deleteMin();
            }

            output = output + "\n";

            for(i = 0; i < size; ++i) {
                if(i != 0) {
                    output = output + ",";
                }

                output = output + ((priorityQueueInterface)priorityQueueTest.get(j + 1)).deleteMin();
            }

            output = output + "\n";
        }

        fileWriter("testResult_3.csv", output);
    }

    public static boolean fileWriter(String fileName, String text) {
        BufferedWriter bufferWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(text);
        } catch (FileNotFoundException var16) {
            System.out.println("For Write Operation File couldnt create or it is in use");
        } catch (IOException var17) {
            System.out.println("For Write Operation IO Exception");
        } catch (Exception var18) {
            var18.printStackTrace();
        } finally {
            if(bufferWriter != null) {
                try {
                    bufferWriter.close();
                } catch (IOException var15) {
                    System.out.println("For Write Operation File couldnt close");
                }
            }

            return true;
        }
    }
}
