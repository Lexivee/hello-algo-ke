/**
 * File: array_queue.java
 * Created Time: 2022-11-25
 * Author: Krahets (krahets@163.com)
 */

package chapter_stack_and_queue;

import java.util.*;

/* 基于环形数组实现的队列 */
class ArrayQueue {
    private int[] nums;  // 用于存储队列元素的数组
    private int front;   // 队首指针，指向队首元素
    private int queSize; // 队列长度

    public ArrayQueue(int capacity) {
        nums = new int[capacity];
        front = queSize = 0;
    }

    /* 获取队列的容量 */
    public int capacity() {
        return nums.length;
    }

    /* 获取队列的长度 */
    public int size() {
        return queSize;
    }

    /* 判断队列是否为空 */
    public boolean isEmpty() {
        return queSize == 0;
    }

    /* 入队 */
    public void offer(int num) {
        if (queSize == capacity()) {
            System.out.println("队列已满");
            return;
        }
        // 计算尾指针，指向队尾索引 + 1
        // 通过取余操作，实现 rear 越过数组尾部后回到头部
        int rear = (front + queSize) % capacity();
        // 尾结点后添加 num
        nums[rear] = num;
        queSize++;
    }

    /* 出队 */
    public int poll() {
        int num = peek();
        // 队首指针向后移动一位，若越过尾部则返回到数组头部
        front = (front + 1) % capacity();
        queSize--;
        return num;
    }

    /* 访问队首元素 */
    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return nums[front];
    }

    /* 返回数组 */
    public int[] toArray() {
        // 仅转换有效长度范围内的列表元素
        int[] res = new int[queSize];
        for (int i = 0, j = front; i < queSize; i++, j++) {
            res[i] = nums[j % capacity()];
        }
        return res;
    }
}

public class array_queue {
    public static void main(String[] args) {
        /* 初始化队列 */
        int capacity = 10;
        ArrayQueue queue = new ArrayQueue(capacity);

        /* 元素入队 */
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);
        System.out.println("队列 queue = " + Arrays.toString(queue.toArray()));

        /* 访问队首元素 */
        int peek = queue.peek();
        System.out.println("队首元素 peek = " + peek);

        /* 元素出队 */
        int poll = queue.poll();
        System.out.println("出队元素 poll = " + poll + "，出队后 queue = " + Arrays.toString(queue.toArray()));

        /* 获取队列的长度 */
        int size = queue.size();
        System.out.println("队列长度 size = " + size);

        /* 判断队列是否为空 */
        boolean isEmpty = queue.isEmpty();
        System.out.println("队列是否为空 = " + isEmpty);

        /* 测试环形数组 */
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
            queue.poll();
            System.out.println("第 " + i + " 轮入队 + 出队后 queue = " + Arrays.toString(queue.toArray()));
        }
    }
}
