package com.xamlab.com;

import static com.xamlab.com.Constants.*;

public class RedBlackTree {

    Node root;

    public RedBlackTree() {
        root = nil;
    }

    public RedBlackTree(Node node) {
        root = node;
    }

    //Printing Red-Black Tree traveling by height
    public void printTree(Node node) {
        if (node == nil) return;
        node.printNodeProperties();
        printTree(node.left);
        printTree(node.right);
    }



    //Finding Node
    //returns null if there is no node  by key
    public Node findNode(int key, Node node) {
        if (this.root == null) return null;
        if (key < node.getKey()) {
            if (node.getLeft() != nil) return findNode(key, node.left);
        } else if (key > node.getKey()) {
            if (node.getRight() != nil) return findNode(key, node.right);
        } else if (key == node.getKey()) {
            return node;
        }
        System.out.print(String.format("There is no  node by Key:%s", key));
        return null;


    }


}
