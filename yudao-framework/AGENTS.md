# MODULE KNOWLEDGE BASE

**Type:** Core Infrastructure
**Pattern:** Spring Boot Starters

## OVERVIEW
Provides cross-cutting concerns (Security, Web, DB) via modular Starters. Business modules depend on these, not vice-versa.

## KEY STARTERS
### 1. Security (`yudao-spring-boot-starter-security`)
*   **Filter**: `TokenAuthenticationFilter` (Parses Header `Authorization: Bearer ...`).
*   **Config**: `YudaoWebSecurityConfigurerAdapter` (Stateless, CSRF disabled).
*   **Context**: `SecurityFrameworkUtils.getLoginUser()` to get current user.

### 2. Web (`yudao-spring-boot-starter-web`)
*   **Exception**: `GlobalExceptionHandler` catches ALL exceptions -> `CommonResult`.
*   **Swagger**: Auto-configured via `YudaoSwaggerAutoConfiguration`.
*   **Jackson**: Standardized JSON serialization (Long -> String for JS precision).

### 3. MyBatis (`yudao-spring-boot-starter-mybatis`)
*   **Audit**: `DefaultDBFieldHandler` auto-fills `createTime`, `updater`, etc.
*   **Data Perm**: `DataPermissionInterceptor` modifies SQL for row-level security.
*   **ORM**: MyBatis Plus integration.

## CONFIGURATION
*   **Location**: `yudao-framework/**/config/*AutoConfiguration.java`.
*   **Overrides**: Set properties in `yudao-server/src/main/resources/application.yaml`.
    ```yaml
    yudao:
      swagger:
        enable: true
      security:
        permit-all-urls: # Whitelist URLs
          - /admin-api/system/auth/login
    ```

## NOTES
*   **Do Not Modify**: Avoid changing framework code directly. Use `Customizer` beans or Properties.
