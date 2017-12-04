import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rakieta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rakieta extends Actor

{
   int predkoscRakiety = 5;
   boolean czyZmienionoPredkosc = false;
   int punkty = 0;
    public void zbadajKlawisze() 
    {
        if( Greenfoot.isKeyDown("right") ) 
        {
            turn( 10 );
        }
    
        if( Greenfoot.isKeyDown("left") ) 
        {
            turn( -10 );
        }
         if( Greenfoot.isKeyDown("a") ) 
        {
            if( !czyZmienionoPredkosc )
           {
               predkoscRakiety++;
               czyZmienionoPredkosc = true;
            }
        }
        if( Greenfoot.isKeyDown("s") ) 
        
            if( !czyZmienionoPredkosc )
           {
               predkoscRakiety--;
               czyZmienionoPredkosc = true;
            }
        if( predkoscRakiety < 0 )
        {
            predkoscRakiety = 0;
        }
  
    if(!Greenfoot.isKeyDown("a")&& !Greenfoot.isKeyDown("s"))
    {
        czyZmienionoPredkosc = false;
    }
}
    private void zbadajBrzegi()
{
    if ( isAtEdge() )
    {
        int xRakiety = getX();
        int yRakiety= getY();
        
        if( xRakiety >= getWorld().getWidth() -1 )
        setLocation( 0 , yRakiety );
         
        if( xRakiety<= 0 )
        setLocation( getWorld().getWidth() -1 , yRakiety );
        
        if( yRakiety <= 0 )
        setLocation( xRakiety , getWorld().getHeight() -1);
        
        if ( yRakiety >= getWorld().getHeight() -1 )
        setLocation (xRakiety , 0);
    }
}

private void zbadajRobocika()
{
    if( isTouching( Robot.class ) )
    {
     removeTouching( Robot.class );
     punkty++;
    }
}

private void zbadajPingwina()
{
    if( isTouching( Pingwin.class ) )
    {
        Greenfoot.stop(); //game over
    }
}
 
private void pokazPunkty()
{
   getWorld().showText("Punkty: " + punkty , 100, 20 ); 
}
public void act()
{
    zbadajKlawisze(); 
    
    move( predkoscRakiety );
    
    zbadajRobocika();
    zbadajPingwina();
    zbadajBrzegi();
    pokazPunkty();
    
    
}
}