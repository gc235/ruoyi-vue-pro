# MODULE KNOWLEDGE BASE

**Type:** Business Module
**Domain:** MP (WeChat Public Account)

## OVERVIEW
WeChat ecosystem integration. Handles Public Accounts (Subscription/Service) and Mini Programs.

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **Msg** | `MpMessageServiceImpl` | Handles incoming WeChat messages. |
| **Reply** | `MpAutoReplyServiceImpl` | Keyword/Default auto-replies. |
| **Menu** | `MpMenuServiceImpl` | Custom menu management. |
| **User** | `MpUserServiceImpl` | Syncs WeChat fans/followers. |

## DEVELOPER GUIDE
### 1. Message Handling
*   **Entry**: `MpMessageController.handle` receives XML from WeChat.
*   **Dispatch**: Uses `WxJava`'s `WxMpMessageRouter` to route by MsgType (Text, Event, etc.).

### 2. Account Config
*   **Multi-Account**: Supports multiple AppIDs via `MpAccountService`.

## CONVENTIONS
*   **Library**: Heavily relies on `binarywang/WxJava` SDK.
