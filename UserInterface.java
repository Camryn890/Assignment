import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;

public class UserInterface{
   public static void main(String[] args){
      //fix
      Scanner scanner = new Scanner(System.in);
      System.out.println("Choose an action from the menu:");
      System.out.println("1. Load a knowledge base from a file");
      System.out.println("2. Add a new statement to the knowledge base");
      System.out.println("3. Search for an item in the knowledge base by term");
      System.out.println("4. Search for a item in the knowledge base by term and sentence");
      System.out.println("5. Quit");
      System.out.print("Enter your choice: ");
      
      int choice = scanner.nextInt();
      
      if(choice == 1)
      {       
         System.out.print("Enter file name:");
         String files = scanner.nextLine();
         File file = new File(files);
         Scanner fileIN = null;
         try
         {
            fileIN= new Scanner(new FileInputStream(file));
         }    
         catch(FileNotFoundException e)
         {  
            System.out.println("File not found");
            System.exit(0);
         }
       }   
            
       else if(choice ==2){
         System.out.println("Enter the term:");
         String term = scanner.nextLine();
            
          System.out.println("Enter the statement:");
          String sen = scanner.nextLine();
            
          System.out.println("Enter the confidence score:");
          float score = scanner.nextFloat();
            
          GenericsKbArrayApp Line = new GenericsKbArrayApp();
          Line.addStatements(term,sen,score,file);
            
          System.out.println("Statement for term " + term + " has been updated.");
         }
   }      

     
      
}
   


//where do we open the file??