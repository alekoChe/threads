package pingPong;

import java.util.concurrent.Phaser;

public class PingPong2 {

    static final Phaser phase = new Phaser(1);

    public static void main(String[] args) {
        play("ping");
        play("pong");
    }
    private static void play(final String msg) {
        new Thread() { public void run() {
            while (true) {
                System.out.println(msg);
                phase.awaitAdvance(phase.arrive()+1);
                pause(500);
            }
        }}.start();
    }

    private static void pause(int timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
