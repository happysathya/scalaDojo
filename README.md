# scalaDojo

A comprehensive Scala coding practice repository featuring algorithms, data structures, functional programming concepts, and coding challenges.

## 🎯 Overview

This project serves as a coding dojo for practicing and mastering Scala programming through various problem-solving exercises. Each implementation includes comprehensive unit tests to ensure correctness and demonstrate usage.

## 📁 Project Structure

```
src/main/scala/com/happysathya/playground/
├── algorithms/          # Core algorithmic problems
├── collections/         # Collection manipulation and operations
├── datastructures/      # Custom data structure implementations
├── effects/            # Functional effects and side effect management
├── functional/         # Functional programming patterns and concepts
├── math/               # Mathematical algorithms and computations
├── puzzles/            # Logic puzzles and brain teasers
├── strings/            # String manipulation and processing
└── utilities/          # Helper utilities and common functions
```

## 🔧 Setup & Requirements

### Prerequisites
- **Scala**: 2.13.x or higher
- **SBT**: 1.x
- **JDK**: 11 or higher

### Getting Started

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd scalaDojo
   ```

2. **Compile the project**
   ```bash
   sbt compile
   ```

3. **Run tests**
   ```bash
   sbt test
   ```

4. **Run a specific test**
   ```bash
   sbt "testOnly com.happysathya.playground.algorithms.BinaryGapTest"
   ```

## 📚 Problem Categories

### 🧮 Algorithms
- **BinaryGap**: Find longest sequence of zeros in binary representation
- **CountBits**: Count number of set bits in integers
- **IsSorted**: Check if array is sorted
- **RightShiftByNTimes**: Implement right shift operations

### 📊 Collections
- **IterablePairWithNextElement**: Pair elements with their successors
- **MaxCounters**: Implement counter operations with max operation
- **MissingElement**: Find missing element in sequence
- **MoveZerosToEnd**: Move all zeros to end of array
- **TwoNumbersAddUpInAList**: Find pairs that sum to target

### 🏗️ Data Structures
- **DoublyLinkedList**: Bidirectional linked list implementation
- **LinkedList**: Single linked list with operations
- **NodeTraversal**: Tree/graph traversal algorithms

### ⚡ Effects
- **CatsEffectEvaluation**: Cats Effect practice and evaluation
- **IncrementNumber**: Side effect management patterns

### 🎭 Functional Programming
- **KleisliDojo**: Kleisli arrow patterns and composition
- **ListCalculator**: Functional list operations
- **StateMonad**: State monad implementation and usage

### 🧮 Mathematics
- **FibonacciSum**: Fibonacci sequence operations
- **GcdAndLcmEuclidean**: Greatest common divisor and least common multiple
- **MinimumMaximumSum**: Array min/max operations
- **RecursiveDigitSum**: Recursive digit summation
- **SquareInRectangle**: Geometric calculations
- **TapeEquilibrium**: Find equilibrium point in array

### 🧩 Puzzles
- **CoinVendingMachine**: Coin change problem
- **FrogJump**: Dynamic programming jump problem
- **LonelyInteger**: Find unique element in array
- **SmallestPositiveInteger**: Find smallest missing positive integer (2 versions)
- **UnPaired**: Find unpaired element

### 🔤 Strings
- **FirstUniqueCharacter**: Find first non-repeating character
- **StringOptimiser**: String compression and optimization
- **StringToCamelCase**: Convert strings to camelCase
- **StringZipOptimiser**: Advanced string compression

### 🛠️ Utilities
- **DataCleanup**: Data processing and cleanup utilities
- **DataStructureDecisionForJava**: Java interop utilities
- **FindWordPrecedenceRule**: Word ordering algorithms
- **LowestNumberInConstantTime**: O(1) minimum operations
- **ProcessLogs**: Log processing utilities
- **ScalaTimeImpl**: Time and date utilities
- **WordOrdering**: Custom word sorting implementations

## 🧪 Testing

Each problem includes comprehensive unit tests located in `src/test/scala/` with the same package structure. Tests demonstrate:
- ✅ Correctness verification
- 🎯 Edge case handling
- 📝 Usage examples
- ⚡ Performance validation

## 🚀 Usage Examples

### Running Individual Problems
```bash
# Compile and run tests for a specific category
sbt "testOnly com.happysathya.playground.algorithms.*"

# Run all functional programming tests
sbt "testOnly com.happysathya.playground.functional.*"

# Run a single test class
sbt "testOnly com.happysathya.playground.puzzles.FrogJumpTest"
```

### Interactive REPL
```bash
sbt console
scala> import com.happysathya.playground.algorithms.BinaryGap
scala> BinaryGap.solution(1041)
```

## 🤝 Contributing

This is a personal coding practice repository. Feel free to:
- 📖 Study the implementations
- 🔄 Suggest improvements
- 🐛 Report issues
- 💡 Propose new problems

## 📝 License

This project is for educational purposes and personal skill development.

---

**Happy Coding! 🎉**
