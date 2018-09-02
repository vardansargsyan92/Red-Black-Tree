package com.xamlab.com;

import static com.xamlab.com.Constants.*;

public class Node {

    //Key
    private int key;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    //Left child node
    Node left;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }


    //Right child Node
    Node right;

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    //Parent Node
    private Node parent;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    //Color either black or red
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    public Node() {
        this.key = -1;
        this.left = nil;
        this.right = nil;
        this.parent = nil;
        this.color = BLACK;
    }

    public Node(int key, Node left, Node right,Node parent, int color) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent=parent;
        this.color = color;
    }


}
