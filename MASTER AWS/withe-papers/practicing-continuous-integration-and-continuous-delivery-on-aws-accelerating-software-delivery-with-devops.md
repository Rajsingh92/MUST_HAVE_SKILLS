# Practicing Continuous Integration and Continuous Delivery on AWS

---

---

## The Challenge of Software Delivery

operations stability and rapid feature  
 development

AWS now offers these CI/CD capabilities as a set of developer services: AWS  
 CodeStar,3 AWS CodeCommit,4 AWS CodePipeline,5 AWS CodeBuild,6 and  
 AWS CodeDeploy.7

---

## What is Continuous Integration and Continuous Delivery/Deployment?

---

### Continuous Integration

> _Continuous integration \(CI\) is a software development practice where  
>  developers regularly merge their code changes into a central repository, after  
>  which automated builds and tests are run_

### Continuous Delivery and Deployment

> _Continuous delivery \(CD\) is a software development practice where code  
>  changes are automatically built, tested, and prepared for production release_

### Continuous Delivery Is Not Continuous Deployment

> _One misconception about continuous delivery is that it means every change  
>  committed is applied to production immediately after passing automated tests_

## Benefits of Continuous Delivery

---

> _automating the process, improving developer productivity, improving code  
>  quality, and delivering updates to your customers faster_

Automate the Software Release Process

Improve Developer Productivity

Improve Code Quality

Deliver Updates Faster

## Implementing Continuous Integration and Continuous Delivery

---

### ![](/assets/cicd1.png)

### A Pathway to Continuous Integration/Continuous Delivery

![](/assets/cicd2.png)

### Teams![](/assets/cicd3.png)

### Testing Stages in Continuous Integration and Continuous Delivery

![](/assets/teststage.png)

**Unit Testing** – Tests a specific section of code to ensure the code does what it is expected to do. The unit testing is performed by software developers during the development phase. At this stage, a static code analysis, data flow analysis, code coverage, and other software verification processes can be applied.

**Integration Testing **– Verifies the interfaces between components against software design. Integration testing is an iterative process and facilitates building robust interfaces and system integrity.

**Component Testing **– Tests message passing between various components and their outcomes. A key goal of this testing could be idempotency in component testing. Tests can include extremely large data volumes, or edge situations and abnormal inputs.

**System Testing **– Tests the system end-to-end and verifies if the software satisfies the business requirement. This might include testing the UI, API, backend logic, and end state.

**Performance Testing** – Determines the responsiveness and stability of a system as it performs under a particular workload. Performance testing also is used to investigate, measure, validate, or verify other quality attributes of the system, such as scalability, reliability, and resource usage. Types of performance tests might include load tests, stress tests, and spike tests. Performance tests are used for benchmarking against predefined criteria.

**Compliance Testing** – Checks whether the code change complies with the requirements of a nonfunctional specification and/or regulations. It determines if you are implementing and meeting the defined standards.

**User Acceptance Testing** – Validates the end-to-end business flow. This testing is executed by an end user in a staging environment and confirms whether the system meets the requirements of the requirement specification. Typically, customers employ alpha and beta testing methodologies at this stage.

**Canary test** -- can be completed by deploying the new code only on a small subset of servers or even one server,

or one Region before deploying code to the entire production environment.

### Building the Pipeline

![](/assets/budpipline.png)

### Pipeline Integration with AWS CodeBuild

Software can be built through the inclusion of a buildspec.yml file that identifies each of the build steps, including pre- and post- build actions, or specified actions through the CodeBuild tool

### Pipeline Integration with Jenkins

**the AWS Code Pipeline Plugin.--** The Pipeline plugin allows complex workflows to be described using Groovy-like domain-specific language and can be used to orchestrate complex pipelines.

## Deployment Methods

---

![](/assets/demploymethodt.png)

All at Once \(In-Place Deployment\)

Rolling Deployment

Immutable and Blue/Green Deployment

## Database Schema Changes

---

**In general, those tools employ some variant of the following methods:  
**

* Add a table to the database where a database version is stored.
* Keep track of database change commands and bunch them together in
  versioned change sets. In the case of Liquibase, these changes are stored
  in XML files. Flyway employs a slightly different method where the
  change sets are handled as separate SQL files or occasionally as separate
  Java classes for more complex transitions.
* When Liquibase is being asked to upgrade a database, it looks at the
   metadata table and determines which change sets to run in order to
   make the database up-to-date with the latest version.

## Summary of Best Practices

---

**Do:  
**

1. Treat your infrastructure as code

o Use version control for your infrastructure code.

o Make use of bug tracking/ticketing systems.

o Have peers review changes before applying them.

o Establish infrastructure code patterns/designs.

o Test infrastructure changes like code changes.

1. Put developers into integrated teams of no more than 12 self-sustaining
   members.

3,  Have all developers commit code to the main trunk frequently, with no  
 long-running feature branches.

4, Consistently adopt a build system such as Maven or Gradle across your  
 organization and standardize builds.

5,  Have developers build unit tests toward 100% coverage of the code base.

6,  Ensure that unit tests are 70% of the overall testing in duration, number,  
 and scope.

7,  Ensure that unit tests are up-to-date and not neglected. Unit test failures  
 should be fixed, not bypassed.

8, Treat your continuous delivery configuration as code.

9, Establish role-based security controls \(that is, who can do what and  
 when\).

o Monitor/track every resource possible.

o Alert on services, availability, and response times.

o Capture, learn, and improve.

o Share access with everyone on the team.

o Plan metrics and monitoring into the lifecycle.

10,  Keep and track standard metrics.

o Number of builds.

o Number of deployments.

o Average time for changes to reach production.

o Average time from first pipeline stage to each stage.

o Number of changes reaching production.

o Average build time.

1, Use multiple distinct pipelines for each branch and team.

**Don’t:  
**

 Have long-running branches with large complicated merges.

 Have manual tests.

 Have manual approval processes, gates, code reviews, and security  
 reviews.

## 

---



