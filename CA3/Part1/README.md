# Tutorial: Setting up our projects with Virtual Machines (Virtual Box)

In this tutorial, we'll walk through running our previous projects ( spring boot tutorial
basic project and gradle_basic_demo ) on a virtual machine.

I made my VM based on the lecture - updating only the ubuntu version. Please verify what
you need for your VM - Each version
of Ubuntu, etc, may need several tweaks in this process.

If you encounter any issues, please verify the network configurations with the **net-tools
** package, and the **ifconfig** command.

<!-- TOC -->
* [Tutorial: Setting up our projects with Vagrant](#tutorial-setting-up-our-projects-with-vagrant)
    * [Step 1: Preparation and Dependency Installation](#step-1-preparation-and-dependency-installation)
      * [Cloning our repository](#cloning-our-repository)
    * [Step 2: Spring Boot Project (CA2 - Part 2)](#step-2-spring-boot-project-ca2---part-2)
      * [Spring Boot Tutorial Basic Project](#spring-boot-tutorial-basic-project)
    * [Step 3: Gradle Chat (CA2 - Part 1)](#step-3-gradle-chat-ca2---part-1)
      * [Gradle Basic Demo](#gradle-basic-demo)
    * [Step 3: Conclusion](#step-3-conclusion)
<!-- TOC -->

### Step 1: Preparation and Dependency Installation

First, ensure you have at least the necessary dependencies installed, including **nvm** or
similar for Node.js, **Java JDK** and **git**. I also used some useful utilities, such as
**nano** (for text editing) and **croc** (for file transfers - here’s
their [documentation](https://schollz.com/tinker/croc6/)). You can use what you feel most
comfortable with.

```bash
sudo apt update
sudo apt install git
sudo apt install nvm
nvm -v
nvm install latest
```

You have some options regarding the JDK, depending on the version you want to install.
Here’s what I did to get Java 17 manually:

```bash
# Getting the .tar.gz file, and manually binding the $JAVA_HOME. You can choose any jdk version you want - I used OpenJDK Java 17.
wget -c https://download.java.net/java/GA/jdk17.0.1/2a2082e5a09d4267845be086888add4f/12/GPL/openjdk-17.0.1_linux-x64_bin.tar.gz | tar -xz
echo "JAVA_HOME=/home/YOUR_USER/jdk-17.0.1" | sudo tee -a /etc/environment
source /etc/environment
```

Otherwise, you might also install it like this, if possible in your environment:

```bash
sudo apt install openjdk-17-jdk
```

Make sure to install the version that suits your needs.

#### Cloning our repository

Now - to clone our repository. As my repository is private, I'll use a generated SSH key
to connect the VM to my GitHub account. I always follow this steps from
the [Github Documentation](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent).
You can, alternatively, modify your repository to public. In the end, here’s what you need
to do:

```bash
git clone git@github.com:line-em/devops-23-24-JPE-1231866.git
```

Now please check if all the dependencies are properly working. If the cloning happened
without a hitch, we can continue to the next step.

### Step 2: Spring Boot Project (CA2 - Part 2)

#### Spring Boot Tutorial Basic Project

Our objective here is to run the spring boot application on the VM, and access it from our
host machine browser. Please check your configurations, the IP, the port, how your setup
is configured.
In my project, as per the assignment/lesson instructions, the final url will
be http://192.168.56.5:8080/.

For that, we will need to navigate to our project root (mine is at ./CA2/Part2/), and run
the following tasks:

```bash
./gradlew build 
./gradlew bootRun
```

The build command is necessary to build our front-end files, and the bootRun, to run the
application. You should run these tasks in this order.

If you encounter errors related to Node.js, such
as `node: /lib/x86_64-linux-gnu/libc.so.6: version GLIBC_2.25' not found (required by node)`,
rectify this by changing the Node version in `build.gradle` to 16.

You can use nvm to download an earlier Node version by running:

```BASH
 nvm install 16 
 nvm use 16
```

You should now be able to successfully access our web page, http://192.168.56.5:8080/.

### Step 3: Gradle Chat (CA2 - Part 1)

#### Gradle Basic Demo

The objective, similarly to the previous task, is to run the server task at the VM, and
the client task at your host machine. For that, first, navigate into your project folder -
mine is at `./CA2/Part1/gradle_basic_demo.´`

I suggest running a basic command first, to check if all is fine in your project. A
command such as:

```bash
./gradlew tasks
```

If you encounter any problems here, we should fix it right away!

One common problem you might encounter is not having the `gradle-wrapper.jar` around,
needed for any ./gradlew commands to run. This may happen due to .`gitignore`
configurations, which might exclude some .jar files!

If this is your case, you can either add it to your repository, or, if you’d rather not
add the .jar file, you can quickly use a CLI file-transfer tool like croc to send
the `gradle-wrapper.jar` to the VM. That way, you can preserve the `gitignore` file as it
was. Run the command again - it should be working now!

With the issue resolved, now we can actually run our server:

```bash
./gradlew runServer
```

To complete the task, we will run the client on our host machine.

If you encounter issues while running the `runClient` task, please check the IP address it
connects to, and change it according to your VM configurations. In my case,
it’s `192.168.56.5`, instead of localhost. You can do this change locally. This adjustment
should enable a successful connection without further issues.

That way, the connection between the server and the client is secured, and we can use our
chat application as expected.

### Step 3: Conclusion

Running the server on the VM offers several benefits, including isolation from host
environment dependencies, making it reproducible across environments, and with the ability
to simulate real-world deployment scenarios more accurately.

About each of those benefits, we can say:

- **Isolation**: The isolation minimizes the risk of conflicts or unintended interactions
  with other software installed on the host system, providing a more stable and
  predictable environment for development and testing.
- **Being easily reproducible**: Virtual machines can be easily cloned or duplicated,
  allowing you to replicate the exact server setup across different development, testing,
  and production environments.
- **Simulating real-world scenarios:** VMs provide a sandboxed environment that better
  mimics real-world deployment scenarios. By running the server on a VM, you can validate
  its performance, scalability, and resilience under realistic conditions, helping you
  identify and address potential issues before deploying to production.
