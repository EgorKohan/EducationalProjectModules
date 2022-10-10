package models;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Course implements ICourse {

    private String name;
    private List<String> codes;
    private Map<String, Student> enrolledStudent = new HashMap<>();

}
