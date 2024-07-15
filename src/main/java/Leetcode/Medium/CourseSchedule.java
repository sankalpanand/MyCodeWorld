package Leetcode.Medium;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CourseSchedule obj = new CourseSchedule();
		int[][] prerequisites = {{1, 0}};
		// System.out.println(obj.canFinish_bfs(2, prerequisites));

		int[][] prerequisites2 = {{0,1}, {0,2}, {1,3}, {1,4}, {3,4}};
		System.out.println(obj.canFinish_bfs(5, prerequisites2));

	}

	// Best explanation - https://www.youtube.com/watch?v=EgI5nU9etnU
	// DFS Version from Neetcode
	// Complexity - O (n + prereq)
	public boolean canFinish(int numCourses, int[][] prerequisitesArray) {
		Map<Integer, List<Integer>> preMap = new HashMap<>();
		Set<Integer> visitSet = new HashSet<>();

		for (int i = 0; i < numCourses; i++) {
			preMap.put(i, new ArrayList<>());
		}

		// preMap = {course: prerequisites}
		for (int[] p : prerequisitesArray) {
			List <Integer> prerequisites = preMap.get(p[0]);
			prerequisites.add(p[1]);
			preMap.put(p[0], prerequisites);
		}

		// Run a DFS starting from course 1
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(i, preMap, visitSet))
				return false;
		}

		return true;
	}

	public boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visitSet) {
		// It means there is a cycle
		if (visitSet.contains(course))
			return false;

		// If at this point in traversal,
		// the prerequisite list of course has reduced to zero,
		// it means this course can be taken without a problem
		if (preMap.get(course).size() == 0)
			return true;

		// Add the course to the visited list to signal next nodes in the cycle
		visitSet.add(course);

		// Now go over the prerequisites of this course
		for (int pre : preMap.get(course)) {
			if (!dfs(pre, preMap, visitSet))
				return false;
		}

		// Once we are done exploring the prerequisites, we remove the course from the visited set because
		// when we go back recursively,
		// we could trace another path to this node where this node may not have been visited
		visitSet.remove(course);

		// Before returning true, also clear the prerequisite list for this course
		preMap.get(course).clear();
		return true;
	}

	public boolean canFinish_bfs(int numCourses, int[][] prerequisites) {
		// dependencies[i] indicates the number of courses that depend on completion of i'th course
		int[] totalDependenciesOn = new int[numCourses];

		// Queue for BFS, which will only hold courses with zero dependencies
		Queue<Integer> queue = new LinkedList<>();

		// We build a list for subjects and a list of their dependencies
		// [course -> {prerequisites}]
		ArrayList<Integer>[] coursesRequiredFor = new ArrayList[numCourses];
		
		// Initialize the graph
		for(int i=0; i<numCourses; i++)
			coursesRequiredFor[i] = new ArrayList<>();


		// For each prerequisite, create our dependency arrays
		for (int i = 0; i < prerequisites.length; i++) 
		{
			int prerequisite = prerequisites[i][1];
			int course = prerequisites[i][0];

			// It means, subject at 1st getCellIndex is a prereq of some other course.
			// So, increment that value in the dependencies array by 1
			totalDependenciesOn[prerequisite]++;

			// Also, add the prerequisite at 1st getCellIndex to the subject at 0th getCellIndex
			coursesRequiredFor[course].add(prerequisite);
		}

		// Add all those courses to the queue on which no other course depend on. We'll start processing those first.
		for (int i = 0; i < totalDependenciesOn.length; i++)
			if (totalDependenciesOn[i] == 0) 
				queue.add(i);

		// array for the result, which will be filled up from the end by getCellIndex
		int[] res = new int[numCourses];
		int index = res.length - 1;
		int count = 0;

		while (!queue.isEmpty()) 
		{
			int course = queue.poll(); 		// this is a course that no other courses will depend upon
			res[index--] = course;          // so we put it at the end of the order list

			// Iterate over the prerequisites of this currently operating course
			for(int i=0; i < coursesRequiredFor[course].size(); i++)
			{
				// Get the dependencies of course i
				int requiredCourse = coursesRequiredFor[course].get(i);

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
		return numCourses == count ? true : false;
	}

	public boolean canFinish_Lee(int n, int[][] prerequisites) {
		ArrayList<Integer>[] graph = new ArrayList[n];

		// This array will tell how many prerequisites are there for i'th course
		int[] degree = new int[n];

		ArrayList<Integer> bfs = new ArrayList();

		for (int i = 0; i < n; ++i)
			graph[i] = new ArrayList<>();

		for (int[] e : prerequisites) {
			int course = e[0];
			int dependsOn = e[1];

			graph[dependsOn].add(course);
			degree[course]++;
		}

		// Collect all the courses that have no prerequisites
		for (int i = 0; i < n; ++i)
			if (degree[i] == 0) // which means there are no prereq to take this course
				bfs.add(i);


		// Iterate through the items that don't have any pre req,
		for (int i = 0; i < bfs.size(); ++i) {
			// then iterate over courses that depend on this course with no dependencies
			int courseWithNoPrereq = bfs.get(i);
			List<Integer> dependentCourses = graph[courseWithNoPrereq];

			for (int j : dependentCourses) {
				// Because I've taken the prerequisite, so reduce the dependency count by 1
				degree[j]--;

				// If the dependency count reaches zero, then add it to the courses with no dependencies
				if (degree[j] == 0)
					bfs.add(j);
			}
		}

		return bfs.size() == n;
	}

}


