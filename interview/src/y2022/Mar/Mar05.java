package y2022.Mar;

import java.util.*;

/**
 * @author Iris 2022/3/5
 */
public class Mar05 {

    /**
     * @see 面试题02.08.环路检测
     * @param head
     * @return 返回环路开始的头节点，否则返回null
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     * @see 面试题03.03.堆盘子
     * 包含多个栈的数据结构
     */
    static class StackOfPlates {
        private final List<Stack<Integer>> data = new ArrayList<>();
        private int stackSize;

        public StackOfPlates(int cap) {
            stackSize = cap;
        }

        public void push(int val) {
            if (stackSize <= 0) return;
            // 序列为空则加入新的栈
            if (data.isEmpty()) data.add(new Stack<>());
            // 当前栈满，则添加新栈
            if (data.get(data.size() - 1).size() == stackSize) data.add(new Stack<>());
            // push元素
            data.get(data.size() - 1).push(val);
        }

        public int pop() {
            return popAt(data.size() - 1);
        }

        public int popAt(int index) {
            // 特殊情况:空栈，index超界
            if (stackSize == 0 || index < 0 || index >= data.size()) return -1;
            Integer popData = data.get(index).pop();
            // 如果当前栈抛出后为空则删除
            if (data.get(index).isEmpty()) data.remove(index);
            return popData;
        }
    }

    /**
     * @see 面试题03.05.栈排序
     */
    static class SortedStack {
        private Stack<Integer> data = new Stack<>();
        private Stack<Integer> temp = new Stack<>();

        public SortedStack() {}

        public void push(int val) {
            // 将当前元素按照栈中元素顺序压入
            while (!data.isEmpty() && data.peek()<val) {
                temp.push(data.pop());
            }
            data.push(val);
            // 将弹出的元素压回
            while (!temp.isEmpty()) {
                data.push(temp.pop());
            }
        }

        public void pop() {
            if (!data.isEmpty()) data.pop();
        }

        public int peek() {
            return (data.isEmpty()) ? -1 : data.peek();
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }
    }


    private boolean[] visited = null;
    /**
     * @see 面试题04.01.节点间通路
     * @param n 图中节点数
     * @param graph 有向图节点数组
     * @param start 起始节点
     * @param target 目标节点
     * @return 返回两节点间是否存在路径
     */
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 访问状态数组
        this.visited = new boolean[graph.length];
        // 反向DFS
        return rDfs(graph, start, target);
    }
    private boolean rDfs(int[][] graph, int start, int target) {
        for (int i = 0; i < graph.length; i++) {
            // 当前节点未被访问（Boolean初始为false）
            if (!visited[i]) {
                // 初始节点可直接到目标点
                if (graph[i][0]==start && graph[i][1]==target) return true;
                visited[i] = true;
                // 压缩搜索区间
                if (graph[i][1]==target && rDfs(graph, start, graph[i][0])) return true;
                visited[i] = false;
            }
        }
        return false;
    }

    /**
     * @see 面试题04.03.特定深度节点链表
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 特殊情况
        if (tree == null) return new ListNode[0];
        queue.offer(tree);

        // 层序遍历
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            ListNode root = new ListNode(0);
            ListNode head = root;
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = queue.poll();
                root.next = new ListNode(curNode.val);
                root = root.next;
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            temp.add(head.next);
        }

        ListNode[] res = new ListNode[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
