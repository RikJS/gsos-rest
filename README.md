Gsos Rest Service

url: http://localhost:8080/rest/

endpoints:

- GET:
 /bmi/{weight}/{length}

Arguments:
weight: weight in kilos
length: length in centimeters

- GET:
/calorieIntake/{weight}/{length}/{age}/{gender}/{activityLevel}

Arguments:
weight: weight in kilos
length: length in centimeters
age: age in years
gender: male or female
activityLevel: sedentary, moderatly_active or active 

