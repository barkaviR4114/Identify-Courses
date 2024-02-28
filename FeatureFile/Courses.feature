Feature: Identify Courses
 
		Scenario: Search for Web Development Courses
		  Given Navigate to the coursera home page
		  When the user clicks on the inputBox
		 	And the user selects the checkBox
		 	Then verify the details of the first course
		 	And verify the details of the second course
		 	
		Scenario: Display the languages and levels
			Given navigate to the coursera home page
			When the user clicks on show more
			Then get the languages and their count
			And get the levels and their count
			
		Scenario: Fill the form
			Given navigate to the Coursera home page
			When the user clicks on For Enterprises
			And the user clicks on Coursera for campus
			And scroll to the form
			Then enter the details in the form 
			And verify the error message