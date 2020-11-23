/**
 * This class is used to store a state of a tic tac toe puzzle in the form of a string as well as a min/max value
 * Methods are included to set the min/max value depending on whose turn it is, X or O
 * @author Mark Hallenbeck
 *
 * Copyright© 2014, Mark Hallenbeck, All Rights Reservered.
 *
 */

public class Node {
	
	private String[] state;
	
	private int minMaxValue;
	
	private int movedTo;
	
	Node(String[] stateOfPuzzle, int move)
	{
		state = stateOfPuzzle;
		
		movedTo = move;
		
		minMaxValue = -1;
	}
	
	int getMovedTo()
	{
		return movedTo;
	}
	
	/**
	 * checks for all the ways that O can win and sets minmax to -10. If it is a draw, sets it to 0
	 */
	void setMinMax_for_O()
	{
		
		if(checkForDraw())
			{
				minMaxValue = 0;
			}
		
		if(state[0].equals("O") && state[1].equals("O") && state[2].equals("O")) //horizontal top
		{
			minMaxValue = -10;
		}
		
		if(state[3].equals("O") && state[4].equals("O") && state[5].equals("O"))//horizontal middle
		{
			minMaxValue = -10;
		}

		if(state[6].equals("O") && state[7].equals("O") && state[8].equals("O"))//horizontal bottom
		{
			minMaxValue = -10;
		}

		if(state[0].equals("O") && state[3].equals("O") && state[6].equals("O"))//vert right
		{
			minMaxValue = -10;
		}

		if(state[1].equals("O") && state[4].equals("O") && state[7].equals("O"))//vert middle
		{
			minMaxValue = -10;
		}

		if(state[2].equals("O") && state[5].equals("O") && state[8].equals("O"))//vert left
		{
			minMaxValue = -10;
		}

		if(state[0].equals("O") && state[4].equals("O") && state[8].equals("O"))// diag from top left
		{
			minMaxValue = -10;
		}

		if(state[2].equals("O") && state[4].equals("O") && state[6].equals("O"))// diag from top right
		{
			minMaxValue = -10;
		}

	}
	
	/**
	 * checks for all the ways that X can win and sets minmax to 10. If a draw, sets minmax to 0
	 */
	void setMinMax_for_X()
	{
		if(checkForDraw())
		{
			minMaxValue = 0;
		}
		
		if(state[0].equals("X") && state[1].equals("X") && state[2].equals("X")) //horizontal top
		{
			minMaxValue = 10;
		}
		
		if(state[3].equals("X") && state[4].equals("X") && state[5].equals("X"))//horizontal middle
		{
			minMaxValue = 10;
		}

		if(state[6].equals("X") && state[7].equals("X") && state[8].equals("X"))//horizontal bottom
		{
			minMaxValue = 10;
		}

		if(state[0].equals("X") && state[3].equals("X") && state[6].equals("X"))//vert right
		{
			minMaxValue = 10;
		}

		if(state[1].equals("X") && state[4].equals("X") && state[7].equals("X"))//vert middle
		{
			minMaxValue = 10;
		}

		if(state[2].equals("X") && state[5].equals("X") && state[8].equals("X"))//vert left
		{
			minMaxValue = 10;
		}

		if(state[0].equals("X") && state[4].equals("X") && state[8].equals("X"))// diag from top left
		{
			minMaxValue = 10;
		}

		if(state[2].equals("X") && state[4].equals("X") && state[6].equals("X"))// diag from top right
		{
			minMaxValue = 10;
		}

	}

	void setMinMax(int x)
	{
		minMaxValue = x;
	}
	
	/**
	 * check the state to see if it is a draw (no b's in the string only X and O)
	 * @return true if its a draw, false if not
	 */
	boolean checkForDraw()
	{
		for(int x = 0; x < state.length; x++)
		{
			if(state[x].equals("b"))
			{
				return false;
			}
		}
		
		return true;
	}
	int getMinMax()
	{
		return minMaxValue;
	}
	
	String[] getInitStateString()
	{
		return state;
	}

}
