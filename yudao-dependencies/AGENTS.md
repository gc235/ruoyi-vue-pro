# MODULE KNOWLEDGE BASE (Dependencies)

**Type:** Maven Dependency Management
**Role:** Version Control & BOM

## OVERVIEW
Centralizes all library versions used across the project. This ensures consistency and simplifies upgrades.

## KEY FILES
- `pom.xml`: The only file in this module. Contains `<dependencyManagement>`.

## DEVELOPER GUIDE
### 1. Adding a new Library
*   **Action**: Add the dependency with its version to `yudao-dependencies/pom.xml`.
*   **Usage**: In other modules, add the dependency WITHOUT the version.

### 2. Upgrading Versions
*   **Action**: Update the property or version string in `yudao-dependencies/pom.xml`.
*   **Verification**: Run a full build to ensure no breaking changes.

## CONVENTIONS
- Use properties for version numbers at the top of the `pom.xml`.
- Group dependencies logically (e.g., Spring Boot, MyBatis, Hutool).
- Avoid adding dependencies directly to business modules with hardcoded versions.
