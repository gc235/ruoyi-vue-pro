# MODULE KNOWLEDGE BASE

**Type:** Business Module
**Domain:** AI (LLM & GenAI)

## OVERVIEW
Integration with LLMs (ChatGPT, Tongyi, etc.) and Image Generation models.

## KEY COMPONENTS
| Component | Class | Description |
|-----------|-------|-------------|
| **Chat** | `AiChatConversationServiceImpl` | Manages chat sessions. |
| **Msg** | `AiChatMessageServiceImpl` | Stores chat history. |
| **Model** | `AiModelServiceImpl` | Configures API Keys/Endpoints. |
| **Image** | `AiImageServiceImpl` | Text-to-Image generation. |

## DEVELOPER GUIDE
### 1. Streaming Response
*   **Tech**: Uses Spring AI / SSE (Server-Sent Events).
*   **Flow**: `AiChatController` returns `Flux<String>` for real-time typing effect.

### 2. Model Adapter
*   **Pattern**: Strategy pattern to support OpenAI, Azure, Alibaba, etc.

## CONVENTIONS
*   **Spring AI**: Built on top of Spring AI framework.
