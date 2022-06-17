package JuegoTenis;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author romy
 */
public class Ball {

  private static final int DIAMETER = 30;
  int x=0; //Inicializamos en 0 la posición x
  int y=0; //Inicializamos en 0 la posición y
  int xa=2; //Inicializamos en 1 la posición xa velocidad
  int ya=2; //Inicializamos en 1 la posición ya velocidad
  private GameLoop juego;
  
  //El constructor Ball llamará a la variable juego de la clase GameLoop
  public Ball(GameLoop juego){
    this.juego=juego;
  }
  
  //Usa los parámetros definidos en el método moveBall() de la clase GameLoop
  void move(){
    boolean changeDirection = true;
    if(x + xa < 10)
      xa = 2;
    else if(x + xa > juego.getWidth() - DIAMETER)
      xa = -2;
    else if(y + ya < 10)
      ya = 2;
    else if(y + ya > juego.getHeight() - DIAMETER)
      juego.gameOver();
    //logramos que la pelota rebote hacia arriba si esta colisiona con la raqueta
    else if(collision()){
      ya = -2;
      y = juego.racquet.getTopY() - DIAMETER; //colocamos a la pelota sobre la raqueta
      juego.speed++;
    }else
      changeDirection = false;
    
    if(changeDirection)
      Sound.BALL.play();
    
    x = x + xa;
    y = y + ya;
  }
  
  /*
  si el rectángulo ocupado por la raqueta "game.racquet.getBounds()" 
  intersecta al rectángulo que encierra a la pelota "getBounds()"
  */
  private boolean collision(){
    return juego.racquet.getBounds().intersects(getBounds());
  }
  
 public void paint(Graphics2D g){
   g.fillOval(x, y, DIAMETER, DIAMETER);
 }
  
 public Rectangle getBounds(){
   return new Rectangle(x, y, DIAMETER, DIAMETER);
 }
}
