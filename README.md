
# Dragon Ball Z character Archive - Backend - CRUD - SpringBoot
  
  
<div id="top"></div>

<!-- TABLE OF CONTENTS -->

## Table of Contents

  <ol>
    <li>
      <a href="#about2">About The Project</a>
      <ul>
        <li><a href="#build3">Structure</a></li>
        <li><a href="#build2">Built With</a></li>
      </ul>
    </li>
    <li><a href="#usage2">Usage</a></li>
    <li><a href="#usage3">Feature</a></li>
    <li><a href="#contact2">Contact</a></li>
  </ol>



<div id="about2"></div>


<!-- ABOUT THE PROJECT -->

## About The Project

Its a springBoot CRUD application for the archive of Dragon Ball Z characters which is a popular Japanese anime television series. This backend system can receive and send REST API's. See below for further information.  

<p align="right">(<a href="#top">back to top</a>)</p>


<div id="build3"></div>

## Structure
  
### Dependency
  Dependecy imported and used for SpringBoot Application -
  * Spring Web
  * Spring Data MongoDB 
  * Lombok
  * Spring Boot DevTools 

### Directory
```
.
└── DragonBallZCharacters/
    ├── DragonBallZCharactersApplication.java
    ├── controller/
    │   └── characterController.java
    ├── exception/
    │   └── characterCollectionException.java
    ├── config/
    │   └── ValidationConfig.java
    ├── repository/
    │   └── characterRepository.java
    └── service/
        └── characterService.java
        └── characterServiceImpl.java
```  
<p align="right">(<a href="#top">back to top</a>)</p>    

<div id="build2"></div>
  
## Built With

### Technology used

  * SpringBoot
  * MongoDB
  * Java (JDK version: 11.0.16)


### Software used
  
  * Postman
  * Editor : Eclipse IDE
  * Studio 3T
  
<p align="right">(<a href="#top">back to top</a>)</p>







<div id="usage2"></div>



<!-- USAGE EXAMPLES -->
## Usage



<p align="right">(<a href="#top">back to top</a>)</p>

I used `Postman` to test REST api's. I've attached few gif's of testing from postman.
* Testing for `GET`, `POST`  
<img src="gifs/dbz_01.gif" width=764 align="center">

* Testing for `PUT`, `DELETE`  <br>
<img src="gifs/dbz_2.gif" align="center">

Referring <a href="#usage3">Features</a> section for a chart of all working API's.






<!-- USAGE EXAMPLES -->
## Features

  * Rest endpoints 

    * **POST:** http://localhost:8080/characters : Add  new characters to the database <br>
    Sample JSON for this request:
     ```
      {
          "name": "piccolo",
          "gender": "male",
          "race": "namekian",
          "age": 25,
          "transform": "orange piccolo",
          "specialpower": "special beam cannon"
      }
      ```
    * **DELETE:** http://localhost:8080/characters/{id} : Delete a characters by it's id
    * **PUT:** http://localhost:8080/characters/{id} : Update characters by it's id
    Sample JSON for this request:
     ```
      {
        "transform": "great ape",
        "specialpower": "ki blast"
      }
      ```
    * **GET:** http://localhost:8080/all/ : Get a list of all characters
 
    
<p align="right">(<a href="#top">back to top</a>)</p>




<!-- CONTACT -->
## Contact

You may contact with me via gmail if needed. 
mail: zareefjafar31@gmail.com


<p align="right">(<a href="#top">back to top</a>)</p>
