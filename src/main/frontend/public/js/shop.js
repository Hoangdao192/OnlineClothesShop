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
    for (let productItem of productItems) {
        let productPriceP = productItem.querySelector(".productPrice p");
        let productPriceFormatted = numberFormat.format(parseInt(productPriceP.innerHTML));
        productPriceP.innerHTML = productPriceFormatted.toString() + "đ";

        let productNameP = productItem.querySelector(".primaryName");
        let productShortNameP = productItem.querySelector(".shortName");
        let productName = productNameP.innerHTML;
        let wordArray = productName.split(" ");
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

    let sortBySelector = document.querySelector(".sortBy select");
    let selectedSortBy = sortBySelector.value;

    let pageNumberContainer = document.querySelector(".pageNumberContainer");
    let pageNumberActive = pageNumberContainer.querySelector(".pageNumber.active");
    let selectedPageNumber = 1;
    if (pageNumberActive != null) {
        selectedPageNumber = pageNumberActive.querySelector("p").innerHTML;
    }
    selectedPageNumber = parseInt(selectedPageNumber);

    let requestUrl = "";
    selectedSortBy = parseInt(selectedSortBy);

    if (selectedProductTypeId == -1) {
        if (selectedCategoryId == -1) {
            requestUrl = "./api/product/list";
        } else {
            requestUrl = "./api/product/list?categoryId=" + selectedCategoryId;
        }
    } else {
        requestUrl = "./api/product/list?productTypeId=" + selectedProductTypeId;
    }

    if (requestUrl.indexOf("?") == -1) {
        requestUrl += "?"
    } else {
        requestUrl += "&"
    }
    switch (selectedSortBy) {
        case 1: requestUrl += "orderBy=name&order=asc"; break;
        case 2: requestUrl += "orderBy=name&order=des"; break;
        case 3: requestUrl += "orderBy=price&order=asc"; break;
        case 4: requestUrl += "orderBy=price&order=des"; break;
    }
    requestUrl += `&page=${selectedPageNumber - 1}`;

    let loader = document.createElement("div");
    loader.innerHTML = "<div class=\"lds-ellipsis\"><div></div><div></div><div></div><div></div></div>";
    loader.classList.add("loader");
    document.querySelector("body").appendChild(loader);

    let request = new XMLHttpRequest();
    request.open("GET", requestUrl);
    request.onload = function () {
        if (this.status >= 200 && this.status < 400) {
            if (document.querySelector("body .loader")) {
                document.querySelector("body").removeChild(loader);
            }
            let result = JSON.parse(this.response);
            parseProductArray(result.products);
            loadPageNumber(result.page, result.numberOfPage);
            formatProductItem();
        }
    }
    request.send();
}

function loadPageNumber(currentPage, numberOfPage) {
    //  Because the api count page from 0
    currentPage++;
    let pageNumberContainer = document.querySelector(".pageNumberContainer");
    pageNumberContainer.innerHTML = "";

    let minPageNumber = 1;
    let maxPageNumber = numberOfPage;
    if (currentPage > 1) {
        minPageNumber = currentPage - 1;
    }
    maxPageNumber = minPageNumber + 4;
    if (maxPageNumber > numberOfPage) {
        maxPageNumber = numberOfPage;
    }
    while (maxPageNumber - minPageNumber < 4 && minPageNumber > 1) {
        --minPageNumber;
    }

    for (let i = minPageNumber; i <= maxPageNumber; ++i) {
        let pageNumberItem = document.createElement("div");
        pageNumberItem.classList.add("pageNumber");
        if (i == currentPage) {
            pageNumberItem.classList.add("active");
        }
        pageNumberItem.innerHTML = `<p>${i}</p>`;
        pageNumberItem.addEventListener("click", () => {
            pageNumberContainer.querySelector(".pageNumber.active").classList.remove("active");
            pageNumberItem.classList.add("active");
            loadProduct();
        })

        pageNumberContainer.appendChild(pageNumberItem);
    }

    let firstPageNavigator = document.querySelector(".firstPage");
    firstPageNavigator.setAttribute("value", "1");
    let lastPageNavigator = document.querySelector(".lastPage");
    lastPageNavigator.setAttribute("value", numberOfPage.toString());

    let pageInfo = document.querySelector(".pageHeading.pageInfo");
    pageInfo.querySelector("p").innerHTML = currentPage + "/" + numberOfPage;
}

function clearActivePage() {
    let activePageNumber = document.querySelector(".pageNumberContainer .pageNumber.active");
    activePageNumber.classList.remove("active");
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
    clearActivePage();
    loadProductType(() => {
        loadProduct();
    });
})

let productTypeSelector = document.querySelector(".productTypeSelector select");
productTypeSelector.addEventListener('change', () => {
    clearActivePage();
    loadProduct();
})

let sortBySelector = document.querySelector(".sortBy select");
sortBySelector.addEventListener('change', () => {
    loadProduct();
})

let firstPageNavigator = document.querySelector(".firstPage");
firstPageNavigator.addEventListener('click', () => {
    let pageNumberContainer = document.querySelector(".pageNumberContainer");
    let pageNumberActive = pageNumberContainer.querySelector(".pageNumber.active");
    pageNumberActive.querySelector("p").innerHTML = firstPageNavigator.getAttribute("value");
    loadProduct();
})

let lastPageNavigator = document.querySelector(".lastPage");
lastPageNavigator.addEventListener('click', () => {
    let pageNumberContainer = document.querySelector(".pageNumberContainer");
    let pageNumberActive = pageNumberContainer.querySelector(".pageNumber.active");
    pageNumberActive.querySelector("p").innerHTML = lastPageNavigator.getAttribute("value");
    loadProduct();
})

