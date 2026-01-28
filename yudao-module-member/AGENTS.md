# MODULE KNOWLEDGE BASE

**Type:** Business Module
**Domain:** Member (C-End User)

## OVERVIEW
Customer (C-End) management. Handles Registration, Login, Levels, and Tags. Distinct from System Users (Admins).

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **Auth** | `MemberAuthServiceImpl` | Mobile/Password Login, Token mgmt. |
| **User** | `MemberUserServiceImpl` | Profile, Avatar, Nickname. |
| **Level** | `MemberLevelServiceImpl` | VIP Levels (Points/Exp based). |
| **Tag** | `MemberTagServiceImpl` | User segmentation tags. |

## DEVELOPER GUIDE
### 1. Authentication
*   **Separation**: Uses `mobile` as primary key. Distinct token store from Admin.
*   **Token**: Stored in Redis. Validated via `TokenAuthenticationFilter`.

### 2. Member Levels
*   **Upgrade**: Triggered by events (Login, Pay, etc.).
*   **Config**: Rules defined in `member_level` table.

## CONVENTIONS
*   **Isolation**: Member data is logically separated from Admin data.
*   **Mobile First**: Phone number is the primary identity.
