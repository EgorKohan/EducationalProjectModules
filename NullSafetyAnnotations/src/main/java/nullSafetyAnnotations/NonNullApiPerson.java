package nullSafetyAnnotations;

import org.springframework.lang.Nullable;

/**
 * Example only for {@link org.springframework.lang.NonNullApi} annotation
 */

public class NonNullApiPerson {

    private String fullName;

    void setFullName(@Nullable String fullName1) {
        if (fullName1 != null && fullName1.isEmpty()) {
            fullName1 = null;
        }
        this.fullName = fullName1; //NonNullFields annotation is working
    }

    public static void main(String[] args) {
        NonNullApiPerson person = new NonNullApiPerson();
        person.setFullName(null);
        person.getFullName().length();
    }

    public String getFullName() {
        return fullName;
    }


}
