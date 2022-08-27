import styles from './SlideBar.module.scss';
import React from "react";

class SlideBar extends React.Component {
    constructor(props) {
        super(props);
        this.maxValue = props.maxValue ? 10 : props.maxValue;
        this.minValue = props.minValue ? 0 : props.minValue;

        this.slideOne = this.slideOne.bind(this);
        this.slideTwo = this.slideTwo.bind(this);
        this.fillColor = this.fillColor.bind(this);

        this.firstSliderRef = React.createRef();
        this.secondSliderRef = React.createRef();
        this.displayValOneRef = React.createRef();
        this.displayValTwoRef = React.createRef();
        this.sliderTrackRef = React.createRef();
        this.minGap = 0;

        this.numberFormat = new Intl.NumberFormat('de-DE');
        this.sliderMaxValue = 5000;
    }

    slideOne(){
        if(parseInt(this.secondSlider.value) - parseInt(this.firstSlider.value) <= this.minGap){
            this.firstSlider.value = parseInt(this.secondSlider.value) - this.minGap;
        }
        this.displayValOne.textContent = (this.numberFormat.format(this.firstSlider.value) + 'k');
        this.fillColor();
    }

    slideTwo(){
        if(parseInt(this.secondSlider.value) - parseInt(this.firstSlider.value) <= this.minGap){
            this.secondSlider.value = parseInt(this.firstSlider.value) + this.minGap;
        }
        this.displayValTwo.textContent = (this.numberFormat.format(this.secondSlider.value) + 'k');
        this.fillColor();
    }

    fillColor(){
        let percent1 = (this.firstSlider.value / this.sliderMaxValue) * 100;
        let percent2 = (this.secondSlider.value / this.sliderMaxValue) * 100;
        this.sliderTrack.style.background = `linear-gradient(to right, #dadae5 ${percent1}% , #3264fe ${percent1}% , #3264fe ${percent2}%, #dadae5 ${percent2}%)`;
    }

    componentDidMount() {
        this.firstSlider = this.firstSliderRef.current;
        this.secondSlider = this.secondSliderRef.current;
        this.displayValOne = this.displayValOneRef.current;
        this.displayValTwo = this.displayValTwoRef.current;
        this.sliderTrack = this.sliderTrackRef.current;
    }

    render() {
        return (
            <div className={styles.priceFilter}>
                <p className={styles.filterTitle}>Price</p>
                <p className={styles.priceRange}>
                    <span ref={this.displayValOneRef} id={styles.range1}>0k</span>
                    -
                    <span ref={this.displayValTwoRef} id={styles.range2}>5.000k</span>
                </p>
                <div className={styles.wrapper}>
                    <div className={styles.sliderContainer}>
                        <div ref={this.sliderTrackRef} className={styles.sliderTrack}></div>
                        <input ref={this.firstSliderRef} type="range" min="0" max="5000" defaultValue="0" id="firstSlider" onChange={this.slideOne}/>
                        <input ref={this.secondSliderRef} type="range" min="0" max="5000" defaultValue="5000" id="secondSlider" onChange={this.slideTwo}/>
                    </div>
                </div>
            </div>
        )
    }
}

export default SlideBar;