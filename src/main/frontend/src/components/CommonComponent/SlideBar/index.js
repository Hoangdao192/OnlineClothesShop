import styles from './SlideBar.module.scss';
import React from "react";

class SlideBar extends React.Component {
    constructor(props) {
        super(props);

        this.className = styles.priceFilter;
        if (this.props.className) {
            this.className += " " + this.props.className;
        }

        this.maxValue = 10;
        this.minValue = 0;
        if (this.props.minValue) {
            this.minValue = this.props.minValue;
        }
        if (this.props.maxValue) {
            this.maxValue = this.props.maxValue;
        }

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
        this.sliderMaxValue = this.maxValue;
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
        this.slideOne();
        this.slideTwo();
    }

    render() {
        return (
            <div className={this.className}>
                <p className={styles.sliderTitle}>Price</p>
                <p className={styles.sliderRange}>
                    <span ref={this.displayValOneRef}>0k</span>
                    -
                    <span ref={this.displayValTwoRef}>5.000k</span>
                </p>
                <div className={styles.wrapper}>
                    <div className={styles.sliderContainer}>
                        <div ref={this.sliderTrackRef} className={styles.sliderTrack}></div>
                        <input ref={this.firstSliderRef} type="range" min={this.minValue.toString()} max={this.maxValue.toString()} defaultValue={this.minValue.toString()} onChange={this.slideOne}/>
                        <input ref={this.secondSliderRef} type="range" min={this.minValue.toString()} max={this.maxValue.toString()} defaultValue={this.maxValue.toString()} onChange={this.slideTwo}/>
                    </div>
                </div>
            </div>
        )
    }
}

export default SlideBar;