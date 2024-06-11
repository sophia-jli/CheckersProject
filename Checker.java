import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Checker here.
 * 
 * @version (a version number or a date)
 */
public class Checker extends Actor
{
    protected boolean isPlayerOne;
    protected int row;
    protected int col;
    private boolean isSelected;
    private GreenfootImage imageDollar;
    private GreenfootImage imageShell;
    private GreenfootImage imageDollarHighlight;
    private GreenfootImage imageShellHighlight;
    //KING variables:
    private boolean isKing;
    private GreenfootImage imageDollarKing;
    private GreenfootImage imageShellKing;
    private GreenfootImage imageDollarKingHighlight;
    private GreenfootImage imageShellKingHighlight;

    public Checker(boolean isPlayerOne, int row, int col) {
        this.isPlayerOne = isPlayerOne;
        this.row = row;
        this.col = col;
        this.isSelected = false;
        imageDollar = new GreenfootImage("SandDollar.png");
        imageDollar.scale(45,45);
        imageShell = new GreenfootImage("SeaShell.png");
        imageShell.scale(45 , 45);
        imageDollarHighlight = new GreenfootImage("DollarHighlight.png");
        imageDollarHighlight.scale(45,45);
        imageShellHighlight = new GreenfootImage("ShellHighlight.png");
        imageShellHighlight.scale(45 , 45);
        imageDollarKingHighlight = new GreenfootImage("DollarKingHighlight.png");
        imageDollarKingHighlight.scale(45,45);
        imageDollarKing = new GreenfootImage("DollarKing.png");
        imageDollarKing.scale(45,45);
        imageShellKingHighlight = new GreenfootImage("ShellKingHighlight.png");
        imageShellKingHighlight.scale(45,45);
        imageShellKing = new GreenfootImage("ShellKing.png");
        imageShellKing.scale(45,45);
        updateImage();
        
        
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            MyWorld world = (MyWorld) getWorld();
            
            if ((isPlayerOne && world.activePlayer == 1) || (!isPlayerOne && world.activePlayer == 2)) {
                world.selectChecker(this);
            }
        }

        if (isSelected && Greenfoot.mouseClicked(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            
            if (mouse != null) {
                Actor clickedActor = mouse.getActor();
                if (clickedActor instanceof Tile) {
                    Tile tile = (Tile) clickedActor;
                    moveToTile(tile);
                    
                }
            }
        }
        checkKing();
    }
    
    public void checkKing() {
        
        
        if (isPlayerOne) {
            if (getRow()>=7) {
                makeKing();
            }
        }
        else {
            if (getRow()<=0) {
                makeKing();
            }
        }
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }

    
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
        setLocation(col, row);
    }
    
    public boolean isPlayerOne() {
        return isPlayerOne;
    }
    
    public void setSelected(boolean selected) {
        isSelected = selected;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(50, 50);
        if (!isKing) {
            if (isPlayerOne) {
            setImage(imageDollar);
        } else {
            setImage(imageShell);
        }
        
        if (isSelected && isPlayerOne) {
            setImage(imageDollarHighlight);
        }
        if (isSelected && !isPlayerOne) {
            setImage(imageShellHighlight);
        }
        }
        
        else {
       
            if (isPlayerOne) {
            setImage(imageDollarKing);
        } else {
            setImage(imageShellKing);
        }
        
        if (isSelected && isPlayerOne) {
            setImage(imageDollarKingHighlight);
        }
        if (isSelected && !isPlayerOne) {
            setImage(imageShellKingHighlight);
        }
        }
        
        
        
    }
    
    private void moveToTile(Tile tile) {
        MyWorld world = (MyWorld)getWorld();
        int fromRow = getRow();
        int fromCol = getCol();
        
        int toRow = tile.getRow();
        int toCol = tile.getCol();

        if (isValidMove(fromRow, fromCol, toRow, toCol, world)) {
            world.moveChecker(this, toRow, toCol);
            setSelected(false);
            fromRow = getRow();
              fromCol = getCol();
        
               toRow = tile.getRow();
            toCol = tile.getCol();
            //double jump
            if (isValidMove(fromRow,fromCol, toRow, toCol, world)) {
                world.moveChecker(this, toRow, toCol);
            setSelected(false);
            }
            world.switchPlayer();
            
        }
    }
    
    private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, MyWorld world) {
        if (world.board[toRow][toCol] != MyWorld.EMPTY) {
            return false;
        }
        //normal move
        if (isKing()) {
            
        
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);
        if (rowDiff == 1 && colDiff == 1) {
            return true;
        }
        //jump move
        
        if (rowDiff == 2 && colDiff == 2) {
            int jumpRow = (fromRow + toRow) / 2;
            int jumpCol = (fromCol + toCol) / 2;
            
            int opponentPiece = isPlayerOne() ? MyWorld.PLAYER_TWO_PIECE : MyWorld.PLAYER_ONE_PIECE;
            if (world.board[jumpRow][jumpCol] == opponentPiece) {
                return true;
                
            }
            
        }
        
        //double jump 
        
        
        return false;
    }
    
    else {
        if (isPlayerOne()) {
            int rowDiff = toRow - fromRow;
            int colDiff = Math.abs(toCol - fromCol);
            
            if (rowDiff == 1 && colDiff == 1) {
            return true;
        }
        //jump move
        
        if (rowDiff == 2 && colDiff == 2) {
            int jumpRow = (fromRow + toRow) / 2;
            int jumpCol = (fromCol + toCol) / 2;
            
            int opponentPiece = isPlayerOne() ? MyWorld.PLAYER_TWO_PIECE : MyWorld.PLAYER_ONE_PIECE;
            if (world.board[jumpRow][jumpCol] == opponentPiece) {
                return true;
                
            }
            
        }
        }
        
        else {
            int rowDiff = toRow - fromRow;
            int colDiff = Math.abs(toCol - fromCol);
            
                if (rowDiff == -1 && colDiff == 1) {
            return true;
        }
        //jump move
        
        if (rowDiff == -2 && colDiff == 2) {
            int jumpRow = (fromRow + toRow) / 2;
            int jumpCol = (fromCol + toCol) / 2;
            
            int opponentPiece = isPlayerOne() ? MyWorld.PLAYER_TWO_PIECE : MyWorld.PLAYER_ONE_PIECE;
            if (world.board[jumpRow][jumpCol] == opponentPiece) {
                return true;
                
            }
            
        }
        }
        return false;
    }
    }
    
    public boolean isKing() {
        return isKing;
    }
    
    public void makeKing() {
        isKing = true;
        updateImage();
    }
    
     
    }
    
    

