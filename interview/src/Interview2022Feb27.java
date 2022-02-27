import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Iris 2022/2/27
 */
public class Interview2022Feb27 {

    public static void main(String[] args) {

    }

    /**
     * @param headA 链表1头节点
     * @param headB 链表2头节点
     * @return 返回两链表相交节点，否则返回null
     * @apiNote 快慢指针处理，先将其中一个链表尾部指向另一链表头部，然后进行快慢指针匹配，最后消除链表首尾的链接
     * @see 面试题02.07.链表相交
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = (pa == null) ? headB : pa.next;
            pb = (pb == null) ? headA : pb.next;
        }
        return pa;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @see 面试题03.01.三合一[用一个数组实现三个栈]
     */
    class TripleInOne {
        int N = 3;
        int[] data;
        int[] locations;
        int size;

        public TripleInOne(int stackSize) {
            size = stackSize;
            data = new int[size * N];
            locations = new int[N];
            for (int i = 0; i < N; i++) {
                locations[i] = i * size;
            }
        }

        public void push(int stackNum, int value) {
            int idx = locations[stackNum];
            if (idx < (stackNum + 1) * size) {
                data[idx] = value;
                locations[stackNum]++;
            }
        }

        public int pop(int stackNum) {
            int idx = locations[stackNum];
            if (idx > stackNum * size) {
                locations[stackNum]--;
                return data[idx - 1];
            } else {
                return -1;
            }
        }

        public int peek(int stackNum) {
            int idx = locations[stackNum];
            if (idx > stackNum * size) {
                return data[idx - 1];
            } else {
                return -1;
            }
        }

        public boolean isEmpty(int stackNum) {
            return locations[stackNum] == stackNum * size;
        }
    }

    /**
     * @see 面试题03.02.栈的最小值>>>各类操作的时间复杂度必须为O(1)
     */
    class MinStack {
        private Stack<dataBlock> data = new Stack<>();
        private int minVal = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        public void push(int x) {
            dataBlock curBlock = new dataBlock();
            curBlock.val = x;
            minVal = Math.min(minVal, x);
            curBlock.curMin = minVal;
            data.push(curBlock);
        }

        public void pop() {
            data.pop();
            minVal = (data.isEmpty()) ? Integer.MAX_VALUE : data.peek().curMin;
        }

        public int top() {
            return data.peek().val;
        }

        public int getMin() {
            return minVal;
        }

        private class dataBlock {
            private int val;
            private int curMin;
        }
    }

    /**
     * @see 面试题03.04.化栈为队>>>用两个栈实现一个队列
     */
    class MyQueue {
        Stack<Integer> queue;
        Stack<Integer> write;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            queue = new Stack<>();
            write = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            write.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            peek();
            return queue.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!queue.isEmpty()) {
                return queue.peek();
            }
            while (!write.isEmpty()) {
                queue.push(write.pop());
            }
            return queue.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return write.isEmpty() && queue.isEmpty();
        }
    }

    /**
     * @see 面试题03.06.动物收容所>>>每次输出最先的对象编号（cat/dog/any）
     */
    class AnimalShelf {
        private LinkedList<int[]> queueCat;
        private LinkedList<int[]> queueDog;

        public AnimalShelf() {
            queueCat = new LinkedList<>();
            queueDog = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            // 区分动物类别
            if (animal[1] == 0) queueCat.addLast(animal);
            else if (animal[1] == 1) queueDog.addLast(animal);
        }

        public int[] dequeueAny() {
            int[] oldDog, oldCat;
            if (!queueCat.isEmpty()) {
                // 猫不空则取出最早的猫
                oldCat = queueCat.getFirst();
            } else if (!queueDog.isEmpty()) {
                // 猫空狗不空
                return queueDog.removeFirst();
            } else {
                // 两者都空
                return new int[]{-1, -1};
            }
            if (!queueDog.isEmpty()) {
                // 狗不空则取出最早的狗
                oldDog = queueDog.getFirst();
            } else {
                // 狗空猫不空
                return queueCat.removeFirst();
            }
            // 比较猫和狗的收养日期
            return (oldCat[0] <= oldDog[0]) ? queueCat.removeFirst() : queueDog.removeFirst();
        }

        public int[] dequeueDog() {
            // 取出最早的狗
            if (!queueDog.isEmpty()) {
                return queueDog.removeFirst();
            } else {
                return new int[]{-1, -1};
            }
        }

        public int[] dequeueCat() {
            // 取出最早的猫
            if (!queueCat.isEmpty()) {
                return queueCat.removeFirst();
            } else {
                return new int[]{-1, -1};
            }
        }
    }
}
