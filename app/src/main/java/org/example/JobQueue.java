package org.example;

public class JobQueue
{
    private PriorityQueue<Job> queue;

    public JobQueue()
    {
        queue = new PriorityQueue<>();
    }

    public void insert(Job job)
    {
        queue.insert(job);
    }

    public void runHighestPriority()
    {
        if(!queue.isEmpty()){
            Job job = queue.extractMax();
            job.execute();
        } else {
            System.out.println("No jobs in the queue to run!");
        }
    }
}