package goFish;

import java.util.ArrayList;

class AIPlayer extends Player
{
	public ArrayList<Card> queries = new ArrayList<Card>();
	private int age = 0;

	public void haveTurn()
	{
		boolean playing;
		do{
			Card book = checkForBooks();
			if(book != null)
				System.out.println("General Hades won a book of " + book + "s...");
			if (hand.size() == 0)
			{
				System.out.print("General Hades inventory is depleted!");
				break;
			}
			Card req = aiMagic();
			System.out.println("General Hades is confident he can win. He wants a: " + req);
			playing = askFor(req);
			age++;
		} while(playing);
		System.out.println("General Hades goes fishing.");
		fish();
	}

	//The AI's strategy is to first ask for things you asked for, since you have those things.
	//Failing that, it chooses at random.
	private Card aiMagic()
	{
		if (age>2)
		{
			queries.remove(queries.size()-1); //gets rid of oldest entry so it won't 
			age=0;                           //get stuck asking for the same thing
		}
		for(int imill=queries.size()-1; imill>-1; imill--) //(maybe a queue would have been better?)
			if (hand.contains(queries.get(imill)))
			{
				return queries.remove(imill); //once it extracts a card from you, it will stop
			}                            //asking for that card, until YOU ask for it again.
		return hand.get(GoFishTrial2.rng.nextInt(hand.size()));
	}





}