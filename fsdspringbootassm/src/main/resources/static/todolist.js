
function newList() {

    event.preventDefault();

    (() => {
        'use strict'
         // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.querySelectorAll('.needs-validation')
         // Loop over them and prevent submission
        Array.from(forms).forEach(form => {
          form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
              event.preventDefault()
              event.stopPropagation()
            }
             form.classList.add('was-validated')
          }, false)

        })
      })()

    const title = document.querySelector("#title").value;
    const description = document.querySelector("#description").value;
    const targetDate = document.querySelector("#targetDate").value;

    addtoDoList(title, description, targetDate);

    document.querySelector("#outputNewToDoList").innerHTML = `Output Test Run = ${title} ${description} ${targetDate}`;
    
}

/*displaytoDoList();

function addtoDoList(title,description,targetDate){

    const newToDo = {
        title: title,
        description: description,
        targetDate: targetDate,
    }

    toDoList.push(newToDo);
}*/
















