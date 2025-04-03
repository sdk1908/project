package org.example.entity;

public class LinkedListCustomPractice {
    private Node head;

    public void insert(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }
        else
        {
            Node current = head;
            while(current.next !=null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void delete(int data){
        Node current=head ;

        if(head == null)
            System.out.println("empty");

        if(head.data == data){
            System.out.println("found");
          head=  head.next ;
        }

        while(current.next !=null && current.next.data != data){


            current = current.next;
        }
        if(current.next !=null)
        current.next = current.next.next;
    }

    public void display(){
Node current;
        if(head == null)
            System.out.println("empty");
    current = head;
        if(current !=null) {
            while (current != null) {
                System.out.println("fgg::::::::::"+current.data);
                current = current.next;
            }
        }
    }

}
