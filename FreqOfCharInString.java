package gut.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FreqOfCharInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "112233412344773327";

		Map<Character, Long> freq1 = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Character, List<Character>> freq = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c));
		System.out.println(freq);

		System.out.println(freq1);

		System.out.println(s.chars().map(c -> c));

		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(arr));

		Arrays.stream(arr).mapToObj(c -> c * c).collect(Collectors.groupingBy(c -> c));

		System.out.println(IntStream.of(arr).mapToObj(c -> c * c).collect(Collectors.groupingBy(c -> c)));
	}

}
