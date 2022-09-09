package org.mastercard.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
public class StudentInfo {
    @Id
    private String fullname;
    private String phonenumber;
    private String email;
    private String highschool;
    private String birthday;
    private String address1;
    private String address2;
    private String password;
    private String username;
}
