package tree;

import supportmodel.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 示例 1：
 * 1
 *  2
 * 3
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 */
public class InorderTraversal {

    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                result.addAll(inorderTraversal(root.left));
            }
            result.add(root.val);
            if (root.right != null) {
                result.addAll(inorderTraversal(root.right));
            }
        }
        return result;
    }

    /**
     * 递归版
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res,root);
        return res;
    }

    private static void dfs(List<Integer> res, TreeNode root) {
        if(root==null) {
            return;
        }
        //按照 左-打印-右的方式遍历
        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);
    }

    /**
     * 非递归版 用栈模拟遍历顺序
     */
    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                root = pop.right;
            }
        }
        return result;
    }
}
