# 🏦 ATM Simulator — Banking Domain Modeling Project

## 📌 Overview

This project is an enterprise-inspired ATM Simulator developed in Java to model real-world banking operations and reinforce backend engineering fundamentals.

The system simulates:

- ATM authentication flows
- Account management
- Withdrawals and deposits
- Transaction history tracking
- Security validations
- Stateful session management

The objective of this project is NOT simply to practice Java syntax.

Instead, the goal is to:
- strengthen Object-Oriented Programming (OOP)
- model financial domain behavior
- understand transactional systems
- prepare for enterprise backend development using Java and Spring Boot

---

# 🎯 Learning Objectives

This project reinforces:

- Encapsulation
- Composition
- State management
- Validation logic
- Exception handling
- Domain-driven thinking
- Financial data integrity
- Enterprise coding structure

---

# 🏗️ System Architecture

```plaintext
+----------------+
|      ATM       |
+----------------+
        |
        ▼
+----------------+
| Authentication |
+----------------+
        |
        ▼
+----------------+
| Account Access |
+----------------+
        |
        ▼
+----------------+
| Transactions   |
+----------------+
```

---

# 🧠 Domain Model (UML)

```plaintext
                         ATM
------------------------------------------------
- id: UUID
- location: String
- cashAvailable: BigDecimal
- insertedCard: Card
- currentSessionAccount: Account

+ insertCard(card)
+ ejectCard()
+ validatePin(pin)
+ withdraw(amount)
+ deposit(amount)
+ showBalance()
+ printTransactionHistory()

------------------------------------------------

                        Card
------------------------------------------------
- cardNumber: String
- pin: String
- blocked: boolean
- failedAttempts: int
- expirationDate: LocalDate

+ validatePin(pin)
+ incrementFailedAttempts()
+ resetAttempts()
+ block()

------------------------------------------------

                      Account
------------------------------------------------
- id: UUID
- accountNumber: String
- ownerName: String
- balance: BigDecimal
- status: AccountStatus
- transactions: List<Transaction>

+ deposit(amount)
+ withdraw(amount)
+ addTransaction(transaction)
+ validateSufficientFunds(amount)

------------------------------------------------

                   Transaction
------------------------------------------------
- id: UUID
- transactionType: TransactionType
- amount: BigDecimal
- timestamp: LocalDateTime
- description: String

------------------------------------------------

                    Enums
------------------------------------------------
AccountStatus
- ACTIVE
- BLOCKED

TransactionType
- WITHDRAWAL
- DEPOSIT
- BALANCE_INQUIRY
```

---

# 🏦 Business Context

ATM systems are transactional systems responsible for securely handling financial operations.

This simulator models:
- customer authentication
- secure transaction execution
- balance integrity
- auditability
- transaction traceability

The project was designed using enterprise-inspired architectural principles commonly found in banking environments.

---

# 📂 Project Structure

```plaintext
com.bank.atm

├── domain
│   ├── ATM.java
│   ├── Account.java
│   ├── Card.java
│   └── Transaction.java
│
├── enums
│   ├── AccountStatus.java
│   └── TransactionType.java
│
├── exception
│   ├── InvalidPinException.java
│   ├── InsufficientFundsException.java
│   ├── CardBlockedException.java
│   └── InvalidAmountException.java
│
├── service
│
├── util
│
└── Main.java
```

---

# 🔐 Business Rules

## PIN Validation
- Maximum 3 failed attempts
- Card becomes blocked after 3 invalid PIN attempts

---

## Withdrawal Rules
- Withdrawal amount must be positive
- Account must have sufficient balance
- ATM must contain sufficient available cash

---

## Transaction Integrity
Every successful operation generates a transaction record.

Transactions are immutable and preserved for auditability purposes.

---

# 💰 Why BigDecimal?

Financial systems must NEVER use:

```java
double
float
```

Reason:
floating-point arithmetic introduces precision errors.

Example:

```java
0.1 + 0.2 != 0.3
```

For financial operations, deterministic precision is mandatory.

Therefore:

```java
BigDecimal
```

is used for:
- balances
- withdrawals
- deposits
- transaction amounts

---

# 🧩 Key Design Decisions

---

## Encapsulation

Business rules belong to the object that owns the state.

✅ Correct:

```java
account.withdraw(amount);
```

❌ Incorrect:

```java
account.balance -= amount;
```

The object itself must control state modifications.

---

## Composition

An Account contains:
- Transactions

An ATM contains:
- Card session
- Current Account session

This models real-world system relationships.

---

## Stateful Design

The ATM maintains:
- inserted card
- active session

This reinforces:
- state management
- transactional thinking

---

# ⚠️ Exception Model

Custom exceptions were implemented to improve:
- readability
- maintainability
- domain expressiveness

## Exceptions

```plaintext
InvalidPinException
InsufficientFundsException
CardBlockedException
InvalidAmountException
AtmOutOfCashException
```

---

# 🧪 Testing Strategy

The following scenarios should be tested:

## Account Tests
- successful deposit
- successful withdrawal
- insufficient funds

---

## Card Tests
- failed PIN attempts
- card blocking behavior

---

## ATM Tests
- authentication flow
- withdrawal validation
- transaction creation

---

# 📜 Logging

Operations generate console logs for traceability.

Example:

```plaintext
[2026-05-08 14:00:00]
WITHDRAWAL
Account: 12345
Amount: 200000 COP
Status: SUCCESS
```

Logging is essential for:
- observability
- debugging
- operational visibility

---

# 🚀 Future Evolution

This project is intentionally designed to evolve into:

```plaintext
ATM Domain
    ↓
Spring Boot REST API
    ↓
PostgreSQL Integration
    ↓
Microservices Architecture
    ↓
Reactive Systems (WebFlux)
```

---

# 🛠️ Technologies Used

- Java 21 (or Java 17+)
- Object-Oriented Programming
- BigDecimal
- Java Collections
- UUID
- Exception Handling

---

# 📚 Concepts Practiced

- Classes and Objects
- Inheritance
- Composition
- Encapsulation
- State management
- Collections
- Validation
- Exception handling
- Domain modeling

---

# 🧠 Engineering Mindset

This project was developed following enterprise-inspired engineering principles:

- separation of responsibilities
- domain ownership
- transactional integrity
- auditability
- maintainability

The goal is to build backend engineering thinking rather than tutorial-style code.

---

# 📌 Author Notes

This project is part of a long-term backend engineering roadmap focused on:

- Java
- Spring Boot
- Banking systems
- Microservices
- Cloud-native architecture
- Reactive programming

---

# ✅ Current Features

- [x] Card authentication
- [x] PIN validation
- [x] Deposits
- [x] Withdrawals
- [x] Balance inquiry
- [x] Transaction history
- [x] Custom exceptions
- [x] Console logging

---

# 🔮 Planned Improvements

- [ ] PostgreSQL persistence
- [ ] REST API layer
- [ ] Spring Boot migration
- [ ] JUnit tests
- [ ] Mockito tests
- [ ] Docker support
- [ ] Kubernetes deployment
- [ ] Reactive programming version

---

# 📈 Key Takeaways

This project demonstrates:
- strong OOP fundamentals
- transactional system modeling
- enterprise-inspired architecture
- financial domain reasoning

It serves as a foundational step toward becoming a backend engineer specialized in banking and fintech systems.