import {isMobile} from "react-device-detect";

const GreeterHeader5Style = {
    fontWeight: "bold",
    fontFamily: "avenir, helvetica, sans-serif",
    color: "#7c6084",

    paddingBottom: "5%",

    fontSize: "180%"
}

if (isMobile) {
    GreeterHeader5Style.fontSize = "110%";
    GreeterHeader5Style.paddingBottom = "15%";
}

export default GreeterHeader5Style;
