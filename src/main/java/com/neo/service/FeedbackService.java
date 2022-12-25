package com.neo.service;

import com.neo.dto.FeedbackDto;

public interface FeedbackService {
    FeedbackDto postFeedback(FeedbackDto feedbackDto);
}
