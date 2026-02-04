package cn.iocoder.yudao.module.bpm.controller.admin.quality.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 质检审核流程 Response VO")
@Data
public class BpmQualityReviewRespVO {

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "任务 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "TASK-20260203-001")
    private String taskId;

    @Schema(description = "发起人用户 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long initiatorUserId;

    @Schema(description = "发起人用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    private String initiatorUsername;

    @Schema(description = "部门负责人邮箱列表")
    private List<String> initiatorDeptHeadEmails;

    @Schema(description = "部门负责人用户 ID 列表")
    private List<Long> initiatorDeptHeadUserIds;

    @Schema(description = "部门负责人用户名列表")
    private List<String> initiatorDeptHeadUsernames;

    @Schema(description = "流程编号")
    private String processInstanceId;

    @Schema(description = "审批结果", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
