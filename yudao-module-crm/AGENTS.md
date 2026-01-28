# MODULE KNOWLEDGE BASE

**Type:** Business Module
**Domain:** CRM (Customer Relationship)

## OVERVIEW
Sales pipeline management. Tracks Leads (Clues), Customers, Opportunities, and Contracts.

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **Clue** | `CrmClueServiceImpl` | Sales leads/prospects. |
| **Customer** | `CrmCustomerServiceImpl` | Converted clients. |
| **Perm** | `CrmPermissionServiceImpl` | Data permissions (Owner/Team). |
| **Follow** | `CrmFollowUpRecordServiceImpl` | Call logs, meeting notes. |

## DEVELOPER GUIDE
### 1. Data Permissions
*   **Owner**: Each record has an `owner_user_id`.
*   **Pool**: Unassigned records go to the "High Seas" pool (`CrmCustomerPoolConfig`).

### 2. Business Status
*   **Config**: Statuses (e.g., "New", "Contacted", "Won") are configurable via `CrmBusinessStatusService`.

## CONVENTIONS
*   **Conversion**: Clue -> Customer + Opportunity.
