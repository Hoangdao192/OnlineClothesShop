import styles from './SlideBar.module.scss';
import React from "react";

class SlideBar extends React.Component {
    constructor(props) {
        super(props);
    }

    sliderOne = document.getElementById("slider-1");
    sliderTwo = document.getElementById("slider-2");
    displayValOne = document.getElementById("range1");
    displayValTwo = document.getElementById("range2");
    minGap = 0;
    sliderTrack = document.querySelector(".slider-track");
    sliderMaxValue = document.getElementById("slider-1").getAttribute("max");
    numberFormat = new Intl.NumberFormat('de-DE');

    slideOne(){
        if(parseInt(sliderTwo.value) - parseInt(sliderOne.value) <= minGap){
            sliderOne.value = parseInt(sliderTwo.value) - minGap;
        }
        displayValOne.textContent = (numberFormat.format(sliderOne.value) + 'k');
        fillColor();
    }

    slideTwo(){
        if(parseInt(sliderTwo.value) - parseInt(sliderOne.value) <= minGap){
            sliderTwo.value = parseInt(sliderOne.value) + minGap;
        }
        displayValTwo.textContent = (numberFormat.format(sliderTwo.value) + 'k');
        fillColor();
    }

    fillColor(){
        let percent1 = (sliderOne.value / sliderMaxValue) * 100;
        let percent2 = (sliderTwo.value / sliderMaxValue) * 100;
        sliderTrack.style.background = `linear-gradient(to right, #dadae5 ${percent1}% , #3264fe ${percent1}% , #3264fe ${percent2}%, #dadae5 ${percent2}%)`;
    }

    render() {
        return (
            <div className={styles.priceFilter}>
                <p className={styles.filterTitle}>Price</p>
                <p className={styles.priceRange}>
                    <span id={styles.range1}>0k</span>
                    -
                    <span id={styles.range2}>5.000k</span>
                </p>
                <div className={[styles.wrapper, styles.rangeSlider].join(' ')}>
                    <div className={styles.sliderContainer}>
                        <div className={styles.sliderTrack}></div>
                        <input type="range" min="0" max="5000" value="0" id="slider-1" onInput="slideOne()"/>
                        <input type="range" min="0" max="5000" value="5000" id="slider-2" onInput="slideTwo()"/>
                    </div>
                </div>
            </div>
        )
    }
}

export default SlideBar;