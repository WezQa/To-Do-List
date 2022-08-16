# To-Do-List
 Practical Project
Coverage: 50%


I was given the task to create a To-do list, which a user would interact with using a front end html website.  The user would require full CRUD functionality.

## Getting Started

Created a brand new repo.  Used Chris'(Trainer) cat repo as a template to start building and structuring my project correctly.

### Prerequisites

I had to install Eclispe, which is what I used as my IDE for Java.  Alongside this there were also installs for maven and a mysql editor, this would allow my Eclispe IDE to interface with the database I would create.  To create the front end I would need to download and install Visual Studio Code.


I would also need a GitHub account to push my work to.

I created a Trello account to use as a project management tool, acting as my own project manager it would be a good way to update and keep track of my progress.

### Installing

To install Eclispe

The fisrt step is go to https://www.eclipse.org/downloads/ and download the latest version.
```
Open the download and run the install wizard, once completed open Eclipse
```
To install Mysql

Then go to https://dev.mysql.com/downloads/workbench/ and download the latest version.
```
Open the download and run the install wizard, once completed open MySql

To install Visual Studio Code

Then go to https://code.visualstudio.com/download and download the latest version.
```
Open the download and run the install wizard, once completed open Visual Studio Code.

## Running the tests

I used Junit tests to run all tests and also mockito is some areas.

### Unit Tests

I caried out testing on my enities as well was other areas of the code.  This was to make sure that the crud functionality is working as intended, as this is what the user required.

```
@Test
	public void constructors_User_User() {
		// Create Cat
		User Userone = new User();

		assertTrue(Userone instanceof User == true);

		User Usertwo = new User(0, "Winston");

		assertTrue(Usertwo instanceof User == true);
		assertEquals("Winston", Usertwo.getName());
```

### Integration Tests 

I used Mockito integration testing, this allows me to test if the controller is working for each object and each method called in the controller.

```
@Test
	public void testGetAllWorkoutChecklist() {
		List<WorkoutChecklist> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(new WorkoutChecklist("Bench Press", 50l, 8l, true));
		MOCK_LIST.add(new WorkoutChecklist("Squats", 50l, 8l, true));
		when(service.readAllWorkoutChecklists()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, controller.getWorkoutChecklist());
```
## Deployment

Run maven clean package to make a new .jar file if any changes was made to the code.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

Westley Defoe

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

Piers Barber
Christopher Yiangou

