# Java Thread Creation & Shared Counter Demo

This project demonstrates thread creation in Java and shows the difference between unsafe and safe shared state handling.

---

## 📁 Project Structure

- `ThreadExtendExample.java` → extends Thread approach
- `RunnableExample.java` → implements Runnable approach
- `SharedCounter.java` → shared counter (critical section)
- `ThreadCreationDemo.java` → main runner

---

## ▶️ How to Test

Run `ThreadCreationDemo.java`

In `SharedCounter.java`, test with `/* synchronized */` commented and uncommented versions.

---

## 🧵 Thread Creation Approaches

### 1. extends Thread
- Thread class is extended directly
- Simple but not flexible
- Not recommended for scalable systems

### 2. implements Runnable ⭐
- Separates task from thread
- Same task can be reused by multiple threads
- Preferred modern approach

---

## 🔄 Shared State Problem

`SharedCounter` is used by multiple threads.

```java
counter++;
