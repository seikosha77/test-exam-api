package com.example.testexamapi.controller;

import com.example.testexamapi.model.Exam;
import com.example.testexamapi.repository.ExamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class ExamController {
    @Autowired
    ExamRepository repository;
    private final Logger log = LoggerFactory.getLogger(ExamController.class);

    @RequestMapping("/create")
    public Exam create(Exam create){
        log.info("Exam creaing for id: " + create.getId());
        Date d = Calendar.getInstance().getTime();

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(d);

        Exam exam = repository.save(new Exam(create.getExamName(),create.getDescription(),create.getPassScore(), create.getCreator(),
                create.getTotalScore(),create.getExamDuration(), date));
        return exam;
    }

    @RequestMapping("/findById")
    public String findById(@RequestParam("id") long id){
        log.info("Exam finding by id: " + id);
        String result = "";
        result = repository.findById(id).toString();

        return result;
    }

    @RequestMapping("/findByCreator")
    public String findByCreator(@RequestParam("creator") String creator){
        log.info("Exam finding by Creator: " + creator);
        String result = "";
        result = repository.findByCreator(creator).toString();

        return result + "\n";
    }

    @RequestMapping("/deleteExam")
    public String deleteExam(@RequestParam("id") int id){
        log.info("Exam deleting for id: " + id);
        repository.deleteById((long) id);
        return "Exam id " + id + " deleted";
    }

    @RequestMapping("/update")
    public String update(Exam exam){
        log.info("Exam updating for id= " + exam.getId());
        Exam getExam = repository.findById(exam.getId()).get();
        exam.setExamName(exam.getExamName());
        exam.setTotalScore(exam.getTotalScore());
        exam.setPassScore(exam.getPassScore());
        exam.setExamDuration(exam.getExamDuration());
        exam.setCreator(exam.getCreator());
        repository.save(exam);
        return getExam + " \nupdated to\n" + exam.toString() + "\n";
    }

    @RequestMapping("/listByDateRange")
    public String listByDateRange(String startDate, String finishDate){
        log.info("Exam listing for date range " + startDate + " between " + finishDate);
        String result = "";
        result = repository.listByDateRange(startDate, finishDate).toString();

        return result + "\n";
    }
}
