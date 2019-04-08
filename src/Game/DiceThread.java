package Game;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Graphics.CustomImage;

public class DiceThread extends Thread {
   // -------------------------------
   private boolean loadingDice;
   private CustomImage diceImage;
   private JLabel diceLabel;
   private int randomNo;
   private JButton dBtn;
   private final int DELAY = 20; // Delay between animation
   private static int HEIGHT = 115;
   private static int WIDTH = 115;

   // ================================

   public DiceThread(JLabel jLabel, int randomNo, boolean loadingDice) {
      super("Dice Thread");
      this.loadingDice = loadingDice;
      diceLabel = jLabel;
      this.randomNo = randomNo;
      start();
   }

   public void run() {

      if (!loadingDice) {
         // Creating Animation ==============================
         int tmp = 0;
         tmp = tmp + HEIGHT; // offset for image

         // First Row of Sprite //
         for (int i = 0; i < 4; i++) {
            diceImage = new CustomImage("assets/diceSprite.png", WIDTH, HEIGHT, tmp, 0);
            tmp = tmp + WIDTH;
            diceLabel.setIcon(new ImageIcon(diceImage.getImage()));
            try {
               Thread.sleep(DELAY);
            } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
         // Second Row of Sprite //
         tmp = 0;
         for (int i = 0; i < 5; i++) {
            diceImage = new CustomImage("assets/diceSprite.png", WIDTH, HEIGHT, tmp, HEIGHT);
            tmp = tmp + HEIGHT;
            diceLabel.setIcon(new ImageIcon(diceImage.getImage()));
            try {
               Thread.sleep(DELAY);
            } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
         // Third Row of Sprite //
         tmp = 0;
         for (int i = 0; i < 5; i++) {
            diceImage = new CustomImage("assets/diceSprite.png", WIDTH, HEIGHT, tmp, HEIGHT * 2);
            tmp = tmp + HEIGHT;
            diceLabel.setIcon(new ImageIcon(diceImage.getImage()));
            try {
               Thread.sleep(DELAY);
            } catch (InterruptedException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      }
      // End of Sprite //
      // ========= Displaying last result on DICE =======================
      switch (randomNo) {
      case 1:
         diceImage = new CustomImage("assets/1.png", WIDTH, HEIGHT, 0, 0);
         break;
      case 2:
         diceImage = new CustomImage("assets/2.png", WIDTH, HEIGHT, 0, 0);
         break;
      case 3:
         diceImage = new CustomImage("assets/3.png", WIDTH, HEIGHT, 0, 0);
         break;
      case 4:
         diceImage = new CustomImage("assets/4.png", WIDTH, HEIGHT, 0, 0);
         break;
      case 5:
         diceImage = new CustomImage("assets/5.png", WIDTH, HEIGHT, 0, 0);
         break;
      case 6:
         diceImage = new CustomImage("assets/6.png", WIDTH, HEIGHT, 0, 0);
         break;
      }
      diceLabel.setIcon(new ImageIcon(diceImage.getImage()));
      dBtn.setEnabled(true);
   }
}