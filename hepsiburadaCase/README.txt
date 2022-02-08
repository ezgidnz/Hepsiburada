REaADME.txt
1) Tests are created with BDD cucumber and Java Selenium
2) This is a maven project

3) For the manual tests for login you can find feature file from the following directory;
	..\HepsiBurada\hepsiburadaCase\src\test\java\com\hepsiburada\features\manualTest.feature
	
4) For the automation cases ,for adding product to the basket without login, you can find feature file from the following directory;
	..\HepsiBurada\hepsiburadaCase\src\test\java\com\hepsiburada\features\automationTest.feature
	and for the feature file of automation step file from the following directory;
	..\HepsiBurada\hepsiburadaCase\src\test\java\com\hepsiburada\steps\automationTestStep.java
	
	NOTE: chrome Driver is added to the..\HepsiBurada\hepsiburadaCase\chromedriver.exe

5) For Api automation test cases you can find it the feature file from the following directory;
	..\HepsiBurada\hepsiburadaCase\src\test\java\com\hepsiburada\apiTesting\groceryApiTest.feature
	you can find it the Step file from the following directory;
	..\HepsiBurada\hepsiburadaCase\src\test\java\com\hepsiburada\apiTesting\groceryApiTest.java
	
	
	NOTE:
	
	I created a mock service (json server) for api testing and i added "db.json" file under the following directory;
    ..\HepsiBurada\hepsiburadaCase\db.json
	
	Also, in the @Before part of api test automation i am running a command on java code "Runtime.getRuntime().exec("cmd /c json-server --watch db.json");"
	
	To not have cases fail you should add following to framework (windows);
	
	npm install -g json-server
	
	Also, you should download node.js
	
	run command "npm install json-server"
	
	this commands are used
	the db.json file created and values are added into it and go to its directory Also you should run to use json server from the below command
	"json-server --watch db.json"
	the command is added to the code you dont need to run it from cmd also
	

	
	NOTE 2: 
	
	*get and post to this page;
	http://localhost:3000/data/

	*and get according to name from this link;
	http://localhost:3000/data?name=apple
