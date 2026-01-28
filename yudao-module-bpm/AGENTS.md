# MODULE KNOWLEDGE BASE

**Type:** Business Module
**Domain:** BPM (Workflow)

## OVERVIEW
Workflow engine based on Flowable. Manages Process Definitions, Instances, and User Tasks.

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **Def** | `BpmProcessDefinitionServiceImpl` | Deploys BPMN XML models. |
| **Instance** | `BpmProcessInstanceServiceImpl` | Starts/Cancels process instances. |
| **Task** | `BpmTaskServiceImpl` | Approve/Reject/Transfer user tasks. |
| **Group** | `BpmUserGroupServiceImpl` | Custom user groups for assignment. |

## DEVELOPER GUIDE
### 1. Process Deployment
*   **Modeler**: Use the frontend BPMN designer.
*   **Deploy**: Saves XML -> Calls Flowable `RepositoryService.deploy`.

### 2. Task Listener
*   **Hook**: Implement `BpmTaskEventListener`.
*   **Events**: Task Created, Assigned, Completed. Use for business logic triggers.

## CONVENTIONS
*   **Flowable**: Wraps native Flowable APIs. Avoid direct DB access to Flowable tables (`ACT_*`).
*   **Business Key**: Links BPM Instance to Business Entity (e.g., Leave Request ID).
