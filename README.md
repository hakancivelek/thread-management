# Thread Management Examples in Java

This project demonstrates the difference between:

- Single-threaded blocking server
- Multi-threaded server

using Java `ServerSocket` and `Socket`.

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

# How to Test

## 1. Compile

```bash
javac src/*.java
```

---

## 2. Run the Server

### Single Thread Server

```bash
java -cp src SingleThreadBlockingServer
```

### Multi Thread Server

```bash
java -cp src MultiThreadServer
```

---

## 3. Open Multiple Terminals

Connect from different terminals using:

```bash
telnet localhost 8080
```

---

## 4. Test SingleThreadBlockingServer

### Terminal 1

Connect but do not send any data.

The server thread becomes blocked while waiting for input.

### Terminal 2

Try connecting again.

You will notice the second client cannot be processed until the first client finishes.

This demonstrates blocking behavior in a single-threaded architecture.

---

## 5. Test MultiThreadServer

### Terminal 1

Connect and keep the connection idle.

### Terminal 2

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