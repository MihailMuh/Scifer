import {isDesktop, isMobile} from 'react-device-detect';

const AppStyle = {
    width: "100%",
    height: "100%",
    backgroundPosition: "center",
    backgroundSize: "cover",
    display: "flex",
};

if (isMobile) {
    AppStyle.backgroundImage = `url(${require('../img/phoneBackground.jpg')})`;
} else if (isDesktop) {
    AppStyle.backgroundImage = `url(${require('../img/background.jpg')})`;
}

export default AppStyle;
