package JuegoTenis;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author romy
 */
public class Ball2 {

  private static final int DIAMETER2 = 20;
  int x=5; //Inicializamos en 0 la posición x
  int y=5; //Inicializamos en 0 la posición y
  int xa=2; //Inicializamos en 1 la posición xa velocidad
  int ya=2; //Inicializamos en 1 la posición ya velocidad
  private GameLoop juego;
  
  //El constructor Ball2 llamará a la variable juego de la clase GameLoop
  public Ball2(GameLoop juego){
    this.juego=juego;
  }
  
  //Usa los parámetros definidos en el método moveBall() de la clase GameLoop
  void move(){
    boolean changeDirection = true;
    if(x + xa < 0)
      xa = 2;
    else if(x + xa > juego.getWidth() - DIAMETER2)
      xa = -2;
    else if(y + ya < 0)
      ya = 2;
    else if(y + ya > juego.getHeight() - DIAMETER2)
      juego.gameOver();
    //logramos que la pelota rebote hacia arriba si esta colisiona con la raqueta
    else if(collision()){
      ya = -2;
      y = juego.racquet.getTopY() - DIAMETER2; //colocamos a la pelota sobre la raqueta
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
   g.fillOval(x, y, DIAMETER2, DIAMETER2);
 }
  
 public Rectangle getBounds(){
   return new Rectangle(x, y, DIAMETER2, DIAMETER2);
 }
}
