package problem1;
public class MyLinkedList {
  Node first, last;
    public MyLinkedList(){
    first= null;
    last= null;
    }
    public void insertFirst(int x, int y){
    Node Node = new Node(x,y);
    if(first==null){
    first = Node;
    last = Node;
    }
    else{
    Node.next=this.first;
    this.first=Node;
    }
    }
    public void insertLast(int x, int y){
    Node Node = new Node(x,y);
    if(last==null){
    first = Node;
    last = Node;
    }
    else{
    this.last.next=Node;
    this.last= Node;
    }
    }
    public Node SearchForDegree(int Yvalue){
    Node temp = this.first;
    while(temp.next!=null){
        if(temp.next.degree==Yvalue){
            return temp;}
        temp = temp.next;
    }
    return null;
    }
    public void RemoveAfter(Node Prev){
    Prev.next=Prev.next.next;
    }
    public void insertAfter(int x,int y,Node prev){
    Node Node = new Node(x,y);
    Node.next= prev.next;
    prev.next=Node;
    }
    public void removeFirst(){
    this.first=first.next;}
    public void removeLast(){
        Node temp = first;
    while(temp.next!=null){
        if(temp.next.next==null){
             temp.next=null;}
        temp = temp.next;
    }
    }

    @Override
    public String toString() {
        String sum = "";
        Node temp = first;
    while(temp!=null){
            sum+=temp.toString();
        temp = temp.next;}
    return sum;
    } 
    
    
}
