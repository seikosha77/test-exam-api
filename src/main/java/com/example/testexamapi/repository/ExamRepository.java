package com.example.testexamapi.repository;

import com.example.testexamapi.model.Exam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExamRepository extends CrudRepository<Exam, Long> {
    List<Exam> findByCreator(String creator);

    @Query(value="select * from exam where date between ?1 and ?2", nativeQuery=true)
    List<Exam> listByDateRange(String date1, String date2);
}
