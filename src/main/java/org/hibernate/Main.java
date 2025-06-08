package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Profile.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        /*
        // Uncomment if inserting new Students
        session.persist(student);
        session.persist(student2);
        session.persist(student3);
        */

        // 🔹 Step 7.1: Get all students whose name starts with 'A'
        System.out.println("🔹 Students with names starting with 'A':");
        List<Student> students = session.createQuery("FROM Student WHERE studentName LIKE 'A%'", Student.class)
                .getResultList();
        students.forEach(System.out::println);

        // 🔹 Step 7.2: List all instructors who teach more than 1 course
        System.out.println("\n🔹 Instructors teaching more than one course:");
        List<Instructor> instructors = session.createQuery(
                        "SELECT i FROM Instructor i JOIN i.courses c GROUP BY i HAVING COUNT(c) > 1", Instructor.class)
                .getResultList();
        instructors.forEach(System.out::println);

        // 🔹 Step 7.3: Fetch all students with their profiles using join
        System.out.println("\n🔹 Students with their profiles:");
        List<Object[]> joinedData = session.createQuery(
                        "SELECT s, p FROM Student s JOIN s.profile p", Object[].class)
                .getResultList();
        for (Object[] row : joinedData) {
            Student s = (Student) row[0];
            Profile p = (Profile) row[1];
            System.out.println(s + " ➤ " + p);
        }

        // 🔹 Step 8: Update student email by ID
        System.out.println("\n🔹 Updating student email:");
        Student studentToUpdate = session.get(Student.class, 1);
        if (studentToUpdate != null) {
            studentToUpdate.setStudentEmail("updated@email.com");
            System.out.println("Updated: " + studentToUpdate);
        }

        // OR using HQL
        /*
        Query query = session.createQuery("UPDATE Student SET studentEmail = :newEmail WHERE studentId = :id");
        query.setParameter("newEmail", "updated@email.com");
        query.setParameter("id", 1);
        int result = query.executeUpdate();
        System.out.println("Updated rows: " + result);
        */

        // 🔹 Step 9.1: Delete a course by ID
        System.out.println("\n🔹 Deleting course with ID 301:");
        Course courseToDelete = session.get(Course.class, 301);
        if (courseToDelete != null) {
            session.remove(courseToDelete);
            System.out.println("Deleted Course: " + courseToDelete.getCourseTitle());
        }

        // 🔹 Step 9.2: Delete a student and see what happens to profile
        System.out.println("\n🔹 Deleting student with ID 2:");
        Student studentToDelete = session.get(Student.class, 2);
        if (studentToDelete != null) {
            session.remove(studentToDelete);
            System.out.println("Deleted: " + studentToDelete);
        }

        transaction.commit();
        factory.close();
    }
}
