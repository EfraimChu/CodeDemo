/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start


import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //思路：
        //每一层可以由上一层得数据Node来获得；
        //所以每次缓存上一层得数据即可；lastLevelNode = List<TreeNode>
        List<List<Integer>> ret = new ArrayList<>();
        if (Objects.isNull(root)) {
            return ret;
        }
        List<TreeNode> lastLevelNode = new ArrayList<>();
        lastLevelNode.add(root);
        ret.add(Arrays.asList(root.val));
        while (true) {
            List<TreeNode> currentLevelNode = new ArrayList<>();
            List<Integer> levelNum = foreachTreeLevel(lastLevelNode, currentLevelNode);
            lastLevelNode = currentLevelNode;

            if (currentLevelNode.isEmpty()) {
                break;
            } else {
                ret.add(levelNum);
            }
        }

        return ret;



    }


    private List<Integer> foreachTreeLevel(List<TreeNode> lastLevelNode, List<TreeNode> currentLevelNode) {
        List<Integer> levelNodeVals = new LinkedList<>();
        lastLevelNode.forEach(node->{
            //left node val
            if (Objects.nonNull(node.left)) {
                levelNodeVals.add(node.left.val);
                currentLevelNode.add(node.left);
            }
            //right node val
            if (Objects.nonNull(node.right)) {
                levelNodeVals.add(node.right.val);
                currentLevelNode.add(node.right);
            }
        });

        return levelNodeVals;
    }

}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
// @lc code=end

