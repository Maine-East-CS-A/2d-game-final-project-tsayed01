public class Board {
   private String[][] board;
   public static final String ANSI_RED = "\u001B[31m";
   public static final String ANSI_BLUE = "\u001B[34m";
   public static final String ANSI_RESET = "\u001B[0m";
   public static final String X = ANSI_RED + "X" + ANSI_RESET;
   public static final String O = ANSI_BLUE + "O" + ANSI_RESET;
   private static int counter = 0;

   public Board(String[][] b){
       board = b;
   }


   public boolean isSpaceAvailable(int row, int col){
       if (board[row][col].equals("|")){
           return true;
       }
       return false;
   }


   public void set(int row, int col, String piece){
        if(isSpaceAvailable(row, col) && piece.equals("X")){
           board[row][col] = X;
           counter++;
       }
	    if(isSpaceAvailable(row, col) && piece.equals("O")){
           board[row][col] = O;
           counter++;
       }
   }
   

   public String verticalWin(){
    int xcount = 0;
    int ocount = 0;
        for (int c = 0; c < board[0].length; c++) {
            xcount = 0;
            ocount = 0;
            for (int r = 0; r < board.length; r++) {
                if(board[r][c].equals(X))
                    xcount++;
                if(board[r][c].equals(O))
                    ocount++;
            }
            if(xcount == 3)
                return X;
            if(ocount == 3)
            return O;
        }
        return "";
   }

   public String horizontalWin(){
        int xcount = 0;
        int ocount = 0;
	    for(int r = 0; r < board.length; r++){
	        xcount = 0;
            ocount = 0;
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c].equals(X))
                    xcount++;
                if(board[r][c].equals(O))
                    ocount++;
            }
            if(xcount == 3)
                return X;
            if(ocount == 3)
                return O;
        }
        return "";
   }

   public String diagonalWin(){
        if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[2][2].equals(X))
            return X;
        if(board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && board[2][0].equals(X))
            return X;
        if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && board[2][2].equals(O))
            return O;
        if(board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && board[2][0].equals(O))
            return O;
        return "";
    }

    public int isThereAWinner(){
        if(horizontalWin().equals(X) || verticalWin().equals(X) || diagonalWin().equals(X)){
            return 1;
        }
        if(horizontalWin().equals(O) || verticalWin().equals(O) || diagonalWin().equals(O)){
            return 2;
        }
        return 0;

   }

   public boolean isThereATie(){
        if(counter == 9 && isThereAWinner() == 0)
            return true;
        return false;

   }



}

