package JuegoTenis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author romy
 */
public class GameLoop extends JPanel {

  Ball ball = new Ball(this);
  Ball2 ball2 = new Ball2(this);
  Racquet racquet = new Racquet(this);
  int speed = 1;

  public int getScore() {
    return speed - 1;
  }

  //En este constructor llamaremos al KeyListener
  public GameLoop() {
    addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyReleased(KeyEvent e) {
        racquet.keyReleased(e);
      }

      @Override
      public void keyPressed(KeyEvent e) {
        racquet.keyPressed(e);
      }

    });
    setFocusable(true);
    Sound.SOUND.loop();
  }

  private void move() {
    ball.move();
    ball2.move();
    racquet.move();
  }

  /*El método moveBall incrementa cada variable en 1+
  private void moveBall(){
    x = x + 1;
    y = y + 1;
  }*/
  @Override
  public void paint(Graphics g) {
    super.paint(g); //limpia la pantalla
    Graphics2D g2d = (Graphics2D) g;
    //Suavizar los bordes del oval
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setColor(Color.MAGENTA);
    ball.paint(g2d); //conversión desde la clase Ball
    Graphics2D g2b = (Graphics2D) g;
    g2b.setColor(Color.BLUE);
    ball2.paint(g2b);
    Graphics2D g2p = (Graphics2D) g;
    g2p.setColor(Color.GRAY);
    racquet.paint(g2p); //conversión desde la clase Racquet
  }

  public void paintText(Graphics t) {
    Graphics2D g2t = (Graphics2D) t;
    g2t.setColor(Color.LIGHT_GRAY);
    g2t.setFont(new Font("Courier", Font.BOLD, 30));
    g2t.drawString(String.valueOf(getScore()), 10, 30);
  }

  /*
  El método gameOver() lanzará un mensaje indicando "Game Over" con un
  botón de Aceptar, haciendo que se termine el programa con System.exit(ABORT)
  Cuando en Ball() detecta que la bola ha llegado al límite del lienzo
  manda la orden a gameOver()
   */
  public static void main(String[] args) throws InterruptedException {
    JFrame ventanaJuego = new JFrame("El juego del Tenis");
    GameLoop juego = new GameLoop();
    ventanaJuego.add(juego);
    ventanaJuego.setSize(300, 400);
    ventanaJuego.setBackground(Color.LIGHT_GRAY);
    ventanaJuego.setVisible(true);
    ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    while (true) { //Game Loop
      juego.move();
      juego.repaint();
      //le dice al procesador que el thread que se está ejecutando descanse por 10 milisegundos
      Thread.sleep(10);
    }
  }

  public void gameOver() {
    Sound.SOUND.stop();
    Sound.GAMEOVER.play();
    JOptionPane.showMessageDialog(this, "Tu puntuación es: " + getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
    System.exit(ABORT);
  }

}
