package com.neo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {

    private Long feedbackId;

    @NotEmpty
    @Size(min = 2,message = "Name must be Atleast 2 character!! ")
    private String feedbackName;

    @Email(message = "Email should be in proper")
    private String feedbackEmail;

    @NotEmpty
    private String feedbackSuggestion;
}
