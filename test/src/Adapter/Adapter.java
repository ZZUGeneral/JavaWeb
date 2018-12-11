package Adapter;

public class Adapter implements WindowMediaPlayer, RealPlayer {
   private WindowMediaPlayer windowMediaPlayer;
   private RealPlayer realPlayer;
   
   public void adapter(WindowMediaPlayer windowMediaPlayer) {
	  this.windowMediaPlayer = windowMediaPlayer;
   }
   
   public void adapter(RealPlayer realPlayer) {
	  this.realPlayer = realPlayer;
   }
   public void windowPlay() {
	  windowMediaPlayer.windowPlay();
   }
   
   public void realPlay() {
	  realPlayer.realPlay();
   }

}