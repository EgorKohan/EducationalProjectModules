package nullSafetyAnnotations;

import lombok.Getter;
import org.springframework.lang.NonNull;

/**
 * Here is a {@link NonNull} annotation on field level, and it highlights the field if it can contain a null
 */

public class Person {

    @Getter
    @NonNull
    private String fullName = "";

    void setFullName(String fullName) {
        if (fullName != null && fullName.isEmpty()) {
            fullName = null;
        }
        this.fullName = fullName == null ? "" : fullName;
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.getFullName().length();
    }

}
