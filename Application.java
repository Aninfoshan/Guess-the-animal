import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Application {

    static HashMap<String,List<String>> animalList=new HashMap<String,List<String>>();
    public static void main(String args[]) throws IOException
    {
        
        Scanner reader = new Scanner(System.in);  
        System.out.println("Please Select an Option \n 1.Play Guess the Animal \n 2.Add Value to dataStore");
        
        while(true)
        {
        int option = reader.nextInt();
        if(option ==1)
        {            Handler handler =new Handler();

            List<String> Input=handler.ReadInput();
            for(String value : Input)
            {
                if(value.trim().length()!=0)
                {
                String tmp[]=value.split("=");
               

                String tmp_questions[]=tmp[1].trim().split(",");
                List<String> tmp_list=new ArrayList<String>();
                for (String entry:tmp_questions)
                {
                    tmp_list.add(entry);
                }
                animalList.put(tmp[0],tmp_list);
                }
                
            }
            System.out.println("Please think of an animal from the following list and press Enter key ");
            for(String entry : animalList.keySet())
            {
                System.out.println(entry);
            }
            String n1 = reader.nextLine(); // Scans the next token of the input as an int.
            //once finished
            
            for(String entry : animalList.keySet())
            {
                List<String> tmp=new ArrayList<String>();
                tmp=animalList.get(entry);
                System.out.println("Enter Y/N for the following questiosn");
                int current_index=0;
                int last_index=0;
                String n ="";
                for (String value:tmp)
                {
                    last_index=tmp.size();
                    current_index++;
                    System.out.println(value);
                    while (true)
                    {
                    n = reader.nextLine(); // Scans the next token of the input as an int.
                    
                    if(n.trim().equalsIgnoreCase("Y"))
                    {
                        if(current_index>=last_index)
                        {
                            System.out.println("Yes, Correct.The Animal You guessed is " + entry);
                            System.exit(0);
                        }
                        
                        break;
                    }
                    else if(n.trim().equalsIgnoreCase("N")&&current_index>1)
                         
                    {
                        System.out.println("Cannot Guess Animal");
                        System.exit(0);
                    }    
                    else if(!n.trim().equalsIgnoreCase("N"))
                    {
                        System.out.println("Please Enter only Y/N");
                        break;
                    }
                    else
                    {
                        break;
                    }
                    }
                    if(n.trim().equalsIgnoreCase("N"))                {
                        break;
                    }

                }
            }
        }
        else if(option==2)
        {
            Handler handler =new Handler();
            handler.WriteDataSource();
        }
        
        }
        
        
        
    }
}
