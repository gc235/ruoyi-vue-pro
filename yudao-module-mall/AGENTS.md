# MODULE KNOWLEDGE BASE

**Type:** Business Module
**Domain:** Mall (Product, Trade, Promotion)

## OVERVIEW
E-commerce engine. Features SPU/SKU management, Shopping Cart, Orders, and Marketing (Coupons/Seckill).

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **Product** | `ProductSpuServiceImpl` | SPU (Standard Product Unit) logic. |
| **SKU** | `ProductSkuServiceImpl` | SKU inventory & price management. |
| **Cart** | `TradeCartServiceImpl` | Shopping cart (Redis-backed). |
| **Order** | `TradeOrderServiceImpl` | Order lifecycle (Create -> Pay -> Ship). |
| **Price** | `TradePriceServiceImpl` | Price calculation engine (Discounts/Coupons). |

## DEVELOPER GUIDE
### 1. Price Calculation
*   **Flow**: `TradePriceService.calculatePrice` is called before order creation.
*   **Logic**: Iterates through `PriceCalculator` implementations (Member Level, Coupon, Activity).

### 2. Order State Machine
*   **States**: Unpaid -> Paid -> Delivered -> Completed (or Cancelled).
*   **Events**: Payment Success (Callback), Timeout Cancel (Job), Confirm Receipt (User).

## CONVENTIONS
*   **SKU vs SPU**: SPU = "iPhone 13", SKU = "iPhone 13 Red 128GB".
*   **Inventory**: Deducted on Order Creation (Lock) or Payment (Deduct). Configurable.
