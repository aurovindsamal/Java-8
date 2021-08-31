import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeService {
	
	public static ArrayList<Employee> listAll() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "Aurovind", "Samal", 29, "Bhubaneswar","M",35000));
		employees.add(new Employee(2, "Aurovind", "Samal", 34, "Bhopal","F",37000));
		employees.add(new Employee(3, "Aurovind", "Samal", 36, "Madhyapradesh","M",35000));
		employees.add(new Employee(4, "Aurovind", "Samal", 38, "Cuttack","M",35000));
		employees.add(new Employee(5, "Aurovind", "Samal", 45, "baleswar","M",35000));
		employees.add(new Employee(6, "Aurovind", "Samal", 55, "chandikhol","M",35000));
		employees.add(new Employee(7, "Aurovind", "Samal", 53, "nakhra","M",35000));
		employees.add(new Employee(8, "Aurovind", "Samal", 79, "bangaluru","M",35000));
		employees.add(new Employee(9, "Aurovind", "Joshi", 100, "ooty","M",35000));
		employees.add(new Employee(10, "Aurovind", "Samal", 29, "salawe","M",35000));
		employees.add(new Employee(11, "Aurovind", "Samal", 92, "mayuri","M",35000));
		employees.add(new Employee(12, "Aurovind", "Samal", 82, "mayurbhanj","M",35000));
		employees.add(new Employee(13, "Aurovind", "Jena", 103, "dhenkanal","M",35000));
		employees.add(new Employee(14, "Aurovind", "Samal", 32, "system","M",35000));
		employees.add(new Employee(15, "Aurovind", "Samal", 49, "bhupal","M",35000));
		employees.add(new Employee(16, "Aurovind", "Samal", 39, "delhi","M",35000));
		employees.add(new Employee(17, "Aurovind", "Bhardwaj", 47, "trivandrum","M",35000));
		employees.add(new Employee(18, "Aurovind", "Samal", 49, "bhuba","M",35000));
		employees.add(new Employee(19, "Aurovind", "Samal", 35, "Bhubaneswar","M",35000));
		employees.add(new Employee(20, "Aurovind", "Samal", 33, "cuttack","M",35000));
		return employees;		
	}
	
	public static TreeMap<Employee,Integer> listAllEmployeesMap(){
		TreeMap<Employee, Integer> hashMap = new TreeMap<Employee, Integer>((o1,o2)->o2.getAge()-o1.getAge());
		hashMap.put(new Employee(1, "Aurovind", "Samal", 29, "Bhubaneswar","M",35000), 100);
		hashMap.put(new Employee(2, "Aditya", "jena", 34, "bagalpur","M",37000), 300);
		hashMap.put(new Employee(3, "Shiva", "Srivastava", 43, "Delhi","M",32000), 200);
		hashMap.put(new Employee(4, "Anshi", "Khandelwal", 27, "Mumbai","F",45000), 50);
		return hashMap;
		
	}

}
