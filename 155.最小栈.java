/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//push(x) —— 将元素 x 推入栈中。
//pop() —— 删除栈顶的元素。
//top() —— 获取栈顶元素。
//getMin() —— 检索栈中的最小元素。

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */

// @lc code=start
class MinStack {

    private int[] stack;
    private int size;
    private int capacity;
    private int minNumber = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        //初始化stack大小
        int initStackSize = 16;
        stack = new int[initStackSize];
        size = initStackSize;
        capacity = 0 ;
    }
    
    public void push(int x) {
        //1. 添加到第0位
        //1.1. 如果stack已满，则2倍扩容
        if (capacity+1 > size ) {
            resize();
        }

        //1.2 所有元素右移1位
        int last = capacity - 1;
        while (last >= 0) {
            stack[last + 1] = stack[last];
            last--;
        }
        //1.3 push
        stack[0] = x;

        //2. capacity++
        capacity++;
        //3. 比较最小值
        if (x <= minNumber) {
            minNumber = x;
        }

    }

    private void resize() {
        int newSize = size * 2;
        int[] newStack = new int[size * 2];
        int i = 0;
        while (i <= (capacity - 1)) {
            newStack[i] = stack[i];
            i++;
        }

        size = newSize;
        stack = newStack;

    }

    public void pop() {
        //1. 移出第0位
        //2. [1,size-1] 左移一位
        int popVal = stack[0];
        int i = 1;
        while (i <= capacity - 1) {
            stack[i - 1] = stack[i];
            i++;
        }
        //3.减少capacity
        capacity--;
        //3. 更新最小值
        if (popVal==minNumber){
            minNumber = findOtherNumber();
        }
    }

    private int findOtherNumber() {
        int min = Integer.MAX_VALUE;
        int i = 0;
        while (i<= capacity - 1) {
            if (stack[i] <= min) {
                min = stack[i];
            }
            i++;
        }
        return min;
    }


    public int top() {
        return stack[0];
    }
    
    public int getMin() {
        //返回最小值
        return minNumber;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
//        stack.push(-2);
//        stack.push(0);
//        stack.push(-3);
//        System.out.println(stack.getMin());
//        stack.pop();
//        System.out.println(stack.top());
//        System.out.println(stack.getMin());
        String[] operatorArray = {"push","push","push","getMin","push","push","push","push","push","top","push","push","getMin","push","getMin","push","push","getMin","push","top","push","getMin","push","push","push","push","getMin","push","push","top","push","push","getMin","pop","getMin","push","push","getMin","getMin","push","getMin","pop","push","push","push","getMin","push","getMin","getMin","getMin","pop","getMin","push","push","getMin","top","getMin","push","getMin","getMin","getMin","getMin","push","getMin","getMin","getMin","push","getMin","push","getMin","push","getMin","getMin","getMin","getMin","pop","getMin","push","getMin","getMin","push","push","pop","push","getMin","push","top","top","push","push","getMin","pop","getMin","push","top","push","getMin","push","getMin","getMin"};
        Integer[] operatorNumber = {85, -99, 67, 0, -27, 61, -97, -27, 35, 0, 99, -66, 0, -89, 0, 4, -70, 0, 52, 0, 54, 0, 94, -41, -75, -32, 0, 5, 29, 0, -78, -74, 0, 0, 0, -58, -44, 0, 0, -64, 0, 0, -45, -99, -27, 0, -96, 0, 0, 0, 0, 0, 26, -58, 0, 0, 0, 25, 0, 0, 0, 0, 33, 0, 0, 0, 71, 0, -62, 0, -78, 0, 0, 0, 0, 0, 0, -30, 0, 0, 85, -15, 0, -40, 0, 72, 0, 0, 18, 59, 0, 0, 0, -59, 0, 10, 0, 9, 0, 0};
        int i = 0;
        while (i <= operatorArray.length) {
            System.out.println(i + ":" + operatorArray[i] + ": " + operatorNumber[i]);
            switch (operatorArray[i]) {
                case "push":
                    stack.push(operatorNumber[i]);
                    break;
                case "getMin":
                    System.out.println(i + ":" + stack.getMin());
                    break;
                case "top":
                    System.out.println(i + ":" + stack.top());
                    break;
                case "pop":
                    stack.pop();
                    break;
                default:
                    System.out.println("操作有误");
            }
            i++;
        }



    }

}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

