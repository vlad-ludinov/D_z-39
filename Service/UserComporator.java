package Service;

import java.util.Comparator;

import Model.User;

public class UserComporator<T extends User> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        String str1 = o1.getFullName().toLowerCase().split(" ")[1];
        String str2 = o2.getFullName().toLowerCase().split(" ")[1];
        int length = compareLenght(str1, str2);
        for (int i = 0; i < length; i++) {
            // HashCode русского алфавита идет по порядку, но буква ё почему-то сильно отличается
            if (Character.hashCode(str1.charAt(i)) == 1105 || Character.hashCode(str2.charAt(i)) == 1105) {
                if (Character.hashCode(str2.charAt(i)) <= 1077 || Character.hashCode(str1.charAt(i)) != 1105 && Character.hashCode(str1.charAt(i)) >= 1078) {
                    return 1;
                } else if (Character.hashCode(str1.charAt(i)) <= 1077 || Character.hashCode(str2.charAt(i)) != 1105 && Character.hashCode(str2.charAt(i)) >= 1078) {
                    return -1;
                }
            } else if (Character.hashCode(str1.charAt(i)) > Character.hashCode(str2.charAt(i))) {
                return 1;
            } else if (Character.hashCode(str1.charAt(i)) < Character.hashCode(str2.charAt(i))) {
                return -1;
            }
        }
        if (str1.length() > str2.length()) {
            return 1;
        } else if (str1.length() < str2.length()) {
            return -1;
        } else {
            return 0;
        }
        
    }

    public int compareLenght(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return str1.length();
        } else if (str1.length() > str2.length()) {
            return str2.length();
        } else {
            return str1.length();
        }
    }

}
