package chessvalidator;

// Abstract class for all pieces
abstract class Piece {
    protected boolean isWhite;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public abstract boolean isValidMove(ChessBoard board, Position start, Position end);
}

// Subclasses for specific pieces
class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(ChessBoard board, Position start, Position end) {
        int direction = isWhite ? 1 : -1;
        int rowDiff = end.row - start.row;
        int colDiff = Math.abs(end.col - start.col);

        // Check single step or double step move
        if (colDiff == 0 && ((rowDiff == direction) || (rowDiff == 2 * direction && start.row == (isWhite ? 1 : 6)))) {
            return board.getPiece(end) == null; // No piece at destination
        }
        // Check diagonal capture
        if (colDiff == 1 && rowDiff == direction) {
            return board.getPiece(end) != null && board.getPiece(end).isWhite() != this.isWhite;
        }
        return false;
    }
}

// Add Rook, Knight, Bishop, Queen, King classes similarly
class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(ChessBoard board, Position start, Position end) {
        // Check horizontal or vertical move
        if (start.row == end.row || start.col == end.col) {
            return board.isPathClear(start, end); // Ensure path is clear
        }
        return false;
    }
}

// Position class
class Position {
    int row, col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

// ChessBoard class
class ChessBoard {
    private Piece[][] board;

    public ChessBoard() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Set up pieces (Pawns, Rooks, etc.)
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(true);
            board[6][i] = new Pawn(false);
        }
        board[0][0] = new Rook(true);
        board[0][7] = new Rook(true);
        board[7][0] = new Rook(false);
        board[7][7] = new Rook(false);
        // Add other pieces...
    }

    public Piece getPiece(Position pos) {
        return board[pos.row][pos.col];
    }

    public void setPiece(Position pos, Piece piece) {
        board[pos.row][pos.col] = piece;
    }

    public boolean isPathClear(Position start, Position end) {
        // Check if all squares between start and end are empty
        int rowStep = Integer.compare(end.row, start.row);
        int colStep = Integer.compare(end.col, start.col);
        int currentRow = start.row + rowStep;
        int currentCol = start.col + colStep;

        while (currentRow != end.row || currentCol != end.col) {
            if (board[currentRow][currentCol] != null) {
                return false;
            }
            currentRow += rowStep;
            currentCol += colStep;
        }
        return true;
    }
}

// Game class
class Game {
    private final ChessBoard board;

    public Game() {
        board = new ChessBoard();
    }

    public boolean validateMove(Position start, Position end) {
        Piece piece = board.getPiece(start);
        if (piece == null) {
            throw new IllegalArgumentException("No piece at the starting position!");
        }
        return piece.isValidMove(board, start, end);
    }

    public void makeMove(Position start, Position end) {
        if (validateMove(start, end)) {
            Piece piece = board.getPiece(start);
            board.setPiece(end, piece);
            board.setPiece(start, null);
            System.out.println("Move successful!");
        } else {
            System.out.println("Invalid move!");
        }
    }
}

// Main class to test
public class ChessValidator {
    public static void main(String[] args) {
        Game game = new Game();
        Position start = new Position(1, 0); // Pawn at (1, 0)
        Position end = new Position(3, 0); // Move to (3, 0)

        game.makeMove(start, end); // Test move
    }
}
