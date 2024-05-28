import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SeaShell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeaShell extends Actor
{
    /**
     * Act - do whatever the SeaShell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SeaShell() {
        GreenfootImage image = getImage();
        image.scale(45 , 45);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
