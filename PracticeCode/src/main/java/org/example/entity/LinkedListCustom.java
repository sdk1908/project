package org.example.entity;

public class LinkedListCustom {
    private Node head;

    public void insert(int newData){
        Node newNode = new Node(newData);
        if(head == null){
            head = newNode;
        }else {
            Node current = head;

            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public  void delete(int value) {


        if(head == null){
            System.out.println("List empty");
            return;
        }

        if(head.data == value){
            head = head.next;
            return;
        }

        Node current = head;

        while(current.next !=null && current.next.data != value ){
            current = current.next;
        }

        if(current.next == null){
            System.out.println("Value not found in the list");
        }else{
            current.next = current.next.next;
        }
    }

    public void display(){

       if(head == null)
          System.out.println("linked list empty ");

        Node current = head;

        while(current != null)
        {
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.print("null");

}
}