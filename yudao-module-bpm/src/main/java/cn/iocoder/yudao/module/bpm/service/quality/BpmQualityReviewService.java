package cn.iocoder.yudao.module.bpm.service.quality;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.bpm.controller.admin.quality.vo.BpmQualityReviewCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.quality.vo.BpmQualityReviewPageReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.quality.BpmQualityReviewDO;
import jakarta.validation.Valid;

/**
 * 质检审核流程 Service 接口
 */
public interface BpmQualityReviewService {

    /**
     * 创建质检审核流程
     *
     * @param userId 发起人用户编号
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createQualityReview(Long userId, @Valid BpmQualityReviewCreateReqVO createReqVO);

    /**
     * 更新质检审核流程的状态
     *
     * @param id 编号
     * @param status 状态
     */
    void updateQualityReviewStatus(Long id, Integer status);

    /**
     * 获得质检审核流程
     *
     * @param id 编号
     * @return 质检审核流程
     */
    BpmQualityReviewDO getQualityReview(Long id);

    /**
     * 获得质检审核流程分页
     *
     * @param userId 用户编号
     * @param pageReqVO 分页查询
     * @return 质检审核流程分页
     */
    PageResult<BpmQualityReviewDO> getQualityReviewPage(Long userId, BpmQualityReviewPageReqVO pageReqVO);

}
