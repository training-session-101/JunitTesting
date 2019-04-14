package unittest.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COURSES")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Course() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(coureseName, course.coureseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coureseName);
    }

    public Course(Integer id, String coureseName) {
        this.id = id;
        this.coureseName = coureseName;
    }

    public Integer getId() {
        return id;
    }

    public String getCoureseName() {
        return coureseName;
    }

    private String coureseName;
}
