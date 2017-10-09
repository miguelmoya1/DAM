package listfilter;

import java.util.List;

/**
 * @author Miguel Moya Ortega
 */
public class Student {

    protected String name;
    protected byte age;
    List<String> subjects;

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public byte getAge() {
        return age;
    }

    public Student setAge(byte age) {
        this.age = age;
        return this;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public Student setSubjects(List<String> subjects) {
        this.subjects = subjects;
        return this;
    }
}
