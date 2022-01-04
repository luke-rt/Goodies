package finalimplementationdraft;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Write to text file
 */
public class WriteToTxtFile
{
    // WriteToFile(input: String): void, takes in string input and overwrites previous content in file
    public static void WriteToFile(String input)
    {
        String myFile = "FinalImplementationDraft/FinalImplementationDraft/data.txt";
        try{
            FileWriter write = new FileWriter(myFile); 
            PrintWriter print_line = new PrintWriter(write);
            print_line.println(input);
            print_line.close();
            
        }
        catch (IOException e) { System.out.println("It doesn't work");
        
        
        }
    }
}
