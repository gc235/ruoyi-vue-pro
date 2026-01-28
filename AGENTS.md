# AGENTS.md (ruoyi-vue-pro)

## OVERVIEW
- Reason: distinct Java/Maven domain; high complexity; isolate backend guidance.
- Context: Spring Boot “Modular Monolith” (Yudao / RuoYi-Vue-Pro).
- Shape: Maven multi-module; module boundaries by domain; shared infra via framework.

## STRUCTURE
- `yudao-server/`: application entry; Spring Boot bootstrap; aggregates modules.
- `yudao-framework/`: infra foundation (web, security, mybatis, redis, common config).
- `yudao-module-*/`: business domains (e.g., system/infra/member); each owns:
  - `controller/` REST APIs
  - `service/` domain logic
  - `dal/` persistence (DO/Mapper)
  - `convert/` MapStruct mappers
  - `enums/`, `api/`, `mq/` as needed

## MODULES
- `yudao-module-system`: Core RBAC, Users, Depts, Dicts, OAuth2.
- `yudao-module-infra`: Infrastructure (File, Config, Job, API Log, DB Doc).
- `yudao-module-member`: User-facing member system (for mobile/mall).
- `yudao-module-pay`: Payment gateway integration (Alipay, WeChat Pay).
- `yudao-module-mall`: E-commerce features (Product, Order, Promotion).
- `yudao-module-bpm`: Business Process Management (Flowable).
- `yudao-module-report`: Reporting and Data Visualization.
- `yudao-module-mp`: WeChat Official Account management.
- `yudao-module-ai`: AI-related features (LLM integration).

## PATTERNS
- Data flow (request): VO -> Controller -> Service -> (DO) -> Mapper -> DB.
- Data flow (response): DO/BO -> Convert(MapStruct) -> VO.
- Naming: `*ReqVO` / `*RespVO` / `*PageReqVO`; `*DO`; `*Mapper`; `*Service`.
- MapStruct:
  - Prefer `@Mapper(componentModel = "spring")` converters in `convert/`.
  - Keep mapping logic declarative; custom mapping via `@Mapping` / helper methods.
- Controllers: thin; validate + auth + delegate; no business branching.
- Services: transactional unit; orchestrate mappers; enforce invariants.
- **Cross-Module Calls**: Use `*Api` interfaces located in the `api` package of the target module. Do not depend on the `biz` implementation of another module.

## TESTING
- Base classes: `BaseDbUnitTest` (DB), `BaseRedisUnitTest` (Redis).
- Data builders: Podam for random fixtures; override for edge cases.
- Focus: service-layer tests; mapper tests only for complex SQL; controller tests sparingly.

## COMMON TASKS
### 1. Adding a new REST API
1. Define `VO` in `controller/vo`.
2. Add method to `Controller`.
3. Implement logic in `Service`.
4. Add `Mapper` method if needed.
5. Add `Convert` mapping.

### 2. Adding a new Module
1. Create `yudao-module-xxx` directory.
2. Add `pom.xml` (copy from existing module).
3. Register in `yudao-server/pom.xml`.
4. Create base package `cn.iocoder.yudao.module.xxx`.

## ANTI-PATTERNS
- No direct SQL building/execution in controllers.
- No business logic in VOs (VOs are transport-only; no persistence annotations).
- No cross-module “reach-in” to mappers/DOs; go via service/API contracts.
- Avoid mixing infra concerns into biz modules; push common to `yudao-framework/`.
