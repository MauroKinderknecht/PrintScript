# PrintScript

## Get started
Create a `gradle.properties` file containing:
 ```
kotlin.code.style=official
GITHUB_ACTOR=<your_github_user>
GITHUB_TOKEN=<your_github_token>
 ```

## Pre-commit
> If you dont see the .git folder, check this [link](https://stackoverflow.com/questions/35784352/intellij-doesnt-show-git-directory)

To add this functionality, we need to create the file pre-commit in ./git/hooks
- Paste the next code into that file
```
#!/bin/sh

echo "*****Running formatKotlin ******"

git stash -q --keep-index

./gradlew formatKotlin

status=$?
git stash pop -q

echo "*****Done with formatKotlin******"

exit $status
```
Then we need to execute the line below
```
chmod +x .git/hooks/pre-commit
```

## Useful commands

Run Linter & Formatter
```
./gradlew lintKotlin
./gradlew formatKotlin
```

Run tests with code coverage
```
./gradlew test
```

Run CLI
```
./gradlew --console plain run
```