import VK, {Auth} from "react-vk";
import VKStyle from "./VKStyle";
import React from "react";

class VKAuth extends React.Component {
    authenticate = (data) => {
        console.log(data)
    }

    render() {
        return (
            <div style={VKStyle}>
                <VK apiId={51462366} style={VKStyle}>
                    <Auth onAuth={this.authenticate}/>
                </VK>
            </div>
        );
    }
}

export default VKAuth;
