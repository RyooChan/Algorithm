/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length - 1);
    }

    private TreeNode makeTree(int[] nums, int start, int end) {
        if(start > end) return null; // 트리 탈출 조건

        int mid = (start + end) / 2; // 이진트리의 중간지점 구하기
        TreeNode node = new TreeNode(nums[mid]); // 해당 지점이 값이 된다.
        node.left = makeTree(nums, start, mid-1); // 왼쪽 트리 구하기(가운데 전까지를 정렬해서 만들면 그게 왼쪽
        node.right = makeTree(nums, mid+1, end); // 반대 오른쪽
        return node;
    }
}
