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
	 * 对TreeNode实例对象进行层次遍历操作
	 * 
	 * @param root 遍历操作的TreeNode对象的根节点
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
	 * 
	 * @param root
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
}
