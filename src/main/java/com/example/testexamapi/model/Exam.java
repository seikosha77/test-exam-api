package com.example.testexamapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Exam")
public class Exam implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "examName")
    private String examName;

    @Column(name = "description")
    private String description;

    @Column(name = "passScore")
    private int passScore;

    @Column(name = "creator")
    private String creator;

    @Column(name = "total_score")
    private int totalScore;

    @Column(name = "exam_duration")
    private int examDuration;

    @Column(name = "date")
    private String date;

    public Exam(){}

    public Exam(String examName, String description, int passScore, String creator, int totalScore, int examDuration, String date) {
        this.examName = examName;
        this.description = description;
        this.passScore = passScore;
        this.creator = creator;
        this.totalScore = totalScore;
        this.examDuration = examDuration;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPassScore() {
        return passScore;
    }

    public void setPassScore(int passScore) {
        this.passScore = passScore;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", description='" + description + '\'' +
                ", passScore=" + passScore +
                ", creator='" + creator + '\'' +
                ", totalScore=" + totalScore +
                ", examDuration=" + examDuration +
                ", date='" + date + '\'' +
                '}';
    }
}
