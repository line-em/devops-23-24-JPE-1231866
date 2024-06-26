/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.payroll;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Entity // <1>
public class Employee {
    private @Id
    @GeneratedValue Long id; // <2>
    private String firstName;
    private String lastName;
    private String description;
    private String jobTitle;
    private int jobYears;
    private String email;

    private Employee() {
    }

    public Employee(String firstName, String lastName, String description, String jobTitle, int jobYears, String email) {
        if (! validateStringArguments(firstName, lastName, description, jobTitle, email))
            throw new IllegalArgumentException("Arguments must not be null or empty.");
        if (! isValidEmail(email))
            throw new IllegalArgumentException("Email must be valid.");
        if (! isValidInt(jobYears))
            throw new IllegalArgumentException("Job years must be a positive number.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.jobTitle = jobTitle;
        this.jobYears = jobYears;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (! isValidString(firstName))
            return;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (! isValidString(lastName))
            return;
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (! isValidString(description))
            return;
        this.description = description;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        if (! isValidString(jobTitle))
            return;
        this.jobTitle = jobTitle;
    }

    public int getJobYears() {
        return jobYears;
    }

    public void setJobYears(int jobYears) {
        if (! isValidInt(jobYears))
            return;
        this.jobYears = jobYears;
    }

    private boolean isValidInt(int jobYears) {
        return jobYears >= 0;
    }

    private boolean isValidString(String argument) {
        return argument != null && ! argument.trim().isEmpty();
    }

    private boolean validateStringArguments(String... arguments) {
        for (String argument : arguments)
            if (! isValidString(argument))
                return false;
        return true;
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailField) {
        this.email = emailField;
    }

    @Override
    public String toString() {
        return "Employee{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", description='" + description + '\'' +
              ", jobTitle='" + jobTitle + '\'' +
              ", jobYears=" + jobYears +
              ", emailField='" + email + '\'' +
              '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return jobYears == employee.jobYears && Objects.equals(id, employee.id) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(description, employee.description) && Objects.equals(jobTitle, employee.jobTitle) && Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, description, jobTitle, jobYears, email);
    }
}
// end::code[]
