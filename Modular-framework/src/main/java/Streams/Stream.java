package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Stream {
	// @Test

	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Kanha");
		names.add("Chintu");
		names.add("Raja");
		names.add("Bitu");
		names.add("Babul");
		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("B")) {
				count++;
			}

		}
		System.out.println(count);
	}

	// @Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Kanha");
		names.add("Chintu");
		names.add("Raja");
		names.add("Bitu");
		names.add("Babul");

		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.err.println(s));

		Long c = names.stream().filter(s -> s.startsWith("B")).count();
		System.out.println(c);

		// Another way

		List<String> abc = Arrays.asList("Kanha", "Kunal", "Kamala", "Kuna", "Muna");
		abc.stream().filter(s -> s.startsWith("M")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

	}

	//@Test
	public void streamMap() {

		List<String> abc = Arrays.asList("Kanha", "Kunal", "Kamala", "Kuna", "Muna");
		abc.stream().filter(s -> s.startsWith("K")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
	}

	//@Test
	public void merge() {
		List<String> abc = Arrays.asList("Kanha", "Kunal", "Kamala", "Kuna", "Muna");
		/*
		 * ArrayList<String> names = new ArrayList<String>(); names.add("Kanha");
		 * names.add("Chintu"); names.add("Raja"); names.add("Bitu");
		 * names.add("Babul");
		 */

		//Stream<String> merge = Stream.concat(names.stream(), abc.stream());
		boolean flag = abc.stream().anyMatch(s -> s.equalsIgnoreCase("Kanha"));
		Assert.assertTrue(flag);
		List<String> ls =abc.stream().filter(s->s.startsWith("K")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println("First latter is :" + ls.get(0));
	}
	@Test
	public void inte() {
		List<Integer> values =Arrays.asList(3,2,2,7,3,5,1,9,7);
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		
		//print only 3rd index after sorting
		List<Integer> li =values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("3rd index is : " + li.get(2));
		
		
	}

}
