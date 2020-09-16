package tictactoe;

public class TicTacToe {
    private char[][] board;
    public final static char X = 'X';
    public final static char O = 'O';
    public final static char EMPTY = '_';
    private int turn;

    public TicTacToe() {
        board = new char[3][3];
        turn = 0;
        restartBoard();
    }

    public void restartBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
    public int getTurn() {
        return turn;
    }

    public boolean setSymbol(int row, int column, char symbol) {
        if (board[row][column] == EMPTY) {
            board[row][column] = symbol;
            return true;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
    }

    public void nextTurn() {
        this.turn++;
    }


    public boolean makeMove(int row, int column) {
        row = row - 1;
        column = 3 - column;
        return setSymbol(column, row, computeSymbol());
    }

    public char computeSymbol() {
        if (turn % 2 == 0) {
            return X;
        } else {
            return O;
        }
    }

    public void printBoard() {
        printBorder();
        for (int i = 0; i < board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        printBorder();
    }

    private void printBorder() {
        System.out.println("---------");
    }

    public boolean winCheck(char symbol) {
        return checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol);
    }

    private boolean checkRows(char symbol) {
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (symbol != board[i][j]) {
                    break;
                }
                count++;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char symbol) {
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (symbol == board[j][i]) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char symbol) {
        return forwardDiagonal(symbol) || backwardDiagonal(symbol);
    }

    private boolean forwardDiagonal(char symbol) {
        for (int i = 0; i < board.length; i++) {
            if (symbol != board[i][i]) {
                return false;
            }
        }
        return true;
    }

    private boolean backwardDiagonal(char symbol) {
        for (int i = 0; i < board.length; i++) {
            if (symbol != board[i][board.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}