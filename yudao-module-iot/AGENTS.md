# MODULE KNOWLEDGE BASE

**Type:** Business Module
**Domain:** IoT (Internet of Things)

## OVERVIEW
Device management platform. Handles Device Registry, Data Collection, and Rule Engine.

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **Device** | `IotDeviceServiceImpl` | Device lifecycle & auth. |
| **Product** | `IotProductServiceImpl` | Device definitions (Thing Model). |
| **Rule** | `IotSceneRuleServiceImpl` | Event-Condition-Action engine. |
| **MQTT** | `IotMqttServer` | Internal MQTT Broker (or bridge). |

## DEVELOPER GUIDE
### 1. Thing Model (TSL)
*   **Def**: Properties, Functions, Events defined in JSON.
*   **Validation**: `IotThingModelService` validates incoming data against TSL.

### 2. Rule Engine
*   **Trigger**: Device Report / Timer / API.
*   **Action**: Alarm / Control Device / Send Message.

## CONVENTIONS
*   **Protocol**: Primary support for MQTT.
