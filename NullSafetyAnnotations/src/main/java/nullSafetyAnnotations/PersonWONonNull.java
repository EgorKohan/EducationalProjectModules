package nullSafetyAnnotations;

import lombok.Getter;

/**
 * Here is working {@link org.springframework.lang.NonNullFields}, and it highlights the field if it can contain a null
 */

public class PersonWONonNull {

    @Getter
//    @Nullable //Don't need to check, that value cannot be a null
    private String fullName;


    void setFullName(String fullName) {
        if (fullName != null && fullName.isEmpty()) {
            fullName = null;
        }
        this.fullName = fullName; //NonNullFields annotation is working
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.getFullName().length();
    }

}
