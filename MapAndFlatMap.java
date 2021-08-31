import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMap {

	public static void main(String[] args) {
		List<Customer> list = CustomerDatabase.getAll();
		// print all email address
		list.stream().map(customer -> customer.getEmail()).forEach(c -> System.out.print(c));

		// print all phone numbers
		List<List<String>> collect = list.stream().map(cu -> cu.getPhoneNumbers()).collect(Collectors.toList());
		System.out.println(collect);

		// print all phone numbers in flat map
		List<String> collect2 = list.stream().flatMap(c -> c.getPhoneNumbers().stream()).collect(Collectors.toList());
		System.out.println(collect2);

		List<List<String>> phoneNumbers = new ArrayList<List<String>>();
		for (Customer c : list) {
			phoneNumbers.add(c.getPhoneNumbers());
		}
		List<String> collect3 = phoneNumbers.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
		System.out.println(collect3);

	}
}
