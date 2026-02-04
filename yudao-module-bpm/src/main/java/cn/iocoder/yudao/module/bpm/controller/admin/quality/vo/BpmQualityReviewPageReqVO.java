package cn.iocoder.yudao.module.bpm.controller.admin.quality.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 质检审核流程分页 Request VO")
@Data
public class BpmQualityReviewPageReqVO extends PageParam {

    @Schema(description = "任务 ID", example = "TASK-20260203-001")
    private String taskId;

    @Schema(description = "发起人用户名", example = "张三")
    private String initiatorUsername;

    @Schema(description = "状态", example = "1")
    private Integer status;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "创建时间")
    private LocalDateTime[] createTime;

}
