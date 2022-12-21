import java.util.*;
import java.util.*;

public class Guessing {

  public static void main(String[] args) {
    Random Random_number= new Random();
    int right_guess=Random_number.nextInt(100);
    int turns=0;
    Scanner obj=new Scanner(System.in);
    System.out.println("-----------------Number Guessing Game-------------");
    System.out.println("Guess a number between 1 to 100, You will have 10 turns !" );
    System.out.println("best of luck !");
    System.out.println("---------------------------------------------------------");
    
    int guess;
    int i=0;
    boolean win=false;
    while(win==false) {
      guess=obj.nextInt();
      turns++;
    
    if(guess==right_guess) {
      win=true;
    }
    else if(i>8)
    {
      System.out.println("---------------------------------------------------------");
      System.out.println("You loose! the right answer was: "+right_guess);
      System.out.println("---------------------------------------------------------");
      return;
    }
    else if(guess<right_guess)
    {
      i++;
      System.out.println("---------------------------------------------------------");
      System.out.println("Yor Guess is lower than the right guess! Turns left: "+(10-i));
      System.out.println("---------------------------------------------------------");
      

    }
    else if(guess>right_guess)
   {
      i++;
      System.out.println("---------------------------------------------------------");
      System.out.println("Your Guess Is Higher Than The Right Guess! Turns left: "+(10-i));
      System.out.println("---------------------------------------------------------");
      
    }
    
    

  }
    System.out.println("---------------------------------------------------------");
    System.out.println("You won !!!");
    System.out.println("Then number was "+right_guess);
    System.out.println("You used "+turns+" turns to guess the right number");
    System.out.println("Your score is "+((11-turns)*10)+" out of 100");
    System.out.println("---------------------------------------------------------");
    

}
}