package com.example.andrew.tictactoe;

/**
 * class Coordinates
 */
public class Coordinates {
    private int row;
    private int col;
    private boolean checkRepeat = false;
    /**
     * Coordinates constructor
     *
     * @param: the row is an integer that is the row on the tic tac toe board
     * @param: the col is an integer that is the column on the tic tac toe board
     * @return: n/a
     */
    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * column getter
     * gets value (integer) of column
     * @param: n/a
     * @return: returns value (integer) of col
     */
    public int getCol() {
        return col;
    }

    /**
     * column setter
     * sets value (integer) of column
     * @param: the col is an integer that is the column on the tic tac toe board
     * @return: n/a
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * row getter
     * gets value (integer) of row
     * @param: n/a
     * @return: returns value (integer) of row
     */
    public int getRow(){
        return row;
    }

    /**
     * row setter
     * sets value (integer) of row
     * @param: the row is an integer that is the row on the tic tac toe board
     * @return: n/a
     */
    public void setRow(int row){
        this.row = row;
    }

    /**
     * checkRepeat getter
     * gets boolean of checkRepeat
     * @param: n/a
     * @return: returns boolean of checkRepeat
     */
    public boolean getCheckRepeat() {
        return checkRepeat;
    }

    /**
     * checkRepeat setter
     * sets boolean of checkRepeat
     * @param: check Repeat is a
     * @return: n/a
     */
    public void setCheckRepeat(boolean checkRepeat) {
        this.checkRepeat = checkRepeat;
    }

    @Override
    public String toString(){
        String coordinateStr = "(" + this.row + "," + this.col + ")";
        return coordinateStr;
    }
}
