import {isMobile} from "react-device-detect";

const GreeterHeaderStyle = {
    fontWeight: "bold",
    fontFamily: "Oswald",
    color: "#153128",

    paddingBottom: "2%",

    fontSize: "240%"
}

if (isMobile) {
    GreeterHeaderStyle.fontSize = "150%";
    GreeterHeaderStyle.paddingBottom = "5%"
}

export default GreeterHeaderStyle;
