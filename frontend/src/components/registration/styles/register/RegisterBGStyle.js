import {isMobile} from "react-device-detect";

const RegisterBGStyle = {
    // 10% is needed so that when adding nodes, the form grows ONLY downwards
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
    RegisterBGStyle.width = "70%";
}

export default RegisterBGStyle;
