import searchImage from './search.svg';
import settingImage from './setting.svg';
import avatarImage from './perfil.png';
import styles from './Header.module.scss';

function Header() {
    return (
        <header className={styles.header}>
            <div className={styles.logo}>
                <img src="https://api.logomaster.ai/logo-template-preview/preview-template-10043.svg" alt=""/>
            </div>
            <div className={styles.menu}>
                <div className={styles.menuItem}>
                    <a href="">Home</a>
                </div>
                <div className={styles.menuItem}>
                    <a href="">Shop</a>
                </div>
                <div className={styles.menuItem}>
                    <a href="">About</a>
                </div>
                <div className={styles.menuItem}>
                    <a href="">Policy</a>
                </div>
            </div>
            <div className={styles.searchBox}>
                <img src={ searchImage } alt=""/>
                <p>Search</p>
            </div>
            <div className={styles.user}>
                <div className={styles.userAccount}>
                    <div className={styles.userAccountAvatar}>
                        <img src={avatarImage} alt=""/>
                    </div>
                    <div className={styles.userAccountInformation}>
                        <div className={styles.userAccountUserName}>
                            <p>JeremyWoods</p>
                        </div>
                        <div className={styles.userAccountEmail}>
                            <p>jeremy@gmail.com</p>
                        </div>
                    </div>
                </div>
                <div className={styles.userSetting}>
                    <img src={ settingImage } alt=""/>
                </div>
            </div>
        </header>
    );
}

export default Header;