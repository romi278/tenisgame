package JuegoTenis;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 *
 * @author Usuario
 */
public class Sound {
  public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("golpe.wav"));
  public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("gameover.wav"));
  public static final AudioClip SOUND = Applet.newAudioClip(Sound.class.getResource("back.wav"));
  
}
