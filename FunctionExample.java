import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample {
	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "Aurovind", "Samal", 29, "Bhubaneswar","M",35000));
		employees.add(new Employee(2, "Aurovind", "Samal", 34, "Bhopal","F",37000));
		employees.add(new Employee(3, "Aurovind", "Samal", 36, "Madhyapradesh","M",35000));
		employees.add(new Employee(4, "Aurovind", "Samal", 38, "Cuttack","M",35000));
		employees.add(new Employee(5, "Aurovind", "Samal", 45, "baleswar","M",45000));
		employees.add(new Employee(6, "Aurovind", "Samal", 55, "chandikhol","M",35000));
		employees.add(new Employee(7, "Aurovind", "Samal", 53, "nakhra","M",40000));
		employees.add(new Employee(8, "Aurovind", "Samal", 79, "bangaluru","M",35000));
		employees.add(new Employee(9, "Aurovind", "Samal", 100, "ooty","M",35000));
		employees.add(new Employee(10, "Aurovind", "Samal", 29, "salawe","M",35000));
		employees.add(new Employee(11, "Aurovind", "Samal", 92, "mayuri","M",35000));
		employees.add(new Employee(12, "Aurovind", "Samal", 82, "mayurbhanj","M",35000));
		employees.add(new Employee(13, "Aurovind", "Samal", 103, "dhenkanal","M",35000));
		employees.add(new Employee(14, "Aurovind", "Samal", 32, "system","M",35000));
		employees.add(new Employee(15, "Aurovind", "Samal", 49, "bhupal","M",35000));
		employees.add(new Employee(16, "Aurovind", "Samal", 39, "delhi","M",35000));
		employees.add(new Employee(17, "Aurovind", "Samal", 47, "trivandrum","M",35000));
		employees.add(new Employee(18, "Aurovind", "Samal", 49, "bhuba","M",35000));
		employees.add(new Employee(19, "Aurovind", "Samal", 35, "Bhubaneswar","M",35000));
		employees.add(new Employee(20, "Aurovind", "Samal", 33, "cuttack","M",35000));	
		
		Predicate<Employee> qualified = employee->employee.getSalary()>35000;
		Function<Employee,Employee> f=employee->{
			employee.salary = employee.getSalary()+500;
			return employee;
		};
		
		List<Employee> l2 = new ArrayList<Employee>();
		for(Employee e:employees) {
			if(qualified.test(e)) {
				f.apply(e);
				l2.add(e);
			}
		}
		System.out.println(l2);
	}

}
