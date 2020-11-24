public class BoardHelper {
	public String evaluateBoard(String[] gameBoard, String turn) {

    	String[][] board = new String[3][3];
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
        		board[i][j] = gameBoard[i*3+j]; //fix
        	}
    	}

    	//ROW
        for( int i = 0; i < 3; i++ ) {
            if(board[i][0] == turn && board[i][1] == turn && board[i][2] == turn){
                return turn;
            }
            
        }
        
        //COLUMN
        for( int j = 0; j < 3; j++ ) {
            if( board[0][j] == turn && board[1][j] == turn && board[2][j] == turn) {
                return turn;
            }
            
        }
        
        //DIAGONAL
        if( board[0][0] == turn  && board[1][1] == turn  && board[2][2] == turn  ) {
        	return turn;        	
        }
        
      
        if( board[0][2] == turn  && board[1][1] == turn  && board[2][0] == turn ) {
        	return turn;        	
        }
            
        
        int gc = 0;

        //DRAW
        for( int i = 0; i < 3; i++ ){
            for( int j = 0; j < 3; j++ ) {
                if( board[i][j] != "b" )
                    gc++;

                if( gc == 9 )
                    return "D";
            }
        }
        
        return "";
    }
}
