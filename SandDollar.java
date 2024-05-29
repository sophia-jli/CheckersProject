import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SandDollar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SandDollar extends Checker
{
    /**
     * Act - do whatever the SandDollar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    
    public SandDollar(boolean isPlayerOne, int row, int col) {
        super(isPlayerOne, row, col);
        GreenfootImage image = getImage();
        image.scale(45, 45);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
