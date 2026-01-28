# MODULE KNOWLEDGE BASE

**Type:** Application Entry Point
**Role:** Bootstrapper & Config Central

## OVERVIEW
The Spring Boot Main Application. Aggregates all modules and centralizes configuration.

## KEY FILES
| File | Description |
|------|-------------|
| `YudaoServerApplication.java` | Main class. `@SpringBootApplication`. |
| `application.yaml` | Global config (Redis, MQ, Server Port). |
| `application-local.yaml` | Local dev config (DB URL, Passwords). |
| `pom.xml` | Module aggregator. Enable/Disable modules here. |

## DEVELOPER GUIDE
### 1. Enabling/Disabling Modules
*   **Action**: Comment/Uncomment dependencies in `pom.xml`.
*   **Effect**: Spring Boot Auto-Configuration will skip missing modules.

### 2. Profile Management
*   **Active Profile**: Set in `application.yaml` -> `spring.profiles.active`.
*   **Files**: `application-{profile}.yaml` overrides default settings.

## CONVENTIONS
*   **No Logic**: This module should remain empty of business logic.
*   **Integration Tests**: Place system-wide integration tests here.
