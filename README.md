# Strategy pattern — PC peripheral profiles (Java)

Interchangeable algorithms: **how a set of peripherals (mouse, keyboard, headset) is configured** — Gaming, Office, Power saver (+ Streaming added later).

## Structure

| Pattern role | Class |
|---|---|
| Strategy interface | `strategy/ProfileStrategy` — `name()`, `apply(DeviceRegistry)` |
| Concrete strategies | `GamingProfile`, `OfficeProfile`, `PowerSaverProfile` (+ `StreamingProfile` in `Main`) |
| Context | `PeripheryContext` — holds a `ProfileStrategy`, `setProfile(...)` switches it at runtime, `activateProfile()` delegates |
| Client | `Main` — builds the setup, picks and switches strategies |
| Supporting classes | `DeviceRegistry`, `ConnectionManager`, `CompatibilityService`, `DeviceType`, `ConnectionType` |

## Build and run

```
mkdir out
javac -d out $(find src -name '*.java')
java -cp out periphery.Main
```
Java 8+.

## Clean Code principles applied

1. **Polymorphism instead of conditionals.** The Context has no `if`/`switch` on the profile. The old `startSetup(boolean gaming)` and the `applyGaming/applyOffice` pair are gone; each profile is a class. `DeviceRegistry.describe()` is also branch-free, because each `DeviceType` carries its own setting name and default. Per-type string checks (`.equals("MOUSE")`) were replaced with enums.
2. **Intention-revealing names.** `GamingProfile`, `PowerSaverProfile`, `MOUSE_DPI`, `KEYBOARD_BACKLIGHT_PERCENT`, `getModelsOfType`, `activateProfile`. A magic number like `16000` becomes a named constant inside the strategy that owns it.
3. **Single Responsibility.** Each strategy contains exactly one configuration algorithm and knows nothing about connections or validation. `ConnectionManager` connects/rolls back, `CompatibilityService` validates, `DeviceRegistry` stores state, and the Context only coordinates.
4. **Context is algorithm-agnostic.** `PeripheryContext` depends only on the `ProfileStrategy` interface. It never casts to or inspects a concrete class. Dependencies are injected via the constructor (Dependency Inversion).
5. **Open/Closed — easy extensibility.** `StreamingProfile` in `Main` was added by implementing the interface only; no existing class changed.
6. **Fail fast / error handling without nulls.** Constructors and setters validate arguments (`Objects.requireNonNull`, range checks). Validation runs before any connection change, and a failed attempt rolls back only the devices it connected.
7. **Small functions, no duplication of concerns.** Methods are short, do one thing and stay at one abstraction level.

## Likely defense questions

- **Why Strategy and not State?** The client chooses the algorithm explicitly; strategies don't know about each other and don't trigger transitions.
- **Why not an `enum` with a `switch`?** That would put the conditional back and force editing existing code for every new profile.
- **Why is the interface not a lambda?** It has two methods (`name`, `apply`); it could be split if lambdas were wanted.
- **Where is runtime switching?** `PeripheryContext.setProfile(...)`, shown in `Main`.
- **What changed from the earlier Facade version?** The Facade hid four subsystems behind one API; here the point is swapping interchangeable algorithms, and the subsystems are kept only as supporting classes.
