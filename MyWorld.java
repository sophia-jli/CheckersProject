import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public int activePlayer = 1;
    private Checker selectedChecker;
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(10, 12, 50); 
        createBoard();
        activePlayer();
        
        selectChecker();
    }
    
    public void createBoard() {
        for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if ((i + j) % 2 == 0) {
                addObject(new WhiteTile(), i+1, j+3);
            } else {
                addObject(new BlackTile(), i+1, j+3);
            }
        }
    }
    
    for (int i=1; i<8; i+=2) {
        for (int j=0; j<3;j++) {
            if (j%2==0) {
                addObject(new SandDollar(), i+1, j+3);
            }
            else {
                addObject(new SandDollar(), i, j+3);
            }
        }
    }
    
    for (int i=1; i<8; i+=2) {
        for (int j=0; j<3;j++) {
            if (j%2==1) {
                addObject(new SeaShell(), i+1, j+8);
            }
            else {
                addObject(new SeaShell(), i, j+8);
            }
        }
    }
    }
    
    public void activePlayer() {

            showText("Player " + activePlayer + "'s turn", 2, 2);
        

    }
    
    public void selectChecker() {
        if (Greenfoot.mouseClicked(null)) {
        Actor actor = Greenfoot.getMouseInfo().getActor();
        if (actor != null) {
            System.out.println("Clicked on: " + actor.getClass().getName());
        }
        if (actor instanceof Checker) {
            selectedChecker = (Checker) actor;
            System.out.println("Checker selected at: " + actor.getX() + ", " + actor.getY());
        } else if (actor instanceof Tile && selectedChecker != null) {
            moveCheckerToTile(selectedChecker, (Tile) actor);
            System.out.println("Checker moved to: " + actor.getX() + ", " + actor.getY());
            selectedChecker = null; // Deselect after moving
        }
    }
    }
    
    private void moveCheckerToTile(Checker checker,Tile tile) {
        int newX = tile.getX();
        int newY = tile.getY();
        checker.setLocation(newX, newY);
    }
    
}
