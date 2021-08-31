import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {
	
	public static Customer getEmailId(String emailId) {
		List<Customer> list = CustomerDatabase.getAll();
		return list.stream().filter(customer->customer.getEmail()
				.equals(emailId)).findAny().orElseThrow(()->new EmailNotFoundException("Email is not present"));
		
	}
	
	public static void main(String[] args) {
		
		Customer customer = new Customer(1,"Amlan",null,Arrays.asList("1234567890","123456781"));
		
		Optional<Customer> emptyOptional = Optional.empty();
		System.out.println(emptyOptional);
		
//		Optional<String> emailOptional = Optional.of(customer.getEmail());
//		System.out.println(emailOptional);
		
		Optional<String> emailOpt = Optional.empty();
		if(emailOpt.isPresent()) {
			System.out.println(emailOpt);
		}
		System.out.println(emailOpt.orElse("Default Value"));
		
		//System.out.println(emailOpt.orElseThrow(()-> new IllegalArgumentException("EMAIL not present")));	
		
		//System.out.println(emailOpt.map(String::toUpperCase).orElseGet(()->"default email..."));
		
		Customer emailId = getEmailId("pqr");
		System.out.println(emailId);
		
	}

}
