package cn.iocoder.yudao.module.bpm.dal.mysql.quality;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.bpm.controller.admin.quality.vo.BpmQualityReviewPageReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.quality.BpmQualityReviewDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 质检审核流程 Mapper
 */
@Mapper
public interface BpmQualityReviewMapper extends BaseMapperX<BpmQualityReviewDO> {

    default PageResult<BpmQualityReviewDO> selectPage(Long userId, BpmQualityReviewPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmQualityReviewDO>()
                .eqIfPresent(BpmQualityReviewDO::getUserId, userId)
                .eqIfPresent(BpmQualityReviewDO::getStatus, reqVO.getStatus())
                .likeIfPresent(BpmQualityReviewDO::getTaskId, reqVO.getTaskId())
                .likeIfPresent(BpmQualityReviewDO::getInitiatorUsername, reqVO.getInitiatorUsername())
                .betweenIfPresent(BpmQualityReviewDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmQualityReviewDO::getId));
    }

}
