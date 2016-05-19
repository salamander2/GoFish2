package goFish;

import java.util.ArrayList;

abstract class Player
{
	protected ArrayList<Card> hand = new ArrayList<Card>();
	private int numBooks;

	public Player()
	{
		for(int imill=0;imill<8;imill++)
			fish();
	}

	public boolean hasGiven(Card cType)
	{
		return hand.contains(cType);
	}

	public ArrayList<Card> giveAll(Card cType)
	{
		ArrayList<Card> x = new ArrayList<Card>(); 
		for(int imill=0;imill<hand.size();imill++)            
			if (hand.get(imill) == cType)
				x.add(hand.get(imill));
		for(int cancun=0;cancun<x.size();cancun++)
			hand.remove(cType);
		return x;
	}

	protected boolean askFor(Card cType)
	{
		int tmp = 0;
		if (this instanceof HumanPlayer)
			tmp = 1;
		Player other = GoFishTrial2.Players[tmp];

		//Used for the computer's strategy//
		if (tmp==1)
			((AIPlayer) other).queries.add(cType);


		if (other.hasGiven(cType))
		{
			for(Card c: other.giveAll(cType))
				hand.add(c);
			return true;
		}
		else
		{
			return false;
		}
	}

	protected void fish()
	{
		if (GoFishTrial2.deckSize() > 0)
			hand.add(GoFishTrial2.draw());
		else
			System.out.println("That is impossible since your inevntory is depleted!");
	}

	public int getNumBooks()
	{
		return numBooks;
	}

	protected Card checkForBooks()
	{
		for(Card c: hand) 
		{
			int num = 0;
			for(Card d: hand)
				if (c == d)
					num++;
			if (num == 4)
			{
				for(int imill=0;imill<4;imill++)
					hand.remove(c);
				numBooks++;
				return c;
			}
		}
		return null;


	}

	public abstract void haveTurn();

}

