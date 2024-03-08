import java.util.Scanner;

/**
 * The class is a user interface that uses the binary search tree 
 */
public class UserInterfaceBST{

   /**
    * The main method that runs the user interface
    * @param args args Command-line arguments.
    */
   public static void main(String[] args){
      
      Scanner scanner = new Scanner(System.in);
      int choice;
      GenericsKbBSTApp results = null;
      do{
         System.out.println("");
         System.out.println("Choose an action from the menu:");
         System.out.println("1. Load a knowledge base from a file");
         System.out.println("2. Add a new statement to the knowledge base");
         System.out.println("3. Search for an item in the knowledge base by term");
         System.out.println("4. Search for a item in the knowledge base by term and sentence");
         System.out.println("5. Quit");
         System.out.print("Enter your choice: ");
         
         choice = scanner.nextInt();
         scanner.nextLine();
         System.out.println("");
         switch (choice) {
         case 1 : 
               System.out.print("Enter file name: ");
               String files = scanner.nextLine();
               System.out.println("");
               results =  new GenericsKbBSTApp(files);
               break;

            
          case 2:
               System.out.print("Enter the term: ");
               String term = scanner.nextLine();
            
               System.out.print("Enter the statement :");
               String sen = scanner.nextLine();
            
               System.out.print("Enter the confidence score: ");
               String score = scanner.next();
               System.out.println("");
               results.addStatements(term,sen,Float.parseFloat(score));
               break;
   

         case 3:
            System.out.print("Enter the term to search: ");
            String choices = scanner.nextLine();
            System.out.println("");
            results.displaySentence(choices);
            break;
 
         case 4:
            System.out.print("Enter the term: ");   
            String terms = scanner.nextLine();
            System.out.print("Enter the statement to search for:");
            String sens = scanner.nextLine();
            System.out.println("");
            results.displayScore(terms,sens);
            break;
            
        case 5:
            System.out.print("Quit");
            break;
       }  
      }while(choice != 5);
      scanner.close();                     
   }     
}