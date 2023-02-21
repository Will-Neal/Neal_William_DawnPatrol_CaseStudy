console.log("Linked");

const form = document.querySelector("#form-container");
const button = document.querySelector("#formButton");

const toggleFormDisplay = (event) => {
    console.log(event);
    console.log(form.getAttribute("class"));
    if(form.getAttribute("class") === "form-container"){
        form.setAttribute("class", "hidden");
        button.textContent = "Show";
        button.style.backgroundColor = "#23B5d3"
    } else {
        form.setAttribute("class", "form-container");
        button.textContent = "Hide"
        button.style.backgroundColor = "#EF6461";
    }
}


button.addEventListener("click", toggleFormDisplay);