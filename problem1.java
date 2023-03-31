package problem1;

import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int n1,n2,delete;
        int count=0;
        MyLinkedList p1 = new MyLinkedList();
        MyLinkedList p2 = new MyLinkedList();
        MyLinkedList added,multy;
        while(count!=2){
        System.out.println("Enter the coefficient and power of the first polynomial. Type 0 at the end:");
        n1=-1;
                    while(n1!=0){
                n1= input.nextInt();
                if(n1!=0){
                n2= input.nextInt();
                if(count==0){
                    insert(n1, n2, p1);
                }
                else if(count==1){
                    insert(n1, n2, p2);}}
        }
            count++;
    }
        System.out.println("The entered polynomials are:");
        System.out.println("P1 "+p1);
        System.out.println("P2 "+p2);
        int pick=0;
        while(pick!=5){
            System.out.println("Which task you want to do?\n1- Add\n2- Multiply\n3- Print\n4- Delete\n5-Exit");
            System.out.println("Please enter a digit (1-5):");
            pick=input.nextInt();
                switch(pick){
                    case 1:
                        System.out.println("Adding two polynomials:");
                        added=addLists(p1,p2);
                        System.out.println(added.toString());
                        break;
                    case 2:
                        System.out.println("Multiplying two polynomials:");
                        multy=multipliedList(p1, p2);
                        System.out.println(multy.toString());
                        break;
                    case 3:
                        System.out.println("The polynomials are:");
                        System.out.println("P1 "+p1);
                        System.out.println("P2 "+p2);
                        break;
                    case 4:
                        System.out.println("Which power you want to delated from both polynomials: ");
                        delete=input.nextInt();
                        deleteNodebyPower(delete,p1);
                        deleteNodebyPower(delete,p2);
                        break;
                    case 5:
                        System.out.println("Exiting the program ….");
                        break;
                }
        }
        
    }
    public static MyLinkedList addLists(MyLinkedList p1,MyLinkedList p2){
    Node i,j,k=null;
    MyLinkedList result= new MyLinkedList();
    int cof, deg;
    i = p1.first;
    j = p2.first;
    while(i!=null && j!=null){
    if(i.degree != 0 && j.degree != 0){
    if(i.degree == j.degree){
    cof= i.coefficient + j.coefficient;
    deg= i.degree;
    i= i.next;
    j= j.next;
    }else if(i.degree > j.degree){
        cof=i.coefficient;
        deg=i.degree;
        i= i.next;}
    else{
        cof=j.coefficient;
        deg=j.degree;
        j=j.next;}
    if (cof != 0){
    result.insertLast(cof, deg);}}
    if(i== null)
        k=j;
    else if(j==null)
        k=i;
    while(k!=null){
    result.insertLast(k.coefficient, k.degree);
    k=k.next;}
    }
    return result;
    }
    public static void deleteNodebyPower(int pow,MyLinkedList list){
        if(pow==list.first.degree){
        list.removeFirst();}
        else if(pow==list.last.degree){
        list.removeLast();}
        else{
            Node delete= list.SearchForDegree(pow);
        if (delete!=null)
            list.RemoveAfter(delete);}
        
    }
    public static MyLinkedList multipliedList(MyLinkedList p1,MyLinkedList p2){
    Node temp1 = p1.first;
    Node temp2;
    MyLinkedList mult= new MyLinkedList();
    int cof,deg;
    while(temp1!=null){
        temp2=p2.first;
        while(temp2!=null){
        cof=temp1.coefficient*temp2.coefficient;
        deg=temp1.degree+temp2.degree;
        insert(cof, deg, mult);
        temp2=temp2.next;}
        temp1=temp1.next;
    }
    return mult;
    }
    public static void insert(int cof,int deg, MyLinkedList list){
        if(list.first==null||deg>list.first.degree){
                    list.insertFirst(cof,deg);}
                else if(deg<list.last.degree)
                    list.insertLast(cof, deg);
                else{
                    Node temp=list.first;
                    while(temp.next.degree>deg){
                       temp=temp.next;}
                        if(temp.next.degree==deg){
                        temp.next.AddingSamePower(cof);
                        }else
                            list.insertAfter(cof, deg, temp);
    }
    }        
}
