package JuegoTenis;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


/**
 *
 * @author romy
 */
public class SoundTest {
  public static void main(String[] args) throws Exception{
    
//		System.out.println("1");
//		URL url = new URL("http://www.edu4java.com/es/game/sound/cancion.wav");
//		System.out.println("2");
//		AudioClip clip = Applet.newAudioClip(url);
//		System.out.println("3");
//		clip.play();
//		System.out.println("4");
//		Thread.sleep(1000);

//URL url = new URL("file:C:\Users\Usuario\Documents\Administración\CFGS DAM-DAW\Programación\Actividades Programación\Archivos Java\Tema 7\src\JuegoTenis\cancion.wav);

URL url = SoundTest.class.getResource("back.wav");
AudioClip clip = Applet.newAudioClip(url);
AudioClip clip2 = Applet.newAudioClip(url);
clip.play();
Thread.sleep(10);
clip2.loop();
Thread.sleep(200);
clip2.stop();

    System.out.println("end");
  }
}
