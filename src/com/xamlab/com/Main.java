package com.xamlab.com;

import static com.xamlab.com.Constants.*;

public class Main {

    public static void main(String[] args) {

        Node node = new Node(7, nil, nil, nil, BLACK);
        Node node1 = new Node(3, nil, nil, node, BLACK);
        Node node2 = new Node(18, nil, nil, node, RED);
        node.setLeft(node1);
        node.setRight(node2);

        Node node3 = new Node(10, nil, nil, node2, BLACK);
        Node node4 = new Node(22, nil, nil, node2, BLACK);
        node2.setLeft(node3);
        node2.setRight(node4);

        Node node5 = new Node(8, nil, nil, node3, RED);
        Node node6 = new Node(11, nil, nil, node3, RED);
        node3.setLeft(node5);
        node3.setRight(node6);

        Node node7 = new Node(26, nil, nil, node4, RED);
        node4.setRight(node7);

        RedBlackTree tree = new RedBlackTree(node);



        tree.printTree(tree.root);
        System.out.println();
        System.out.println();


        /*//right rotation of node with key 18
        tree.rotateRight(tree.findNode(18, tree.root));
        tree.printTree(tree.root);
        System.out.println();
        System.out.println();*/

        //left rotation of node with key 18
        tree.rotateLeft(tree.findNode(18, tree.root));
        tree.printTree(tree.root);
        System.out.println();
        System.out.println();
    }
}
