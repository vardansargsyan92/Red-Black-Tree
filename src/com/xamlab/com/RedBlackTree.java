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
        String color = node.getColor() == BLACK ? "Color:BLACK" : "Color:RED";
        String key = String.format("Key:%s", node.getKey());
        String left = node.getLeft() == nil ? "Left:NIL" : String.format("Left:%s", node.left.getKey());
        String right = node.getRight() == nil ? "Right:NIL" : String.format("Right:%s", node.right.getKey());
        String parent = String.format("Parent:%s", node.getParent().getKey());

        System.out.print(key + " " + color + " " + left + " " + right + " " + parent + "\n");
        printTree(node.left);
        printTree(node.right);
    }


}
