package org.hibernate;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    private int courseId;

    private String courseTitle;
    private String courseDescription;

    @ManyToMany
    @JoinTable(
            name = "course_instructor",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id")
    )
    private List<Instructor> instructors;

    public Course() {}

    public Course(int courseId, String courseTitle, String courseDescription) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
    }

    public Course(int courseId, String courseTitle, String courseDescription, List<Instructor> instructors) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.instructors = instructors;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", instructors=" + instructors +
                '}';
    }
}
