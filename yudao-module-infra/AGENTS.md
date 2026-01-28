# MODULE KNOWLEDGE BASE

**Type:** Business Module
**Domain:** Infrastructure (File, Job, Config, Log)

## OVERVIEW
Manages technical infrastructure resources. Implements Strategy Pattern for file storage and Quartz for scheduling.

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **File** | `FileServiceImpl` | Upload/Download logic. Uses `FileClient`. |
| **Storage** | `FileClientFactory` | Creates S3/FTP/Local clients based on config. |
| **Job** | `JobServiceImpl` | Wraps Quartz Scheduler. Handles cron tasks. |
| **API Log** | `ApiAccessLogServiceImpl` | Async logging of all API requests. |
| **Config** | `ConfigServiceImpl` | Dynamic system config (stored in DB). |

## DEVELOPER GUIDE

### 1. File Storage
*   **Upload**: `FileController` -> `FileService.createFile` -> `FileClient.upload`.
*   **Add Provider**: Implement `FileClient` interface, register in `FileClientConfig`.

### 2. Scheduled Jobs
*   **Create**: Define Bean with `@Component`.
*   **Register**: Add record in `infra_job` table (Handler Name = Bean Name).
*   **Logic**:
    ```java
    @Component("myJob")
    public class MyJob implements JobHandler {
        @Override
        public String execute(String param) { ... }
    }
    ```

## CONVENTIONS
*   **Async Logging**: Access/Error logs are written asynchronously to avoid blocking main thread.
*   **Config Refresh**: DB Config changes publish a Redis Message to refresh local cache on all nodes.
