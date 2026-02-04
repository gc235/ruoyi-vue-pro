package cn.iocoder.yudao.module.bpm.service.quality.listener;

import cn.iocoder.yudao.module.bpm.api.event.BpmProcessInstanceStatusEvent;
import cn.iocoder.yudao.module.bpm.api.event.BpmProcessInstanceStatusEventListener;
import cn.iocoder.yudao.module.bpm.service.quality.BpmQualityReviewService;
import cn.iocoder.yudao.module.bpm.service.quality.BpmQualityReviewServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 质检审核流程状态监听器
 */
@Component
public class BpmQualityReviewStatusListener extends BpmProcessInstanceStatusEventListener {

    @Resource
    private BpmQualityReviewService qualityReviewService;

    @Override
    protected String getProcessDefinitionKey() {
        return BpmQualityReviewServiceImpl.PROCESS_KEY;
    }

    @Override
    protected void onEvent(BpmProcessInstanceStatusEvent event) {
        qualityReviewService.updateQualityReviewStatus(Long.parseLong(event.getBusinessKey()), event.getStatus());
    }

}
