package org.hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "Profile")
public class Profile {

    @Id
    private int profileId;

    private String profileBio;
    private String profilePhoneNumber;

    @OneToOne
    @JoinColumn(name = "student_id") // Foreign key column in Profile table
    private Student student;

    public Profile() {}

    public Profile(int profileId, String profileBio, String profilePhoneNumber, Student student) {
        this.profileId = profileId;
        this.profileBio = profileBio;
        this.profilePhoneNumber = profilePhoneNumber;
        this.student = student;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getProfileBio() {
        return profileBio;
    }

    public void setProfileBio(String profileBio) {
        this.profileBio = profileBio;
    }

    public String getProfilePhoneNumber() {
        return profilePhoneNumber;
    }

    public void setProfilePhoneNumber(String profilePhoneNumber) {
        this.profilePhoneNumber = profilePhoneNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId=" + profileId +
                ", profileBio='" + profileBio + '\'' +
                ", profilePhoneNumber='" + profilePhoneNumber + '\'' +
                ", student=" + student +
                '}';
    }
}
