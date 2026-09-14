# Custom PC Periphery Builder — Software Design Patterns (Assignment #1)

## Overview
This application implements the **Builder Creational Design Pattern** in Java to orchestrate step-by-step construction of complex PC peripheral setups. It supports custom, fluent method-chained setups as well as standardized presets via a `Director`.

---

## Clean Code Principles Applied & Justified

### 1. Meaningful & Intention-Revealing Names
- **Concept**: Identifiers directly state intention without obscure shorthand.
- **Before**:
  ```java
  public void build(String k, String m, int w) { ... }