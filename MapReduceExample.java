import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);
		List<String> words = Arrays.asList("corejava", "spring", "hibernate");

		int sum = 0;
		for (int n : numbers) {
			sum += n;
		}
		System.out.println(sum);

		int sum2 = numbers.stream().mapToInt(i -> i).sum();
		System.out.println(sum2);

		Integer reduce = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println(reduce);

		Optional<Integer> reduce2 = numbers.stream().reduce(Integer::sum);
		System.out.println(reduce2.orElse(100));

		Integer mulResult = numbers.stream().reduce(1, (a, b) -> a * b);
		System.out.println(mulResult);

		Integer maxvalue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
		System.out.println(maxvalue);

		Integer maxvalueWithMethodReference = numbers.stream().reduce(Integer::max).get();
		System.out.println(maxvalueWithMethodReference);

		String longestString = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
				.get();
		System.out.println(longestString);

		// get employee whose grade A
		// get salary
		double avgSalary = CustomerDatabase.getAll().stream()
				.filter(customer -> customer.getName().equalsIgnoreCase("A")).map(c -> c.getId()).mapToDouble(i -> i)
				.average().getAsDouble();
		System.out.println(avgSalary);

		double sumSalary = CustomerDatabase.getAll().stream()
				.filter(customer -> customer.getName().equalsIgnoreCase("A")).map(c -> c.getId()).mapToDouble(i -> i)
				.sum();
		System.out.println(sumSalary);

	}

}
