package com.zc.tree;

/**
 * https://developer.aliyun.com/ask/302552
 * <p>
 * 只要看到二叉树的问题，先把这个框架写出来准没错
 * TreeNode left = lowestCommonAncestor(root.left, p, q);
 * TreeNode right = lowestCommonAncestor(root.right, p, q);
 * <p>
 * <p>
 * 然后对于递归的问题，无非就是灵魂三问
 * 1. 这个函数是干嘛的？
 * 当p和q不存在的时候，返回null
 * 当p和q中一个存在的时候返回那个节点
 * 当p和q都存在时候就返回最近公共祖先
 * 2. 参数的变量是什么？
 * root变成root.left和roo.right
 * 3. 得到递归结果你想干嘛？
 * 如果左右子树都为空，返回null
 * 如果其中一个为null，那么返回另一个（可能是公共祖先，也可能是单个节点）
 * 如果都不为null，那么返回root（因为这时候root就是他们的最近公共祖先。因为再往上的节点都是要么在左子树能找到这两个节点，要么在右子数）
 * 4. 递归停止的条件？
 * root为空
 * root等于p或q，直接返回。（可能是公共祖先，也可能是单个节点）
 *
 * @author lizhecao 2021/3/22
 * @version 1.0
 */
public class LowestCommonAncestorOfABinaryTree {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (null == root) {
      return null;
    }
    if (root == p || root == q) {
      return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (null == left && null == right) {
      return null;
    }

    if (null != left && null != right) {
      return root;
    }
    return null == left ? right : left;
  }
}

