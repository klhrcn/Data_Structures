import java.util.*;

public class KBestCounter<T extends Comparable<? super T>> implements KBest<T> {
    private final int k;
    private PriorityQueue<T> minHeap;

    public KBestCounter(int k){
        this.k=k;
        this.minHeap = new PriorityQueue<>(k);
    }

    @Override
    public void count(T x){
        if (minHeap.size() <k){
            minHeap.add(x);
        }else if(x.compareTo(minHeap.peek())>0){
            minHeap.poll();
            minHeap.add(x);
        }
    }

    @Override
    public List<T> kbest(){
        List<T>result = new ArrayList<>(minHeap);
        Collections.sort(result);
        return result;
    }

}
