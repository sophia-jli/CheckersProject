import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * AANYA AND SOPHIA
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     */
    public int activePlayer = 1;
    private Checker selectedChecker;
    public int[][] board;

    public static final int EMPTY = 0;
    public static final int PLAYER_ONE_PIECE = 1;
    public static final int PLAYER_TWO_PIECE = 2;
    public int shellCount = 12;
    public int dollarCount = 12;
    
    public MyWorld()
    {    
        // Create a new world with 8x8 cells with a cell size of 50x50 pixels.
        super(8, 8, 50);  //LATER CHANGE TO A SAND BACKGROUND W/ CUES FOR PLAYERS
        //originally 10x12 (+3 & +8)
        createBoard();
        //showActivePlayer();
    }
    
    public void act() {
        endGame();
    }
    
    public void createBoard() {
        board = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    addObject(new WhiteTile(i, j), j, i);
                } else {
                    addObject(new BlackTile(i, j), j, i);
                }
                board[i][j] = EMPTY; 
            }
        }
        
        // Add player 1
        for (int i = 0; i < 8; i += 2) {
            for (int j = 0; j < 3; j++) {
                if (j % 2 == 0) {
                    addObject(new Checker(true, j, i+1), i+1, j);
                    board[j][i+1] = PLAYER_ONE_PIECE;
                } else {
                    addObject(new Checker(true, j, i), i , j);
                    board[j][i] = PLAYER_ONE_PIECE;
                }
            }
        }
        
        // Ad Player 2 
        for (int i = 0; i < 8; i += 2) {
            for (int j = 5; j < 8; j++) {
                if (j % 2 == 0) {
                    addObject(new Checker(false, j, i+1), i+1, j);
                    board[j][i+1] = PLAYER_TWO_PIECE;
                } else {
                    addObject(new Checker(false, j, i), i, j);
                    board[j][i] = PLAYER_TWO_PIECE;
                }
            }
        }
    }
    
    //public void showActivePlayer() {
      //  showText("Player " + activePlayer + "'s turn", 2, 2);
    //}
    
    public void selectChecker(Checker checker) {
        if (selectedChecker != null) {
            selectedChecker.setSelected(false);
        }
        selectedChecker = checker;
        selectedChecker.setSelected(true);
    }

    public void moveChecker(Checker checker, int toRow, int toCol) {
        int fromRow = checker.getRow();
        int fromCol = checker.getCol();
        board[toRow][toCol] = board[fromRow][fromCol];
        board[fromRow][fromCol] = EMPTY;
        checker.setPosition(toRow, toCol);
        
        int jumpRow = (fromRow + toRow) / 2;
        int jumpCol = (fromCol + toCol) / 2;
        if (Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 2) {
            board[jumpRow][jumpCol] = EMPTY;
        
            Checker oppChecker = getObjectsAt(jumpCol, jumpRow, Checker.class).get(0);
            //Remove opponent jumped
            if (oppChecker.isPlayerOne()) {
                dollarCount--;
            }
            if (!oppChecker.isPlayerOne()) {
                shellCount--;
            }
            removeObject(oppChecker); 
        }
    }

    public void switchPlayer() {
        activePlayer = (activePlayer == 1) ? 2 : 1;
        //showActivePlayer(); NEED TO FIX THIS
    }
    
    public void endGame() {
        if (shellCount==0) {
            showText("Player 1 Wins!", 3,3);
            Greenfoot.stop();
        }
        if (dollarCount==0) {
            showText("Player 2 Wins!", 3,3);
            Greenfoot.stop();
        }
    }
    
}

