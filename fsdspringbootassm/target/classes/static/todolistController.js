/*
    todolistController perform action to the TODO List to be displayed
    (1) Display all ToDo List to be retrieved from the back-end
    (2) Add new todo to the todo list (send the new project to the back-end)
    (3) edit an existing todo detail
    (4) remove an existing todo from the todo list
*/
//development APIs
const addAPI= 'http://localhost:8080/item/add';
const displayAPI = 'http://localhost:8080/item/all';

let todolistController = [];

function displaytoDoList()
{
todolistController = [];  // This is to reset the array to nothing in order

console.log("in"); // This is to test whether it appear on the browser. Can check with inspect and console
       //fetch data from database using the REST API endpoint from Spring Boot
       //GET http method is a default
       fetch(displayAPI)
           .then((resp) => resp.json())
           .then(function(data) {
               console.log("2. receive data")
               console.log(data);
               data.forEach(function (item, index) {

                   const itemObj = {
                       id: item.id,
                       title: item.title,
                       description: item.description,
                       targetDate: item.targetDate

                  };
                   //consist of 3 objects
                   todolistController.push(itemObj);
             });

            //Display all the 3 objects from the customerController array
             renderProductPage();

           })
           .catch(function(error) {
               console.log(error);
           });
}

function renderProductPage() {

           let displaytoDoList = " ";

           for (let i = 0; i < todolistController.length; i++ ) {

                displaytoDoList += `
                        <tr>
                          <td>${todolistController[i].title}</td>
                          <td>${todolistController[i].description}</td>
                          <td>${todolistController[i].targetDate}</td>
                        </tr>
               `
           }

            document.querySelector("#toDoList").innerHTML = displaytoDoList;
}


function addtoDoList(title,description,targetDate){

    //FormData is an Object provided by the Browser API for us to send the data over to the backend
   const formData = new FormData();
   formData.append('title', title);
   formData.append('description', description);
    formData.append('targetDate', targetDate);

  fetch(addAPI, {
        method: 'POST',
        body: formData
        })
        .then(function(response) {
            console.log(response.status); // Will show you the status - 200 ok, 500, 404
            if (response.ok) {
                alert("Successfully Added To Do List!")
                displaytoDoList();  // Need to put this in order to display it on the browser
            }
            else {
               alert("Something went wrong. Please try again")
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error adding item to Name")
        });



}