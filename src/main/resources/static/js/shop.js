window.onload = function(){
    slideOne();
    slideTwo();
}

let sliderOne = document.getElementById("slider-1");
let sliderTwo = document.getElementById("slider-2");
let displayValOne = document.getElementById("range1");
let displayValTwo = document.getElementById("range2");
let minGap = 0;
let sliderTrack = document.querySelector(".slider-track");
let sliderMaxValue = document.getElementById("slider-1").getAttribute("max");
let numberFormat = new Intl.NumberFormat('de-DE');

function slideOne(){
    if(parseInt(sliderTwo.value) - parseInt(sliderOne.value) <= minGap){
        sliderOne.value = parseInt(sliderTwo.value) - minGap;
    }
    displayValOne.textContent = (numberFormat.format(sliderOne.value) + 'k');
    fillColor();
}
function slideTwo(){
    if(parseInt(sliderTwo.value) - parseInt(sliderOne.value) <= minGap){
        sliderTwo.value = parseInt(sliderOne.value) + minGap;
    }
    displayValTwo.textContent = (numberFormat.format(sliderTwo.value) + 'k');
    fillColor();
}
function fillColor(){
    percent1 = (sliderOne.value / sliderMaxValue) * 100;
    percent2 = (sliderTwo.value / sliderMaxValue) * 100;
    sliderTrack.style.background = `linear-gradient(to right, #dadae5 ${percent1}% , #3264fe ${percent1}% , #3264fe ${percent2}%, #dadae5 ${percent2}%)`;
}

function formatCurrency() {
    let productItems = document.querySelectorAll(".productItem");
    console.log(productItems);
    for (let productItem of productItems) {
        let productPriceP = productItem.querySelector(".productPrice p");
        let productPriceFormatted = numberFormat.format(parseInt(productPriceP.innerHTML));
        productPriceP.innerHTML = productPriceFormatted.toString() + "đ";

        let productNameP = productItem.querySelector(".primaryName");
        let productShortNameP = productItem.querySelector(".shortName");
        let productName = productNameP.innerHTML;
        let wordArray = productName.split(" ");
        console.log(wordArray);
        if (wordArray.length >= 2) {
            productNameP.innerHTML = wordArray[0] + " " + wordArray[1];
            let productShortName = "";
            for (let i = 2; i < wordArray.length; ++i) {
                productShortName += " " + wordArray[i];
            }
            productShortNameP.innerHTML = productShortName;
        }
    }
}

formatCurrency();

let request = new XMLHttpRequest();
request.open("GET", "./api/home");
request.onload = function () {
    if (this.status >= 200 && this.status < 400) {
        console.log(this.response);
    }
}
request.send();