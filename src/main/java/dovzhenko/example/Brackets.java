package dovzhenko.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;

import com.google.common.collect.ImmutableMap;
/**
 * Created by gleb on 14.05.16.
 */
public final class Brackets {

    private static Map<Character, Character> BRACKETS = ImmutableMap.of(')', '(', ']', '[', '}', '{');

    private Brackets() {
    }

    public static boolean checkBrackets(String text){
        Objects.requireNonNull(text);

        Deque<Character> brackets = new ArrayDeque<>();
        for (Character symbol : text.toCharArray()) {
            if (BRACKETS.containsValue(symbol)) {
                brackets.addFirst(symbol);
            } else if (BRACKETS.containsKey(symbol)) {
                if (brackets.isEmpty()) {
                    return false;
                }
                if (!Objects.equals(brackets.removeFirst(), BRACKETS.get(symbol))) {
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }

}

