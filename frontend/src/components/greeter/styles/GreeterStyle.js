import {isMobile} from "react-device-detect";

const GreeterStyle = {
    margin: "auto",
    display: "block",

    width: "50%",

    background: "#CCCCFF",
    opacity: "90%",

    borderRadius: "40px",
    boxShadow: "0 0 10px rgba(0, 0, 0, 1)",

    paddingRight: "2em",
    paddingLeft: "2em",
    paddingBottom: "2em",
}

if (isMobile) {
    GreeterStyle.width = "75%";
} else if (window.screen.height < 1080) {
    // GreeterStyle.width = "55%";
}

export default GreeterStyle;
