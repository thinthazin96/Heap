/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thinthazin
 */
public class ourHeap<T> {
    //store the info in nodes that hve key and data.
    private class Node<T> {
		int key;
		T data;
		Node() 
                {
			key = 0;
			data = null;
		}
		Node(int k, T d)
                {
			key = k;
			data = d;
		}
		//getters 
		int getKey() {return key;}
		T getData() {return data;}
		void setKey(int k){key = k;}
		void setData(T d) {data = d;}
		public String toString()
                {
			return (key + " " + data.toString());
		}
    }
    private Node<T>[] heap;
    private int size;
    public ourHeap()
     {
         heap= (Node<T>[]) new Object[1000];
         size = 0;                
     }
    public boolean isEmpty()
    {
        return (size==0);       
    }
    private void resize(int s)
    {
        if(s < heap.length)
            return;
                    System.out.println("old capacity: "+ heap.length +"new capacity: "+ s );
         Node[] temp = (Node[]) new Object[s];
         for(int i = 0; i< size; i++)
         {
             temp[i] = heap[i];
         }
         heap = temp;
    }
    public void add(int k, T e)
    {
        if(size == heap.length)
        {
            this.resize((heap.length + 100));
        }
        Node newNode = new Node(k,e);
        heap[size] = newNode;
        size++;
        heapify(size-1);
    }
    void heapify(int i)
    {
        if(i == 0)
        {
            return;
        }
        if(heap[(i-1)/2].getKey() > heap[i].getKey())
        {
            return;
        }           
        Node temp = new Node(heap[i].getKey(),heap[i].getData());
        heap[i].setKey(heap[(i-1)/2].getKey());
        heap[i].setData(heap[(i-1)/2].getData());
        
        heap[(i-1)/2].setKey(temp.getKey());
        heap[(i-1)/2].setData((T)temp.getData());
        heapify((i-1)/2);
    }
    public String toString()
    {
		if (this.isEmpty())
			return "[]";
		String st = "[";
		//add to the set all elements except the last one 
		for (int i = 0; i <size-1; i++){
			st = st + heap[i].toString() + ", ";
		}
		//add the last element 
		st = st + heap[size-1].toString() + "]";
		return st;
    }
	public void print()
        {
		System.out.println(this.toString());
	}
    
}
