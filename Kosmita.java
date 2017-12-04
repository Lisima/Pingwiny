import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kosmita here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kosmita extends Actor
{
    int ileWPrawo = 1;
    int ileWDol = 1;
   
    private void zbadajBrzegi()
{
    if ( isAtEdge() )
    {
        int xRobota = getX();
        int yRobota= getY();
        
        if( xRobota >= getWorld().getWidth() -1 )
        setLocation( 0 , yRobota );
         
        if( xRobota <= 0 )
        setLocation( getWorld().getWidth() -1 , yRobota );
        
        if( yRobota <= 0 )
        setLocation( xRobota , getWorld().getHeight() -1);
        
        if ( yRobota >= getWorld().getHeight() -1 )
        setLocation (xRobota , 0);
    }
}

    public void act() 
    {
        
        if(Greenfoot.getRandomNumber ( 100 ) < 3 )
        {
            ileWPrawo = Greenfoot.getRandomNumber( 4 ) -2; // -2. -2, -1, 0 , 1
            ileWDol = Greenfoot.getRandomNumber( 4 ) -2 ;
        }
        
        setLocation( getX()+ileWPrawo, getY() +ileWDol);
        zbadajBrzegi();
    }     
}
