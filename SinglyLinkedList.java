package recursion;

/* ITI 1121/1521. Introduction to Computer Science II
 * Assignment/Devoir 4
 *
 * Marcel Turcotte
 */

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {



	private static class Node<E> {
        private E value;
        private Node<E> next;
        private Node( E value, Node<E> next ) {
            this.value = value;
            this.next  = next;
        }
	}

    // Instance variable
    /*
     * This next line is a bit weird, but making last.next being null as the default
     * means you can tell an empty node by checking last.next (without relying on null).
     */
    private Node<E> first;
    private Node<E> last=new Node <E> (null, first);
    
    //  ----------------------------------------------------------
    //  SinglyLinkedList methods
    //  ----------------------------------------------------------

    public void addFirst( E item ) {
    	if (last.next==first)
 	   {
 		   this.first=new Node<E> (item, null);
 	  this.last=this.first;
 	   }
 	   else
 	   {
        first = new Node<E>( item, first );
 	   }
    }

    public boolean isEmpty() { 
        return first == null; 
    }
   private void addLast(E item) {
	   if (last.next==first)
	   {
		   this.first=new Node<E> (item, null);
	  this.last=this.first;
	   }
	   else
	   {
		   this.last.next= new Node<E> (item, null);
		   this.last=this.last.next;
		   
	   }
   }
    public SinglyLinkedList<Integer> indexOfAll( E element ) {
    	SinglyLinkedList<Integer> index  =new SinglyLinkedList<Integer>();
    	 //System.out.print(index.toString());
    	 // Non recursive implementation;
    	 /*
    	Node <E> input =this.first;
    	int counter = 0;
    	
    	
    while (input.next!=null){
    	if (input.value==element){
    	index.addLast(counter);	
    	}
    	counter++;
    		input=input.next;
    		}
    		return index;
    	
    		*/
    	 Integer counter = new Integer (0);
    	 return indexOfAll(element,this.first, index,counter);
    	 
    }
   
	//throw new UnsupportedOperationException( "** replace this statement by your answer to the question **" );
   
    private SinglyLinkedList<Integer>  indexOfAll (E element, Node <E>input, SinglyLinkedList<Integer> index, Integer counter)
    {
    	if (element==input.value || (element==null && input.value==null))
    	{
    		index.addLast(counter);    		
    	}
    	if (input==this.last)
		{
			return index;
		}
    	else
    	
    	//System.out.print(index.toString());
    	{
    	counter++;
		return indexOfAll(element, input.next, index, counter);
    	}
    }
    //  ----------------------------------------------------------
    //  Other instance methods
    //  ----------------------------------------------------------

    @Override
    public String toString() {
        return "{" + toString(first) + "}";
    }

    private String toString(Node<E> p) {

        String result = "";

        if (p != null) {
            result = p.value.toString();
            if (p.next != null) {
                 result = result + "," + toString(p.next);
            }
        }

        return result;
    }
}
