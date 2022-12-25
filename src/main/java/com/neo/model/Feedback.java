package com.neo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "feedback_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @Column(name = "feedback_name")
    private String feedbackName;

    @Column(name = "feedback_email")
    private String feedbackEmail;

    @Column(name = "feedback_suggestion")
    private String feedbackSuggestion;
}
