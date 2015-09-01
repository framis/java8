package Collections;

import java.util.List;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {

        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        final List<String> startsWithN = friends.stream()
                .filter(name -> name.startsWith("N"))
                .collect(Collectors.toList());

        System.out.println(String.format("Found %d names", startsWithN.size()));


        // Predicate<T> takes in one parameter of type T and returns a boolean result to indicate a decision for whatever check it represents.
        final Function<String, Predicate<String>> startsWithLetter =
                (String letter) -> (String name) -> name.startsWith(letter);

        System.out.println(String.format("Found %d names", friends.stream().filter(startsWithLetter.apply("N")).count()));
    }

}
