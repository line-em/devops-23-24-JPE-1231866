# Technical Report for CA1

![](https://i.postimg.cc/Kj58KJgM/final-ca1.png)

<!-- TOC -->
* [Technical Report for CA1](#technical-report-for-ca1)
  * [Analysis, Design, and Implementation](#analysis-design-and-implementation)
  * [Part 1](#part-1)
    * [Step-by-Step Guide](#step-by-step-guide)
      * [Initial Setup](#initial-setup)
      * [Adding the jobYears Field](#adding-the-jobyears-field)
  * [Part 2](#part-2)
    * [Step-by-Step Guide](#step-by-step-guide-1)
      * [Adding the email Field](#adding-the-email-field)
      * [Validating the Email Field - Fix Invalid Email](#validating-the-email-field---fix-invalid-email)
  * [The Final Result](#the-final-result)
    * [Tests](#tests)
      * [jobTitle](#jobtitle)
      * [Invalid Email](#invalid-email)
    * [React UI](#react-ui)
    * [DatabaseLoader](#databaseloader)
    * [Employee Class Constructor](#employee-class-constructor)
* [Alternative Solution](#alternative-solution)
  * [Mercurial](#mercurial)
    * [Requirements](#requirements)
    * [Mercurial Part 1](#mercurial-part-1)
    * [Mercurial Part 2](#mercurial-part-2)
  * [Conclusion](#conclusion)
* [Author](#author)
<!-- TOC -->

## Analysis, Design, and Implementation

The assignment consists of two parts. The first part involves adding a new
field, `jobYears`, to the `Employee` class, including validation and testing. The second
part involves adding another field, `email`, to the `Employee` class, including validation
and testing. The final result should be a fully functional application with the new fields
and validations added. We will also tag the versions as we go along, using branching and
merging to keep track of the changes.

The implementation of the assignment involves making changes to the `Employee` class,
the `DatabaseLoader` class, the `app.js` file, and the `EmployeeTest` class. The changes
include adding the new fields, `jobYears` and `email`, to the `Employee` class, adding
validation and methods for the new fields, and updating the UI to display the new fields.
The changes also involve adding tests to the `EmployeeTest` class to validate the new
fields.

The implementation phase encompassed the actual development and integration of the new
features into the system. This involved writing code to add the email field to the
Employee class, updating the user interface to display and capture email information, and
implementing validation logic to ensure that only valid email addresses were accepted.
Additionally, testing was conducted throughout the implementation phase to verify the
correctness and robustness of the new features.

## Part 1

### Step-by-Step Guide

#### Initial Setup

- **1. Initializing a New Git Repository**: Begin by initializing an empty Git repository
  in your local directory, or create a new one on GitHub.
- **2. Creating a .gitignore File**: Create a .gitignore file to avoid tracking
  unnecessary files. For example, for IntelliJ and Maven projects:
    - 2.1. Get the .gitignore file
      from `https://www.toptal.com/developers/gitignore?templates=java,intellij,maven`
    - 2.2. Paste the content into the .gitignore file in your project directory.
    - 2.3. Don't forget to commit and push the .gitignore file to the repository.
- **3. Cloning the Tutorial Project from GitHub**: Now, we will focus on another
  repository for a while. Clone this project from GitHub into any folder. For example:
    - 3.1. `git clone git@github.com:spring-guides/tut-react-and-spring-data-rest.git`
- **4. Navigating to the Project Directory**: Move to the basic directory of this project.
    - `cd ./tut-react-and-spring-data-rest/basic/`
- **5. Running the SpringBoot App**: Execute the command to run the SpringBoot app:
    - `./mvnw spring-boot:run`
- **6. Checking the Application**: Verify the application is running by accessing it
  through the browser: http://localhost:8080/
- **7. Creating a New Directory**:  Now we need to move the tutorial folder into our
  previously created repository. If the repository exists on GitHub, clone it locally.
  Next, create a new directory named "CA1" within the repository to store the assignment
  files, including the tutorial folder.
    - 7.1. `git clone git@github.com:line-em/devops-23-24-JPE-1231866.git`
    - 7.2. `mkdir CA1`
- **8. Navigating to the CA1 Directory**: Move to the newly created "CA1" directory.
    - 8.1. `cd ./CA1`
- **9. Going back to the tut-react-and-spring-data-rest folder**, delete the .git
  directory from the *“tut-react-and-spring-data-rest-main”* to avoid git tracking
  conflicts.
- **10. Moving the tut-react-and-spring-data-rest-main to the CA1 directory**:
    - 10.1 `mv ./YourFolderPath/tut-react-and-spring-data-rest-main ./CA1`
    - 10.2 You can rename the folder, if you want, to something like "tutorial".
- **11. Committing and Pushing to the GitHub Repository**: Use git add . to start tracking the new files. However, first, please make sure the .gitignore file from before is working! You don't want folders such as .idea/ and node_modules being added to the repository.
    - 11.1. `git add .`
    - 11.2. `git commit -m “[CA1] - Add tutorial files to CA1”`
- **12. Warm Up**: After setting up, spend some time warming up, getting to know the project structure. For instance, I did:
    - Modify the CSS, on commit #763301b5, [CSS] - Add custom CSS and Hanken Grotesk font.
      Closes #4.
    - Add the jobTitle field, on commit #08503c70, [FEAT] - Add job title field. Closes
      #1.)
    - Tested the Employee class, on commit #653af61e, [TEST] - Add tests to Employee.
      Closes #5.
    - It's important to properly use `git status, git add ., git commit -am, and git push`
      to keep track of the changes and commit them properly.
- **13. Now that everything is properly set up, you can start the assignment.** Tag this
  version as v1.1.0. I named it after the feature we're gonna add on the next part!
    - 13.1. `git tag -a v1.1.0 -m “add and support Employee's jobYears field.”`
    - 13.2. `git push --tags`
    - 13.3. `git tag` to verify if the tag was created.

#### Adding the jobYears Field

- **14. Opening the project on IntelliJ** - To avoid problems, I recommend opening the
  folder "tutorial" directly on IntelliJ. This is to make sure the `pom.xml` is read correctly. We will work on the `basic/` folder that is inside
  the tutorial folder.
    - 14.1. Click on "Open or Import" on IntelliJ, and select the "tutorial" folder.
- **15 - Add the field jobYears to the Employee.** To properly add the field jobYears, here are the tasks we will need to implement, in no particular order:
    - 15.1. Add the field to the Employee class, adding it to its constructor.
    - 15.2. Add the field to the entries in the DatabaseLoader class.
    - 15.3. Add the field to the table in the app.js file.
    - 15.4. Add validation to the field in the Employee class.
    - 15.5. Add the field to the EmployeeTest class, where needed, and create new tests.
    - 15.6. Modify methods such as hashCode() and equals() to include the new field.
    - 15.7. Add the corresponding getters and setters.
    - 15.8. Run the tests and the application to check if everything is working properly.
- **16 - Tests** - We will first commit the tests for the Employee class. After making your modifications, run
  the following commands:
    - 16.0. `git status` (to verify the files that were modified)
    - 16.1. `git add .` (In case you created a new file. You can also specify the file to be added, such as `git add FILE.java`)
    - 16.2. `git commit -m “[JobYears] #Add tests to jobYears. Closes #3”`
    - 16.3. `git status` to check if everything is ok.
    - 16.4. `git push` to push the changes to the repository.
- **17 - Add methods to employees, including validation.** Do the same process as in the
  previous step, but now for the methods and validation of the jobYears field.
    - 17.1. `git add .` and `git status`, whenever it is needed.
    - 17.2. `git commit -m “[JobYears] Add methods to jobYears, validating Employee attributes. Closes #2 #6”`
    - 17.3. `git push`
- **18 - Optional - Add new entries**: If you want to add new entries to the database, you
  can do so by adding them to the DatabaseLoader class. After that, run the tests and the
  application to check if everything is working properly.
    - I did this in the commit `[Data] - Add new Employees. Closes #8`.
- **19 - Finishing touches and remaining steps**: Minor fixes and UI changes can be made
  here, to accommodate the new field. For example, I added the jobYears field to the table
  header in the app.js file.
    - I did this in the
      commit `[JobYears] - Add new field, jobYears, to the UI. Closes #13`
    - After that, run the tests and the application to check if everything is working
      properly.
- **20 - Tagging the version as v1.2.0**: After finishing the implementation, tag the
  version as v1.2.0.
    - 20.1. `git tag -a v1.2.0 -m “Support Employee's jobYears field completed.”`
    - 20.2. `git push --tags`
    - 20.3. `git tag` to verify if the tag was created.
- **21 - Complete the assignment**: After finishing the assigment, tag it as ca1-part1.
    - 21.1. `git tag -a ca1-part1`
    - 21.2. `git push --tags`
    - 21.3. `git tag` to verify if the tag was created.

## Part 2

### Step-by-Step Guide

#### Adding the email Field

- **1. Creating a New Branch**: Begin by creating a new branch for adding the email field.
    - 1.1. `git checkout -b email-field`
- **2. Verifying the Branch**: Make sure the branch was created successfully. You can do this by using:
    - 2.1. `git branch -a`
- **3. Adding Email Field to Employee Class**: Add the email field to the Employee class
  and test it. Commit the tests for the Employee class first, following the same steps as before (status/add/commit/push, as needed).
- **4. Adding Methods and Validation**: Add methods to Employee, including basic
  validation, and make fixes in the DatabaseLoader class, so the application can compile.
- **5. Adding Email Field to UI**: Add the email field to the table in the app.js file.
    - Verify that everything is working properly before moving on! Use `./mvnw spring-boot:run` to verify the changes.
- **6. Merging Changes**: Now, merge the email-field branch into the main branch.
    - 6.1. `git checkout main`
    - 6.2. `git merge --no-ff email-field`
- **7. Creating a New Tag**: Create a new tag for this version.
    - 7.1. `git tag -a v1.3.0 -m "Support Employee's email field"`
- **8. Verifying Tag Creation**: Verify if the tag was created successfully.
    - 8.1. `git tag`
- **9. Pushing Changes and Tag**: Push the changes and the tag to the repository.
    - 9.1. `git push --tags`
    - 9.2. `git push`

![final_ca1merge.png](https://i.postimg.cc/j2TjdGCT/final-ca1merge.png)

#### Validating the Email Field - Fix Invalid Email

- **12. Creating a New Branch**: Begin by creating a new branch for fixing invalid email.
    - 12.1. `git checkout -b fix-invalid-email`
- **13. Verifying the Branch**: Make sure the branch was created successfully.
    - 13.1. `git branch -a`
- **14. Adding Validation to Email Field**: Add validation to the email field in the
  Employee class by adding a method `isValidEmail`.
- **15. Adding Tests**: Add tests to the EmployeeTest class to validate the email field.
- **16. Merging Changes**: Now, merge the fix-invalid-email branch into the main branch.
    - 16.1. `git checkout main`
    - 16.2. `git merge --no-ff fix-invalid-email`
- **17. Creating a New Tag**: Create a new tag for this version. This is a minor revision,
  so it will be v1.3.1.
    - 17.1. `git tag -a v1.3.1 -m "Add email specific validation for email field at Employee."`
- **18. Verifying Tag Creation**: Verify if the tag was created successfully.
    - 18.1. `git tag`
- **19. Pushing Changes and Tag**: Push the changes and the tag to the repository.
    - 19.1. `git push --tags`
    - 19.2. `git push`

![final_ca1merge2.png](https://i.postimg.cc/2jd6X8XS/final-ca1merge2.png)

- **21 - Complete the assignment**: After finishing both tasks, tag it as ca1-part2.
    - 21.1. `git tag -a ca1-part2`
    - 21.2. `git push --tags`
    - 21.3. `git tag` to verify if the tag was created.

## The Final Result

Here are some screenshots of the final result. The application is running properly, with
the new fields and validations added. The tests are also running properly.

### Tests

#### jobTitle

![final_ca1tests.png](https://i.postimg.cc/DZLZh2v5/final-ca1tests.png)

#### Invalid Email

![final_ca1invalidemail.png](https://i.postimg.cc/W1z13mpd/final-ca1invalidemail.png)

There are more tests in the EmployeeTestClass
here: [EmployeeTest.java](https://github.com/line-em/devops-23-24-JPE-1231866/blob/main/CA1/tutorial/basic/src/test/com/gregIturnquist/payroll/EmployeeTest.java)

### React UI

![final_ca1.png](https://i.postimg.cc/Kj58KJgM/final-ca1.png)

### DatabaseLoader

![final_ca1db.png](https://i.postimg.cc/gkYJ9Ffq/final-ca1db.png)

### Employee Class Constructor

![final_ca1employee.png](https://i.postimg.cc/FsDKNCvt/final-ca1employee.png)
You can find the Employee class
here: [Employee.java](https://github.com/line-em/devops-23-24-JPE-1231866/blob/main/CA1/tutorial/basic/src/main/java/com/greglturnquist/payroll/Employee.java)

# Alternative Solution

## Mercurial

For an alternative technological solution to version control that is not based on Git, one
potential option is Mercurial.
Here are some of the similarities between Mercurial and Git:

- **Branching and Merging:** Both Mercurial and Git support branching and merging,
  allowing developers to work on separate features or fixes concurrently and then merge
  them back into the main codebase.
- **Distributed Version Control:** Mercurial, like Git, is a distributed version control
  system (DVCS), enabling developers to work offline and collaborate effectively with
  distributed teams.
- **Committing Changes:** Both Mercurial and Git allow developers to commit changes to
  their local repositories, providing a detailed history of project changes over time.
- **Tagging and Versioning:** Mercurial and Git both support tagging and versioning,
  allowing developers to mark specific points in history as releases or milestones.

Some of the main differences I've found, however, are:

![mercurial.png](https://i.postimg.cc/s2tXbBrv/mercurial.png)

Considering the current assignment, here are some considerations to be made when making
the transition from Git to Mercurial:

### Requirements

- **Initialization and Setup:** Start by initializing a new Mercurial repository in the
  project directory or creating a new repository on a hosting service
  like [Sourcehub](https://hg.sr.ht/). Don't forget to install Mercurial on your machine.
  You can find instructions on how to do
  it [here](https://www.mercurial-scm.org/wiki/Download). You can create a `.hgignore`
  file to avoid tracking unnecessary files, similar to how it's done in Git.

### Mercurial Part 1

- **1. Initializing a New Mercurial Repository**: Initialize a new Mercurial repository using the following command:
  - `hg init`

- **2. Creating a .hgignore File**: Create a .hgignore file to avoid tracking unnecessary files.

- **3. Cloning the Tutorial Project from Bitbucket**
  - 3.1. `hg clone https://bitbucket.org/spring-guides/tut-react-and-spring-data-rest`

- **4. Navigating to the Project Directory**: Move to the basic directory of this project.
  - `cd ./tut-react-and-spring-data-rest/basic/`

- **5. Running the SpringBoot App**: Execute the command to run the SpringBoot app:
  - `./mvnw spring-boot:run`

- **6. Checking the Application**: Verify the application is running by accessing it through the browser: http://localhost:8080/

- **7. Creating a New Directory**: Now we need to move the tutorial folder into our previously created repository. If the repository exists on Github, Sourcehub, etc, clone it locally. Next, create a new directory named "CA1" within the repository to store the assignment files, including the tutorial folder.
  - 7.1. `hg clone https://bitbucket.org/line-em/devops-23-24-JPE-1231866`
  - 7.2. `mkdir CA1`

- **8. Navigating to the CA1 Directory**: Move to the newly created "CA1" directory.
  - 8.1. `cd ./CA1`

- **9. Going back to the tut-react-and-spring-data-rest folder**, delete the .git directory from the *“tut-react-and-spring-data-rest-main”* to avoid Mercurial tracking conflicts.

- **10. Moving the tut-react-and-spring-data-rest-main to the CA1 directory**:
  - 10.1 `mv ./YourFolderPath/tut-react-and-spring-data-rest-main ./CA1`
  - 10.2 You can rename the folder, if you want, to something like "tutorial".

- **11. Committing and Pushing to the Repository**:
  - 11.1. `hg add .`
  - 11.2. `hg commit -m “[CA1] - Add tutorial files to CA1”`

- **12. Warm Up**: After setting up, spend some time warming up, getting to know the project structure.

- **13. Now that everything is properly set up, you can start the assignment.** Tag this version as v1.1.0.
  - 13.1. `hg tag v1.1.0`

**14. Opening the project on IntelliJ** - To avoid problems, I recommend opening the folder "tutorial" directly on IntelliJ. This is to make sure the `pom.xml` is read correctly. We will work on the `basic/` folder that is inside the tutorial folder.
- 14.1. Click on "Open or Import" on IntelliJ, and select the "tutorial" folder.

**15 - Add the field jobYears to the Employee.**

**16 - Tests** - We will first commit the tests for the Employee class. After making your modifications, run the following commands:
- 16.0. `hg status` (to verify the files that were modified)
- 16.1. `hg commit -m “[JobYears] #Add tests to jobYears. Closes #3”`
- 16.2. `hg push`

**17 - Add methods to employees, including validation.** Do the same process as in the previous step, but now for the methods and validation of the jobYears field.
- 17.1. `hg commit -m “[JobYears] Add methods to jobYears, validating Employee attributes. Closes #2 #6”`
- 17.2. `hg push`

**18 - Optional - Add new entries**: If you want to add new entries to the database, you can do so by adding them to the DatabaseLoader class. After that, run the tests and the application to check if everything is working properly.

**19 - Finishing touches and remaining steps**: Minor fixes and UI changes can be made here, to accommodate the new field. For example, I added the jobYears field to the table header in the app.js file.
- After that, run the tests and the application to check if everything is working properly.

**20 - Tagging the version as v1.2.0**: After finishing the implementation, tag the version as v1.2.0.
- 20.1. `hg tag v1.2.0`

**21 - Complete the assignment**: After finishing the assignment, tag it as ca1-part1.
- 21.1. `hg tag ca1-part1`

### Mercurial Part 2

**1. Creating a New Branch**: Begin by creating a new branch for adding the email field.
- 1.1. `hg branch email-field`

**2. Verifying the Branch**: Make sure the branch was created successfully. You can do this by using:
- 2.1. `hg branches`

**3. Adding Email Field to Employee Class**: Add the email field to the Employee class and test it. Commit the tests for the Employee class first, following the same steps as before (status/add/commit/push, as needed).

**4. Adding Methods and Validation**: Add methods to Employee, including basic validation, and make fixes in the DatabaseLoader class, so the application can compile.

**5. Adding Email Field to UI**: Add the email field to the table in the app.js file. Verify that everything is working properly before moving on! Use `./mvnw spring-boot:run` to verify the changes.

**6. Merging Changes**: Now, merge the email-field branch into the main branch.
- 6.1. `hg update default`
- 6.2. `hg merge email-field`

**7. Creating a New Tag**: Create a new tag for this version.
- 7.1. `hg tag v1.3.0`

**8. Verifying Tag Creation**: Verify if the tag was created successfully.
- 8.1. `hg tags`

**9. Pushing Changes and Tag**: Push the changes and the tag to the repository.
- 9.1. `hg push`

**12. Creating a New Branch**: Begin by creating a new branch for fixing invalid email.
- 12.1. `hg branch fix-invalid-email`

**13. Verifying the Branch**: Make sure the branch was created successfully.
- 13.1. `hg branches`

**14. Adding Validation to Email Field**.

**15. Adding Tests**.

**16. Merging Changes**: Now, merge the fix-invalid-email branch into the main branch.
- 16.1. `hg update default`
- 16.2. `hg merge fix-invalid-email`

**17. Creating a New Tag**: Create a new tag for this version. This is a minor revision, so it will be v1.3.1.
- 17.1. `hg tag v1.3.1`

**18. Verifying Tag Creation**: Verify if the tag was created successfully.
- 18.1. `hg tags`

**19. Pushing Changes and Tag**: Push the changes and the tag to the repository.
- 19.1. `hg push`

**21 - Complete the assignment**: After finishing both tasks, tag it as ca1-part2.
- 21.1. `hg tag ca1-part2`
- 21.3. `hg tags` to verify if the tag was created.

## Conclusion

In summary, both Git and Mercurial offer comprehensive version control solutions, but Git is more widely adopted with a larger community and ecosystem. Git's branching model is powerful and flexible, while Mercurial prioritizes simplicity and consistency in its user interface. The choice between them often depends on personal preference and project needs, with Git being favored for its popularity and extensive tooling support, while Mercurial shines in stability.

# Author
- [Aline Emily](https://github.com/line-em), 1231866
- Repository: https://github.com/line-em/devops-23-24-JPE-1231866/
