import {isMobile} from "react-device-detect";

const GreeterStyle = {
    margin: "auto",

    background: "#CCCCFF",
    opacity: "90%",

    width: "70%",

    borderRadius: "40px",
    boxShadow: "0 0 10px rgba(0, 0, 0, 1)",

    paddingRight: "2em",
    paddingLeft: "2em",
    paddingBottom: "3em",
    paddingTop: "1em",

    display: "table"
}

if (isMobile) {
    GreeterStyle.width = "85%";
} else if (window.screen.height > 1000) {
    GreeterStyle.width = "55%";
}

export default GreeterStyle;
