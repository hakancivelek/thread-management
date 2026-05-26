# Blocking I/O Example

This module demonstrates how blocking I/O behaves in different server architectures using Java `ServerSocket` and `Socket`.

Examples included:

- `SingleThreadBlockingServer`
- `MultiThreadServer`

---

# Project Structure

```text
blockingio/
├── SingleThreadBlockingServer.java
└── MultiThreadServer.java
```

---

# SingleThreadBlockingServer

Handles all client requests sequentially using a single thread.

## Which Problem Does It Demonstrate?

This server demonstrates the classic blocking I/O problem.

If one client:

- sends data very slowly
- or never sends any data

the entire server becomes blocked because the same thread is responsible for:

- accepting connections
- reading data
- responding to clients

As a result, other clients must wait.

This model does not scale well under concurrent traffic.

---

# MultiThreadServer

Creates a separate thread for each client connection.

## Which Problem Does It Solve?

This server solves the “entire server blocking” problem by isolating each client request into its own thread.

If one client becomes slow:

- only its own thread blocks
- other clients continue working normally

This improves concurrency and responsiveness.

However, creating one thread per request can become expensive under very high traffic.

---

# How to Run

## 1. Compile

From the `src` directory:

```bash
javac blockingio/*.java
```

---

## 2. Run SingleThreadBlockingServer

```bash
java blockingio.SingleThreadBlockingServer
```

---

## 3. Run MultiThreadServer

```bash
java blockingio.MultiThreadServer
```

---

# How to Test

Open multiple terminals and connect using:

```bash
telnet localhost 8080
```

---

# Test SingleThreadBlockingServer

## Terminal 1

Connect but do not send any data.

The server thread becomes blocked while waiting for input.

## Terminal 2

Try connecting again.

You will notice the second client cannot be processed until the first client finishes.

This demonstrates blocking behavior in a single-threaded architecture.

---

# Test MultiThreadServer

## Terminal 1

Connect and keep the connection idle.

## Terminal 2

Connect again and send data.

You will notice:

- the second client still works
- only the first client thread remains blocked

This demonstrates concurrent request handling using multiple threads.

---

# Key Concepts

- Blocking I/O
- Concurrency
- Thread-per-request model
- Socket programming
- Thread isolation
- Scalability limitations