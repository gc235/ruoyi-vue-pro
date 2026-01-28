# MODULE KNOWLEDGE BASE

**Type:** Business Module (Reference Implementation)
**Domain:** System (Auth, RBAC, Dept, Dict)

## OVERVIEW
The kernel of the platform. Implements RBAC (Role-Based Access Control), Authentication (OAuth2), and Data Permissions.

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **Login** | `AdminAuthServiceImpl` | Handles login (Pwd/SMS/Social) & Captcha. |
| **Token** | `OAuth2TokenServiceImpl` | Manages Access/Refresh tokens (DB-backed). |
| **RBAC** | `PermissionServiceImpl` | Maps Users ↔ Roles ↔ Menus. |
| **Security** | `SecurityFrameworkServiceImpl` | Bean `@ss`. Checks permissions via `@PreAuthorize`. |
| **Data Perm** | `DeptDataPermissionRule` | JSQLParser hook for `dept_id` filtering. |

## DEVELOPER GUIDE

### 1. Authentication Flow
*   **Login**: `AuthController` -> `AdminAuthService.login` -> `OAuth2TokenService.createAccessToken`.
*   **Check**: `TokenAuthenticationFilter` (Framework) parses token -> `SecurityContextHolder`.

### 2. Adding Permissions
1.  **DB**: Insert record into `system_menu` (Type: Button/Menu).
2.  **Code**: Add annotation to Controller:
    ```java
    @PreAuthorize("@ss.hasPermission('system:user:create')")
    public CommonResult<Long> createUser(...) { ... }
    ```

### 3. Data Permissions
*   **Mechanism**: Auto-injects `WHERE dept_id = ?` based on User's Role Data Scope.
*   **Enable**: Ensure table has `dept_id`. Register via `DeptDataPermissionRuleCustomizer`.
*   **Disable**: Use `@DataPermission(enable = false)` on Service method.

## CONVENTIONS
*   **VO/DTO/DO**: Strict separation. `Convert` interface (MapStruct) is mandatory.
*   **Controller**: Returns `CommonResult<T>`. Never return raw objects.
*   **Service**: Interface + Impl. Transactional logic here.
