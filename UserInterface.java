import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;

public class UserInterface{
   public static void main(String[] args){
      
      Scanner scanner = new Scanner(System.in);
      int choice;
      do{
         System.out.println("Choose an action from the menu:");
         System.out.println("1. Load a knowledge base from a file");
         System.out.println("2. Add a new statement to the knowledge base");
         System.out.println("3. Search for an item in the knowledge base by term");
         System.out.println("4. Search for a item in the knowledge base by term and sentence");
         System.out.println("5. Quit");
         System.out.print("Enter your choice: ");
      
         choice = scanner.nextInt();
      
         switch(choice)
         {    
            case 1:   
               System.out.print("Enter file name:");
               String files = scanner.nextLine();

               try
               {
                  File file = new File(files);
                  Scanner FileIN= new Scanner(new FileInputStream(file));
                  GenericsKbArrayApp add = new GenericsKbArrayApp();
                  add.ArrayFile(files);

               }    
               catch(FileNotFoundException e)
               {  
               System.out.print("File not found");
               System.exit(0);
               }  
            
            case 2:
               System.out.print("Enter the term:");
               String term = scanner.nextLine();
            
               System.out.print("Enter the statement:");
               String sen = scanner.nextLine();
            
               System.out.print("Enter the confidence score:");
               float score = scanner.nextFloat();
            
               GenericsKbArrayApp Line = new GenericsKbArrayApp();
               Line.addStatements(term,sen,score,file);
            
               System.out.print("Statement for term " + term + " has been updated.");

            case 3:
               System.out.print("Enter the term to search: ");
               String choices = scanner.nextLine();
               GenericsKbArrayApp add = new GenericsKbArrayApp();
               add.displaySentence(choices,files);
            
            case 4:
               System.out.print("Enter the term: ");   
               String terms = scanner.nextLine();
               System.out.print("Enter the statement to search for:");
               String sens = scanner.nextLine();
               GenericsKbArrayApp adds = new GenericsKbArrayApp();
               adds.displayScore(terms,sens,files);
            
            case 5:
               System.out.print("Quit");
            }      
      
      }while(choice != 5);                          
   }          
}