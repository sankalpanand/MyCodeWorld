package LeetcodeMedium;

import java.util.*;


public class CourseSchedule2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public int[] findOrder(int numCourses, int[][] prerequisites) 
	{
		// dependencies[i] indicates the number of courses that depend on completion of i'th course
		int[] totalDependenciesOn = new int[numCourses];

		// Queue for BFS, which will only hold courses with zero dependencies
		Queue<Integer> queue = new LinkedList<>();

		// This is an array of ArrayLists. Course[0] will have a list of prerequisites of Course[0]
		ArrayList<Integer>[] coursesRequiredFor = new ArrayList[numCourses];
		
		// Initialize the graph
		for(int i=0; i<numCourses; i++)
			coursesRequiredFor[i] = new ArrayList<Integer>();


		// For each prerequisite, create our dependency arrays
		for (int i = 0; i < prerequisites.length; i++) 
		{
			// It means, subject at 1st index is a prereq of some other course.
			// So, increment that value in the dependencies array by 1
			totalDependenciesOn[prerequisites[i][1]]++;

			// Also, add the prerequisite at 1st index to the subject at 0th index
			coursesRequiredFor[prerequisites[i][0]].add(prerequisites[i][1]);
		}


		// For each course, add all those courses to the queue that have zero dependencies, we'll start with them
		for (int i = 0; i < totalDependenciesOn.length; i++) 
		{
			if (totalDependenciesOn[i] == 0) 
			{
				queue.add(i);
			}
		}

		// array for the result, which will be filled up from the end by index
		int[] res = new int[numCourses];
		int index = res.length - 1;

		int count = 0;

		while (!queue.isEmpty()) 
		{
			int course = queue.poll(); 		// this is a course that no other courses will depend upon
			res[index--] = course;          // so we put it at the end of the order list

			// Iterate over the prerequisites of this currently operating course
			for(int i=0; i<coursesRequiredFor[course].size();i++)
			{
				// Get the dependencies of course i
				int requiredCourse = (int)coursesRequiredFor[course].get(i);

				// Decrease the dependency count of the prereq of i'th course
				// When this count is reduced to zero, we can again add it to the queue
				totalDependenciesOn[requiredCourse]--;

				// Check if the dependency is reduced to zero, if yes, add to the queue and increase the counter.
				if(totalDependenciesOn[requiredCourse] == 0)
				{
					queue.add(requiredCourse);					
				}
			}
			
			// we are done with course "key", so increase the number of completed courses
			count++; 
		}

		// if the totalNumber of courses visited is not numCourses, then we cannot complete all the courses; otherwise return the result
		return numCourses == count ? res : new int[0];
	}
}


