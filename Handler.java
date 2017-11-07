import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Handler {
    String filename="C:\\Users\\Antony\\Documents\\test.txt";
    public  List<String> ReadInput() throws IOException
    {
        List<String> lines = Files.readAllLines(Paths.get(filename));
//        for(String line : lines)
//            System.out.println(line);
       return lines;
    }
    
    public void WriteDataSource() throws IOException
    {
        List<String> dataSource=ReadInput();
        String facts="";
        for(String entry:dataSource)
        {
            if(entry.length()!=0)
            facts =facts +entry+"\n";
        }
        
        
        System.out.println("Enter the Animal Name");
        Scanner reader = new Scanner(System.in);  
        String animalName = reader.nextLine(); // Scans the next token of the input as an int.
        String questions="";
        String input ="";
        String fact=animalName+"=";
        do
        {
            if(!questions.equals(""))
                questions=questions+",";
            System.out.println("Enter the fact about the animal");
            reader = new Scanner(System.in);  
            String question = reader.nextLine(); // Scans the next token of the input as an int.
            questions=questions+question;
            
            System.out.println("Enter Y to continue adding facts and N to exit");
             input = reader.nextLine(); // Scans the next token of the input as an int.
            

            
            
        }while(input.equalsIgnoreCase("Y"));
        fact=fact+questions+"\n";

        facts=facts+fact;
        try(  PrintWriter out = new PrintWriter( filename )  ){
            out.println( facts );
        }
        

        System.out.println("The animal has been successfully added to datastore");
        System.exit(0);     
    }
    
}