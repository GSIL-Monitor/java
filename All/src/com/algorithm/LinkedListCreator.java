package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *	递归创建链表，按照以下原则：
 *		严格定义递归函数作用，包括参数，返回值，Side-effect
 *  	先一般，后特殊
 *  	每次调用必须缩小问题规模
 *  	每次问题规模缩小程度必须为1
 */
public class LinkedListCreator {
	/**
	 * 递归创建linked list方法
	 */
	public Node createLinkedList(List<Integer> data) {

		if (data.isEmpty()) {
			return null;
		}

		Node firstNode = new Node(data.get(0));
		//递归   .subList(1, data.size()) 为去掉第0个元素剩下的所有元素
		firstNode.setNext(createLinkedList(data.subList(1, data.size())));

		//firstNode是head  指向null
		return firstNode;
	}


	public static void main(String[] args) {
		LinkedListCreator creator = new LinkedListCreator();

		Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));
		Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));
		Node.printLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)));

	}


}
