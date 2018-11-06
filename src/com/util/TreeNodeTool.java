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
		TreeNode temp = root;

		while (temp != null || !stack.isEmpty()) {

			if (temp != null) {
				System.out.print(temp.val + " ");
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				//stack.push(temp.right);右子节点不需要存入
				temp = temp.right;
			}
		}
	}

	
	/**
	 * 中序遍历（非递归法）
	 * 
	 * @param root
	 */
	public static void LDRTraverse(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;

		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			else {
				temp = stack.pop();
				System.out.print(temp.val + " ");
				temp = temp.right;	//出栈访问右子节点，而不是出栈后输出，造成了返回父节点后，再次访问子节点。
			}
		}
	}
	
	
	
	/**
	 * 测试用例
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		TreeNodeTool.levelTraverse(root);
		TreeNodeTool.DLRTraverse(root);
		TreeNodeTool.LDRTraverse(root);
//		System.out.println(kthSmallest(root, 2));
	}
}
