import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;

class MyTest {

	@Test
	void test1() {
		String[] board = {"b","b","b","b","b","b","b","b","b"};
		AI_MinMax newAIPrediction = new AI_MinMax(board);
		ArrayList<Integer> movesList = newAIPrediction.printBestMoves(false);
		
		assertEquals(movesList.size(), 9);
	}
	
	@Test
	void test2() {
		String[] board = {"b","X","b","b","b","b","b","b","b"};
		AI_MinMax newAIPrediction = new AI_MinMax(board);
		ArrayList<Integer> movesList = newAIPrediction.printBestMoves(false);
		
		assertEquals(movesList.size(), 8);
	}
	
	@Test
	void test3() {
		String[] board = {"b","b","b","X","b","b","b","b","b"};
		AI_MinMax newAIPrediction = new AI_MinMax(board);
		ArrayList<Integer> movesList = newAIPrediction.printBestMoves(false);
		String[] board2 = {"b","X","b","b","b","b","b","b","b"};
		AI_MinMax newAIPrediction2 = new AI_MinMax(board2);
		ArrayList<Integer> movesList2 = newAIPrediction2.printBestMoves(false);
		
		assertEquals(movesList.size(), movesList2.size());
	}
	
	@Test
	void test4() {
		String[] board = {"X","X","X","b","b","b","b","b","b"};
		BoardHelper boardHelper = new BoardHelper();
		
		assertEquals(boardHelper.evaluateBoard(board, "X"), "X");
	}
	
	@Test
	void test5() {
		String[] board = {"O","b","b","b","O","b","b","b","O"};
		BoardHelper boardHelper = new BoardHelper();
	
		assertEquals(boardHelper.evaluateBoard(board, "O"), "O");
	}
	
	@Test
	void test6() {
		String[] board = {"O","b","b","O","b","b","O","b","O"};
		BoardHelper boardHelper = new BoardHelper();
	
		assertEquals(boardHelper.evaluateBoard(board, "O"), "O");
	}
	
	@Test
	void test7() {
		String[] board = {"b","b","X","b","X","b","X","b","b"};
		BoardHelper boardHelper = new BoardHelper();
	
		assertEquals(boardHelper.evaluateBoard(board, "X"), "X");
	}
	
	
	@Test
	void test8() {
		String[] board = {"X","O","O","O","X","X","X","O","O"};
		BoardHelper boardHelper = new BoardHelper();
//		X O O
//		O X X
//		X O O
	
		assertEquals(boardHelper.evaluateBoard(board, "O"), "D");
		assertEquals(boardHelper.evaluateBoard(board, "X"), "D");
	}
	
	@Test
	void test9() {
		String[] board = {"X","O","b","O","X","X","X","O","O"};
		BoardHelper boardHelper = new BoardHelper();
//		X O b
//		O X X
//		X O O
	
		assertEquals(boardHelper.evaluateBoard(board, "O"), "");
		assertEquals(boardHelper.evaluateBoard(board, "X"), "");
	}

}
