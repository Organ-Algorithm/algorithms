package com.arithmetic.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.util.TreeNode;
import com.util.TreeNodeTool;

/**
 * 给定一个二叉搜索树，通过kthSmallest()方法来查找其中第 k 个最小的元素
 *
 * @author HONG
 * @date: 2018年10月31日 下午3:03:34
 */
public class S5_kthSmallest {

	/**
	 * 查找二叉搜索树中第 k 个最小的元素
	 * 
	 * @param root 二叉搜索树
	 * @param k    第k个最小元素
	 * @return 第k个最小元素的值，若不存在第k个最小元素的值
	 */
	public static int kthSmallest(TreeNode root, int k) {

		List<TreeNode> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			
			while (stack.peek().left != null) {
				stack.push(stack.peek().left);
			}

			TreeNode temp = stack.pop();
			list.add(temp);
			
			if (temp.right != null) {
				stack.push(temp.right);
			}

		}

		return list.get(k).val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		TreeNodeTool.levelTraverse(root);
		TreeNodeTool.LDRTraverse(root);
//		System.out.println(kthSmallest(root, 2));
	}
}
