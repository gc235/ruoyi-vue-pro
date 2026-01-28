# MODULE KNOWLEDGE BASE (SQL)

**Type:** Database Scripts
**Domain:** Persistence Schema & Initial Data

## OVERVIEW
Contains SQL scripts for various database types (MySQL, PostgreSQL, Oracle, etc.). The primary development database is **MySQL**.

## STRUCTURE
- `mysql/`: Main SQL scripts.
  - `ruoyi-vue-pro.sql`: Full schema and initial data.
  - `quartz.sql`: Quartz scheduler tables.
- `other-db-types/`: Scripts for DM, Kingbase, Oracle, etc.
- `tools/`: Python/Shell scripts for SQL conversion or database setup.

## DEVELOPER GUIDE
### 1. Schema Changes
*   **Action**: When adding a new table or column, update `mysql/ruoyi-vue-pro.sql`.
*   **Naming**: Use `snake_case` for tables and columns.
*   **Common Columns**: Every business table should have:
    ```sql
    `creator` varchar(64) DEFAULT '',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updater` varchar(64) DEFAULT '',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted` bit(1) NOT NULL DEFAULT b'0',
    `tenant_id` bigint NOT NULL DEFAULT '0',
    ```

### 2. Initial Data
*   **Menus**: Insert into `system_menu`.
*   **Dicts**: Insert into `system_dict_type` and `system_dict_data`.
*   **Config**: Insert into `system_config`.

## ANTI-PATTERNS
- Do not use database-specific features (like stored procedures) unless absolutely necessary.
- Avoid hardcoding IDs in scripts if they might conflict with existing data.
- Ensure `tenant_id` is present if the table supports multi-tenancy.
