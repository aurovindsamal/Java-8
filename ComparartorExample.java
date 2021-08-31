import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ComparartorExample {

	public static void main(String[] args) {

		ArrayList<Employee> list = EmployeeService.listAll();
//		Comparator<Employee> comp = Comparator.comparing(Employee::getAge);
//		ArrayList<Employee> sortByAge = (ArrayList<Employee>) list.stream().sorted(comp).collect(Collectors.toList());
//		System.out.println(sortByAge);
//		
//		Comparator<Employee> compByFnameAndLastname = Comparator.comparing(Employee::getfName).thenComparing(Employee::getlName);
//		List<Employee> compByFNameAndLastNameResult = list.stream().sorted(compByFnameAndLastname).collect(Collectors.toList());
//		System.out.println(compByFNameAndLastNameResult);

		Comparator<Employee> compByName = Comparator.comparing(Employee::getlName);
		List<Employee> listByName = list.stream().filter(e -> e.getAge() > 10).sorted(compByName)
				.collect(Collectors.toList());
		//System.out.println(listByName);

		// Sorting based on the age of employees
//		TreeMap<Employee, Integer> mapEployees = (TreeMap<Employee, Integer>) EmployeeService.listAllEmployeesMap();
//		mapEployees.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getAge)))
//				.forEach(e -> System.out.println(e));

		// Sorting based on the age of employees in reversed order
//		TreeMap<Employee, Integer> mapEployeesReversed = (TreeMap<Employee, Integer>) EmployeeService.listAllEmployeesMap();
//		mapEployeesReversed.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getAge).reversed()))
//				.forEach(e -> System.out.println(e));
		
		//Sorting Employee object based on value
		TreeMap<Employee, Integer> sampledata = (TreeMap<Employee, Integer>) EmployeeService.listAllEmployeesMap();
		sampledata.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e->System.out.println(e));
		
		//sort based on key on primitive data types
		TreeMap<Employee, Integer> sampledata1 = (TreeMap<Employee, Integer>) EmployeeService.listAllEmployeesMap();
		sampledata1.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e->System.out.println(e));
	}

}
