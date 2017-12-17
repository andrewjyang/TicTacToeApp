package com.example.andrew.tictactoe;

/**
 * class TicTacToeBoard
 */
public class TicTacToeBoard {

    private int nDimension;
    private Cell[][] grid;

    /**
     * Tic Tac Toe Board default constructor
     *
     * @param: the nDimension is an integer that establishes the N x N board
     * @return: n/a
     */
    public TicTacToeBoard(int nDimension){
        this.nDimension = nDimension;
        initializeBoard();
    }

    /**
     * initializeBoard() method
     * initializes the tic tac toe board, and places the symbol in each cell of grid[row][col]
     * @param: n/a
     * @return: n/a
     */
    public void initializeBoard(){
        grid = new Cell[nDimension][nDimension];
        for (int row = 0; row < nDimension; row++)
            for (int col = 0; col < nDimension; col++){
                grid[row][col] = new Cell(row,col,'-');
            }
    }

    /**
     * printBoard() method
     * prints vertical lines on tic tac toe board (makes it pretty)
     * @param: n/a
     * @return: n/a
     */
    public void printBoard(){
        for (int i = 0; i < nDimension; i++) {
            System.out.print("| ");
            for (int j = 0; j < nDimension; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * isValidMove() method
     * checks for valid move by first checking if the userinput's coordinates is either out of bounds or if the
     * move is repeated
     * @param: coordinates of type Coordinates are the coordinates where each player marks the board with 'X' or 'O'.
     * @return: returns boolean true unless one if conditional is met
     */
    public boolean isValidMove(Coordinates coordinates) {
        // check if out of bounds
        if (coordinates.getRow() > nDimension - 1 || coordinates.getCol() > nDimension - 1) {
            int x = coordinates.getRow() + 1;
            int y = coordinates.getCol() + 1;

            System.out.println("(" + x + "," + y + ")" + " is not a valid move!");
            return false;
        }

        // check if 0
        if (coordinates.getRow() == 0 - 1 && coordinates.getCol() == 0 - 1){
            int x = coordinates.getRow() + 1;
            int y = coordinates.getCol() + 1;

            System.out.println("(" + x + "," + y + ")" + " is not a valid move!");
            return false;
        }

        // check if repeated move
        if (grid[coordinates.getRow()][coordinates.getCol()].getSymbol() != '-') {
            int x = coordinates.getRow() + 1;
            int y = coordinates.getCol() + 1;

            System.out.println("(" + x + " , " + y + ")" + " is not a valid move!");
            return false;
        }

        return true;
    }

    /**
     * makeMove() method
     * updates the tic tac toe board and replaces each - with the playerSymbol (X or O)
     * @param: coordinates of type Coordinates are the coordinates where each player marks the board with 'X' or 'O'.
     * @param: playerSymbol of type char is the symbol of the player ('X' for player 1 or 'O' for player 2)
     * @return: n/a
     */
    public void makeMove(Coordinates coordinates, char playerSymbol){
        grid[coordinates.getRow()][coordinates.getCol()].setSymbol(playerSymbol);
    }

    /**
     * isWinner() method
     * checks for if there is a winner by row, column, diagnal, or if the tic tac toe board is full
     * @param: playerSymbol of type char is the symbol of the player ('X' for player 1 or 'O' for player 2)
     * @return: return methods rowWin(playerSymbol)), columnWin(playerSymbol), diagnalWin(playerSymbol), or isFull()
     *          to check for Win or Tie on the tic tac toe board
     */
    public boolean isWinner(char playerSymbol) {

        return (isRowWin(playerSymbol) || isColumnWin(playerSymbol) || isDiagnalWin(playerSymbol));

    }

    /**
     * rowWin() method
     * checks for a win by 'N' in a row
     * @param: playerSymbol of type char is the symbol of the player ('X' for player 1 or 'O' for player 2)
     * @return: return true for 'N' playerSymbols in a row and false otherwise.
     */
    private boolean isRowWin(char playerSymbol){
        int charctr;
        for(int x = 0; x < nDimension; x++){
            charctr = 0;
            for(int y = 0; y < nDimension; y++){
                if(grid[x][y].getSymbol() == playerSymbol){
                    charctr++;
                }
                if(charctr == nDimension){
                    System.out.println("\nCongratulations, " + playerSymbol + " wins!");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * columnWin() method
     * checks for a win by 'N' in a column
     * @param: playerSymbol of type char is the symbol of the player ('X' for player 1 or 'O' for player 2)
     * @return: return true for 'N' playerSymbols in a column and false otherwise.
     */
    private boolean isColumnWin(char playerSymbol) {
        int charctr;
        for(int y = 0; y < nDimension; y++){
            charctr = 0;
            for(int x = 0; x < nDimension; x++){
                if(grid[x][y].getSymbol() == playerSymbol){
                    charctr++;
                }
                if(charctr == nDimension){
                    System.out.println("\nCongratulations, " + playerSymbol + " wins!");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * diagnalWin() method
     * checks for a win by 'N' in any diagnal
     * @param: playerSymbol of type char is the symbol of the player ('X' for player 1 or 'O' for player 2)
     * @return: return true for 'N' playerSymbols in any diagnal and false otherwise.
     */
    private boolean isDiagnalWin(char playerSymbol) {
        int charctr = 0;
        int charctr2 = 0;
        for (int d = 0; d < nDimension; d++) {
            if (grid[d][d].getSymbol() == playerSymbol) {
                charctr++;
            }
            if (grid[d][nDimension-d-1].getSymbol() == playerSymbol){
                charctr2++;
            }
            if (charctr == nDimension || charctr2 == nDimension) {
                System.out.println("\nCongratulations, " + playerSymbol + " wins!");
                return true;
            }
        }
        return false;
    }

    /**
     * isFull() method
     * checks if entire tic tac toe board is filled with playerSymbols
     * @param: n/a
     * @return: return false is tictactoeboard is full of playerSymbols and true otherwise.
     */
    public boolean isFull() {
        for(int x = 0; x < nDimension; x++){
            for(int y = 0; y < nDimension; y++){
                if(grid[x][y].getSymbol() == '-'){
                    return false;
                    }
                }
            }
        System.out.println("\nThe game is a scratch :(. \n");
        return true;
        }

    @Override
    public String toString() {
        String boardStr = "";
        for (int row = 0; row < nDimension; row++){
            for (int col = 0; col < nDimension; col++){
                Cell curCell = grid[row][col];
                String cellStr = curCell.toString();
                boardStr += cellStr;
            }
            boardStr += '\n';
        }
        return boardStr;
    }

}