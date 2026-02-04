package cn.iocoder.yudao.module.bpm.dal.dataobject.quality;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 质检审核流程业务 DO
 */
@TableName(value = "bpm_quality_review", autoResultMap = true)
@KeySequence("bpm_quality_review_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BpmQualityReviewDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 发起人用户编号
     */
    private Long userId;
    /**
     * 任务 ID（业务变量）
     */
    private String taskId;
    /**
     * 发起人用户名
     */
    private String initiatorUsername;
    /**
     * 部门负责人邮箱列表（JSON 数组）
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> initiatorDeptHeadEmails;
    /**
     * 部门负责人用户 ID 列表（JSON 数组，可选）
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Long> initiatorDeptHeadUserIds;
    /**
     * 部门负责人用户名列表（JSON 数组，可选）
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> initiatorDeptHeadUsernames;
    /**
     * 审批结果状态
     */
    private Integer status;
    /**
     * 流程实例编号
     */
    private String processInstanceId;

}
