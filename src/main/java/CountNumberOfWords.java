import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


// count the number of words in a string
public class CountNumberOfWords {

    public static void main(String[] args) {

        String str = "aaa aaa ddd fff aaa rrr ttt hhh aaa fff hhh uuu jjj kkk lll aaa";

        countWords(str).forEach((s, i) -> System.out.println(s + " : " + i));
        System.out.println("STREAM");
        countWordsWithStream(str).forEach((s, i) -> System.out.println(s + " : " + i));

    }

    private static Map<String, Integer> countWords(String str){
        Map<String, Integer> map = new HashMap<>();

        for (String s : str.split(" ")) {
            map.merge(s, 1, Integer::sum);
        }
        return map;
    }

    private static Map<String, Long> countWordsWithStream(String str){
        return Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
