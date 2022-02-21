Coverage: 82%
# Inventory Management System - Project

A CLI (Command Line interface) based upon Java which will interact with a database exhibiting CRUD (Create, Read, Update, Delete) Functionality

## Getting Started

STEP 1: Run IMS-Project-Schema.sql to create the database
STEP 2: Change db.properties to match your database

This should create an instance of a database on your local machine in which the project can interact with

### Prerequisites

Recommended prior installations

```
Java (1.8 or Higher)
Maven (3.8.4 or Higher)
```

### Installing

Java JDK Installation

Follow video Below for step by step guide

```
https://www.youtube.com/watch?v=IJ-PJbvJBGs
```

Maven Installation

Follow video Below for step by step guide

```
https://www.youtube.com/watch?v=3ODSQ0EpoQI
```

Eclipse Installation

Download and Installation - Follow Steps on their download page selecting "ECLIPSE IDE FOR JAVA DEVELOPERS"

```
https://www.eclipse.org/downloads/packages/installer
```

Change workstation settings to fit the project

```
(Window -> Preferences -> Java -> Installed JRE) Make sure your local JDK is selected not the one that comes preinstalled with eclipse
```

```
(Project -> Properties -> Java Compiler) Make sure the Java Compliance box is ticked otherwise certain tests will fail 
```


## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Unit tests test parts of a system in isolation, this provides a more granular insight into potential issues.

```
@Test
public void testReadAll() {
	List<Customer> customers = new ArrayList<>();
	customers.add(new Customer(1L, "jordan", "harrison", 25, "07288765432"));

	Mockito.when(dao.readAll()).thenReturn(customers);

	assertEquals(customers, controller.readAll());

	Mockito.verify(dao, Mockito.times(1)).readAll();
}
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Euan Black** - *Updated Version* - [EuanYeet](https://github.com/EuanYeet)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

## Acknowledgements

- ProgrammingKnowledge for his Java JDK and Maven install guide (https://www.youtube.com/channel/UCs6nmQViDpUw0nuIx9c_WvA)

