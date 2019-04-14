package unittest.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;

@JsonSerialize
public class CourseDetails {
    public Integer getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    @JsonSerialize
    private Integer courseId;
    @JsonSerialize
    private String courseName;

    public CourseDetails() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDetails that = (CourseDetails) o;
        return Objects.equals(courseId, that.courseId) &&
                Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName);
    }

    public CourseDetails(Integer courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

}
