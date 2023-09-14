package com.zc.tree;

/**
 * @author lizhecao 2021/3/22
 * @version 1.0
 */
public class InvertBinaryTree226 {
  public TreeNode invertTree(TreeNode root) {
    if (null == root) {
      return null;
    }

    invertTree(root.left);
    invertTree(root.right);
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    return root;
  }
}
