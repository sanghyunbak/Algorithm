package com.shbak.study.queue;

/**
 * implements ring buffer: have a size
 * that solve element move problem
 *
 * enque: insert data to queue
 * deque: get data from queue and delete
 * front: at first element's index
 * rear : last + 1 index to enque
 */
public class RingBuffer {
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;

    /**
     * initialize
     *  - queue memory assign
     *  - initial value assign
     * @param capacity
     */
    public RingBuffer(int capacity) {
        this.max = capacity;
        front = rear = num = 0;
        this.que = new int[this.max];
    }

    public class RingBufferQueueOverflowException extends RuntimeException {}

    public int enqueue(int value) {
        if (num == max) {
            throw new RingBufferQueueOverflowException();
        }

        que[rear++] = value;
        if (rear == this.max) {
            rear = 0;
        }
        num++;

        return this.rear;
    }

    public class RingBufferEmptyException extends RuntimeException {}

    public int dequeue() {
        if (num <= 0) {
            throw new RingBufferEmptyException();
        }

        int value = this.que[front++];
        num--;

        if(front == this.max) {
            front = 0;
        }

        return value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("======================== RingBuffer Current Status =========================\n");
        sb.append(String.format("%-20s: %d\n", "max", max));
        sb.append(String.format("%-20s: %d\n", "rear", rear));
        sb.append(String.format("%-20s: %d\n", "front", front));
        sb.append(String.format("%-20s: %d\n", "num", num));
        sb.append(String.format("%-20s: ", "queue"));

        if(front < rear) {
            for (int i = front; i < rear; i++) {
                sb.append(que[i] + " ");
            }
        }
        else {
          for (int i = front; i < this.max; i++) {
              sb.append(que[i] + " ");
          }

          for (int i = 0; i< rear; i++) {
              sb.append(que[i] + " ");
          }
        }
        sb.append("\n");
        sb.append("=============================================================================\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        final int NUM = 10;
        RingBuffer ringBuffer = new RingBuffer(NUM);

        for (int i = 0; i < NUM; i++) {
            ringBuffer.enqueue(i);
        }

        System.out.println("initial status :\n" + ringBuffer.toString());

        ringBuffer.dequeue();
        ringBuffer.dequeue();
        ringBuffer.dequeue();

        System.out.println("three times call dequeue: \n" + ringBuffer.toString());

        ringBuffer.enqueue(11);

        System.out.println("enqueue 11 : \n" + ringBuffer.toString());
    }
}
