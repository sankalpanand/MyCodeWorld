package Leetcode.Medium;

import java.util.*;


public class CourseSchedule2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	// Leetcode - https://leetcode.com/problems/course-schedule-ii/description/
	// Neetcode - https://www.youtube.com/watch?v=Akt3glAwyfY
	public int[] findOrder_DFS(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> prereqMap = new HashMap<>();	// map of {course : depends on...}
		for (int i = 0; i < numCourses; i++) {
			prereqMap.put(i, new ArrayList<>());
		}
		for (int[] pair : prerequisites) {
			prereqMap.get(pair[0]).add(pair[1]);
		}

		List<Integer> output = new ArrayList<>();
		Set<Integer> visit = new HashSet<>();
		Set<Integer> cycle = new HashSet<>();	// This will tell us if this course has been visited in our current path

		for (int i = 0; i < numCourses; i++) {
			if (!dfs(i, prereqMap, visit, cycle, output)) {
				return new int[0];
			}
		}

		// Convert output list to an array
		int[] result = new int[output.size()];
		for (int i = 0; i < output.size(); i++) {
			result[i] = output.get(i);
		}
		return result;
	}

	private boolean dfs(int course, Map<Integer, List<Integer>> prereq, Set<Integer> visit, Set<Integer> cycle, List<Integer> output) {
		if (cycle.contains(course)) {
			return false;
		}
		if (visit.contains(course)) {
			return true;
		}

		cycle.add(course);
		for (int pre : prereq.get(course)) {
			if (!dfs(pre, prereq, visit, cycle, output)) {
				return false;
			}
		}
		cycle.remove(course); 	// Remove the course since it's no longer along the path we're going
		visit.add(course);
		output.add(course);
		return true;
	}
}


