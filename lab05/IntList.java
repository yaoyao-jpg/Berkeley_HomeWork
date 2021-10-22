/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 *
 * @author Maurice Lee and Wan Fung Chui
 */

public class IntList {

    /** The integer stored by this node. */
    public int item;
    /** The next node in this IntList. */
    public IntList next;

    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints 1 2 3 */
    public static IntList of(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
        IntList x=this;
        if(position<0)
            throw new IllegalArgumentException("ERROR!");
        for(int i=0;i<position;++i)
        {
            if(x.next==null)
            {
                throw new IllegalArgumentException("ERROR!");
            }
            x=x.next;
        }
        return x.item;
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "1 2 3".
     *
     * @return The String representation of the list.
     */
    public String toString() {
        //TODO: YOUR CODE HERE
        String s="";
        IntList x=this;
        int flag=0;
        while(true)
        {
            if(x.next==null)
            {
                if(flag==0)
                {
                    s+=x.item;
                    flag=1;
                }
                else
                {
                    s+=(" "+x.item);
                }
                break;
            }
            if(flag==0)
            {
                s+=x.item;
                flag=1;
            }
            else
            {
                s+=(" "+x.item);
            }
            x=x.next;
        }
        return s;
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * NOTE: A full implementation of equals requires checking if the
     * object passed in is of the correct type, as the parameter is of
     * type Object. This also requires we convert the Object to an
     * IntList, if that is legal. The operation we use to do this is called
     * casting, and it is done by specifying the desired type in
     * parenthesis. An example of this is on line 84.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IntList)) {
            return false;
        }
        IntList otherLst = (IntList) obj;

        IntList x=this;
        IntList y=otherLst;
        Boolean t=true;
        //TODO: YOUR CODE HERE
        while(true)
        {
            if(x.next==null)
            {
                if(y.next==null&&x.item==y.item)  ;
                else t=false;
                break;
            }
            else if(y.next==null)
            {
                t=false;
                break;
            }
            else
            {
                if(x.item!=y.item)
                {
                    t=false;
                    break;
                }
                x=x.next;
                y=y.next;
            }
        }
        return t;
    }

    /**
     * Adds the given value at the end of the list.
     *
     * @param value, the int to be added.
     */
    public void add(int value) {
        //TODO: YOUR CODE HERE
        IntList x=this;
        IntList n=new IntList(value,null);
        while(true)
        {
            if(x.next==null) break;
            x=x.next;
        }
        x.next=n;
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        //TODO: YOUR CODE HERE
        IntList x=this;
        int minx=x.item;
        while(true)
        {
            if(x.next==null)
            {
                minx=Math.min(minx,x.item);
                break;
            }
            minx=Math.min(minx,x.item);
            x=x.next;
        }
        return minx;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        //TODO: YOUR CODE HERE
        int sum=0;
        IntList x=this;
        while(true)
        {
            if(x.next==null)
            {
                sum+=Math.pow(x.item,2);
                break;
            }
            sum+=Math.pow(x.item,2);
            x=x.next;
        }
        return sum;
    }

    /**
     * Destructively squares each item of the list.
     *
     * @param L list to destructively square.
     */
    public static void dSquareList(IntList L) {
        while (L != null) {
            L.item = L.item * L.item;
            L = L.next;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.item * L.item, null);
        IntList ptr = res;
        L = L.next;
        while (L != null) {
            ptr.next = new IntList(L.item * L.item, null);
            L = L.next;
            ptr = ptr.next;
        }
        return res;
    }

    /** Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.item * L.item, squareListRecursive(L.next));
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
    public static IntList dcatenate(IntList A, IntList B) {
        //TODO: YOUR CODE HERE
        if(A==null&&B==null) return null;
        if(A==null) return B;
        if(B==null) return A;
        IntList x=A;
        while(true)
        {
            if(x.next==null)
            {
                x.next=B;
                break;
            }
            x=x.next;
        }
        return A;
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * non-destructively.
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
     public static IntList catenate(IntList A, IntList B) {
        //TODO: YOUR CODE HERE
         if(A==null&&B==null) return null;
         if(A==null) return B;
         if(B==null) return A;
         IntList a=A,b=B;
         IntList res = new IntList(a.item , null);
         IntList ptr = res;
         a = a.next;
         while (a != null) {
             ptr.next = new IntList(a.item , null);
             a = a.next;
             ptr = ptr.next;
         }
         while (b != null) {
             ptr.next = new IntList(b.item , null);
             b= b.next;
             ptr = ptr.next;
         }
        return res;
     }
}