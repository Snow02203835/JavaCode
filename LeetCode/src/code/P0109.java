package code;

import model.BinaryTree;
import model.ListNode;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P0109 {
    public static void main(String[] args) {
        P0109 main = new P0109();
        BinaryTree showTree = new BinaryTree();
        ListNode list = ListNode.toList("[-10,-3,0,5,9]");
        System.out.println(showTree.serialize(main.sortedListToBST(list)));
    }
    public TreeNode sortedListToBST(ListNode head) {
        return connect(toList(head));
    }

    private TreeNode connect(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return null;
        }
        if (nums.size() == 1) {
            return new TreeNode(nums.get(0));
        }
        int middle = nums.size()/2;
        TreeNode root = new TreeNode(nums.get(middle));
        root.left = connect(nums.subList(0, middle));
        root.right = connect(nums.subList(middle+1, nums.size()));
        return root;
    }

    private List<Integer> toList(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            nums.add(temp.val);
            temp = temp.next;
        }
        return nums;
    }
}
