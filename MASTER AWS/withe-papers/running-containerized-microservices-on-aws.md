# Running Containerized Microservices on AWS

---

---

---

## Introduction

**microservice characteristics:**

• Componentization via services

• Organized around business capabilities

• Products not projects

• Smart endpoints and dump pipes

• Decentralized governance

• Decentralized data management

• Infrastructure automation

• Design for failure

• Evolutionary design

**twelve factors app:**cover four key areas: deployment, scale, portability, and architecture:

1. Codebase - One codebase tracked in revision control, many deploys

2. Dependencies - Explicitly declare and isolate dependencies

3. Config - Store configurations in the environment

4. Backing services - Treat backing services as attached resources

5. Build, release, run - Strictly separate build and run stages

6. Processes - Execute the app as one or more stateless processes

7. Port binding - Export services via port binding

8. Concurrency - Scale out via the process model

9. Disposability - Maximize robustness with fast startup and graceful shutdown

10. Dev/prod parity - Keep development, staging, and production as similar as possible

11. Logs - Treat logs as event streams

12. Admin processes - Run admin/management tasks as one-off processes

## Componentization Via Services

## Organized Around Business Capabilities

## Products Not Projects

## Smart Endpoints and Dumb Pipes

## Decentralized Governance

## Decentralized Data Management

**design pattern can be used in microservice:**

• Proxy – Helps provide a surrogate or placeholder for another object to control access to it.

• Visitor – Helps represent an operation to be performed on the elements of an object structure.

• Interpreter – Helps map a service to data store semantics.

• Observer – Helps define a one-to-many dependency between objects so that when one object changes state, all of its dependents are notified and updated automatically.

• Decorator – Helps attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to sub-classing for extending functionality.

• Memento – Helps capture and externalize an object's internal state so that the object can be returned to this state later.

## Infrastructure Automation

## Design for Failure

## Evolutionary Design

**design pattern can be used in microservice:**

• Sidecar extends and enhances the main service.

• Ambassador creates helper services that send network requests on behalf of a consumer service or application.

• Chain provides a defined order of starting and stopping containers.

• Proxy provides a surrogate or placeholder for another object to control access to it.

• Strategy defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.

• Iterator provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

![](/assets/awsdockerbg.png)

## Conclusion



