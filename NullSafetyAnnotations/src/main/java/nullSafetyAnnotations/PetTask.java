package nullSafetyAnnotations;

import lombok.Getter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Getter
public class PetTask {

    private String name;
    @Nullable
    private String surname;
    @Nullable
    private String patronymic;

    @NonNull
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(@Nullable String surname) {
        this.surname = surname;
    }

    public void setPatronymic(@NonNull String patronymic) {
        this.patronymic = patronymic;
    }

    public static void main(String[] args) {
        PetTask petTask = new PetTask();
        petTask.setSurname(null);
        petTask.setName(petTask.getSurname());
        petTask.setPatronymic(null);
    }

}
