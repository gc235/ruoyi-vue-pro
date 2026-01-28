-- ===========================================
-- BPM 模块数据库表结构 SQL 脚本
-- 生成自实体类: yudao-module-bpm/src/main/java/cn/iocoder/yudao/module/bpm/dal/dataobject
-- ===========================================

-- -------------------------------------------
-- 1. BPM 流程分类表
-- 对应实体: BpmCategoryDO
-- -------------------------------------------
DROP TABLE IF EXISTS `bpm_category`;
CREATE TABLE `bpm_category` (
    `id`            BIGINT          NOT NULL AUTO_INCREMENT COMMENT '分类编号',
    `name`          VARCHAR(64)     NOT NULL DEFAULT '' COMMENT '分类名',
    `code`          VARCHAR(64)     NOT NULL DEFAULT '' COMMENT '分类标志',
    `description`   VARCHAR(255)    DEFAULT '' COMMENT '分类描述',
    `status`        TINYINT         NOT NULL DEFAULT 0 COMMENT '分类状态（0-开启，1-关闭）',
    `sort`          INT             NOT NULL DEFAULT 0 COMMENT '分类排序',
    `creator`       VARCHAR(64)     DEFAULT '' COMMENT '创建者',
    `create_time`   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`       VARCHAR(64)     DEFAULT '' COMMENT '更新者',
    `update_time`   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`       BIT(1)          NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='BPM 流程分类表';

-- -------------------------------------------
-- 2. BPM 表单定义表
-- 对应实体: BpmFormDO
-- -------------------------------------------
DROP TABLE IF EXISTS `bpm_form`;
CREATE TABLE `bpm_form` (
    `id`            BIGINT          NOT NULL AUTO_INCREMENT COMMENT '表单编号',
    `name`          VARCHAR(64)     NOT NULL DEFAULT '' COMMENT '表单名',
    `status`        TINYINT         NOT NULL DEFAULT 0 COMMENT '表单状态（0-开启，1-关闭）',
    `conf`          TEXT            COMMENT '表单的配置',
    `fields`        TEXT            COMMENT '表单项的数组（JSON 格式）',
    `remark`        VARCHAR(255)    DEFAULT '' COMMENT '备注',
    `creator`       VARCHAR(64)     DEFAULT '' COMMENT '创建者',
    `create_time`   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`       VARCHAR(64)     DEFAULT '' COMMENT '更新者',
    `update_time`   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`       BIT(1)          NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='BPM 工作流表单定义表';

-- -------------------------------------------
-- 3. BPM 流程定义扩展信息表
-- 对应实体: BpmProcessDefinitionInfoDO
-- -------------------------------------------
DROP TABLE IF EXISTS `bpm_process_definition_info`;
CREATE TABLE `bpm_process_definition_info` (
    `id`                            BIGINT          NOT NULL AUTO_INCREMENT COMMENT '编号',
    `process_definition_id`         VARCHAR(64)     NOT NULL DEFAULT '' COMMENT '流程定义的编号',
    `model_id`                      VARCHAR(64)     NOT NULL DEFAULT '' COMMENT '流程模型的编号',
    `model_type`                    TINYINT         DEFAULT 10 COMMENT '流程模型的类型（10-BPMN, 20-SIMPLE）',
    `category`                      VARCHAR(64)     DEFAULT '' COMMENT '流程分类的编码',
    `icon`                          VARCHAR(512)    DEFAULT '' COMMENT '图标',
    `description`                   VARCHAR(512)    DEFAULT '' COMMENT '描述',
    `form_type`                     TINYINT         DEFAULT 10 COMMENT '表单类型（10-流程表单, 20-业务表单, 30-自定义表单）',
    `form_id`                       BIGINT          DEFAULT NULL COMMENT '动态表单编号',
    `form_conf`                     TEXT            COMMENT '表单的配置',
    `form_fields`                   TEXT            COMMENT '表单项的数组（JSON 格式）',
    `form_custom_create_path`       VARCHAR(255)    DEFAULT '' COMMENT '自定义表单的提交路径',
    `form_custom_view_path`         VARCHAR(255)    DEFAULT '' COMMENT '自定义表单的查看路径',
    `simple_model`                  TEXT            COMMENT 'SIMPLE 设计器模型数据（JSON 格式）',
    `visible`                       BIT(1)          DEFAULT b'1' COMMENT '是否可见',
    `sort`                          BIGINT          DEFAULT 0 COMMENT '排序值',
    `start_user_ids`                TEXT            COMMENT '可发起用户编号数组（逗号分隔）',
    `start_dept_ids`                TEXT            COMMENT '可发起部门编号数组（逗号分隔）',
    `manager_user_ids`              TEXT            COMMENT '可管理用户编号数组（逗号分隔）',
    `allow_cancel_running_process`  BIT(1)          DEFAULT b'1' COMMENT '是否允许撤销审批中的申请',
    `allow_withdraw_task`           BIT(1)          DEFAULT b'0' COMMENT '是否允许审批人撤回任务',
    `process_id_rule`               VARCHAR(512)    DEFAULT NULL COMMENT '流程 ID 规则（JSON 格式）',
    `auto_approval_type`            TINYINT         DEFAULT NULL COMMENT '自动去重类型',
    `title_setting`                 VARCHAR(512)    DEFAULT NULL COMMENT '标题设置（JSON 格式）',
    `summary_setting`               VARCHAR(512)    DEFAULT NULL COMMENT '摘要设置（JSON 格式）',
    `process_before_trigger_setting` TEXT           DEFAULT NULL COMMENT '流程前置通知设置（JSON 格式）',
    `process_after_trigger_setting` TEXT            DEFAULT NULL COMMENT '流程后置通知设置（JSON 格式）',
    `task_before_trigger_setting`   TEXT            DEFAULT NULL COMMENT '任务前置通知设置（JSON 格式）',
    `task_after_trigger_setting`    TEXT            DEFAULT NULL COMMENT '任务后置通知设置（JSON 格式）',
    `print_template_setting`        TEXT            DEFAULT NULL COMMENT '自定义打印模板设置（JSON 格式）',
    `creator`                       VARCHAR(64)     DEFAULT '' COMMENT '创建者',
    `create_time`                   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`                       VARCHAR(64)     DEFAULT '' COMMENT '更新者',
    `update_time`                   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`                       BIT(1)          NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    INDEX `idx_process_definition_id` (`process_definition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='BPM 流程定义扩展信息表';

-- -------------------------------------------
-- 4. BPM 流程表达式表
-- 对应实体: BpmProcessExpressionDO
-- -------------------------------------------
DROP TABLE IF EXISTS `bpm_process_expression`;
CREATE TABLE `bpm_process_expression` (
    `id`            BIGINT          NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name`          VARCHAR(64)     NOT NULL DEFAULT '' COMMENT '表达式名字',
    `status`        TINYINT         NOT NULL DEFAULT 0 COMMENT '表达式状态（0-开启，1-关闭）',
    `expression`    TEXT            NOT NULL COMMENT '表达式',
    `creator`       VARCHAR(64)     DEFAULT '' COMMENT '创建者',
    `create_time`   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`       VARCHAR(64)     DEFAULT '' COMMENT '更新者',
    `update_time`   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`       BIT(1)          NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='BPM 流程表达式表';

-- -------------------------------------------
-- 5. BPM 流程监听器表
-- 对应实体: BpmProcessListenerDO
-- -------------------------------------------
DROP TABLE IF EXISTS `bpm_process_listener`;
CREATE TABLE `bpm_process_listener` (
    `id`            BIGINT          NOT NULL AUTO_INCREMENT COMMENT '主键 ID',
    `name`          VARCHAR(64)     NOT NULL DEFAULT '' COMMENT '监听器名字',
    `status`        TINYINT         NOT NULL DEFAULT 0 COMMENT '状态（0-开启，1-关闭）',
    `type`          VARCHAR(32)     NOT NULL DEFAULT '' COMMENT '监听类型（execution-执行监听器，task-任务监听器）',
    `event`         VARCHAR(32)     NOT NULL DEFAULT '' COMMENT '监听事件（start/end/create/assignment/complete/delete/update/timeout）',
    `value_type`    VARCHAR(32)     NOT NULL DEFAULT '' COMMENT '值类型（class/delegateExpression/expression）',
    `value`         VARCHAR(1024)   NOT NULL DEFAULT '' COMMENT '值',
    `creator`       VARCHAR(64)     DEFAULT '' COMMENT '创建者',
    `create_time`   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`       VARCHAR(64)     DEFAULT '' COMMENT '更新者',
    `update_time`   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`       BIT(1)          NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='BPM 流程监听器表';

-- -------------------------------------------
-- 6. BPM 用户组表
-- 对应实体: BpmUserGroupDO
-- -------------------------------------------
DROP TABLE IF EXISTS `bpm_user_group`;
CREATE TABLE `bpm_user_group` (
    `id`            BIGINT          NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name`          VARCHAR(64)     NOT NULL DEFAULT '' COMMENT '组名',
    `description`   VARCHAR(255)    DEFAULT '' COMMENT '描述',
    `status`        TINYINT         NOT NULL DEFAULT 0 COMMENT '状态（0-开启，1-关闭）',
    `user_ids`      TEXT            COMMENT '成员用户编号数组（JSON 格式）',
    `creator`       VARCHAR(64)     DEFAULT '' COMMENT '创建者',
    `create_time`   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`       VARCHAR(64)     DEFAULT '' COMMENT '更新者',
    `update_time`   DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`       BIT(1)          NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='BPM 用户组表';

-- -------------------------------------------
-- 7. OA 请假申请表
-- 对应实体: BpmOALeaveDO
-- -------------------------------------------
DROP TABLE IF EXISTS `bpm_oa_leave`;
CREATE TABLE `bpm_oa_leave` (
    `id`                    BIGINT          NOT NULL AUTO_INCREMENT COMMENT '请假表单主键',
    `user_id`               BIGINT          NOT NULL COMMENT '申请人的用户编号',
    `type`                  VARCHAR(32)     NOT NULL DEFAULT '' COMMENT '请假类型',
    `reason`                VARCHAR(512)    DEFAULT '' COMMENT '原因',
    `start_time`            DATETIME        NOT NULL COMMENT '开始时间',
    `end_time`              DATETIME        NOT NULL COMMENT '结束时间',
    `day`                   BIGINT          DEFAULT 0 COMMENT '请假天数',
    `status`                TINYINT         NOT NULL DEFAULT 0 COMMENT '审批结果（1-处理中，2-审批通过，3-审批不通过，4-已取消）',
    `process_instance_id`   VARCHAR(64)     DEFAULT '' COMMENT '对应的流程编号',
    `creator`               VARCHAR(64)     DEFAULT '' COMMENT '创建者',
    `create_time`           DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`               VARCHAR(64)     DEFAULT '' COMMENT '更新者',
    `update_time`           DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`               BIT(1)          NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id` (`user_id`),
    INDEX `idx_process_instance_id` (`process_instance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='OA 请假申请表';

-- -------------------------------------------
-- 8. BPM 流程抄送表
-- 对应实体: BpmProcessInstanceCopyDO
-- -------------------------------------------
DROP TABLE IF EXISTS `bpm_process_instance_copy`;
CREATE TABLE `bpm_process_instance_copy` (
    `id`                        BIGINT          NOT NULL AUTO_INCREMENT COMMENT '编号',
    `start_user_id`             BIGINT          DEFAULT NULL COMMENT '发起人 ID',
    `process_instance_name`     VARCHAR(128)    DEFAULT '' COMMENT '流程名',
    `process_instance_id`       VARCHAR(64)     NOT NULL DEFAULT '' COMMENT '流程实例的编号',
    `process_definition_id`     VARCHAR(64)     DEFAULT '' COMMENT '流程实例的流程定义编号',
    `category`                  VARCHAR(64)     DEFAULT '' COMMENT '流程分类',
    `activity_id`               VARCHAR(64)     DEFAULT '' COMMENT '流程活动的编号',
    `activity_name`             VARCHAR(128)    DEFAULT '' COMMENT '流程活动的名字',
    `task_id`                   VARCHAR(64)     DEFAULT '' COMMENT '任务 ID',
    `user_id`                   BIGINT          NOT NULL COMMENT '用户编号（被抄送的用户编号）',
    `reason`                    VARCHAR(512)    DEFAULT '' COMMENT '抄送意见',
    `creator`                   VARCHAR(64)     DEFAULT '' COMMENT '创建者',
    `create_time`               DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`                   VARCHAR(64)     DEFAULT '' COMMENT '更新者',
    `update_time`               DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`                   BIT(1)          NOT NULL DEFAULT b'0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    INDEX `idx_user_id` (`user_id`),
    INDEX `idx_process_instance_id` (`process_instance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='BPM 流程抄送表';
