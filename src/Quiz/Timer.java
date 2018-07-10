package Quiz;

import gui.QuizController;

import java.util.TimerTask;

public class Timer {

    private java.util.Timer t;
    private TimerTask tt;
    private int maxIterations = 100, usedIterations = 100;
    private QuizController c;

    public Timer(QuizController c) {
        this.c = c;
        t = new java.util.Timer();
    }

    public void waitForNextQuestion(final int iterations){
        t.scheduleAtFixedRate(tt = new TimerTask() {
            private int it = iterations;
            @Override
            public void run() {
                if (it != 0) {
                    it -= 1;
                }else{
                    c.displayQuestion();
                    interrupt();
                }
            }
        }, 50, 50);
        tt.run();
    }

    public void start() {
        usedIterations = maxIterations;
        t.scheduleAtFixedRate(tt = new TimerTask() {
            @Override
            public void run() {
                if (usedIterations != 0) {
                    usedIterations -= 1;
                    c.setProgressBar(((double)usedIterations/maxIterations));
                }else{
                    interrupt();
                    c.timeIsUp();
                }
            }
        }, 50, 50);
        tt.run();
    }

    public void interrupt() {
        tt.cancel();
    }

    public int getUsedIterations() {
        return usedIterations;
    }

    /**
     * @return millis needed to answer the question
     */
    public long getUsedTime() {
        return 0;
    }
}
