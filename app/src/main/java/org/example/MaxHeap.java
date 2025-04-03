package org.example;
import java.util.ArrayList;
import java.util.Collections;

//implement using an array

public class MaxHeap<T extends Comparable<T>>
{
    private ArrayList<T> heap;
    
    public MaxHeap()
    {
        heap = new ArrayList<>();
    }

    public void insert(T element)
    {
        heap.add(element);
        siftUp(heap.size() - 1);
    }

    public T getMax()
    {
        if(heap.size() > 0){
            return heap.get(0);
        } else {
            return null;
        }
    }

    public T extractMax()
    {
        if(heap.size() == 0){
            return null;
        }
        T max = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        siftDown(0);
        return max;
    }

    public void heapify(ArrayList<T> arr)
    {
        heap = new ArrayList<>(arr);
        for(int i = heap.size() / 2 - 1; i >= 0; i--){
            siftDown(i);
        }
    }

    private void siftUp(int i)
    {
        int parent = (i - 1) / 2;
        while(i != 0 && heap.get(i).compareTo(heap.get(parent)) > 0){
            Collections.swap(heap, i, parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    private void siftDown(int i)
    {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        while(left < heap.size()){
            int largest = i;
            if(left < heap.size() && heap.get(left).compareTo(heap.get(largest)) > 0){
                largest = left;
            }
            if(right < heap.size() && heap.get(right).compareTo(heap.get(largest)) > 0){
                largest = right;
            }
            if(largest == i){
                break;
            }
            Collections.swap(heap, i, largest);
            i = largest;
            left = 2 * i + 1;
            right = 2 * i + 2;
        }
    }

    public void clear()
    {
        heap.clear();
    }

    public int size() 
    {
        return heap.size();
    }

    public boolean isEmpty()
    {
        return heap.isEmpty();
    }
}