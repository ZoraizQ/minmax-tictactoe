The source code for this program is located in the src folder. To run as a java project from the command line, you will need to go to that directory to compile and run. javac AI_MinMax.java and then java AI_MinMax

Input:
The input to this program is a string of the format specified in the write up. A 'b' denotes a blank space and a capital X or capital O represent what they are. Proper input is required to run this program, there is not a lot of error checking as the program this would be in would not need to ( a tic tac toe game with a computer opponent). 

Output:
This program assumes that it will be X's turn to move. The program prints out the initial states that can be made from X's next move. It also prints out a min/max value for the resulting state. A value of -1 means it did not result in a win, A 10 is a win for X, a -10 is a win for O and a 0 is a tie.
The last line of output will list all the moves that X should make