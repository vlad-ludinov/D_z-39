package Model;

public class Student extends User implements Comparable<Student> {

    private Double gpa;
    private String advistor;

    public Student(Long id, String fullName, Integer age, String phoneNumber) {
        super(id, fullName, age, phoneNumber);
        // this.gpa = gpa;
        // this.advistor = advistor;
    }

    @Override
    public int compareTo(Student o) {

        String str1 = this.getFullName().toLowerCase().split(" ")[0];
        String str2 = o.getFullName().toLowerCase().split(" ")[0];
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


    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s", getId(), getFullName(), getAge(), getPhoneNumber());
    }

    @Override
    public boolean equals(Object obj) {
        String str = (String)obj;
        return this.getFullName() == str;
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
