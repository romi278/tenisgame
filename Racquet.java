package JuegoTenis;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author romy
 */
public class Racquet {
  private static final int Y = 330;
  private static final int WIDTH = 80;
  private static final int HEIGHT = 10;
  int x=0; //Inicializamos en 0 la posición x
  int xa=0; //Inicializamos en 1 la posición xa velocidad
  private GameLoop juego;
  
  //El constructor Racquet llamará a la variable juego de la clase GameLoop
  public Racquet(GameLoop juego){
    this.juego=juego;
  }
  
  //Utiliza el parámetro x,xa de moveBall() para la velocidad, controla que el 
  //Sprite no se salga de la pantalla
  public void move(){
    if(x+xa > 0 && x+xa < juego.getWidth()-WIDTH)
      x = x+xa;
  }
  
  public void paint(Graphics2D g){
   g.fillRect(x, Y, WIDTH, HEIGHT);
 }
  
  //Controla cuando dejamos de presionar una tecla, se detiene
  public void keyReleased(KeyEvent e){
    xa = 0;
  }
  
  //Controla el movimiento según la tecla presionada
  public void keyPressed(KeyEvent e){
    if(e.getKeyCode() == KeyEvent.VK_LEFT)
      xa = -6;
    if(e.getKeyCode() == KeyEvent.VK_RIGHT)
      xa = 6;
  }
  
  //Retorna un objeto rectángulo indicando posición racquet()
  public Rectangle getBounds(){
    return new Rectangle(x, Y, WIDTH, HEIGHT);
  }
  
  /*
  nos da la posición en el eje y de la parte superior de la raqueta
  para que esté sobre la raqueta
  */
  public int getTopY(){
    return Y;
  }
}
