import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author AyKo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<StackInterface> listStacks= new ArrayList<StackInterface>();

        try {

            Scanner sc = new Scanner(new File("test.csv"));

            while (sc.hasNext()) {
                String arr[]=sc.next().split(",");
                StackInterface<Object> stackA = new StackA<Object>();
                StackInterface<Object> stackB = new StackB<Object>();
                StackInterface<Object> stackC = new StackC<Object>();
                StackInterface<Object> stackD = new StackD<Object>();

                listStacks.add(stackA);
                listStacks.add(stackB);
                listStacks.add(stackC);
                listStacks.add(stackD);

                for (int i = 0; i < arr.length; i++) {
                    stackA.push(arr[i]);
                    stackB.push(arr[i]);
                    stackC.push(arr[i]);
                    stackD.push(arr[i]);
                }
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Open Err "+e.toString());
        }

        String output="";
        for (int i = 0; i < listStacks.size(); i++) {

            int sizeStack =listStacks.get(i).size();
            output+=sizeStack;
            for (int j = 0; j < sizeStack; j++) {
                output+=","+listStacks.get(i).pop();
            }
            output+="\n";
        }
        fileWriter("testResult_1.csv",output);






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
            bufferWriter.close();
            return true;
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
        }
        return false;
    }

}
