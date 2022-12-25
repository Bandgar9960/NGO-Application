package com.neo.controller;

import com.neo.dto.FeedbackDto;
import com.neo.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class FeedBackController {

    Logger logger= LoggerFactory.getLogger(FeedBackController.class);
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedbacks")
    public ResponseEntity<FeedbackDto> saveFeedback(@Valid @RequestBody FeedbackDto feedbackDto ){

        logger.info("Initiated request for save the feedback details");
        FeedbackDto postfeedback = this.feedbackService.postFeedback(feedbackDto);
        logger.info("Completed request for save the feedback details");
        return new ResponseEntity<>(postfeedback, HttpStatus.CREATED);
    }
}
