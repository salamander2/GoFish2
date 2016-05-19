package goFish;
import java.util.Scanner;

class HumanPlayer extends Player
{
	public void haveTurn()
	{
		Scanner scn = new Scanner(System.in);
		boolean playing = true;
		do{
			Card book = checkForBooks();
			if(book != null)
				System.out.println("You have successfully won a book of " + book + "s!");

			if (hand.size() == 0)
			{
				System.out.print("Your inventory is depleted, you must "); //Go fish
				break;
			}
			else
			{
				System.out.println("Your current weaponry inventory: ");
				for(Card c: hand)
					System.out.print(c + " ");
				System.out.println();
			}

			System.out.println("Ask General Hades for what weapon?");

			Card req;
			try{
				req = Card.valueOf(scn.next().toUpperCase());
			}
			catch(IllegalArgumentException e){ //If what you said is not in Card
				System.out.println("You don't have anymore of this weapon!. Try again:");
				continue;
			}

			if(!hand.contains(req))
			{
				System.out.println("You can't ask for inventory that you dont have! Try again:");
				continue;
			}

			System.out.println("You ask for a " + req);
			playing = askFor(req); //If you get card(s), askFor returns true and loops
		} while(playing);
		System.out.println("Go fish!");
		fish();
	}
}
