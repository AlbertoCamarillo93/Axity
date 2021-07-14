import './home-pokemon';


const API_URL = "https://pokeapi.co/api/v2/pokemon";


const xhr = new XMLHttpRequest();

function onRequestHandler(){
    if (this.readyState == 4 && this.status == 200){
        const data = JSON.parse(this.response);
       // const HTMLResponse = document.querySelector('#app');

        //const tpl = data.map(user => `<li>${user.name}<li>`);
        console.log(data);
    }
}

xhr.addEventListener("load", onRequestHandler);
xhr.open("GET", API_URL);
xhr.send();