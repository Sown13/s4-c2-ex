package com.demo.s4c2exam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_score_t")
public class StudentScoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_score_id")
    private Integer studentScoreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "fk_student_id"))
    private StudentModel student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", foreignKey = @ForeignKey(name = "fk_subject_id"))
    private SubjectModel subject;

    @Column(name = "score1")
    private Double score1;

    @Column(name = "score2")
    private Double score2;

    @Transient
    public String getGrade() {
        if (score1 == null || score2 == null) return "";
        double avg = 0.3 * score1 + 0.7 * score2;
        if (avg >= 8.0) return "A";
        if (avg >= 6.0) return "B";
        if (avg >= 4.0) return "D";
        return "F";
    }

}
