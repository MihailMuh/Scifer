import {isMobile} from "react-device-detect";

const RegisterBGStyle = {
    margin: "10% auto",
    display: "block",

    background: "#CCCCFF",
    opacity: "90%",

    borderRadius: "40px",
    boxShadow: "0 0 10px rgba(0, 0, 0, 1)",

    paddingRight: "2em",
    paddingLeft: "2em",
    paddingBottom: "2em",
    paddingTop: "2em",
}

if (isMobile) {
} else if (window.screen.height > 1000) {
}

export default RegisterBGStyle;
