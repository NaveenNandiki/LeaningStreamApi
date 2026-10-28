package gut.streams;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abcd";

		List<Character> rsList = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					Collections.reverse(list);
					return list;
				}));
		String resString = rsList.stream().map(String::valueOf).collect(Collectors.joining());

		System.out.println(resString);
		System.out.println();

		String str = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					Collections.reverseOrder();
					return list.stream().map(String::valueOf).collect(Collectors.joining());
				}));
		System.out.println(str);

	}

}
