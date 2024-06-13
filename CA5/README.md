# Technical Report CA5: Jenkins Project

## Introduction

The Jenkins pipeline scripts created in this CA are designed to automate the build, test, archive and others stages of a Gradle project located in the `CA2/Part1/gradle_basic_demo` and `CA2/Part2` directories.

This will allow us to understand how Jenkins works, and the various ways it can automate our projects, saving us a lot of effort and time.

## Prerequisites

To follow this tutorial, you need to have **Jenkins** installed and properly configured. This includes setting up the necessary Jenkins plugins - in this case, **publishHTML, Javadoc and Docker related plugins**.

You can install Jenkins on Docker, using the following image:
![Jenkins](images/jenkinsimage.png)

You might also need to configure Jenkins authentication if it's your first time using it. You can follow the instructions on the `docker logs`

![jenkins auth](images/jenkins_auth.png)

## CA5 Part 1

The first part of the CA5 is to practic with our project Gradle Basic Demo. So that's what we're going to do!

Our Jenkinsfile for this project should include the following tasks: Checkout, Assemble, Test and Archive. Please remember that it follows the groovy language and syntax. Here's what mine looks like:

```groovy
pipeline {
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking Out...'
                script {
                    git branch: 'main',
                        url: 'https://github.com/line-em/devops-23-24-JPE-1231866.git'
                }
            }
        }
        stage('Assemble') {
            steps {
                dir('./CA2/Part1/gradle_basic_demo') {
                    echo 'Assembling...'
                    sh './gradlew assemble'
                }
            }
        }
        stage('Test') {
            steps {
                dir('./CA2/Part1/gradle_basic_demo') {
                    echo 'Testing...'
                    sh './gradlew test'
                }
            }
            post {
                always {
                    junit '**/build/test-results/**/*.xml'
                }
            }
        }
        stage('Archive') {
            steps {
                echo 'Archiving...'
                archiveArtifacts artifacts: 'CA2/Part1/gradle_basic_demo/build/**/*.jar', onlyIfSuccessful: true
            }
        }
    }
}
```

Please verify if all the directories are alright, as this can cause some trouble. Also, please take note that this repository is public - for private repositories, you might need to tweak the process to include your credentials!

We also need to create our pipeline at Jenkins. At your **Dashboard**, go to **New Item > Pipeline** and name it the way your prefer. Mine is *ca5_part1*.

You need to configure Jenkins to find and run our pipeline script properly though, so on the Configuration, go to **Pipeline** and do the following:

- Select **Pipeline Script on SCM** on Definition
- Choose **Git**
- Add your repository and credentials, if you have any.
- Choose your **branch**. I specified that mine runs on *origin/main*.
  ![alt text](images/pipeline_branch.png)
- Specify your Jenkinsfile path. Mine is on *CA5/Part1/Jenkinsfile*.
- If you encounter any problems, disable **Lightweight Checkout**. Mine is checked off.

You might need to tweak this process depending on your configurations and project. Fortunately, Jenkins is very intuitive and when certain tasks fail, you can easily detect what went wrong:

![alt text](images/part1_process.png)

If your pipeline runs successfully, you should encounter a view such as this, fully in green:

![alt text](images/part1_result.png)
![alt text](images/part1_result2.png)

You can rename your builds for an easier time searching, and also check the results of several steps, such as the Tests:

![alt text](images/part1_tests.png)

Now we're ready for the second part for this assignment!

# Author
- [Aline Emily](https://github.com/line-em), 1231866
- Repository: https://github.com/line-em/devops-23-24-JPE-1231866/