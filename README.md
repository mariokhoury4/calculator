# Java Calculator

A powerful, extensible command-line calculator written in Java. This tool evaluates mathematical expressions with full operator precedence, function support, implicit multiplication, and expression history.

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-green)](./LICENSE)

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Supported Operations & Functions](#supported-operations--functions)
- [Constants](#constants)
- [Project Structure](#project-structure)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- Evaluate complex mathematical expressions with operator precedence and parentheses.
- Supports implicit multiplication (e.g., `2(3 + 4)` → `2 * (3 + 4)`).
- Includes standard arithmetic operators and advanced mathematical functions.
- Supports constants `pi` and `e` as built-in values.
- View expression history with the `history` command.
- Graceful error handling with clear messages.

---

## Installation

### Prerequisites

- Java Development Kit (JDK) 17 or higher.
- Maven (for building and running the project).

### Steps

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd Calculator
2. **Build the Project**:
   ```bash
   mvn clean install
   ```
3. **Run the Application**:
   ```bash
   java -jar target/Calculator.jar
   ```
   **Or**
   ```bash
   mvn exec:java -Dexec.mainClass="Calculator"
   ```

## Usage
1. Start the calculator
2. Type an expression (e.q., `2 + 3 * (4 - 1)` or `sin(pi / 2)`)
3. Press Enter to evaluate the expression
4. Type `history` to view previous expressions
5. Type `exit` to quit the application

### Example Input
- `2 + 3 * 4` → `14.0`
- `sin(pi / 2)` → `1.0`
- `2(3 + 4)` → `14.0`
- `abs(round(-2.8) + floor(1.5))` → `2.0`
- `history` → Displays previous expressions
- `exit` → Exits the application

## Supported Operations & Functions
### Arithmetic Operations

| Operation      | Symbol | Precedence |
| -------------- | ------ | ---------- |
| Addition       | `+`    | Low        |
| Subtraction    | `-`    | Low        |
| Multiplication | `*`    | Medium     |
| Division       | `/`    | Medium     |
| Modulo         | `%`    | Medium     |
| Exponentiation | `^`    | High       |
| Parentheses    | `()`   | Highest    |

### Mathematical Functions

| Function   | Description                   |
| ---------- | ----------------------------- |
| `sin(x)`   | Sine (degrees)                |
| `cos(x)`   | Cosine (degrees)              |
| `tan(x)`   | Tangent (degrees)             |
| `sqrt(x)`  | Square root                   |
| `log(x)`   | Logarithm base 10             |
| `ln(x)`    | Natural logarithm (base *e*)  |
| `exp(x)`   | e raised to the power of *x*  |
| `abs(x)`   | Absolute value                |
| `ceil(x)`  | Round up to nearest integer   |
| `floor(x)` | Round down to nearest integer |
| `round(x)` | Round to the nearest integer  |


### Constants

| Constant | Value           |
| -------- | --------------- |
| `pi`     | 3.1415926535... |
| `e`      | 2.7182818284... |


## Project Structure

Calculator/
├── pom.xml
├── src/
│   ├── main/java/
│   │   ├── Calculator.java
│   │   ├── model/
│   │   │   ├── OperationRegistry.java
│   │   │   ├── RecursiveExpressionEvaluator.java
│   │   │   └── operation/
│   │   │       ├── basic/        # Binary operations (+, -, *, etc.)
│   │   │       └── unary/        # Unary functions (sin, cos, etc.)
│   │   └── utils/
│   │       ├── TokenUtils.java
│   │       ├── Constants.java
│   │       └── ExpressionValidatorUtils.java
│   └── test/java/
│       └── CalculatorTest.java
│       └── utils/TokenUtilsTest.java
│       └── model/RecursiveExpressionEvaluatorTest.java

## Testing
To run the tests, use the following command:
```bash
mvn test
```

Test coverage includes:
- Tokenization and validation 
- Expression evaluation with operator precedence 
- Function and constant handling

## Contributing
Contributions are welcome!
1. Fork the repository 
2. Create a branch for your feature 
3. Add code and unit tests 
4. Open a pull request with a clear description

Please follow standard Java conventions and include Javadoc for public methods.
