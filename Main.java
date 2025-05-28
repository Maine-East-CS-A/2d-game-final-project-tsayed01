import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
	String[][] board = new String[3][3];
    for(int r = 0; r < board.length; r++){
        for(int c = 0; c < board[0].length; c++){
            board[r][c] = "|";
        }
    }
	Board b = new Board(board);
	Scanner scan = new Scanner(System.in);


	System.out.println("\nLet’s play Tic-Tac-Toe!");
	System.out.println("\nPlease write in Player 1's name:");
	String name1 = scan.nextLine();
	System.out.println("Please write in Player 2's name:");
	String name2 = scan.nextLine();
	System.out.println();

	int counter = 0;
	while(counter < 9){
		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[0].length; c++){
				System.out.print(board[r][c] + " ");
			}
		System.out.println();
		}
	
		System.out.println("\n" + name1 + "'s Turn:");
		System.out.println("Please enter the row of your move:");
		int row = scan.nextInt();
		if(row != 1 && row != 2 && row != 3){
			System.out.println("\nInvalid input. Please enter a valid value.");
			System.out.println("Please enter the row of your move:");
			row = scan.nextInt();
		}
		System.out.println("Please enter the column of your move:");
		int col = scan.nextInt();
		if(col != 1 && col != 2 && col != 3){
			System.out.println("\nInvalid input. Please enter a valid value.");
			System.out.println("Please enter the column of your move:");
			col = scan.nextInt();
		}
		System.out.println();
		
		if(b.isSpaceAvailable(row-1, col-1) == false){
			System.out.println("This space is already occupied. Please choose another space.");
			System.out.println("Please enter the row of your move:");
			row = scan.nextInt();
			System.out.println("Please enter the column of your move:");
			col = scan.nextInt();
			System.out.println();
		}
		b.set(row-1, col-1, "X");
		counter++;
		
		if(b.isThereAWinner() == 1){
			for(int r = 0; r < board.length; r++){
				for(int c = 0; c < board[0].length; c++){
					System.out.print(board[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println("\n" + name1 + " won!");
			break;
		}
		if(b.isThereAWinner() == 2){
			for(int r = 0; r < board.length; r++){
				for(int c = 0; c < board[0].length; c++){
					System.out.print(board[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println("\n" + name2 + " won!");
			break;
		}
		if(b.isThereATie()){
			System.out.println("It's a tie!");
			break;
		}

		for(int r = 0; r < board.length; r++){
			for(int c = 0; c < board[0].length; c++){
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}

		System.out.println("\n" + name2 + "'s Turn:");
		System.out.println("Please enter the row of your move:");
		row = scan.nextInt();
		if(row != 1 && row != 2 && row != 3){
			System.out.println("\nInvalid input. Please enter a valid value.");
			System.out.println("Please enter the row of your move:");
			row = scan.nextInt();
		}
		System.out.println("Please enter the column of your move:");
		col = scan.nextInt();
		if(col != 1 && col != 2 && col != 3){
			System.out.println("\nInvalid input. Please enter a valid value.");
			System.out.println("Please enter the column of your move:");
			col = scan.nextInt();
		}
		System.out.println();
		
		if(b.isSpaceAvailable(row-1, col-1) == false){
			System.out.println("Please choose another space");
			System.out.println("Please enter the row of your move:");
			row = scan.nextInt();
			System.out.println("Please enter the column of your move:");
			col = scan.nextInt();
			System.out.println();
		}
		b.set(row-1, col-1, "O");
		counter++;

		
		if(b.isThereAWinner() == 1){
			for(int r = 0; r < board.length; r++){
				for(int c = 0; c < board[0].length; c++){
					System.out.print(board[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println("\n" + name1 + " won!");
			break;
		}
		if(b.isThereAWinner() == 2){
			for(int r = 0; r < board.length; r++){
				for(int c = 0; c < board[0].length; c++){
					System.out.print(board[r][c] + " ");
				}
				System.out.println();
			}
			System.out.println("\n" + name2 + " won!");
			break;
		}
		if(b.isThereATie()){
			System.out.println("It's a tie!");
			break;
		}
	}
   }
}
