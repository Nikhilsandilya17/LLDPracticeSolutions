package tictactoe.model;

public class Board {
    private static final int SIZE = 3;
    private final char[][] board;

    public Board() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-'; // Initial empty state
            }
        }
    }

    public boolean markCell(int x, int y, char c) {
        if(x<0 || x>2 || y<0 || y>2){
            System.out.println("Valid position not selected");
            return false;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == x && j == y) {
                    if(board[i][j]=='-'){
                        board[i][j] = c;
                    }
                    else {
                        System.out.println("Position already filled");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkForWin(char c) {
        //check for rows and diagonal
        for (int i = 0; i < SIZE; i++) {
            if ((board[0][i] == c && board[1][i] == c && board[2][i] == c) || (board[i][0] == c && board[i][1] == c && board[i][2] == c)) {
                return true;
            }
        }
        //check for diagonals
        return ((board[0][0] == c && board[1][1]== c && board[2][2] == c) || (board[0][2] == c && board[1][1] == c && board[2][0] == c));
    }

    public boolean checkForDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayBoard(){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
