package cn.iocoder.yudao.module.bpm.service.quality;

import java.util.Map;

public interface QualityReviewExternalTaskService {

    void sendEmailToDeptHead(Map<String, Object> variables);

    void qualityCheck(Map<String, Object> variables);

    void sendMessage(Map<String, Object> variables);

}
