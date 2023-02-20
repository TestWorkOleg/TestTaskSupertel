import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Port {
    private String[] indexes;

    public Port(String[] indexes) {
        this.indexes = indexes;
    }

    public List<List<Integer>> parseIndexes() {
        List<List<Integer>> result = new ArrayList<>();
        for (String index : indexes) {
            List<Integer> numbers = new ArrayList<>();
            String[] ranges = index.split(",");
            for (String range : ranges) {
                Pattern pattern = Pattern.compile("(\\d+)-(\\d+)");
                Matcher matcher = pattern.matcher(range);
                if (matcher.matches()) {
                    int start = Integer.parseInt(matcher.group(1));
                    int end = Integer.parseInt(matcher.group(2));
                    for (int i = start; i <= end; i++) {
                        numbers.add(i);
                    }
                } else {
                    int number = Integer.parseInt(range);
                    numbers.add(number);
                }
            }
            result.add(numbers);
        }
        return result;
    }
}