package com.zc.tree;

/**
 * @author lizhecao 2021/3/22
 * @version 1.0
 */
public class FlattenBinaryTreeToLinkedList114 {
  public void flatten(TreeNode root) {
    flattenHelp(root);
  }

  public TreeNode flattenHelp(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (null == root.left && null == root.right) {
      return root;
    }

    TreeNode leftTail = flattenHelp(root.left);
    TreeNode rightTail = flattenHelp(root.right);

    if (null != root.left) {
      TreeNode temp = root.right;
      root.right = root.left;
      root.left = null;
      leftTail.right = temp;
      if (null == rightTail) {
        return leftTail;
      }
    }

    return rightTail;
  }
}
