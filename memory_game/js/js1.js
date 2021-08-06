(function(){
var matches = 0;

var images = [];

var flippedCards = [];

var modalGameOver= document.querySelector("#modalGameOver");

var imgMatchSign = document.querySelector("#imgMatchSign");


for(var i = 0; i < 12 ;i++){
	var img= {
		src: "img1/"+ i +".jpg",
		id: i % 6
	};
	images.push(img);
}

Game();
function Game(){
matches = 0;

	flippedCards = [];
images = randomSort(images);

var  frontFaces = document.getElementsByClassName("front");
var  backFaces = document.getElementsByClassName("back"); 


for(var i = 0; i< 12; i++){

frontFaces[i].classList.remove("flipped","match");
backFaces[i].classList.remove("flipped","match");


var card = document.querySelector("#card" +i);
card.style.left = i % 6 === 0 ? 5 + "px" : i % 6 * 165 + 5 + "px";
card.style.top = i < 6 ? 5 + "px" : 250 + "px";

card.addEventListener("click",flipcard, false);

frontFaces[i].style.background = "url('"+ images[i].src+ "')";
frontFaces[i].setAttribute("id",images[i].id);
}

modalGameOver.style.zIndex = -2;
modalGameOver.removeEventListener("click",Game,false);

}

function randomSort(oldArray){




var newArray = [];

while(newArray.length !==  oldArray.length){

var i = Math.floor(Math.random()*oldArray.length);

if(newArray.indexOf(oldArray[i]) < 0){
newArray.push(oldArray[i]);

  }

}
return newArray;
   
   }

function flipcard (){
if(flippedCards.length < 2){

var faces = this.getElementsByClassName("face");
faces[0].classList.toggle("flipped");
faces[1].classList.toggle("flipped");

flippedCards.push(this);

if(flippedCards.length === 2){
if(flippedCards[0].childNodes[3].id === flippedCards[1].childNodes[3].id){
flippedCards[0].childNodes[1].classList.toggle("match");
flippedCards[0].childNodes[3].classList.toggle("match");
flippedCards[1].childNodes[1].classList.toggle("match");
flippedCards[1].childNodes[3].classList.toggle("match");

matchCardSign();

matches++;

flippedCards = [];

if(matches === 6){
	gameOver();
}

}

}

}
else{
flippedCards[0].childNodes[1].classList.toggle("flipped");
flippedCards[0].childNodes[3].classList.toggle("flipped");
flippedCards[1].childNodes[1].classList.toggle("flipped");
flippedCards[1].childNodes[3].classList.toggle("flipped");

flippedCards = [];

}
}



function gameOver(){
modalGameOver.style.zIndex = 10;
modalGameOver.addEventListener("click",Game,false);
}

function matchCardSign(){
imgMatchSign.style.zIndex = 1;
imgMatchSign.style.top = 150 + "px";
imgMatchSign.style.opacity = 0;
setTimeout(function(){

	imgMatchSign.style.zIndex = -1;
imgMatchSign.style.top = 100 + "px";
imgMatchSign.style.opacity = 1;
},1500)
}

}());