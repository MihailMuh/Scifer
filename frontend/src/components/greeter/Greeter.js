import GreeterStyle from "./styles/GreeterStyle"
import GreeterHeader5Style from "./styles/GreeterHeader5Style"
import GreeterHeaderStyle from "./styles/GreeterHeaderStyle"
import VkAuth from "./auth/vk/VkAuth";

const Greeter = () => {
    return (
        <div style={GreeterStyle}>
            <h1 style={GreeterHeaderStyle}>
                <span style={{fontSize: "150%", color: "#240d3b"}}><i>Scifer</i></span> - это приложение, призванное
                помочь студентам и<br/>руководителям организовать свою научную деятельность</h1>
            <h1 style={GreeterHeader5Style}>Найди сплоченные команды и лучших наставников!</h1>
            <VkAuth/>
        </div>
    )
}

export default Greeter;
