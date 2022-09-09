package org.mastercard.repositories;

import org.mastercard.models.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentInfo, String> {
    List<StudentInfo> findByfullname(String name);
}
