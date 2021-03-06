package com.xamlab.com;

import static com.xamlab.com.Constants.*;

public class Node {

    //Key
    private int key;

    public int getKey() {
        return key;
    }

    //Left child node
    private Node left;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }


    //Right child Node
    private Node right;

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
    private boolean color;

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }


    //NIL Node
    public Node() {
        this.key = -1;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public Node(int key) {
        this.key = key;
        this.left = nil;
        this.right = nil;
        this.parent = nil;
        this.color = BLACK;
    }

    public Node(int key, Node left, Node right, Node parent, boolean color) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.color = color;
    }

    public void printNodeProperties() {
        if (this.isNil()) return;
        String color = this.color == BLACK ? "Color:BLACK" : "Color:RED";
        String key = String.format("Key:%s", this.key);
        String left = this.left == nil ? "Left:NIL" : String.format("Left:%s", this.left.key);
        String right = this.right == nil ? "Right:NIL" : String.format("Right:%s", this.right.key);
        String parent = this.parent == nil ? "Parent:NIL" : String.format("Parent:%s", this.parent.key);
        System.out.print(color + " " + key + " " + left + " " + right + " " + parent + "\n");
    }

    public boolean isNil() {
        return this.key == -1;
    }


}
