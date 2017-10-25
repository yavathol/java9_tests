package pl.ycs.test9streams;

import java.util.Comparator;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamTester {

    private static final Pattern PATTERN = Pattern.compile(" ");

    public static void main(String ... doYourBest) {
        String starWars = "Luke DarthVader ObiWan QuiGonJinn Palpatine";

        Function<String, Stream<String>> lineSplitter = l -> PATTERN.splitAsStream(l);

        Stream.of(starWars)
                .flatMap(lineSplitter)
//                .sorted(((o1, o2) -> o2.compareTo(o1)))
                .sorted((Comparator.reverseOrder()))
                .forEachOrdered(System.out::println);
    }
}
