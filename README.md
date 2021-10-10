# IBM assignment

The web application and its MySQL database is in google cloud and can be accessed with this link:
https://pure-oxygen-328214.appspot.com/


# Backend was developed using Spring Boot

# For image processing I used Google Vision API

# Client side was built using Vue Js 

Vue js code is inside .html as a script tag

## To build the app

The credentials for api and cloud connectivity are inside the code, so all there is to do is just run the spring boot app.
I used IntelliJ IDE to open up the project, dependencies are updated automatically.
### Note:
After I uploaded the app to Google Cloud and wanted to clean up css, it started throwing cors errors out of nowhere, so I left the css as it is in the cloud, and the app might not fetch rest api data when built manually on local machine. 

## Improvement ideas

 - As the app was supposed to show only the object names, I created an
   Entity table called Object with just id and objectName. Ideally, I
   think it would be better to store more information gathered from
   Google Vision API and get the objectName attribute to display it.
	 
 - I wanted to show the image for preview at the website when the objects were retrieved, but somehow could not get it to work. Definitely an improvement to the application.
 - CSS should also be improved. I started getting cors errors at the very end after deploying to cloud, and decided to leave it as it was.
