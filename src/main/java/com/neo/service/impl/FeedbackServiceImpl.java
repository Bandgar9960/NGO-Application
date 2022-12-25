package com.neo.service.impl;

import com.neo.dto.FeedbackDto;
import com.neo.model.Feedback;
import com.neo.repository.FeedbackRepository;
import com.neo.service.FeedbackService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    Logger logger= LoggerFactory.getLogger(FeedbackService.class);

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FeedbackDto postFeedback(FeedbackDto feedbackDto) {
        logger.info("Initiating dao call for the post feedback details");
        Feedback feedback = this.modelMapper.map(feedbackDto, Feedback.class);
        Feedback saveFeedback = this.feedbackRepository.save(feedback);
        logger.info("Completed dao call for the post feedback details");
        return this.modelMapper.map(saveFeedback, FeedbackDto.class);
    }
}
