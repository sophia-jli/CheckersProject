import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Checker here.
 * 
 * @version (a version number or a date)
 */
public class Checker extends Actor
{
    protected boolean isPlayerOne;
    protected int row, col;
    private boolean isSelected;

    public Checker(boolean isPlayerOne, int row, int col) {
        this.isPlayerOne = isPlayerOne;
        this.row = row;
        this.col = col;
        this.isSelected = false;
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
        if (isPlayerOne) {
            setImage("SandDollar.png");
        } else {
            setImage("SeaShell.png");
        }
        if (isSelected) {
            image.setColor(Color.YELLOW);
        }
        image.fillOval(5, 5, 40, 40);
        setImage(image);
    }
    
    private void moveToTile(Tile tile) {
        MyWorld world = (MyWorld) getWorld();
        int fromRow = getRow();
        int fromCol = getCol();
        int toRow = tile.getRow();
        int toCol = tile.getCol();

        if (isValidMove(fromRow, fromCol, toRow, toCol, world)) {
            world.moveChecker(this, toRow, toCol);
            setSelected(false);
            world.switchPlayer();
        }
    }
    
    private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, MyWorld world) {
        if (world.board[toRow][toCol] != MyWorld.EMPTY) {
            return false;
        }
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);
        return rowDiff == 1 && colDiff == 1;
    }
}
