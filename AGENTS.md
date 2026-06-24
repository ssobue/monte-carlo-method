# Repository Guidelines

## Project Structure & Module Organization
- `build.gradle`: Gradle configuration (Java 25, Checkstyle, PMD, Jacoco, Sonar).
- `settings.gradle`: Gradle project settings and repository policy.
- `gradle/wrapper/`: Gradle Wrapper files; use `./gradlew` for local and CI builds.
- `src/main/java/dev/sobue/math/MonteCarloMethod.java`: Main implementation.
- `src/test/java/...`: JUnit 5 tests (add here).
- `.github/workflows/main.yaml`: CI runs `./gradlew --no-daemon verify`.
- `build/`: Build artifacts (generated).

## Build, Test, and Development Commands
- Build and run: `./gradlew clean verify`
  - Compiles, runs Checkstyle/PMD, executes tests, and runs the app entry point.
- Run only tests: `./gradlew test`
- Package: `./gradlew assemble`
- Run app during development: `./gradlew run --args='100000'`
- Static analysis only: `./gradlew checkstyleMain checkstyleTest pmdMain pmdTest`

Prerequisite: Use JDK 25 (`actions/setup-java@v5` sets this in CI).

## Coding Style & Naming Conventions
- Style enforced by Checkstyle (Google checks) and PMD; builds fail on violations.
- Indentation and formatting: follow Google Java Style; use UTF-8 encoding.
- Naming: `PascalCase` classes, `camelCase` methods/fields, `UPPER_SNAKE_CASE` constants.
- Packages under `dev.sobue.math`; keep classes small and focused.

## Testing Guidelines
- Framework: JUnit Jupiter (JUnit 5).
- Location: `src/test/java/...` mirroring package structure.
- Naming: Class ends with `Test` (e.g., `MonteCarloMethodTest`).
- Run: `mvn test` or as part of `mvn verify`.
- Aim for fast, deterministic tests; cover core math and edge cases. No coverage threshold enforced yet.

## Commit & Pull Request Guidelines
- Commits: concise, imperative present tense (e.g., "Add pi estimator").
- Branches: `feature/...`, `fix/...`, `chore/...`, `deps/...` are encouraged.
- PRs: include a clear summary, rationale, before/after notes, how to run, and linked issues. Ensure CI is green.

## Notes on Performance & CI
- Monte Carlo runs can be CPU-intensive; prefer smaller trial counts locally when iterating.
- CI executes `mvn --batch-mode verify` on push and pull requests, and runs SonarCloud
  analysis only when the workflow has a usable token; keep builds quick and deterministic.
