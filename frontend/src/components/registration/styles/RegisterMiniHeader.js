import {isMobile} from "react-device-detect";

const RegisterMiniHeader = {
    margin: "auto",
    textAlign: "center",

    fontWeight: "bold",
    fontFamily: "Oswald",

    fontSize: "180%"
}

if (isMobile) {
    RegisterMiniHeader.fontSize = "160%";
}

export default RegisterMiniHeader;
