package cn.iocoder.yudao.module.bpm.service.quality;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.bpm.api.task.BpmProcessInstanceApi;
import cn.iocoder.yudao.module.bpm.api.task.dto.BpmProcessInstanceCreateReqDTO;
import cn.iocoder.yudao.module.bpm.controller.admin.quality.vo.BpmQualityReviewCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.quality.vo.BpmQualityReviewPageReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.quality.BpmQualityReviewDO;
import cn.iocoder.yudao.module.bpm.dal.mysql.quality.BpmQualityReviewMapper;
import cn.iocoder.yudao.module.bpm.enums.task.BpmTaskStatusEnum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserNickname;
import static cn.iocoder.yudao.module.bpm.enums.ErrorCodeConstants.QUALITY_REVIEW_NOT_EXISTS;

/**
 * 质检审核流程 Service 实现类
 */
@Service
@Validated
public class BpmQualityReviewServiceImpl implements BpmQualityReviewService {

    /**
     * 质检审核流程对应的流程定义 KEY
     */
    public static final String PROCESS_KEY = "qualityReviewProcess";

    @Resource
    private BpmQualityReviewMapper qualityReviewMapper;

    @Resource
    private BpmProcessInstanceApi processInstanceApi;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createQualityReview(Long userId, BpmQualityReviewCreateReqVO createReqVO) {
        // 插入业务表
        BpmQualityReviewDO review = BeanUtils.toBean(createReqVO, BpmQualityReviewDO.class)
                .setUserId(userId)
                .setInitiatorUsername(getLoginUserNickname())
                .setStatus(BpmTaskStatusEnum.RUNNING.getStatus());
        qualityReviewMapper.insert(review);

        // 发起 BPM 流程
        Map<String, Object> processInstanceVariables = new HashMap<>();
        processInstanceVariables.put("taskId", createReqVO.getTaskId());
        processInstanceVariables.put("initiatorUserId", userId);
        processInstanceVariables.put("initiatorUsername", getLoginUserNickname());
        processInstanceVariables.put("initiatorDeptHeadEmails", createReqVO.getInitiatorDeptHeadEmails());
        processInstanceVariables.put("initiatorDeptHeadUserIds", createReqVO.getInitiatorDeptHeadUserIds());
        processInstanceVariables.put("initiatorDeptHeadUsernames", createReqVO.getInitiatorDeptHeadUsernames());
        String processInstanceId = processInstanceApi.createProcessInstance(userId,
                new BpmProcessInstanceCreateReqDTO().setProcessDefinitionKey(PROCESS_KEY)
                        .setVariables(processInstanceVariables).setBusinessKey(String.valueOf(review.getId()))
                        .setStartUserSelectAssignees(createReqVO.getStartUserSelectAssignees()));

        // 将工作流的编号，更新到业务表
        qualityReviewMapper.updateById(new BpmQualityReviewDO().setId(review.getId())
                .setProcessInstanceId(processInstanceId));
        return review.getId();
    }

    @Override
    public void updateQualityReviewStatus(Long id, Integer status) {
        validateQualityReviewExists(id);
        qualityReviewMapper.updateById(new BpmQualityReviewDO().setId(id).setStatus(status));
    }

    private void validateQualityReviewExists(Long id) {
        if (qualityReviewMapper.selectById(id) == null) {
            throw exception(QUALITY_REVIEW_NOT_EXISTS);
        }
    }

    @Override
    public BpmQualityReviewDO getQualityReview(Long id) {
        return qualityReviewMapper.selectById(id);
    }

    @Override
    public PageResult<BpmQualityReviewDO> getQualityReviewPage(Long userId, BpmQualityReviewPageReqVO pageReqVO) {
        return qualityReviewMapper.selectPage(userId, pageReqVO);
    }

}
