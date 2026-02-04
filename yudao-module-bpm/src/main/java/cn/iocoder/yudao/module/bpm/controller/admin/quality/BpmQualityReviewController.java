package cn.iocoder.yudao.module.bpm.controller.admin.quality;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.bpm.controller.admin.quality.vo.BpmQualityReviewCreateReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.quality.vo.BpmQualityReviewPageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.quality.vo.BpmQualityReviewRespVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.quality.BpmQualityReviewDO;
import cn.iocoder.yudao.module.bpm.service.quality.BpmQualityReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "管理后台 - 质检审核流程")
@RestController
@RequestMapping("/bpm/quality-review")
@Validated
public class BpmQualityReviewController {

    @Resource
    private BpmQualityReviewService qualityReviewService;

    @PostMapping("/create")
    @PreAuthorize("@ss.hasPermission('bpm:quality-review:create')")
    @Operation(summary = "创建质检审核流程")
    public CommonResult<Long> createQualityReview(@Valid @RequestBody BpmQualityReviewCreateReqVO createReqVO) {
        return success(qualityReviewService.createQualityReview(getLoginUserId(), createReqVO));
    }

    @GetMapping("/get")
    @PreAuthorize("@ss.hasPermission('bpm:quality-review:query')")
    @Operation(summary = "获得质检审核流程")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<BpmQualityReviewRespVO> getQualityReview(@RequestParam("id") Long id) {
        BpmQualityReviewDO review = qualityReviewService.getQualityReview(id);
        BpmQualityReviewRespVO respVO = BeanUtils.toBean(review, BpmQualityReviewRespVO.class);
        if (respVO != null) {
            respVO.setInitiatorUserId(review.getUserId());
        }
        return success(respVO);
    }

    @GetMapping("/page")
    @PreAuthorize("@ss.hasPermission('bpm:quality-review:query')")
    @Operation(summary = "获得质检审核流程分页")
    public CommonResult<PageResult<BpmQualityReviewRespVO>> getQualityReviewPage(@Valid BpmQualityReviewPageReqVO pageVO) {
        PageResult<BpmQualityReviewDO> pageResult = qualityReviewService.getQualityReviewPage(getLoginUserId(), pageVO);
        PageResult<BpmQualityReviewRespVO> respVO = BeanUtils.toBean(pageResult, BpmQualityReviewRespVO.class);
        if (respVO != null && respVO.getList() != null) {
            for (int i = 0; i < respVO.getList().size(); i++) {
                BpmQualityReviewRespVO item = respVO.getList().get(i);
                BpmQualityReviewDO source = pageResult.getList().get(i);
                item.setInitiatorUserId(source.getUserId());
            }
        }
        return success(respVO);
    }

}
