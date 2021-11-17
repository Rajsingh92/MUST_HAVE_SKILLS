# AWS SWF – Simple Workflow

* AWS SWF makes it easy to build applications that coordinate work across distributed components
* SWF makes it easier to develop asynchronous and distributed applications by providing a programming model and infrastructure for coordinating distributed components, tracking and maintaining their execution state in a reliable way
* SWF does the following
  * stores metadata about a workflow and its component parts.
  * stores task for workers and queues them until a Worker needs them.
  * assigns task to workers, which can run either on cloud or on-premises
  * routes information between executions of a workflow and the associated Workers.
  * tracks the progress of workers on Tasks, with configurable timeouts.
  * maintains workflow state in a durable fashion
* SWF helps coordinating tasks across the application which involves managing intertask dependencies, scheduling, and concurrency in accordance with the logical flow of the application.
* SWF gives full control over implementing tasks and coordinating them without worrying about underlying complexities such as tracking their progress and maintaining their state.
* SWF tracks and maintains the workflow state in a durable fashion, so that the application is resilient to failures in individual components, which can be implemented, deployed, scaled, and modified independently
* SWF offers capabilities to support a variety of application requirements and is suitable for a range of use cases that require coordination of tasks, including media processing, web application back-ends, business process workflows, and analytics pipelines.

### Simple Workflow Concepts

![](https://i1.wp.com/media.amazonwebservices.com/blog/swf_parts_1.png?zoom=1.25&resize=544%2C726&ssl=1 "AWS SWF Components")

* **Workflow**
  * Fundamental concept in SWF is the **Workflow**, which is the automation of a business process
  * A workflow is a set of activities that carry out some objective, together with logic that coordinates the activities.
* **Workflow Execution**
  * A **workflow execution **is a running instance of a workflow
* **Workflow History**
  * SWF maintains the state and progress of each workflow execution in its **Workflow History**, which saves the application from having to store the state in a durable way.
  * It enables applications to be stateless as all information about a workflow execution is stored in its workflow history.
  * For each workflow execution, the history provides a record of which activities were scheduled, their current status, and their results. The workflow execution uses this information to determine next steps.
  * History provides a detailed audit trail that can be used to monitor running workflow executions and verify completed workflow executions.
  * Operations that do not change the state of the workflow _for e.g. polling _execution do not typically appear in the workflow history
  * **Markers**
    can be used to record information in the workflow history of a workflow execution that is specific to the use case
* **Domain**
  * Each workflow runs in an AWS resource called a **Domain**, which controls the workflow’s scope
  * An AWS account can have multiple domains, with each containing multiple workflows
  * Workflows in different domains cannot interact with each other
* **Activities**
  * Designing an SWF workflow, **Activities**
    need to be precisely defined and then registered with SWF as an **activity type **with information such as name, version and timeout
* **Activity Task & Activity Worker**
  * An **Activity Worker **is a program that receives activity tasks, performs them, and provides results back. An activity worker can be a program or even a person who performs the task using an activity worker software
  * Activity tasks—and the activity workers that perform them can
    * run synchronously or asynchronously, can be distributed across multiple computers, potentially in different geographic regions, or run on the same computer,
    * be written in different programming languages and run on different operating systems
    * be created that are long-running, or that may fail, time out require restarts or that may complete with varying throughput & latency
* **Decider**
  * A **Decider **implements a Workflow’s coordination logic.
  * Decider schedules activity tasks, provides input data to the activity workers, processes events that arrive while the workflow is in progress, and ends \(or closes\) the workflow when the objective has been completed.
  * Decider directs the workflow by receiving decision tasks from SWF and responding back to SWF with decisions. A decision represents an action or set of actions which are the next steps in the workflow which can either be to schedule an activity task, set timers to delay the execution of an activity task, to request cancellation of activity tasks already in progress, and to complete or close the workflow.
* Workers and Deciders are both stateless, and can respond to increased traffic by simply adding additional Workers and Deciders as needed
* Role of  SWF service is to function as a reliable central hub through which data is exchanged between the decider, the activity workers, and other relevant entities such as the person administering the workflow.
* Mechanism by which both the activity workers and the decider receive their tasks \(activity tasks and decision tasks resp.\) is by polling the SWF
* SWF allows “long polling”, requests will be held open for up to 60 seconds if necessary, to reduce network traffic and unnecessary processing
* SWF informs the decider of the state of the workflow by including with each decision task, a copy of the current workflow execution history. The workflow execution history is composed of events, where an event represents a significant change in the state of the workflow execution
  _for e.g events would be the completion of a task, notification that a task has timed out, or the expiration of a timer that was set earlier in the workflow execution_
  . The history is a complete, consistent, and authoritative record of the workflow’s progress

### Workflow Implementation & Execution

1. Implement **Activity workers **with the processing steps in the **Workflow**
   .
2. Implement **Decider ** with the coordination logic of the **Workflow**
   .
3. Register the **Activities **and **workflow **with SWF.
4. Start the **Activity workers **and **Decider**. Once started, the decider and activity workers should start polling Amazon SWF for tasks.
5. Start one or more executions of the Workflow. Each execution runs independently and can be provided with its own set of input data.
6. When an execution is started, SWF schedules the initial decision task. In response, the decider begins generating decisions which initiate activity tasks. Execution continues until your decider makes a decision to close the execution.
7. View and Track workflow executions

[  
](https://www.amazon.com/Certified-Solutions-Architect-Official-Study-ebook/dp/B01M6W6WYD/ref=as_li_ss_il?ie=UTF8&qid=1529919794&sr=8-1&keywords=aws+certification&linkCode=li2&tag=jayendrapatil-20&linkId=5529a97f2764184c701dca11e1974da0)

