package synthesizer;

import java.util.Random;

public class GuitarString {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996;

    private BoundedQueue<Double> buffer;

    public GuitarString(double frequency){
        buffer=new ArrayRingBuffer<>((int)Math.round(SR/frequency));
        for (int i = 0; i < buffer.capacity() ; i++) {
            buffer.enqueue(0.0);
            
        }
    }
    public void pluck(){
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.dequeue();
            buffer.enqueue(Math.random()-0.5);

        }
    }
    public void tic(){
       double frontsample= buffer.dequeue();
       buffer.enqueue(DECAY*0.5*(frontsample+ sample()));


        }
    public double sample() {
        return buffer.peek();
    }
    }

