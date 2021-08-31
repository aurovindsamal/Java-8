import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {
	
	public static Predicate<Employee> isAdult(){
		return employee->employee.getAge()>18;
	}
	
	public static Predicate<Employee> isAdultBhubaneswar(){
		return employee->employee.getAge()>18 && employee.getCity().equalsIgnoreCase("Bhubaneswar");
	}
	
	public static Predicate<Employee> isMale(){
		return employee->employee.getGender().equalsIgnoreCase("M");
	}

	public static List<Employee> filteredEmployees(List<Employee> employees, Predicate<Employee> predicate){
		return (List<Employee>) employees.stream().filter(predicate).collect(Collectors.toList());
	}
	
}
