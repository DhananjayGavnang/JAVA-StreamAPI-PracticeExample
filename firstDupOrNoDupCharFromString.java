package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String str = "Dhananjayh";

        String reduce = str.chars().mapToObj(c -> String.valueOf((char) c))
                .reduce((c1,c2)->c2+c1).orElse(str);
        System.out.println(reduce);

        //------------Find first dup OR no dup char from string using LinkedHashMap
        Map<Character,Integer> charCount = new LinkedHashMap<>();

        str.chars().mapToObj(c->(char)c)
                .forEach(c->charCount.put(c,charCount.getOrDefault(c,0)+1));

        Character firstDupChar = charCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        //System.out.println(firstDupChar);

        //------------Find first duplicate char from string using hashSet
        Set<Character> charSet=new HashSet<>();
        Character c1 = str.chars().mapToObj(c -> (char) c)
                .filter(c -> !charSet.add(c))
                .findFirst()
                .orElse(null);

    }
}
