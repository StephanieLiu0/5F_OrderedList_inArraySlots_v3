/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index of the first occurrence of 
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    public int indexOf( Integer findMe) {
        // return whileIndexOf( findMe);
	return recursiveIndexOf( findMe, size()-1, 0);
    }

    public int whileIndexOf( Integer findMe) {
	int low = 0;
	int high = size()-1;
	int cur;

	while (high >= low) {
	    cur = (low+high)/2;
	    int value = list_iAS.get(cur)-findMe;
	    if (value == 0)
		return cur;
	    else if (value > 0)
		high = cur-1;
	    else
		low = cur + 1;
	    }
	return -1;
    }
		   
    public int recursiveIndexOf( Integer findMe, Integer high, Integer low) {
	int cur = (low+high)/2;
	int value = list_iAS.get(cur)-findMe;
	if (high < low)
	    return -1;
	else if (value == 0)
	    return cur;
	else if (value > 0)
	    return recursiveIndexOf( findMe, cur-1, low);
	else
	    return recursiveIndexOf( findMe, high, low+1);
    }
    

    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
