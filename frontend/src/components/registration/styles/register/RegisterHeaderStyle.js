import {isMobile} from "react-device-detect";

const RegisterHeaderStyle = {
    textAlign: "center",
    margin: "auto",

    fontFamily: "Oswald",
    color: "#240d3b",

    paddingBottom: "4%",

    fontSize: "370%",
}

if (isMobile) {
    RegisterHeaderStyle.fontSize = "300%";
    RegisterHeaderStyle.paddingBottom = "9%";
}

export default RegisterHeaderStyle;
