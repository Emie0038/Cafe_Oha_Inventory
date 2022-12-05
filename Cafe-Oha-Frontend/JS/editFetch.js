//add save button with event listener
import { getAll } from "./Service/API_calls";


const saveButton = document.getElementById("saveButton");
const param = new URLSearchParams(window.location.search);
const urlId = param.get("id");
const id = urlId;
const url= "http://localhost:8080/menu/"+id;
const nameTag = document.getElementById("title");
const typeTag = document.getElementById("instruction");
let imageName = ""

console.log(url)

getMe()

async function getMe()
{
    const response = await fetch(url).then(response => response.json());
    console.log(response);
    nameTag.value = response.name
    typeTag.value = response.instruction
    imageName = response.imageName
}

async function editMenuItem(menuItem) {
    fetch(url,{
        method: 'PUT',
        headers:{
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(menuItem)
    })
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(err => console.log(err))

}
saveButton.addEventListener('click', (e) => {
    e.preventDefault()
    if(nameTag.value != "" && typeTag.value != "") {
        editMenuItem({
                "id": id,
                "name": nameTag.value,
                "instruction": typeTag.value,
                "imageName": imageName
            }

        )
        window.location.href = "instructions.html?id=" + id;
    } else {
        alert("You cannot save an empty menu")
    }

})






const cancelButtonEdit = document.getElementById("cancelButton");
cancelButtonEdit.addEventListener("click", () => {
    window.location.href = "instructions.html?id=" + id;

});






