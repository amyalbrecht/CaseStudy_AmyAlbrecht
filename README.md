# Max's Photo Album
### by Amy Albrecht
### Case Study for [TEK Global] 2021 -Java Developer 01
**April 12, 2021**

***
## Overall Concept
Max's Photo Album is a place where relatives can go to upload pictures of my son, Max, if they’re uncomfortable using social media.

***
## Full Stack Components

Technology used:

- Database (MariaDB)
- Core Java 
- Spring MVC
- Spring Data JPA
- Spring Boot (the final project is Spring Boot)
- HTML5/CSS3
- Junit
- JSP
- Maven 4.0.0
- Eclipse IDE version 2020-12 (4.18.0)
- HeidiSQL 11.2.0.6250
- Tomcat v9.0


***

## User Stories
**Login/Logout User Stories**

- As a user, I want to create a user account with an email and password so that I can access the website to look at and upload photos.
- As a user, I want to login to my account so that I am able to securely look at photos.
- As a user, I want to be able to logout so that no one else can access my account when I’m done using the site.

**Photo User Stories**

- As a user, I want to upload photos so that I can share photos with the rest of Max’s family.
- As a user, I want to add captions to my photos so that I can add more context to my photos.
- As a user, I want to edit the caption of a photo that I have uploaded so that I can fix typos or add more context.
- As a user, I want to see all the photos that have already been updated by everybody so that I can see more pictures of Max!
- As a user, I want to put tags on my photos so that I can search photos by tag. (stretch goal)
- As a user, I want to put tags on other people's photos so that I can fix an error or add a tag I think is missing.

**Photo Album User Stories**

- As a user, I want to view all the photo albums on one page so that I can choose from the album I want to view.
- As a user, I want to view all the photos of an album while I'm in an album so that I can look at all the photos in one space.

**Misc**

- As a user, I want to see more info about Max and what he's up to so that I can catch up with Max and his family.
- As a user, I want to see an error page if an error occurs so that I can know what’s going on during an error and go back to the home page if I want.


***

## Technical Issues and How I Tackled the Challenges

I’m brand new to GitHub, so I had lots of issues trying to figure it out. I’m getting the hang of it now, though.

Figuring out JUnit proved very difficult. I used it once before in a Skills Based Assessment, and then I converted my Case Study to Spring Data JPA. Unfortunately, JUnit doesn’t work with the @Autowired annotation unless you’re using Spring Boot. By the time I realized that, it was Saturday, April 10. I did convert my project to Spring Boot, but it was too late to implement JUnit fully because of the other issues I was debugging. Going forward, I plan to use TDD and JUnit before I push projects because I realize how important they are.

I wanted a better user validation for the login, but for now, I have a landing page that only has the login form without the header.jsp that can take you anywhere within the app. Should I decide to create a version 2.0 of this app, that would be the first thing I would work on.

There were several things I wanted to include in this project, but I realized that due to time constraints, they had become stretch goals:

- CRUD functionality for User model
- CRUD functionality for Album model
- Update and Delete functionality for Tag model
- Authorization levels for Users
- Comments and Likes for each Photo
- Date Created field for Photo and Album
- search for photos by Tag
- Carousel in Bootstrap



***
## Extras saved in GitHub

- Database schema (DBschema.pdf)
- SQL file to create database without data (createPhotosDB.sql)
- SQL file to create database with data (createPhotosDBWithData.sql)
- Wireframes (Wireframes.pdf)
- PowerPoint deck (AmyAlbrechtCaseStudyPresentation.ppt)

***




