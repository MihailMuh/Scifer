const VKStyle = {
    margin: "0 10%",

    borderRadius: "5px",
    boxShadow: "0 0 10px rgba(0, 0, 0, 1)",

    width: "300px",
}

if (window.screen.width < 800) {
    VKStyle.margin = "0 auto";
}

export default VKStyle;
