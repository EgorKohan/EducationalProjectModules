package property.access;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import models.Course;
import models.CourseEntity;
import models.ICourse;
import models.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/**
 * Не понимаю в чем смысл, так как без сеттеров не работает, а с ними рефлексия как бы не нужна
 */

@Slf4j
public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        simpleProperty();
    }

    private static void simpleProperty() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Course course = new Course();
        String name = "Computer Science";
        List<String> codes = Arrays.asList("CS", "CS01");

        Object object = course;

        PropertyUtils.setSimpleProperty(object, "name", name);
        PropertyUtils.setSimpleProperty(object, "codes", codes);

        System.out.println("object = " + object);
    }

    private static void indexedProperty() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Course course = new Course();
        String name = "Computer Science";
        List<String> codes = Arrays.asList("CS", "CS01");

        PropertyUtils.setSimpleProperty(course, "name", name);
        PropertyUtils.setSimpleProperty(course, "codes", codes);
        PropertyUtils.setIndexedProperty(course, "codes[0]", "CS02");

        System.out.println("course = " + course);
    }

    private static void mappedProperty() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Course course = new Course();
        Student student = new Student();
        String studentName = "Joe";
        student.setName(studentName);

        PropertyUtils.setMappedProperty(course, "enrolledStudent(1)", student);

        System.out.println("studentName = " + course);
    }

    private static void nestedPropertyAccess() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Course course = new Course();
        Student student = new Student();
        String studentName = "Joe";
        student.setName(studentName);

        PropertyUtils.setMappedProperty(course, "enrolledStudent(ST-1)", student);

        String name = (String) PropertyUtils.getNestedProperty(course, "enrolledStudent(ST-1).name");

        System.out.println("name = " + name);
    }

    private static void copyBeanProperties() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Course course = new Course();
        course.setName("Computer Science");
        course.setCodes(Arrays.asList("CS", "CS1"));
        course.getEnrolledStudent().put("ST-1", new Student());

        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(courseEntity, course);

        System.out.println("courseEntity = " + courseEntity);
    }

    private static void checkWorkWithInterfaces() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ICourse course = new Course();

        PropertyUtils.setSimpleProperty(course, "name", "Bob");

        System.out.println("course = " + course);
    }

}
