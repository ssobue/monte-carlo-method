# Monte Carlo Method

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ssobue_monte-carlo-method&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=ssobue_monte-carlo-method&branch=main)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ssobue_monte-carlo-method&metric=coverage)](https://sonarcloud.io/summary/new_code?id=ssobue_monte-carlo-method&branch=main)

This project estimates Pi using the Monte Carlo method. It is a compact Gradle
project written in Java.

## Repository Structure
```
monte-carlo-method/
  ├── build.gradle     # Gradle build configuration
  ├── settings.gradle  # Gradle project settings
  ├── gradlew          # Gradle Wrapper script
  ├── src/main/java/   # Java source code
  │   └── dev/sobue/math/MonteCarloMethod.java
  └── .github/         # CI settings (GitHub Actions)
```
GitHub Actions runs `./gradlew --no-daemon verify` on JDK 25 and JDK 26, builds
a GraalVM native image on JDK 25, and runs SonarQube Cloud analysis when the
token is available.

## Main Components
### MonteCarloMethod.java
- Performs 100,000,000 random trials.
- Counts how many points fall inside or outside the unit circle.
- After execution it prints the total iterations, counts, and the estimated
  value of Pi.

### build.gradle
- Uses Java 25.
- Includes Checkstyle and PMD for static analysis.
- Includes GraalVM Native Build Tools for native image generation.
- Includes SonarQube Cloud project properties for CI analysis.
- `verify` executes `MonteCarloMethod` after the standard Gradle checks.

## Key Points
1. **Build and Run**
   - Execute `./gradlew verify` to compile the code, run Checkstyle/PMD, and run
     `MonteCarloMethod`.
   - Execute `./gradlew run --args='100000'` to run the app with a custom
     iteration count.
   - Execute `./gradlew nativeCompile` with GraalVM to build a native executable.
2. **Development Style**
   - Coding standards are enforced with Checkstyle and PMD. Builds fail if
     violations remain.
3. **Continuous Integration**
   - GitHub Actions automatically runs Gradle builds on JDK 25 and JDK 26, a
     GraalVM native build, and SonarQube Cloud analysis on each push and pull
     request.
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

Start by reading `build.gradle` and `MonteCarloMethod.java`, then run `./gradlew verify` to
see the project in action. The code base is small, so getting familiar with it
should not take long.
