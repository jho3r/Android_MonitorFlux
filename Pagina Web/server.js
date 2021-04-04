//jshint esversion:6
const express = require('express');
const app = express();
const Backendless = require('Backendless');
const APP_ID = '4D75900B-E59C-1318-FF7D-6D0FBCB48400';
const API_KEY = 'D8A51FE0-8E45-4B09-A7DB-5EF972FAA792';
Backendless.initApp(APP_ID, API_KEY);

app.use(express.static("public"));

app.get("/", function(req, res) {
  res.sendFile(__dirname + "/index.html");
});

app.get("/about", function(req, res) {
  res.sendFile(__dirname + "/about.html");
});

app.get("/tutorials", function(req, res) {
  res.sendFile(__dirname + "/tutorials.html");
});

app.get("/tutorialsno", function(req, res) {
  res.sendFile(__dirname + "/tutorialsno.html");
});

app.listen(3000, function() {
  console.log("Servidor iniciado en el puerto 3000");
});

//Para escribir un objeto en Backendless
/*

var objToSave = {name: 'Joe', age: 25};
Backendless.Data.of('Person').save(objToSave)
  .then(function (object) {
    console.log('Object has been saved');
    return object;
  })
  .catch(function (error) {
    console.log( 'Error ' + error.message);
    throw error;
  });

  */

//Para leer un objeto de Backendless

/*
Backendless.Data.of('Person').findFirst()
  .then(function(object) {
    console.log('Object has been retrieved');
    console.log(`Name ${object.name}, age ${object.age}`);
    console.log("Name: " + object.name + ", " + "age: " + object.age);
    return object;
  })
  .catch(function(error) {
    console.log('Error ' + error.message);
    throw error;
  });
  */

//Para actualizar un objeto
/*
Backendless.Data.of('Person').findFirst()
  .then(function(object) {
    // update the object - assign a random value
    // to the "age" property
    object.age = Math.round(Math.random() * 50);

    // now save the object back in the database
    Backendless.Data.of('Person').save(object)
      .then(function(savedObject) {
        console.log('Object has been updated');
      })
      .catch(function(error) {
        console.log('Error updating object ' +
          error.message);
        throw error;
      });
  })
  .catch(function(error) {
    console.log('Error ' + error.message);
    throw error;
  });
*/

//Para eliminar un objeto de Backendless
/*
Backendless.Data.of('Person').findFirst()
  .then(function (object) {
    // the "object" argument is the retrieved
    // object from the database. Let's delete it:
    Backendless.Data.of('Person').remove(object)
      .then( function (savedObject) {
        console.log( 'Object has been removed' );
      })
      .catch(function (error) {
        console.log( 'Error removing object ' +
                     error.message);
        throw error;
      });
  })
  .catch(function (error) {
    console.log( 'Error retrieving object ' +
                 error.message);
    throw error;
  });
*/

//Para registrar un usuario
/*
function userRegistered( user )
{
  console.log( "user has been registered" );
}

function gotError( err )
{
  console.log( "error message - " + err.message );
  console.log( "error code - " + err.statusCode );
}

var user = new Backendless.User();
user.email = "james.bond@mi6.co.uk";
user.password = "supe3rs3cre3t";

Backendless.UserService.register( user )
  .then( userRegistered )
  .catch( gotError );
*/

// Para iniciar sesion Backendless
/*
function userLoggedIn( user )
{
  console.log( "user has logged in" );
  // any other API call at this point
  // or later in the app will be executed
  // on behalf of the logged in user
}

function gotError( err ) // see more on error handling
{
  console.log( "error message - " + err.message );
  console.log( "error code - " + err.statusCode );
}

var login = "jhoer.perez@gmail.com";
var password = "1234";
Backendless.UserService.login( login, password )
 .then( userLoggedIn )
 .catch( gotError );
*/
