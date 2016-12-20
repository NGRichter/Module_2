package ss.week5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
	
	//@ensures \result == (\forall K k1,k2; map.containsKey(k1) && map.containsKey(k2) && k1 != k2; map.get(k1) != map.get(k2));
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        Set<K> keys = map.keySet();
        ArrayList<Object> temp = new ArrayList<Object>();
        for (K k : keys) {
        	if (temp.contains(map.get(k))) {
        		return false;
        	} else {
        		temp.add(map.get(k));
        	}
        }
        return true;
    }
    
    //@ensures \result == (\forall V v; map.containsValue(v); \exists K k; map.get(k) == v);
    public static <K, V> 
           boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        for (V v : range) {
        	if (!map.containsValue(v)) {
        		return false;
        	}
        	int i = 0;
        	for (K k : map.keySet()) {
        		if (map.get(k).equals(v)) {
        			break;
        		}
        		i++;
        	}
        	if (i == map.keySet().size()) {
        		return false;
        	}
        }
        return true;
    }
    //@ensures (\forall K key; inverse.get(map.get(key)) == key);
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> inverse = new HashMap<V, Set<K>>();
        for (K key : map.keySet()) {
        	V value = map.get(key);
        	if (inverse.containsKey(value)) {
        		inverse.get(value).add(key);
        	} else {
        		inverse.put(value, new HashSet<K>());
        		inverse.get(value).add(key);
        	}
        	
        }
        return inverse;
	}
    //@ensures (\forall K key; inverse.get(map.get(key)) == key);
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> inverse = new HashMap<V, K>();
        for (K key : map.keySet()) {
        	V value = map.get(key);
        	inverse.put(value, key);
        }
        return inverse;
	}
	
	//@ensures \result (\forall V v; g.containsKey(v));
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        for (V v : f.values()) {
        	if (!g.containsKey(v)) {
        		return false;
        	}
        }
        return true;
	}
	
	//@ensures (\forall K key, W w; composed.get(k) == w);
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        Map<K, W> composed = new HashMap<K, W>();
		for (K k : f.keySet()) {
        	W w = g.get(f.get(k));
        	composed.put(k, w);
        }
        return composed;
	}
}
