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
        printTree(node.getLeft());
        printTree(node.getRight());
    }


    //Finding Node
    //returns null if there is no node  by key
    public Node findNode(int key, Node node) {
        if (this.root == null) return null;
        if (key < node.getKey()) {
            if (node.getLeft() != nil) return findNode(key, node.getLeft());
        } else if (key > node.getKey()) {
            if (node.getRight() != nil) return findNode(key, node.getRight());
        } else if (key == node.getKey()) {
            return node;
        }
        System.out.print(String.format("There is no  node by Key:%s", key));
        return null;


    }

    //Right Rotation
    //We have two cases
    // 1. when we rotate  root node
    // 2. when we  rotate internal node
    public void rotateRight(Node node) {
        //case 2
        if (node.getParent() != nil) {
            if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(node.getLeft());
            } else {
                node.getParent().setRight(node.getLeft());
            }
            node.getLeft().getParent().setParent(node.getParent());
            node.setParent(node.getLeft());
        } else
        //case 1
        {
            Node left = root.getLeft();
            root.setLeft(root.getLeft().getRight());
            left.getRight().setParent(root);
            root.setParent(left);
            left.setRight(root);
            left.setParent(nil);
            root = left;
        }
    }


}
