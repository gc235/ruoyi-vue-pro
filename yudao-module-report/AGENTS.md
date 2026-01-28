# MODULE KNOWLEDGE BASE

**Type:** Business Module
**Domain:** Report (GoView, Jimu)

## OVERVIEW
Low-code reporting integration. Supports GoView (Large Screen) and JimuReport (Dashboard).

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **GoView** | `GoViewProjectServiceImpl` | Manages large screen projects. |
| **Data** | `GoViewDataServiceImpl` | SQL/HTTP data source execution. |
| **Jimu** | `JimuReportTokenServiceImpl` | Auth integration for JimuReport. |

## DEVELOPER GUIDE
### 1. GoView Integration
*   **Storage**: Projects stored in `report_goview_project`.
*   **Data**: Supports SQL (Dynamic) and HTTP (API) data sources.

### 2. Security
*   **Token**: JimuReport uses a separate token mechanism, bridged via `JimuReportTokenService`.

## CONVENTIONS
*   **Third-Party**: This module is primarily an adapter for external tools.
