package cn.iocoder.yudao.module.bpm.service.quality;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class QualityReviewExternalTaskServiceImpl implements QualityReviewExternalTaskService {

    @Override
    public void sendEmailToDeptHead(Map<String, Object> variables) {
        log.warn("[QualityReview][sendEmailToDeptHead] TODO implement. variables={}", variables);
    }

    @Override
    public void qualityCheck(Map<String, Object> variables) {
        log.warn("[QualityReview][qualityCheck] TODO implement. variables={}", variables);
    }

    @Override
    public void sendMessage(Map<String, Object> variables) {
        log.warn("[QualityReview][sendMessage] TODO implement. variables={}", variables);
    }

}
