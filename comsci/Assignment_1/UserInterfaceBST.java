import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;

public class UserInterfaceBST{
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
         
         if(choice == 1){ 
               System.out.print("Enter file name:");
               String files = scanner.nextLine();

               try
               {
                  File file = new File(files);
                  Scanner FileIN= new Scanner(new FileInputStream(file));
                  GenericsKbBSTApp<Objects> add = new GenericsKbBSTApp<>(files);
                  FileIN.close();
                  System.out.println("Knowledge base loaded successfully ");
               }  

               catch(FileNotFoundException e)
               {  
               System.out.print("File not found");
               System.exit(0);
               }  
         }     
            
         else if(choice ==2){
               System.out.print("Enter the term:");
               String term = scanner.nextLine();
            
               System.out.print("Enter the statement:");
               String sen = scanner.nextLine();
            
               System.out.print("Enter the confidence score:");
               float score = scanner.nextFloat();
            
               GenericsKbBSTApp<Objects> Line = new GenericsKbBSTApp<>();
               Line.addStatements(term,sen,score);
            
               //System.out.print("Statement for term " + term + " has been updated.");
         }     

         else if(choice ==3){
            System.out.print("Enter the term to search: ");
            String choices = scanner.nextLine();
            GenericsKbBSTApp<Objects> add = new GenericsKbBSTApp<>();
            add.displaySentence(choices);
            }  
            
         else if(choice ==4){
            System.out.print("Enter the term: ");   
            String terms = scanner.nextLine();
            System.out.print("Enter the statement to search for:");
            String sens = scanner.nextLine();
            GenericsKbBSTApp<Objects> adds = new GenericsKbBSTApp<>();
            adds.displayScore(terms,sens);
         }  
            
         else if(choice ==5){
            System.out.print("Quit");
            }     
      }while(choice != 5);
      scanner.close();                     
   }     
}