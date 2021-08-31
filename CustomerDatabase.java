import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerDatabase {
	
	public static List<Customer> getAll(){
		return Stream.of(
				new Customer(1,"Amlan","amlan@gmail.com",Arrays.asList("1234567890","123456781")),
				new Customer(1,"Luck","luck@gmail.com",Arrays.asList("123457473","7836337")),
				new Customer(1,"Buck","buck@gmail.com",Arrays.asList("26346487","3783267272"))
				).collect(Collectors.toList());	
	}

}
