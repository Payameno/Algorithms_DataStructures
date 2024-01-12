package msc;
import java.util.*;

class solution {

    public int getMaxSubjectsPassed(List<Integer> answered, List<Integer> needed, int q) {

        //Get the number of subjects
        int n = answered.size();
        int maxSubject = 0;

        /*
        Create a minHeap data structure to hold the difference 
        */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //Add the differences to the minHeap
        for (int i = 0; i < n; i++) {
            int difference = needed.get(i) - answered.get(i);

            if (difference <= 0) {
                maxSubject++;
            } else {
                minHeap.offer(difference);
            }

        }

        // Check if we can fill the difference with the available additional attempts (q)
        while (!minHeap.isEmpty()) {
            int differenceFromTarget = minHeap.poll();

            //if dif is smaller or equal to q we can proceed 
            if (differenceFromTarget <= q) {
                // Update the available additional attempts
                q -= differenceFromTarget;
                
                //update number of subjects passed
                maxSubject++;
            }

        }
        return maxSubject;
    }

     public static void main(String[] args) {
        List<Integer> requiredQuestions = new LinkedList<>(List.of(2,3,4)); // Example array representing the required questions for each subject
        List<Integer> answeredQuestions = new LinkedList<>(List.of(1,2,3)); // Example array representing the questions already answered for each subject
        int additionalAttempts = 4; // Example number of additional attempts allowed

        int maxSubjectsPassed = getMaxSubjectsPassed(requiredQuestions, answeredQuestions, additionalAttempts);
        System.out.println("Maximum subjects passed: " + maxSubjectsPassed);
    }

}
/*
 Problem:
The question had three parameters

Needed [5,4,3,] 
Answered [2,5,1]
q = 3
constraints 1 < n < 10 ^ 5

1- needed: A list of integers:representing the number of questions required to pass 
a subject. Indices represent each subject.

2- answered: A list representing the number of questions answered by the student,
if this integer reaches the needed amount, that subject is considered passed

3- q of primitive type int, a limit on the number of additional questions that 
can be correctly answered.

The question requires the maximum number of possible subjects passed 
by the students by adding q successful answers. 

Solution: Finding the difference, using a minHeap to represent them
finally updating the answered List and the result;

 */