package com.example.andrew.tictactoe;

public class Cell {
    private Coordinates coordinates;
    private char symbol;

    /**
     * Cell default constructor
     *
     * @param: the coordinates are a pair of integers that represent a row and column on the tic tac toe board
     * @return: n/a
     */
    Cell(Coordinates coordinates){
        this.coordinates = coordinates;
        this.symbol = '-';
    }

    /**
     * Cell explicit value constructor
     *
     * @param: the coordinates are a pair of integers that represent a row and column on the tic tac toe board
     * @param: the symbol is the symbol X, O, or - for
     * @return: n/a
     */
    Cell (Coordinates coordinates, char symbol){
        this.coordinates = coordinates;
        this.symbol = symbol;
    }

    /**
     * Cell Constructor
     *
     * @param: row is the row on the tic tac t
     * @param:
     * @return: n/a
     */
    Cell(int row, int column, char symbol){
        this.coordinates = new Coordinates(row,column);
        this.symbol = symbol;
    }

    /**
     * Symbol getter
     * gets char of symbol
     * @param: n/a
     * @return: returns char of symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Symbol setter
     * sets char of symbol
     * @param: the symbol is a symbol that represents each player ('X' or 'O')
     * @return: n/a
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Coordinates getter
     * gets type Coordinates of coordinates
     * @param: n/a
     * @return: returns type Coordinates of coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Coordinates setter
     * sets type Coordinates of coordinates
     * @param: coordinates of type Coordinates are the coordinates where each player marks the board with 'X' or 'O'.
     * @return: n/a
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return Character.toString(this.symbol);
    }
}

