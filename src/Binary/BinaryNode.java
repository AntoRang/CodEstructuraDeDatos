package Binary;

import Queue.Queue;

/**
 * Created by AntonioRang on 11/6/17.
 */
public class BinaryNode {

    public int value;
    public String animal;
    public String qs;
    public BinaryNode leftChild;
    public BinaryNode rightChild;

    public BinaryNode(int value){
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    public BinaryNode(int value, String qs){
        this.value = value;
        this.qs = qs;
        leftChild = null;
        rightChild = null;
    }


    public BinaryNode(String animal){
        this.animal = animal;
        leftChild = null;
        rightChild = null;
    }

    public void preorderTraversal(){
        preorder(this);
    }

    public void inorderTraversal(){
        inorder(this);
    }

    public void postorderTraversal(){
        postorder(this);
    }

    public void dephFirstTraversal(){
        Queue<BinaryNode> fila =new Queue<BinaryNode>();
        BinaryNode temp;
        fila.offer(this);

        while(!fila.isEmpty()){
            temp = fila.remove();
            System.out.print(temp.value);

            if(temp.leftChild != null && temp.rightChild != null) {
                fila.offer(temp.leftChild);
                fila.offer(temp.rightChild);
            }else {
                if(temp.leftChild != null){
                    fila.offer(temp.leftChild);
                }else if(temp.rightChild != null){
                    fila.offer(temp.rightChild);
                }
            }
        }
    }

    private void preorder(BinaryNode node){
        if(node.leftChild == null && node.rightChild == null){
            System.out.print(node.value);
            return;
        }
        if(node.leftChild != null){
            System.out.print(node.value);
            preorder(node.leftChild);
            preorder(node.rightChild);
        } else{
            System.out.print(node.value);
            preorder(node.rightChild);
        }

    }

    private void inorder(BinaryNode node){
        if(node.leftChild == null && node.rightChild == null) {
            System.out.print(node.value);
            return;
        }
        if(node.leftChild!=null){
            inorder(node.leftChild);
            System.out.print(node.value);
            inorder(node.rightChild);
        }else{
            System.out.print(node.value);
            inorder(node.rightChild);
        }
    }

    private void postorder(BinaryNode node){
        if(node.leftChild == null && node.rightChild == null){
            System.out.print(node.value);
            return;
        }
        if(node.leftChild != null) {

            postorder(node.leftChild);
            postorder(node.rightChild);
            System.out.print(node.value);
        }else{
            postorder(node.rightChild);
            System.out.print(node.value);
        }
    }

    public int treeSize(BinaryNode node){
        int count =0 ;
        if(node.leftChild == null && node.rightChild == null){
            count++;
            return count;
        }
        if(node.leftChild != null) {
            treeSize(node.leftChild);
            treeSize(node.rightChild);
            count++;
        }else{
            treeSize(node.rightChild);
            count++;
        }
        return count;
    }


    public void addNode(int value) {
        if(value < this.value) {
            if(leftChild == null) {
                leftChild = new BinaryNode(value);
            }
            leftChild.addNode(value);
        }
        if(value > this.value){
            if (rightChild == null) {
                rightChild = new BinaryNode(value);
            }
            rightChild.addNode(value);
        }
    }

    public BinaryNode findNode(int target){

        if(target == this.value){
            return this;
        }

        if(target < this.value) {
            if(leftChild == null) {
                return null;
            }
            return leftChild.findNode(target);
        }
        else {
            if(rightChild == null) {
                return null;
            }
            return rightChild.findNode(target);
        }

    }

    public int countOneChild(BinaryNode root) {
        int count = 0;
        if (root.leftChild!= null) {
            if(root.rightChild == null){
                count += 1 + height(root.leftChild);
            }
            count += height(root.leftChild);
        }

        if (root.rightChild!= null) {
            if(root.leftChild== null){
                count += 1 + height(root.rightChild);
            }
            count += height(root.rightChild);
        }

        return count;
    }
//    public int treeSize(BinaryNode node) {
//        int count = 1;
//        if (node.leftChild != null) {
//            count = 1 + treeSize(node.leftChild);
//        }
//
//        if (node.rightChild != null) {
//            count += treeSize(node.rightChild);
//        }
//
//        return count;
//    }


    public int height(BinaryNode root) {
        int l = 0;
        int r = 0;
        if(root.rightChild == null){
            r=0;
        }else{
            r = 1 + height(root.rightChild);
        }

        if(root.leftChild == null){
            l=0;
        }else{
            l = 1 + height(root.leftChild);
        }

        if(l <=  r){
            return  r;
        }

        return l;
    }

}
