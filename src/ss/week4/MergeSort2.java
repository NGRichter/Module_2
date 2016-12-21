package ss.week4;

import java.util.*;

public class MergeSort2 {
    public static <E extends Comparable<E>>
           void mergesort(List<E> list) {
    	if (list.size() == 1 || list.size() == 0) {
    		return;
    	}
    	int length = list.size();
    	List<E> first = list.subList(0, length / 2);
    	List<E> last = list.subList(length / 2, length);
    	mergesort(first);
    	mergesort(last);
    	mergeall(first, last, list);
    }
    
    public static <E extends Comparable<E>> 
    		void mergeall(List<E> first, List<E> last, List<E> list) {
    	int ifirst = 0;
    	int ilast = 0;
    	int imerged = 0;
    	
    	while (ifirst < first.size() && ilast < last.size()) {
    		if (first.get(ifirst).compareTo(last.get(ilast)) < 0) {
    			list.set(imerged, first.get(ifirst));
    			ifirst++;
    		} else {
    			list.set(imerged, last.get(ilast));
    			ilast++;
    		}
    		imerged++;
    	}
    	while (ilast < last.size()) {
    		list.set(imerged, last.get(ilast));
    		imerged++;
    		ilast++;
    	}
    	while (ifirst < first.size()) {
    		list.set(imerged, first.get(ifirst));
    		ifirst++;
    		imerged++;
    	}
    }
}
