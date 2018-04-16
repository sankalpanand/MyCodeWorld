package LeetcodeEasy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels_BFS(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return result;
        q.add(root);

        while(!q.isEmpty()) {

            // We need to store size right now, because going further on the same level we will add children to the queue
            // and only the elements present at this time will be at the same level.
            int n = q.size();
            double sum = 0.0;

            // Since only the elements from 0 to n are at the same level, we go through them.
            for(int i = 0; i < n; i++) {

                TreeNode node = q.poll();
                sum = sum + node.val;

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            result.add(sum / n);
        }
        return result;
    }

    public List<Double> averageOfLevels_DFS(TreeNode root) {
        // list answer for sum all value in same level
        List<Double> answer = new ArrayList<Double>();

        // list counter for count number of node in same level
        List<Integer> counter = new ArrayList<Integer>();

        // using dfs to sum all value in same level and count number of node in same level
        dfs(0, root, answer, counter);

        // answer will be answer[level] / counter[level]
        for (int level = 0; level < answer.size(); level++) {
            answer.set(level, answer.get(level) / counter.get(level));
        }
        return answer;
    }

    public void dfs(int level, TreeNode node, List<Double> answer, List<Integer> counter) {
        if (node == null) {
            return;
        }

        // When you'll move to the next level, if you'll do those update below, you'll run into ArrayOutOfBound exception
        // So make sure that these lists have always some value on their level index
        if (answer.size() <= level) {
            answer.add(0.0);
            counter.add(0);
        }

        // At every level, update the value by adding it to the current node
        answer.set(level, answer.get(level) + node.val);

        // At every level, increment the Count at that level
        counter.set(level, counter.get(level) + 1);

        // go left node and right node
        dfs(level + 1, node.left, answer, counter);
        dfs(level + 1, node.right, answer, counter);
    }
}
