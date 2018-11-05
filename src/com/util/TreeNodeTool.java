package com.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * TreeNode实例对象的工具类，主要实现各种遍历。
 *
 * @author HONG
 * @date: 2018年10月31日 上午11:08:35
 */
public class TreeNodeTool {

	/**
	 * 层次遍历（非递归法）
	 * 
	 * @param root 遍历的根节点
	 */
	public static void levelTraverse(TreeNode root) {
		Queue<TreeNode> queueA = new LinkedList<>();
		Queue<TreeNode> queueB = new LinkedList<>();

		queueA.add(root);

		while (!queueA.isEmpty() || !queueB.isEmpty()) {
			/*
			 * 两个队列对象，一个队列存储一层的所有结点；使用两个队列，为逐层输出时层与层之间有间隔区别。
			 */
			Queue<TreeNode> queueNoNull = queueA.peek() == null ? queueB : queueA;
			Queue<TreeNode> queueNull = queueB.peek() == null ? queueB : queueA;

			while (!queueNoNull.isEmpty()) {
				TreeNode node = queueNoNull.remove();
				System.out.print(node.val + " ");

				if (node.left != null) {
					queueNull.add(node.left);
				}

				if (node.right != null) {
					queueNull.add(node.right);
				}

			}
			System.out.println();
		}

	}

	/**
	 * 先序遍历（非递归法：使用Stack）
	 * 
	 * @param root 遍历的根节点
	 */
	public static void DLRTraverse(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();

			System.out.println(node.val + "");

			if (node.right != null) {
				stack.push(node.right);
			}

			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	/**
	 * 中序遍历（非递归法）
	 * 
	 * 问题：采用非递归法（即使用一般循环法），面临的问题是，当左子节点遍历完成后，返回父节点，
	 * 父节点符合知道其左、右子节点已经遍历完成。同样图的遍历可能也会考虑到同样的问题。
	 * 
	 * 常规实现中：是先访问节点，再存入Stack里面，同理【先序遍历法】也是如此。都是先访问节点，再存入Stack中。
	 * 
	 * @param root
	 */
	public static void LDRTraverse(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (node.left != null) {
				stack.push(node.left);
				continue;
			}
			
			System.out.println(node.val);
			
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		//

	}
}
