# What you need to know

## General
- This GitHub repo uses Ant in GitHub Actions to check for breaking code, and to host the most recent build of JavaDoc documentation using GitHub pages [which can be found here](https://merchygoedwig.github.io/cscm94-coursework-2/).
- Push notifications for all actions are sent to the `#group_8_cscm94` channel on the MSc Computer Science Discord server.
- Only source code is to be hosted here, if you are using an IDE that creates non-source code material (IntelliJ/Eclipse etc.) for project management, please make sure that these files do not get committed! You can make sure this doesn't happen by pattern matching in `.gitignore`!

## Branching stuff
- Never, ever, not ever, and this is meant in the nicest possible way, push to the master branch!
- Branch out here, git checkout the remote branch locally, commit and push to the branch. When you're ready to merge back to master:
  - make sure the code want to merge has appropriate unit tests (JUnit),
  - run ant locally, make sure that your changes don't break stuff,
  - commit your changes to the remote branch,
  - create a new pull request, be as descriptive as you can be without using too many words, making sure you describe what has been changed during the history of the branch you are merging!
- Use meaningful names when you create branches (i.e. adding-someFeature, fixing-[commit hash])

## Coding conventions
- Coding conventions for this project are defined [here](https://drive.google.com/file/d/1sKMj3rkKobZePRCtAFRudB2C6XXPlqT5/view?usp=sharing).
