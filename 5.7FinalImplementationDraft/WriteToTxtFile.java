import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Write to text file
 */
public class WriteToTxtFile
{
    public static void main(String [] args)
    {
        String myFile = "RawData.txt";
        try{
            FileWriter write = new FileWriter(myFile);
            PrintWriter print_line = new PrintWriter(write);
            print_line.printf("%s" + "%n", "Testing write to a file");
           
        print_line.close();
        }
        catch (IOException e) { System.out.println("It doesn't work");
        
        
        }
    }
}
