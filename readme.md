# Demo to show bug when using the new `DefaultBatchConfiguration` extension

When the `DefaultBatchConfiguration` gets extended and overridden in a slightly more complex scenario, this error
happens on every startup:

s.c.a.AnnotationConfigApplicationContext : Exception encountered during context initialization - cancelling refresh
attempt: org.springframework.beans.factory.BeanDefinitionStoreException: Invalid bean definition with name '
jobRepository' defined in class path resource [org/example/SpringBatchDemo.class]: @Bean definition illegally overridden
by existing bean definition: Generic bean:
class [org.springframework.batch.core.repository.support.JobRepositoryFactoryBean]; scope=; abstract=false;
lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null;
factoryMethodName=null; initMethodNames=null; destroyMethodNames=null

Version: Spring Boot 3 RC1, using Spring Batch 5 RC1.

## Does this even start up in generell?

Yes it does. To test this, just comment out `SpringBatchDemo` and Spring Boot should start up completely normal.

P.S.: The batch steps don't make much, they're basically empty, they're just there to take part in triggering the bug.

## Run this demo

### Prerequisites

A running MariaDB is needed, with an account named "demo", password "user". To create such a user-account, you can run,
as admin with all needed rights, the script `createDemoUser.sql`. Then login as that user (**not as the admin!**) and
create a database named "demo". You can use the script `createDatabase.sql` for that.

The database doesn't really matter, any will do, and it can be configured in the `resources/application.properties`.

### Starting it

Either open this in your favorite IDE and start the Spring Service, like every other Spring service, or
run `gradle bootJar` and launch the jar with `java -jar build/libs/SpringBatchBugJobRepo.jar`.