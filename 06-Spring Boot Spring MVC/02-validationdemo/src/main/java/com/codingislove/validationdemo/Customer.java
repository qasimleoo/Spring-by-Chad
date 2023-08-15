package com.codingislove.validationdemo;

import com.codingislove.validationdemo.validation.CourseCode;
import jakarta.validation.constraints.*;
import org.springframework.web.bind.annotation.InitBinder;

public class Customer {
    @NotNull(message = "is required")
    private String firstName = "";

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName = "";

    @NotNull(message = "is required.")
    @Min(value = 0, message = "must be greater than or equal to 0.")
    @Max(value = 10, message = "must be less than or equal to 10.")
    private Integer freePasses;

    @NotNull(message = "is required.")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits are allowed.")
    private String postalCode;

    @NotNull(message = "is required.")
    @CourseCode
    private String courseCode;

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
