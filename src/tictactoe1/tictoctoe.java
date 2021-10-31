package tictactoe1;

import java.util.Random;
import java.util.Scanner;

public class tictoctoe {

	static char[] board = new char[10];
	private static char cross = 'X';
	private static char circle = 'O';
	private static char playerSymbol;
	private static char computerSymbol;
	private static int toss = 0;
	private static int turn = 0;




	public static char[] creatingBoard() {
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}

	private static void allowPlayerToChoose() {
		System.out.println("Enter the symbol X or O you want to choose");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		playerSymbol = input.charAt(0);
		if (playerSymbol == cross) {
			playerSymbol = cross;
			computerSymbol = circle;
			System.out.println("player symbol is : " + playerSymbol);

		} else if (playerSymbol == circle) {
			playerSymbol = circle;
			computerSymbol = cross;
			System.out.println("player symbol is : " + playerSymbol);

		} else {
			System.out.println("Invalid input");
			allowPlayerToChoose();
		}
	}


	public static void showBoard() {
		System.out.println(" board looks like :");
		System.out.println("");
		System.out.println("   " + board[1] + "   " + "|" + "   " + board[2] + "   " + "|" + "   " + board[3] + "   ");
		System.out.println("  -------------------");
		System.out.println("   " + board[4] + "   " + "|" + "   " + board[5] + "   " + "|" + "   " + board[6] + "   ");
		System.out.println("  -------------------");
		System.out.println("   " + board[7] + "   " + "|" + "   " + board[8] + "   " + "|" + "   " + board[9] + "   ");
	}

	public static void userMove() {
		System.out.println("Enter the empty position(between 1-9) where you wants to make the move ");
		Scanner sc = new Scanner(System.in);
		int position = sc.nextInt();
		if (position >= 1 && position <= 9)
		{
			if (board[position] == ' ') {
				System.out.println("position  : " + position + " is empty");
				board[position] = playerSymbol;
				showBoard();
			} else {
				System.out.println("Invalid move, position is not empty");
			}
		} else {
			System.out.println("You entered a invalid position");
		}
		turn = 1;
		System.out.println("Computer's turn");
	}
	public static void computerMove() {
		Random random = new Random();
		int compPlay = random.nextInt(10);   
		if (compPlay >= 1 && compPlay <= 9 && board[compPlay] == ' '  )
		{
			if (board[compPlay] == ' ') {

				board[compPlay] = circle;
				showBoard();
			} else {
				System.out.println("Invalid move, position is not empty");
			}
		} else {
			computerMove();
		}
		turn = 0;
		System.out.println("Player's turn");

	}


	public static int doToss()
	{
		int tossResult = (int) Math.floor(Math.random() * 10) % 2;
		if(tossResult == 0)
		{
			System.out.println("User-Player plays first");
		}
		else
		{
			System.out.println("Computer plays first");
		}
		return tossResult;

	}


	public  static void turnUntilWeGetWinner()
	{
		char symbol = ' ';

		if(toss == 0)
		{
			userMove();
			turn =1;
		}
		else
		{
			computerMove();
			turn = 0;
		}

		boolean winnerFound = false;
		while(winnerFound != true)
		{
			if(turn == 0)
			{
				userMove();
				symbol = playerSymbol;
			}
			else
			{
				computerMove();
				symbol = computerSymbol;
			}
			winnerFound = checkWinningCondition(symbol);

			/*
			 * if all the boards position are fill and no one win then its a tie
			 */
			if(board[1]!=' '  &&  board[2]!=' ' && board[3]!=' ' && board[4]!=' ' && board[5]!=' '&& board[6]!=' '&&
					board[7]!=' '&& board[8]!=' '&& board[9]!=' ' && winnerFound !=true)
			{
				System.out.println("It is a tie , no one won");
				break;
			}
		}
		if(symbol==playerSymbol)
		{
			System.out.println("Player won");
		}
		else
		{
			System.out.println("Computer won");
		}
	}



	public  static boolean  checkWinningCondition(char symbol)
	{
		boolean gotWinner = false;
		if(board[1] == symbol && board[2]==symbol &&board[3]==symbol)
		{
			gotWinner =true;
		}
		if(board[4] == symbol && board[5]==symbol &&board[6]==symbol)
		{
			gotWinner =true;
		}
		if(board[7] == symbol && board[5]==symbol &&board[9]==symbol)
		{
			gotWinner =true;
		}
		if(board[1] == symbol && board[4]==symbol &&board[7]==symbol)
		{
			gotWinner =true;
		}
		if(board[2] == symbol && board[5]==symbol &&board[8]==symbol)
		{
			gotWinner =true;
		}
		if(board[3] == symbol && board[6]==symbol &&board[9]==symbol)
		{
			gotWinner =true;
		}
		if(board[1] == symbol && board[5]==symbol &&board[9]==symbol)
		{
			gotWinner =true;
		}
		if(board[3] == symbol && board[5]==symbol &&board[7]==symbol)
		{
			gotWinner =true;
		}
		return gotWinner;
	}
	public static void main(String args[]) {
		System.out.println("Welcome to TicTacToe Board Game");
		board = creatingBoard();
		allowPlayerToChoose();
		showBoard();
		toss = doToss();
		turnUntilWeGetWinner();
	}
}
