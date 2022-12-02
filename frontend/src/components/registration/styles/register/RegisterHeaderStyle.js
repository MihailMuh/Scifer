import {isMobile} from "react-device-detect";

const RegisterHeaderStyle = {
    textAlign: "center",
    margin: "auto",

    fontWeight: "bold",
    fontFamily: "Oswald",
    color: "#240d3b",

    paddingBottom: "3%",

    fontSize: "400%",
}

if (isMobile) {
    RegisterHeaderStyle.fontSize = "300%";
    RegisterHeaderStyle.paddingBottom = "9%";
}

export default RegisterHeaderStyle;
