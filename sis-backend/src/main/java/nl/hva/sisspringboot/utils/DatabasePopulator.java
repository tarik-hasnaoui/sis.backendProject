
package nl.hva.sisspringboot.utils;

import java.util.Date;
import java.util.List;

import nl.hva.sisspringboot.model.Address;
import nl.hva.sisspringboot.model.Block;
import nl.hva.sisspringboot.model.Course;
import nl.hva.sisspringboot.model.CourseGroup;
import nl.hva.sisspringboot.model.CourseProgram;
import nl.hva.sisspringboot.model.CourseType;
import nl.hva.sisspringboot.model.ExamResult;
import nl.hva.sisspringboot.model.Module;
import nl.hva.sisspringboot.model.Semester;
import nl.hva.sisspringboot.model.StudentProfile;
import nl.hva.sisspringboot.model.User;
import nl.hva.sisspringboot.model.UserProfile;
import nl.hva.sisspringboot.model.UserRole;

public class DatabasePopulator {

    public static User createUser(String email, String password, String token, boolean isEnabled, UserProfile userProfile, Date lastLogin, UserRole userRole) {
        return new User(email, password, token, isEnabled, lastLogin, userProfile, userRole);
    }

    public static StudentProfile createUserProfile(String studentNumber, Date registrationDate, Date unsubscriptionDate, String previousDegree, List<ExamResult> examResults, CourseGroup courseGroup, CourseProgram courseProgram, char gender, String initials, String firstName, String lastName, String insertion, String phoneNumber, Date dateOfBirth, String placeOfBirth, String training, String nationality, Address address) {

        return new StudentProfile(studentNumber, registrationDate, unsubscriptionDate, previousDegree, examResults, courseGroup, courseProgram, gender, initials, firstName, lastName, insertion, phoneNumber, dateOfBirth, nationality, training, nationality, address);
    }

    public static Address createAddress(String street, int houseNumber, String houseNumberAddition, String zipCode, String city) {
        return new Address(street, houseNumber, street, zipCode, city);
    }

    public static Course createCourse(String courseCode, String coursename, CourseType courseType, List<CourseProgram> coursePrograms) {
        return new Course(courseCode, coursename, courseType, 240, coursePrograms);
    }

    public static Module createModule(String name, int ects) {
        return new Module(name, ects);
    }

    public static Block createBlock(Integer blockNumber, Date startDate, Date endDate, List<Module> modules, Semester semester) {
        return new Block(blockNumber, startDate, endDate, modules, semester);
    }
}
