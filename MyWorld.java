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
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(10, 12, 50); 
        createBoard();
        activePlayer();
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
    
}
