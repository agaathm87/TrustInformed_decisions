# README 
ASC2-trustmodel

## What is ASC2?

ASC2 is a Multi-Agent System (MAS) framework designed for agents created with the AgentScript agent programming language. The language of ASC2 is based on AgentSpeak(L)/Jason, making it familiar to those with experience in agent-oriented programming.

ASC2 acts as a cross-compiler, translating high-level AgentScript code into lower-level executable languages. In the current version, the target language is Scala. ASC2 leverages the Akka actor framework, so at runtime, each ASC2 agent becomes an actor-based micro-system. For more details, see [this paper](https://arxiv.org/abs/2105.10916).

Because ASC2 agents are cross-compiled into Scala, you can use all mainstream JVM development and deployment tools (including CI/CD) with ASC2 out-of-the-box.

---

## How does it work?

ASC2 works as a cross-compiler that translates AgentScript into Scala. Each agent is compiled into an Akka actor, and the system can be run as a standard JVM application.

There are two main ways to use ASC2:

1. **As a compiler plugin with Maven or SBT**  
  This is the preferred approach for most projects, offering robust debugging and integration with existing Java/Scala projects. Your agent programs become a normal part of your project source, with access to compile-time checks.

2. **As a library to compile ASC2 code from text files at runtime**  
  This approach is similar to traditional agent programming languages and is useful if agent source code does not need to be available at compile-time. However, you lose some advantages such as static analysis and IDE integration.

---

## Requirements

- Java 11+
- SBT or Maven

---

## Getting Started

### 1. Create a Java or Scala project
Maven
The source code to this tutorial is located at https://github.com/mostafamohajeri/asc2-java-examples

With maven compiler plugin
Create a maven project, here we call it asc-test-java.

### 2. Add ASC2 to your build

#### Maven

Add the ASC2 Maven plugin to your `pom.xml`:

```xml
<build>
   <plugins>
      <plugin>
       <groupId>io.github.mostafamohajeri</groupId>
       <artifactId>scriptcc-maven-plugin</artifactId>
       <version>1.4.4</version>
       <configuration>
        <sourceDirectory>${asc2.source-directory}</sourceDirectory>
       </configuration>
       <executions>
        <execution>
          <phase>generate-sources</phase>
          <goals>
           <goal>scriptcc</goal>
          </goals>
        </execution>
       </executions>
      </plugin>
      <plugin>
        <groupId>net.alchim31.maven</groupId>
        <artifactId>scala-maven-plugin</artifactId>
        <version>4.8.0</version>
      </plugin>
   </plugins>
</build>
<properties>
   <asc2.source-directory>src/main/asl</asc2.source-directory>
</properties>
```
Note the ${asc2.source-directory} points to the directory containing the source code of the agents. This can be replaced by a string or better a property in the pom file:

<properties>
    ...
    <asc2.source-directory>src/main/asl</asc2.source-directory>
</properties>
The scala-maven-plugin is also needed as the generated sources by ASC2 are in Scala

<plugin>
    <groupId>net.alchim31.maven</groupId>
    <artifactId>scala-maven-plugin</artifactId>
    <version>4.8.0</version>
</plugin>

Adding these two plugins is basically enough for running a project, but, for more control over the agents we will add two more dependencies:
Add the required dependencies:

```xml
<dependencies>
   <dependency>
      <groupId>io.github.mostafamohajeri</groupId>
      <artifactId>agentscript-grounds_2.13</artifactId>
      <version>0.47</version>
   </dependency>
   <dependency>
      <groupId>io.github.mostafamohajeri</groupId>
      <artifactId>agentscript-commons_2.13</artifactId>
      <version>0.47</version>
   </dependency>
</dependencies>
```

---

### 3. Write your agent programs
Now we are ready to write our agent programs, which should be located in the same directory as the one passed to the compiler plugin. We define two agents pinger.asl and ponger.asl.
Place your `.asl` files in the directory specified by `asc2.source-directory`. Example agents:

**pinger.asl**
```asl
!init_pinging("ponger").

+!init(PongerAgentName) =>
   #println(Self + ": pinging " + PongerAgentName);
   #coms.inform(PongerAgentName,ping).

+pong => #println(Self + ": ponged by " + Source).
```

**ponger.asl**
```asl
+ping =>
   #println(Self + ": pinged by " + Source);
   #println(Self + ": ponging " + Source);
   #coms.inform(Source , pong).
```

---

### 4. Compile and run

Compile the project:
Now we can simply compile the project with $ mvn clean generate-sources which should result in creation of a package with two scala files in target/generated-sources/ directory.

To compile the agents we can use

$ mvn clean generate-sources scala:compile

(Note that IDE's like IntellijIdea take care of this process automatically, also it is not needed to clean, re-generate and re-compile everything all the time, this is just for learning purposes here)


```sh
mvn clean generate-sources scala:compile
```
Utilizing the agents
To run these agents we need to create a system (MAS). The following is an example of how this can be done:
Run your main class (see below for an example):

```java
import infrastructure.AgentRequest;
import infrastructure.AgentRequestMessage;
import infrastructure.MAS;
import akka.actor.typed.ActorSystem;
import scala.collection.immutable.Seq;
import java.util.List;

public class MainMaven {
  public static void main(String[] args) {
   MAS mas = MAS.build();
   var system = ActorSystem.create(mas.applyDefaults(), "MAS");
   system.tell(
        AgentRequestMessage.apply(
              toSeq(List.of(
                        new AgentRequest(asl.pinger_companion.create(), "pinger", 1),
                        new AgentRequest(asl.ponger_companion.create(), "ponger", 1)
                   )
              ),
              system
        )
   );
  }
  private static Seq<AgentRequest> toSeq(List<AgentRequest> l) {
   return scala.jdk.CollectionConverters.ListHasAsScala(l).asScala().toSeq();
  }
}
```
Now we can simply compile the whole project 
Run with:
```sh
mvn generate-sources scala:compile compile exec:java -Dexec.mainClass="MainMaven"
```

---
and by running our main file we'll get the output:

$ mvn generate-sources scala:compile compile  exec:java -Dexec.mainClass="MainMaven"
...
pinger: pinging ponger
ponger: pinged by pinger
ponger: ponging pinger
pinger: ponged by ponger

### Using the runtime compiler

You can also use ASC2 as a runtime library. Add a JSON file describing your agents:
For this approach we need the same dependencies as before, the only required dependencies are:

<dependencies>
    <dependency>
        <groupId>io.github.mostafamohajeri</groupId>
        <artifactId>agentscript-grounds_2.13</artifactId>
        <version>0.47</version>
    </dependency>
    <dependency>
        <groupId>io.github.mostafamohajeri</groupId>
        <artifactId>agentscript-commons_2.13</artifactId>
        <version>0.47</version>
    </dependency>
</dependencies>
this time we add a .json file to our asc2 source directory defining what type and number of agents are needed:

**input.json**
```json
{
  "agents": [
   {
    "name" : "pinger",
    "script_file" : "pinger.asl",
    "number": 1
   },
   {
    "name" : "ponger",
    "script_file" : "ponger.asl",
    "number": 1
   }
  ]
}
```
and then, the main file will look like:
**Main.java**
```java
import infrastructure.MAS;
import scriptcc.ScriptRunner;
import java.io.File;

public class Main {
   public static void main(String[] args) {
      scriptcc.ScriptRunner r = new ScriptRunner();
      File f = new File("src/main/asl/input.json");
      MAS system = r.createMas(f.getAbsolutePath(),false);
   }
}
```
Run with:
```sh
mvn exec:java -Dexec.mainClass="Main"
```

---
This approach as you can see is simpler as there is no need to set-up the compiler and its plugins and also there is no generated sources. However, there are many downsides, as there is no access to compiler's static analyzer, debugging break points, and caching that is already provided by maven.

## Project Structure and File Overview

This project is organized to separate agent logic, trust modeling, and backend integration. Below is an overview of the main files and their responsibilities:

- **decisionCosinesim.asl**  
  Coordinates agent selection, trust updates, and communication with Java logic.  
  Defines agent names, relationships, goal/trustor scores, derived beliefs, event handling, score acquisition, utility plans, and agent selection/trust update logic.

- **trustworthiness.asl**  
  Calculates and manages trustworthiness and untrustworthiness beliefs for agents.  
  Combines competence, benevolence, and integrity using defined weights, and records reasons for untrustworthiness.

- **benevolence.asl**  
  Manages benevolence intervals, processes offers, and updates benevolence beliefs for agents.  
  Allows the agent to learn and adapt benevolence beliefs over time.

- **competence.asl**  
  Handles competence calculation, updating, and management for agents and their actions.  
  Competence is assessed recursively, considering subplans and prerequisites.

- **integrity.asl**  
  Calculates and updates the integrity of agents based on their principles, intentions, and actions.  
  Integrity is measured as the alignment between principles, intentions, and actions.

- **AgentSelectionLogic.java**  
  Implements the Java backend for agent selection, belief storage, and vector similarity calculations.  
  Acts as the bridge between the agent logic in ASL and the underlying trust model computations.

---

### Project Structure Example

```
project-root/
│
├── src/
│   ├── main/
│   │   ├── asl/
│   │   │   ├── decisionCosinesim.asl
│   │   │   ├── trustworthiness.asl
│   │   │   ├── benevolence.asl
│   │   │   ├── competence.asl
│   │   │   └── integrity.asl
│   │   └── java/
│   │       └── AgentSelectionLogic.java
│   └── test/
│       └── ...
├── pom.xml
└── README.md
```

---

## Code Citations

This project uses or adapts code from the following sources (see `Code Citations.md` for details):

- [SPIMBench CosineUtil.java (Apache-2.0)](https://github.com/jsaveta/SPIMBench/blob/2b653aa621a8ee6c8c9ae1c87d227c17be781af3/src/eu/ldbc/semanticpublishing/util/CosineUtil.java)
- [cs7637-kbai VectorExt.java (unknown)](https://github.com/hellokathy/cs7637-kbai/blob/1001dd6b60255e24e9a9a500c58634b31bd04f11/project3/src/project3/VectorExt.java)
- [AIDE Hybird.java (unknown)](https://github.com/jinfenglin/AIDE/blob/2743fc5cc750883abe8e11b7032f7bda313fe30f/src/recommandation/Hybird.java)
- [tfidf-similarity TfidfSimilarityCalculator.java (unknown)](https://github.com/nameof/tfidf-similarity/blob/eebc193ca9619f35251e80824080fe7cdb8137d9/src/main/java/com/nameof/tfidf/similarity/TfidfSimilarityCalculator.java)
- [agentscript (MIT)](https://github.com/mostafamohajeri/agentscript)
- [PaperTrustworthiness (MIT)](https://github.com/basten-leeftink/PaperTrustworthiness)
- [Trust-dynamics (MIT)](https://github.com/FrederiqueLalieu/Trust-dynamics)
- [Benevolence-paper (MIT)](https://github.com/ZurekTom/Benevolence-paper)


---

This documentation is structured to be clear, replicable, and extendable for bachelor students and new developers.  
For more details on the ASC2 language and framework, see the official ASC2 repository and the referenced papers.