package org.mastercard.controllers;

import org.mastercard.models.StudentInfo;
import org.mastercard.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/studentAPI")
public class CreateStudentAccountController {

    @Autowired
    StudentRepository studentRepo;
    @PostMapping("/addStudentInfo")
    public ResponseEntity<StudentInfo> createStudentInfo(@RequestBody StudentInfo student) {
        return new ResponseEntity<StudentInfo>(studentRepo.save(student), HttpStatus.CREATED);
    }

    @GetMapping("/getData")
    ResponseEntity<List<StudentInfo>> getAllStudentInfo(String getData) {
        try {
            List<StudentInfo> studentReview = new ArrayList<StudentInfo>();
            if (getData == null) {
                studentRepo.findAll().forEach(studentReview::add);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            if (studentReview.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(studentReview, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/studentData/{name}")
    public ResponseEntity<StudentInfo> returnData(@PathVariable("name") String NAME) {
        Optional<StudentInfo> studentdata = studentRepo.findById(NAME);
        if (studentdata.isPresent()) {
            return new ResponseEntity<>(studentdata.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}