package application;

import java.util.HashMap;

import interfaces.KV;

public class MyReduce {
    
    public KV[][] kvlistlist;

    public MyReduce(KV[][] in) {
        this.kvlistlist = in;
    }

    public KV[] reduce() {
        
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
		
        for (KV[] kvlist : this.kvlistlist) {
            for (KV kv : kvlist) {
                if (hm.containsKey(kv.k)) {
                    hm.put(kv.k, hm.get(kv.k)+Integer.parseInt(kv.v));
                } else {
                    hm.put(kv.k, Integer.parseInt(kv.v));
                }
            }
        }

        int l = hm.size();
        KV[] kvlistOUT = new KV[l];
        int i = 0;

        for (String k : hm.keySet()) {
            kvlistOUT[i] = new KV(k,hm.get(k).toString());
            i++;
        }

        return kvlistOUT;
    }

}