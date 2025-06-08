package org.hibernate;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Instructor")
public class Instructor {

    @Id
    private int instructorId;

    private String instructorName;
    private String instructorExpertise;

    @ManyToMany(mappedBy = "instructors")
    private List<Course> courses;

    public Instructor() {}

    public Instructor(int instructorId, String instructorName, String instructorExpertise, List<Course> courses) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorExpertise = instructorExpertise;
        this.courses = courses;
    }

    public Instructor(int instructorId, String instructorName, String instructorExpertise) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorExpertise = instructorExpertise;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorExpertise() {
        return instructorExpertise;
    }

    public void setInstructorExpertise(String instructorExpertise) {
        this.instructorExpertise = instructorExpertise;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorId=" + instructorId +
                ", instructorName='" + instructorName + '\'' +
                ", instructorExpertise='" + instructorExpertise + '\'' +
                '}';
    }
}
