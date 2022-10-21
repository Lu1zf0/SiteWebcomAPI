const body = document.querySelector('.banner');
const button2 = document.querySelector('.button2'); 
const button3 = document.querySelector('.button3');
const button4 = document.querySelector('.button4');
const button5 = document.querySelector('.button5');


button2.addEventListener('click', () =>{
    body.classList.toggle('fogo');
    button2.classList.toggle('butfire');
    button3.classList.toggle('nonee');
    button4.classList.toggle('nonee');
    button5.classList.toggle('nonee');
})

button3.addEventListener('click', () =>{
    body.classList.toggle('grama');
    button3.classList.toggle('butgrama');
    button4.classList.toggle('nonee');
    button2.classList.toggle('nonee');
    button5.classList.toggle('nonee');
})

