import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WhiteTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhiteTile extends Tile
{
    /**
     * Act - do whatever the WhiteTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WhiteTile(int row, int col) {
        super(row, col);
        GreenfootImage image = getImage();
        image.scale(50, 50);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
