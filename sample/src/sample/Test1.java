package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {

	
//@SuppressWarnings("null")
public static void main(String[] args) throws FileNotFoundException {
	
String s=new String("vammssi");
	
List<String> l1=s.chars().mapToObj(c -> (char) c).map(c->c.toString()).collect(Collectors.toList());
	System.out.println(l1);
//	
//	  char[] myCharArray = s.toCharArray();
//
//      Stream<Character> myStreamOfCharacters = IntStream
//                .range(0, myCharArray.length)
//                .mapToObj(i -> myCharArray[i]);
//
//      List<Character> list1 = myStreamOfCharacters.collect(Collectors.toList());
//      
//
//     // list.forEach(System.out::println);
//      Map<Object, Long> counts =
//  			l1.stream().filter(i -> Collections.frequency(l1, i) >1).collect(Collectors.groupingBy(e->e, (Collectors.counting())));
//	System.out.println(counts);
	
//	List<String> list=Arrays.asList("v","a","a","m","s","s");
//	System.out.println(list);
	Map<String, Long> counts =
			l1.stream().filter(i -> Collections.frequency(l1, i) >1).collect(Collectors.groupingBy(e->e, (Collectors.counting())));
	System.out.println(counts);
	
	
	
	
	
	List<Character> l2=s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
	
	
	Map<Character, Long> counts1 =
			l2.stream().filter(i -> Collections.frequency(l2, i) >1).collect(Collectors.groupingBy(e->e, (Collectors.counting())));
	System.out.println(counts1);
	
	System.out.println(Test1.readFileIntoListOfWords());
	List<String> l3=Test1.readFileIntoListOfWords();
	Map<String, Long> counts2 =
			l3.stream().filter(i -> Collections.frequency(l3, i) >1).collect(Collectors.groupingBy(e->e, (Collectors.counting())));
	System.out.println(counts2);
	String s1="vamsi";
	String s2=null;
	System.out.println(s1==s2);
	System.out.println(s2==s);
	System.out.println(s1.equals(s2));
	//System.out.println(s2.equals(s1));
	
	File file=new File("/Users/vamsi.c/Desktop/vam.txt");
	Scanner sc=new Scanner(file);
	int count=0;
	while (sc.hasNext()) {
		String string = (String) sc.next();
		if(string.equals("vamsi")) {
			count++;
		}
		
	}
	System.out.println(count);
	readFileIntoListOfWords();
	
}
public static List<String> readFileIntoListOfWords() {
    try {
        return Files.readAllLines(Paths.get("/Users/vamsi.c/Desktop/vam.txt"))
            .stream()
            .map(l -> l.split(" "))
            .flatMap(Arrays::stream)
            .collect(Collectors.toList());
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    return Collections.emptyList();
}

}
