/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application;

/**
 *
 * @author Mariusz Kamiński
 */
public class Board {
    private Player playerX;
    private int countX;
    private Player playerO;
    private int countO;
    private char[][] board;
    
    public Board() {
        this.playerX = new Player('X');
        this.countX = 0;
        this.playerO = new Player('O');
        this.countO = 0;
        this.board = new char[3][3];
    }
    //True X turn / False O turn
    public boolean Turn() {
        return countX <= countO;
    }
    //Setters
    public void setX (int x, int y) {
        board[x][y] = 'X';
        countX++;
    }
    
    public void setO (int x, int y) {
        board[x][y] = 'O';
        countO++;
    }
    //Getters
    public char getCell(int x, int y) {
        return board[x][y];
    }
    
    
    //Game Logic
    public boolean Win() {
       final String xWin = "XXX";
       final String oWin = "OOO";
       String diagonalLeft = "";
       String diagonalRight = "";
       
       for (int i = 0; i < board.length; i++) {
           String row = "";
           String column = "";
           diagonalLeft += board[i][i];
           diagonalRight += board[i][2 - i];
           if (diagonalLeft.equals(xWin) || diagonalLeft.equals(oWin)) {
               return true;
           }
           if (diagonalRight.equals(xWin) || diagonalRight.equals(oWin)) {
               return true;
           }
           for (int j = 0; j < board[i].length; j++) {
               row += board[i][j];
               column += board[j][i];
               if ((row.equals(xWin) || row.equals(oWin)) || (column.equals(xWin) || column.equals(oWin)) ) {
                   return true;
               }
           }
       }
       
       return false;
    }
    
}
