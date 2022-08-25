import filterImage from './filter.svg';
import styles from './Sidebar.module.scss';
import SlideBar from "../SlideBar";
import React from "react";

class Sidebar extends React.Component {
    render() {
        return (
            <div className={styles.mainLeft}>
                <div className={styles.filter}>
                    <div className={styles.filterConfig}>
                        <div className={styles.filterButton}>
                            <img src={filterImage} alt=""/>
                            <p>Filter</p>
                        </div>
                        <div className={styles.clearFilter}>
                            <p>Clear</p>
                        </div>
                    </div>
                    <div className={styles.sizeFilter}>
                        <p className={styles.filterTitle}>Size</p>
                        <div className={styles.sizeContainer}>
                            <div className={styles.sizeItem}>S</div>
                            <div className={styles.sizeItem}>M</div>
                            <div className={styles.sizeItem}>L</div>
                            <div className={styles.sizeItem}>XL</div>
                            <div className={styles.sizeItem}>XXL</div>
                        </div>
                    </div>
                    <div className={styles.colorFilter}>
                        <p className={styles.filterTitle}>Color</p>
                        <div className={styles.colorContainer}>
                            <div className={styles.colorItem}></div>
                            <div className={styles.colorItem}></div>
                            <div className={styles.colorItem}></div>
                            <div className={styles.colorItem}></div>
                            <div className={styles.colorItem}></div>
                        </div>
                    </div>
                    <SlideBar/>
                </div>
            </div>
        );
    }
}

export default Sidebar;