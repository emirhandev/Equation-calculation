public class Node {
    int coefficient;
    int degree;
    Node next;
    public Node(int coefficient, int degree){
    this.coefficient = coefficient;
    this.degree= degree;
    this.next=null;}
    public String toString(){
    if(next==null){
        if(degree!=0||degree!=1){
        return coefficient+"x^"+degree;}
        else if(degree==0){
        return coefficient+"";}
        else {
        return coefficient+"x";}}
    else{
        if(degree!=0||degree!=1){
        return coefficient+"x^"+degree+"+";}
        else if(degree==0){
        return coefficient+"+";}
        else {
        return coefficient+"x+";}
    }
    }
    public void AddingSamePower(int n1){
    this.coefficient+=n1;}
}
