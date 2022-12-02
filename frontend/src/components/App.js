import AppStyle from './AppStyle';
import Greeter from './greeter/Greeter';
import React from "react";
import WebFont from "webfontloader";
import Registration from "./registration/Registration";

const vkCodeForAccess = window.location.href.split("?code=")

class App extends React.Component {
    componentDidMount() {
        WebFont.load({
            google: {
                families: ['Oswald']
            }
        });
    }

    render() {
        if (vkCodeForAccess.length === 2) {
            return (
                <div style={AppStyle}>
                    <Registration code={vkCodeForAccess[1]}/>
                </div>
            );
        }
        return (
            <div style={AppStyle}>
                <Greeter/>
            </div>
        );
    }
}

export default App;
