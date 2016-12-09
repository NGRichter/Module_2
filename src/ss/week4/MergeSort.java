package ss.week4;

import java.util.*;

public class MergeSort {
	
	private List<E> elists = new ArrayList<E>();
	
    public <E extends Comparable<E>> void mergesort(List<E> list) {
    	int length = list.size();
    	List<E> elist = new ArrayList<E>(list);
    	merge(0, list.size() - 1);
    
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
    	for (int i = low; i <= high; i++) {
    		temp.add(i, elists.get(i)); 
    	}
    }
    
}
