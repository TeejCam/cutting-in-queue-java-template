package org.example;

public class PriorityQueue<T extends Comparable<T>>
{
    private MaxHeap<T> heap;

    public PriorityQueue()
    {
        heap = new MaxHeap<>();
    }

    public void insert(T val)
    {
        heap.insert(val);
    }

    public T extractMax()
    {
        return heap.extractMax();
    }

    public T peek()
    {
        return heap.getMax();
    }

    public int size()
    {
        return heap.size();
    }

    public boolean isEmpty()
    {
        return heap.isEmpty();
    }

    public void clear()
    {
        heap.clear();
    }
}