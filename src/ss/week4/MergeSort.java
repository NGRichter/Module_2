package ss.week4;

import java.util.*;

public class MergeSort<E extends Comparable<E>> {
	
	private List<E> elists = new ArrayList<E>();
	private List<E> temp = new ArrayList<E>();
	private int length;
	
    public void mergesort(List<E> list) {
    	length = list.size();
    	elists = (ArrayList<E>) list;
    	merge(0, length - 1);
    
    }
    	
    public void merge(int low, int high) {
    	if (low < high) {
    		int mid = low + (high - low) / 2;
    		merge(low, mid);
    		merge(mid + 1, high);
    		mergeall(low, mid, high);
    	}
    }
    
    private void mergeall(int low, int mid, int high) {
    	for (int i = 0; i <= length; i++) {
    		temp.add(elists.get(0));
    	}
    	for (int i = low; i <= high; i++) {
    		temp.set(i, elists.get(i)); 
    	}
    	int i = low;
    	int j = mid + 1;
    	int k = low;
    	while (i <= mid && j <= high) {
    		if (temp.get(i).compareTo(temp.get(j)) <= 0) {
    			elists.set(k, temp.get(i));
    			i++;
    		} else {
    			elists.set(k, temp.get(j));
    			j++;
    		}
    		k++;
    	}
    	while (i <= mid) {
    		elists.set(k, temp.get(i));
    		k++;
    		i++;
    	}
    }
 
}
