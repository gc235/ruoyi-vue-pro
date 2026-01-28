# MODULE KNOWLEDGE BASE

**Type:** Business Module
**Domain:** ERP (Enterprise Resource Planning)

## OVERVIEW
Inventory and Finance management. Purchase, Sales, Stock, and Finance.

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **Product** | `ErpProductServiceImpl` | ERP-specific product info. |
| **Stock** | `ErpStockServiceImpl` | Real-time inventory tracking. |
| **Purchase** | `ErpPurchaseOrderServiceImpl` | Procurement orders. |
| **Sale** | `ErpSaleOrderServiceImpl` | Sales orders. |
| **Finance** | `ErpAccountServiceImpl` | Cash flow & bank accounts. |

## DEVELOPER GUIDE
### 1. Inventory Logic
*   **In/Out**: All stock movements are recorded in `erp_stock_record`.
*   **Check**: `ErpStockService.countStock` calculates current quantity.

### 2. Workflow
*   **Purchase**: Order -> In-Stock -> Payment.
*   **Sale**: Order -> Out-Stock -> Receipt.

## CONVENTIONS
*   **Precision**: Monetary values in `BigDecimal` (unlike Pay module's Integer).
