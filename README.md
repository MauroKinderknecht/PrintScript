# PrintScript

## Get started

Create a `gradle.properties` file containing:
 ```
kotlin.code.style=official
gpr.user=<your_github_user>
gpr.key =<your_github_token>
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

## Known bugs
- Que una keyword sea una keyword "letVar" deberia ser un Identifier y matchea a 2 tokens Let y Identifier
- Que el parser se banque operaciones compuestas y orden de precedencia
- Code coverage en los test
- Tests para el interpreter y el cli
- Las expresiones complejas no funcionan consistentemente