import java.util.*;
/*
 *  job class dataStructure --> id, deadline, profit
 *  sort 
 *  fill
 *  max deadline method 
 */




class Job {
    char id;
    int deadline;
    int profit;

    public Job (char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    static void printJobSequence (Job [] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit- a.profit);
        int n = jobs.length;
        int maxDeadline = getMaxDeadline(jobs);
        char [] result = new char[maxDeadline];
        boolean [] slot = new boolean[maxDeadline];
        Arrays.fill(slot, false);
        for(int i=0; i<n; i++) {
            for(int j=Math.min(maxDeadline - 1, jobs[i].deadline-1); j>0 ; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true;
                    break;
                }
            }
        }
        for(char job : result) {
            System.out.println(job + " ");
        }
    }
    static int getMaxDeadline(Job[] jobs) {
        int maxDeadline = Integer.MIN_VALUE;
        for(Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }
        return maxDeadline;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfJobs = sc.nextInt();
        Job [] jobs = new Job[numOfJobs];
        for (int i = 0; i < jobs.length; i++) {
            System.out.println("enter the job details for " + (i+1));
            System.out.print("ID : ");
            char id = sc.next().charAt(0);
            System.out.print("enter the deadline:");
            int deadline = sc.nextInt();
            System.out.print("enter the profit:");
            int profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }
        printJobSequence(jobs);
    }
}
