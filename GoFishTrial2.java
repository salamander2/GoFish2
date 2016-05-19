package goFish;

import java.util.ArrayList; 
import java.util.Scanner;  
import java.util.Random;
import java.awt.*;
import javax.swing.*;

class GoFishTrial2
{
	
	
	static final Random rng = new Random();
	static private ArrayList<Card> cards;
	static public Player[] Players;

	public static Card draw()
	{
		return cards.remove(rng.nextInt(cards.size()));
	}

	public static int deckSize()
	{
		return cards.size();
	}

	public static void main(String[] args)
	{
		System.out.println("  Sounds of sorrow and lament echo throughout the plains.");
		System.out.println("  Tensions are at the edges as imminent doom is present.");
		System.out.println("  General Hades and you are facing off in an epic battle for the ages.");
		System.out.println("  Your nation of Pagnotti is severly dependent on the victory here.");
		System.out.println("  This battle determines who receives the port of Dumesville.");

		cards = new ArrayList<Card>();
		for(int imill=0;imill<4;imill++)
			for(Card weapons: Card.values())
				cards.add(weapons);
		Player Us = new HumanPlayer();
		Player Hades = new AIPlayer();
		Players = new Player[] {Us, Hades};

		while(Players[0].getNumBooks() + Players[1].getNumBooks() < 13)
		{
			Players[0].haveTurn();
			System.out.println("----------");
			Players[1].haveTurn();
			System.out.println("----------");
		}

		int yScore = Players[0].getNumBooks(); int aiScore = Players[1].getNumBooks();
		if (yScore > aiScore)
			System.out.println("Congratulations, you have defended Pagnotti's honor!"+ yScore + " to "+ aiScore +"!");
		else if (aiScore > yScore)
			System.out.println("General Hades has won! Pagnotti is devastated by your inability to win."+ yScore + " to "+ aiScore +"...");
		else
			System.out.println("The war is at the edges, and both sides have decided on a draw "+yScore+" each!");
	}
}