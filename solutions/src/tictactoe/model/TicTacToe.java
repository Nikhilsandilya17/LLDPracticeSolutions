package tictactoe.model;

import tictactoe.enums.PieceType;

import java.util.Scanner;

public class TicTacToe {

    private User userX;
    private User userY;
    private final Board board;

    public User getUserX() {
        return userX;
    }

    public void setUserX(User userX) {
        this.userX = userX;
    }

    public User getUserY() {
        return userY;
    }

    public void setUserY(User userY) {
        this.userY = userY;
    }

    public TicTacToe(User userX, User userY, Board board) {
        this.userX = userX; // o
        this.userY = userY; // x
        this.board = board;
    }


    public void play() {
        Scanner scanner = new Scanner(System.in); // input
        User currentPlayer = userX;
        board.displayBoard();
        while(true){
            System.out.println("Enter position (x,y) for: "+currentPlayer.getName()+" playing with piece:"+currentPlayer.getPlayingPiece()+" ->");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            char c = (currentPlayer.getPlayingPiece() == PieceType.X) ? 'x' : 'o';
            if(!board.markCell(x,y,c)){
                board.displayBoard();
                continue;
            }
            if(board.checkForWin(c)){
                System.out.println("Congrats "+currentPlayer.getName()+" has won the game with "+ currentPlayer.getPlayingPiece());
                board.displayBoard();
                break;
            }
            if(board.checkForDraw()){
                System.out.println("Game drawn !!!");
                board.displayBoard();
                break;
            }
            currentPlayer = (currentPlayer == userX) ? userY : userX;
        }
        scanner.close();

    }


}
