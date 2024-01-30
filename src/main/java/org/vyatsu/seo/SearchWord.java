//package org.vyatsu.seo;
//
//import java.util.*;
//
//public class SearchWord {
//
//    public static Map<String, Integer> getSearchWordByDescription(CharSequence text) {
//        Map<String, Integer> words = new LinkedHashMap<>();
//        String word = String.valueOf(text.charAt(0));
//
//        for (int i = 1; i < text.length(); i++) {
//            if (text.charAt(i) != ' ') {
//                word += text.charAt(i);
//            } else {
//                words.merge(word.toLowerCase(), 1, Integer::sum);
//                word = "";
//            }
//        }
//
//        return sortByValue(words);
//    }
//    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {
//        return unsortedMap.entrySet()
//                .stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);
//    }
//
//
//}
