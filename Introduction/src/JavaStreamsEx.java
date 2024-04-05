import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class JavaStreamsEx {
	public static void main(String[] args)
	{
		List<String> names = Stream.of("nishi","niki","shreya","nidhi","nan","nishi").collect(Collectors.toList());
		int num[] = {6,3,9,7,1,9,0,3};
		long countNames = names.stream().filter(s -> s.startsWith("n")).count();
		System.out.println(countNames) ;
		System.out.println("----------------------------------");

		//multiple lined function
		names.stream().filter(s ->
		{
		s.endsWith("a");
		return false;
		}
		).count();
		
		System.out.println("----------------------------------");
		//operate on each of the returned element
		names.stream().filter(s -> s.length()>3).forEach(s -> System.out.println(s));
		System.out.println("----------------------------------");

		//Do actions on the filtered stream - Map
		names.stream().filter(s-> s.contains("ni")).sorted().map(s-> s.toUpperCase()).forEach(s->System.out.println(s));
		
		System.out.println("----------------------------------");

		
		//	Merging 2 streams
		List<String> numList = Arrays.asList("6","3","9","7","3");
		Stream<String> newStream =  Stream.concat(names.stream(), numList.stream());
		boolean matchRes =  newStream.anyMatch(s -> s.equalsIgnoreCase("nishi"));
		Assert.assertTrue(matchRes);
		System.out.println("----------------------------------");
		
		//collecting the stream output to a list 
		Stream<String> newStream1 =  Stream.concat(names.stream(), numList.stream());

		List<String> collected = newStream1.distinct().collect(Collectors.toList());
		collected.stream().forEach(s -> System.out.println(s));
		System.out.println("----------------------------------");

		
		//distinct numbers
		List<Integer> numbers = Arrays.asList(0,3,5,7,3,1,9,0,7);
		numbers.stream().distinct().limit(3).forEach(s-> System.out.println(s));;
		System.out.println("----------------------------------");


	}

}
