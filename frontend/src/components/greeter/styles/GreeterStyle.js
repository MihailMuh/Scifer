import {isMobile} from "react-device-detect";

const GreeterStyle = {
    margin: "auto",
    display: "block",

    background: "#CCCCFF",
    opacity: "90%",

    borderRadius: "40px",
    boxShadow: "0 0 10px rgba(0, 0, 0, 1)",

    paddingRight: "2em",
    paddingLeft: "2em",
    paddingBottom: "3em",
}

if (isMobile) {
    GreeterStyle.width = "70%";
}

export default GreeterStyle;
