package cn.iocoder.yudao.module.bpm.controller.admin.quality.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "管理后台 - 质检审核流程创建 Request VO")
@Data
public class BpmQualityReviewCreateReqVO {

    @Schema(description = "任务 ID（业务变量）", requiredMode = Schema.RequiredMode.REQUIRED, example = "TASK-20260203-001")
    @NotBlank(message = "任务 ID 不能为空")
    private String taskId;

    @Schema(description = "发起人用户 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "发起人用户 ID 不能为空")
    private Long initiatorUserId;

    @Schema(description = "发起人用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotBlank(message = "发起人用户名不能为空")
    private String initiatorUsername;

    @Schema(description = "部门负责人邮箱列表", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "部门负责人邮箱不能为空")
    private List<String> initiatorDeptHeadEmails;

    @Schema(description = "部门负责人用户 ID 列表（可选）")
    private List<Long> initiatorDeptHeadUserIds;

    @Schema(description = "部门负责人用户名列表（可选）")
    private List<String> initiatorDeptHeadUsernames;

    @Schema(description = "发起人自选审批人 Map", example = "{taskKey1: [1, 2]}")
    private Map<String, List<Long>> startUserSelectAssignees;

}
