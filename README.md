# Scheduler
A simple console program to check the time availability of two people for arranging a meeting
## Prerequisites
Before you begin, ensure you have met the following requirements:

- You have installed a recent version of Java JDK (version 8 or above).
- You have a basic understanding of Java and Gradle.
- You have Gradle installed on your machine.

## Running the Application
To run the Scheduler application, follow these steps:

1. First, clone the repository to your local machine. You can do this with the following command:
```console
git clone https://github.com/Bszabat/scheduler
```
2. build the project using:
```console
gradle build
```
3. Run the application using:
```console
gradle run
```
When you run the application, it will create two Calendar objects representing two different schedules. 
It will then find the common free slots between these two schedules that are at least 30 minutes long, and print these slots to the console.

You can change the Input by modifing `Calendars` in App.java file:
```java
Calendar calendar = new Calendar(start time: "09:00",  end time: "18:00" , planned meetings: Arrays.asList(
             new String[]{"09:00", "10:30"},
             new String[]{"12:00", "13:00"},
             new String[]{"16:00", "18:00"}
             ));
```
and the duration of the meeting by changing `duration` in this line:
```java
List<int[]> commonSlots = calendar.findCommonFreeSlots(<duration>, calendar2);
```
