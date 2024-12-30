package tictactoe;

import tictactoe.enums.PieceType;
import tictactoe.model.Board;
import tictactoe.model.TicTacToe;
import tictactoe.model.User;

public class TicTacToeDemo {
    public static void run(){
        User user1 = new User(1, "Nikhil", PieceType.O);
        User user2 = new User(2, "Anand", PieceType.X);
        Board board = new Board();

        TicTacToe ticTacToe = new TicTacToe(user1, user2, board);
        ticTacToe.play();

    }
}
