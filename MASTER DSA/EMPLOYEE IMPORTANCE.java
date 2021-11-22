/**
Employee Importance |  Easy | Google |

You have a data structure of employee information, which includes the employee's unique id, their importance value, and their direct subordinates' id.

You are given an array of employees employees where:

employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the subordinates of the ith employee.
Given an integer id that represents the ID of an employee, return the total importance value of this employee and all their subordinates.


Example 1:


Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
 */




import java.util.*;
class Solution {
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Integer> employeeImportanceMap = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> employeeSubordinatesMap = new HashMap<Integer, List<Integer>>();
		for (Employee employee : employees) {
			int employeeId = employee.id;
			int importance = employee.importance;
			List<Integer> subordinates = employee.subordinates;
			employeeImportanceMap.put(employeeId, importance);
			if (subordinates != null)
				employeeSubordinatesMap.put(employeeId, subordinates);
		}
		int totalImportance = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(id);
		while (!queue.isEmpty()) {
			int curId = queue.poll();
			int importance = employeeImportanceMap.get(curId);
			totalImportance += importance;
			List<Integer> subordinates = employeeSubordinatesMap.getOrDefault(curId, new ArrayList<Integer>());
			for (int subordinate : subordinates)
				queue.offer(subordinate);
		}
		return totalImportance;
	}
}