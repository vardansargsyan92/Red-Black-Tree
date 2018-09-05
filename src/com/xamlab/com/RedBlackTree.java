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
    //We have three cases
    // 1. when we rotate  root node
    // 2. when we  rotate internal node
    // 3. when the  root is NIL
    public void rotateRight(Node node) {

        //case3
        if (node == nil) return;

        //case 2
        if (node.getParent() != nil) {
            if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(node.getLeft());
            } else {
                node.getParent().setRight(node.getLeft());
            }
            node.getLeft().setParent(node.getParent());
            node.setParent(node.getLeft());

            if (node.getLeft().getRight() != nil) {
                node.getLeft().getRight().setParent(node);
            }
            node.setLeft(node.getLeft().getRight());
            node.getParent().setRight(node);
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

    //Left Rotation
    //We have three cases
    // 1. when we rotate  root node
    // 2. when we  rotate internal node
    // 3. when the  root is NIL
    public void rotateLeft(Node node) {

        //case 3
        if (node == nil) return;

        //case2
        if (node.getParent() != nil) {
            if (node == node.getParent().getLeft()) {
                node.getParent().setLeft(node.getRight());
            } else {
                node.getParent().setRight(node.getRight());
            }

            node.getRight().setParent(node.getParent());
            node.setParent(node.getRight());


            if(node.getRight().getLeft()!=nil){
                node.getRight().getLeft().setParent(node);
            }

            node.setRight(node.getRight().getLeft());
            node.getParent().setLeft(node);

        }else

        //case 1
        {
            Node right = root.getRight();
            root.setRight(right.getLeft());
            right.getLeft().setParent(root);
            root.setParent(right);
            right.setLeft(root);
            right.setParent(nil);
            root = right;
        }
    }


}
