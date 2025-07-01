# Monte Carlo Method

This project estimates Pi using the Monte Carlo method. It is a compact Maven
project written in Java.

## Repository Structure
```
monte-carlo-method/
  ├── pom.xml          # Maven build configuration
  ├── src/main/java/   # Java source code
  │   └── jp/sobue/math/MonteCarloMethod.java
  └── .github/         # CI settings (GitHub Actions)
```
GitHub Actions runs `mvn --batch-mode verify` on each push.

## Main Components
### MonteCarloMethod.java
- Performs 100,000,000 random trials.
- Counts how many points fall inside or outside the unit circle using
  `AtomicLong`.
- The trials run with Java's parallel streams.
- After execution it prints the total iterations, counts, and the estimated
  value of Pi.

### pom.xml
- Uses Java 21.
- Includes Checkstyle and PMD for static analysis.
- `exec-maven-plugin` executes `MonteCarloMethod` during the `verify` phase.

## Key Points
1. **Build and Run**
   - Execute `mvn verify` to compile the code, run Checkstyle/PMD, and run
     `MonteCarloMethod`.
2. **Development Style**
   - Coding standards are enforced with Checkstyle and PMD. Builds fail if
     violations remain.
3. **Continuous Integration**
   - GitHub Actions automatically runs the Maven build on each push.
4. **Code Size**
   - Only one Java file is included, making it easy to understand the project
     quickly.

## Further Learning
- **Monte Carlo Basics** – Review the theory behind using random sampling to
  estimate areas.
- **Maven Plugin Configuration** – Explore the various plugins in `pom.xml`,
  such as Checkstyle, PMD, and the exec plugin.
- **Performance and Parallelism** – Because the trial count is large, you can
  look into multithreading performance measurements.
- **CI/CD Workflow** – The GitHub Actions workflow is minimal and can be
  extended to include tests or artifact publishing.

Start by reading `pom.xml` and `MonteCarloMethod.java`, then run `mvn verify` to
see the project in action. The code base is small, so getting familiar with it
should not take long.
