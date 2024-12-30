package tictactoe.model;

import tictactoe.enums.PieceType;

public class User {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public User(int userId, String name, PieceType playingPiece) {
        this.userId = userId;
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PieceType getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PieceType playingPiece) {
        this.playingPiece = playingPiece;
    }

    private String name;
    private PieceType playingPiece;


}
