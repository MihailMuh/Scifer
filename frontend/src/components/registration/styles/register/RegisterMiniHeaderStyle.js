import {isMobile} from "react-device-detect";

const RegisterMiniHeaderStyle = {
    textAlign: "center",
    margin: "auto",

    fontFamily: "Oswald",

    fontSize: "180%"
}

if (isMobile) {
    RegisterMiniHeaderStyle.fontSize = "160%";
}

export default RegisterMiniHeaderStyle;
