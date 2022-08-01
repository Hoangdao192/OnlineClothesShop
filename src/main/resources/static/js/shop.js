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

function formatProductItem() {
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

function loadProductType(callback) {
    let categorySelector = document.querySelector(".categorySelector select");
    let selectedCategoryId = categorySelector.value;
    let productTypeSelector = document.querySelector(".productTypeSelector select");
    productTypeSelector.innerHTML = "<option value='-1'>All</option>";
    if (selectedCategoryId != -1) {
        let request = new XMLHttpRequest();
        request.open("GET", `./api/producttype/list?categoryId=${selectedCategoryId}`);
        request.onload = function () {
            if (this.status >= 200 && this.status < 400) {
                let productTypeArray = JSON.parse(this.response);
                for (let productType of productTypeArray) {
                    let option = document.createElement("option");
                    option.setAttribute("value", productType.id);
                    option.innerHTML = productType.name;
                    productTypeSelector.appendChild(option);
                }
            }
            if (callback) {
                callback();
            }
        }
        request.send();
    } else {
        if(callback) {
            callback();
        }
    }
}

function loadProduct() {
    let categorySelector = document.querySelector(".categorySelector select");
    let selectedCategoryId = categorySelector.value;
    let productTypeSelector = document.querySelector(".productTypeSelector select");
    let selectedProductTypeId = productTypeSelector.value;
    let requestUrl = "";

    if (selectedProductTypeId == -1) {
        if (selectedCategoryId == -1) {
            requestUrl = "./api/product/list";
        } else {
            requestUrl = "./api/product/list?categoryId=" + selectedCategoryId;
        }
    } else {
        requestUrl = "./api/product/list?productTypeId=" + selectedProductTypeId;
    }

    let request = new XMLHttpRequest();
    request.open("GET", requestUrl);
    request.onload = function () {
        if (this.status >= 200 && this.status < 400) {
            parseProductArray(JSON.parse(this.response));
            formatProductItem();
        }
    }
    request.send();
}

function parseProductArray(productArray) {
    let productContainer = document.querySelector(".productContainer");
    productContainer.innerHTML = "";
    for (let product of productArray) {
        let productItem = document.createElement("div");
        productItem.classList.add("productItem");
        productItem.innerHTML =
            `<div class="productImage">
                <img src="images/database/${product.productImagePath}" alt="">
                <div class="favorite">
                    <i class="fa-solid fa-heart"></i>
                </div>
                <div class="addToCart">
                    <p>Add to cart</p>
                    <!-- <i class="fa-solid fa-plus"></i> -->
                </div>
            </div>
            <div class="productInformation">
                <div class="productPrice">
                    <p>${product.productPrice}</p>
                </div>
                <div class="productName">
                    <p class="primaryName">${product.productName}</p>
                    <p class="shortName">UT12536</p>
                </div>
            </div>`;
        productContainer.appendChild(productItem);
    }

}

loadProductType(() => {
    loadProduct();
});

let categorySelector = document.querySelector(".categorySelector select");
categorySelector.addEventListener('change', () => {
    loadProductType(() => {
        loadProduct();
    });
})
let productTypeSelector = document.querySelector(".productTypeSelector select");
productTypeSelector.addEventListener('change', () => {
    loadProduct();
})

