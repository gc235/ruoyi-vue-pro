# MODULE KNOWLEDGE BASE

**Type:** Business Module
**Domain:** Payment (Channel, Order, Refund)

## OVERVIEW
Unified Payment Gateway. Abstracts Alipay, WeChat Pay, and Wallet into a unified API.

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **Client** | `PayClientFactory` | Creates `PayClient` (Alipay/WxPay) by config. |
| **Order** | `PayOrderServiceImpl` | Manages payment orders (internal). |
| **Notify** | `PayNotifyServiceImpl` | Handles callbacks from Payment Gateways. |
| **Wallet** | `PayWalletServiceImpl` | User balance (recharge/consume). |

## DEVELOPER GUIDE
### 1. Payment Flow
1.  **Submit**: App calls `PayOrderService.submitOrder` -> Returns Pay URL/Params.
2.  **User Pays**: User completes payment on Alipay/WeChat.
3.  **Callback**: Gateway calls `PayNotifyController` -> `PayNotifyService`.
4.  **Success**: `PayNotifyService` updates Order Status -> Notifies Business Module.

### 2. Adding a Channel
*   **Impl**: Extend `AbstractPayClient`. Implement `unifiedOrder`, `refund`, etc.
*   **Register**: Add Enum `PayChannelEnum`. Update `PayClientFactory`.

## CONVENTIONS
*   **Idempotency**: Critical in `PayNotifyService`. Handle duplicate callbacks gracefully.
*   **No Floating Point**: Use `Integer` (cents) for all monetary values.
