import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends Actor
{
    /**
     * Act - do whatever the Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int row;
    private int col;
    private boolean isSelected;
    protected GreenfootImage imageNormal;
    protected GreenfootImage imageHighlight;
    
    private boolean isHighlighted; //FIX THIS?? isnt highlighting
    

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
        
    }

    public void act() {
        if (Greenfoot.mouseMoved(this)) {
            setHighlighted(true);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            setHighlighted(false);
        } //NOT WORKING>??
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public void setHighlighted(boolean highlighted) {
        isHighlighted = true;
        updateImage();
    }

    protected void updateImage() {
        if (isHighlighted) {
            setImage(imageHighlight); //
        } 
        else {
            setImage(imageNormal);
        }
        
    }
    
}
