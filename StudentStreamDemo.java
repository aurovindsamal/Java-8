import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStreamDemo {

	static List<Student> studentList = new ArrayList<Student>();

	public static void main(String[] args) {

		studentList.add(new Student(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		studentList.add(new Student(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		studentList.add(new Student(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		studentList.add(new Student(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		studentList.add(new Student(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		studentList.add(new Student(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		studentList.add(new Student(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		studentList.add(new Student(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		studentList.add(new Student(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		studentList.add(new Student(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		studentList.add(new Student(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		studentList.add(new Student(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		studentList.add(new Student(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		studentList.add(new Student(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		studentList.add(new Student(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		studentList.add(new Student(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		studentList.add(new Student(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// Query 1 : How many male and female employees are there in the organization?
		method1();
		System.out.println("\n");
		// Query 2 : Print the name of all departments in the organization?
		method2();
		System.out.println("\n");
		// Query 3 : What is the average age of male and female students?
		method3();
		System.out.println("\n");
		// Query 4 : Get the details of highest paid student in the organization?
		method4();
		System.out.println("\n");
		// Query 5 : Get the names of all employees who have joined after 2015?
		method5();
		System.out.println("\n");
		// Query 6 : Count the number of employees in each department?
		method6();
		System.out.println("\n");
		// Query 7 : What is the average salary of each department?
		method7();
		System.out.println("\n");
		// Query 8 : Get the details of youngest male employee in the product
		// development department?
		method8();
		System.out.println("\n");
		// Query 9 : Who has the most working experience in the organization?
		method9();
		System.out.println("\n");
		// Query 10 : How many male and female employees are there in the sales and
		// marketing team?
		method10();
		System.out.println("\n");
		// Query 11 : What is the average salary of male and female employees?
		method11();
		System.out.println("\n");
		// Query 12 : List down the names of all employees in each department?
		method12();
		System.out.println("\n");
		// Query 13 : What is the average salary and total salary of the whole
		// organization?
		method13();
		System.out.println("\n");
		// Query 14 : Separate the employees who are younger or equal to 25 years from
		// those employees who are older than 25 years.
		method14();
		System.out.println("\n");
		// Query 15 : Who is the oldest employee in the organization? What is his age
		// and which department he belongs to?
		method15();
	}

	public static void method1() {
		System.out.println("Query 1 : How many male and female students are there in the organization?");
		Map<String, Long> noOfmaleAndFemaleStudets = studentList.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
		System.out.println(noOfmaleAndFemaleStudets);
	}

	public static void method2() {
		System.out.println("Query 2 : Print the name of all departments in the organization?");
		studentList.stream().map(student -> student.getDepartment()).distinct().forEach(System.out::println);
	}

	private static void method3() {
		System.out.println("Query 3 : What is the average age of male and female employees?");
		Map<String, Double> averageAgeMaleAndFemale = studentList.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getAge)));
		System.out.println(averageAgeMaleAndFemale);
	}

	private static void method4() {
		System.out.println("Query 4 : Get the details of highest paid student in the organization?");
		Optional<Student> collect = studentList.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Student::getSalary)));
		System.out.println(collect.get().getName());
	}

	private static void method5() {
		System.out.println("Query 5 : Get the names of all students who have joined after 2015?");
		Stream<String> map = studentList.stream().filter(student -> student.getYearOfJoining() > 2015)
				.map(student -> student.getName());
		map.forEach(System.out::println);
	}

	private static void method6() {
		System.out.println("Query 6 : Count the number of employees in each department?");
		Map<String, Long> collect = studentList.stream()
				.collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
		System.out.println(collect);
	}

	private static void method7() {
		System.out.println("Query 7 : What is the average salary of each department?");
		Map<String, Double> avgSalaryOfDepartments = studentList.stream()
				.collect(Collectors.groupingBy(Student::getDepartment, Collectors.averagingDouble(Student::getSalary)));
		Set<Entry<String, Double>> entrySet = avgSalaryOfDepartments.entrySet();
		for (Map.Entry<String, Double> entry : entrySet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	private static void method8() {
		System.out
				.println("Query 8 : Get the details of youngest male employee in the product development department?");
		Optional<Student> min = studentList.stream()
				.filter(student -> student.getDepartment().equalsIgnoreCase("Product Development")
						&& student.getGender().equalsIgnoreCase("Male"))
				.min(Comparator.comparingInt(Student::getAge));
		System.out.println(min);
	}

	private static void method9() {
		System.out.println("Query 9 : Who has the most working experience in the organization?");
		Optional<Student> seniorMostEmployeeWrapper = studentList.stream()
				.sorted(Comparator.comparingInt(Student::getYearOfJoining)).findFirst();
		Student seniorMostEmployee = seniorMostEmployeeWrapper.get();

		System.out.println("Senior Most Employee Details :");

		System.out.println("----------------------------");

		System.out.println("ID : " + seniorMostEmployee.getId());

		System.out.println("Name : " + seniorMostEmployee.getName());

	}

	private static void method10() {
		System.out.println("Query 10 : How many male and female employees are there in the sales and marketing team?");
		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = studentList.stream()
				.filter(student -> student.getDepartment().equalsIgnoreCase("Sales And Marketing"))
				.collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
		System.out.println(countMaleFemaleEmployeesInSalesMarketing);
	}

	private static void method11() {
		System.out.println("Query 11 : What is the average salary of male and female employees?");
		Map<String, Double> avgSalaryOfMaleAndFemaleEmployees = studentList.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingDouble(Student::getSalary)));
		System.out.println(avgSalaryOfMaleAndFemaleEmployees);
	}

	private static void method12() {
		System.out.println("Query 12 : List down the names of all employees in each department?");
		Map<String, List<Student>> employeeListByDepartment = studentList.stream()
				.collect(Collectors.groupingBy(Student::getDepartment));
		Set<Entry<String, List<Student>>> entrySet = employeeListByDepartment.entrySet();

		for (Entry<String, List<Student>> entry : entrySet) {
			System.out.println("--------------------------------------");

			System.out.println("Employees In " + entry.getKey() + " : ");

			System.out.println("--------------------------------------");

			List<Student> list = entry.getValue();

			for (Student e : list) {
				System.out.println(e.getName());
			}
		}

	}

	private static void method13() {
		System.out.println("Query 13 : What is the average salary and total salary of the whole organization?");
		DoubleSummaryStatistics employeeSalaryStatistics = studentList.stream()
				.collect(Collectors.summarizingDouble(Student::getSalary));
		System.out.println("Average Salary = " + employeeSalaryStatistics.getAverage());
		System.out.println("Total Salary = " + employeeSalaryStatistics.getSum());

	}

	private static void method14() {
		System.out.println(
				"Query 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years");
		Map<Boolean, List<Student>> partitionEmployeesByAge = studentList.stream()
				.collect(Collectors.partitioningBy(student -> student.getAge() > 25));
		Set<Entry<Boolean, List<Student>>> entrySet = partitionEmployeesByAge.entrySet();
		for (Entry<Boolean, List<Student>> entry : entrySet) {
			if (entry.getKey()) {
				System.out.println("Employees older than 25 years :");
			} else {
				System.out.println("Employees younger than or equal to 25 years :");
			}
			System.out.println("----------------------------");
			List<Student> list = entry.getValue();
			for (Student e : list) {
				System.out.println(e.getName());

			}
		}
	}

	private static void method15() {
		System.out.println(
				"Query 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?");
		Optional<Student> oldestStudentWrapper = studentList.stream().max(Comparator.comparingInt(Student::getAge));
		Student oldestStudent = oldestStudentWrapper.get();
		System.out.println("name " + oldestStudent.getName());
		System.out.println("Organisation " + oldestStudent.getDepartment());
		System.out.println("Age " + oldestStudent.getAge());
	}
}
