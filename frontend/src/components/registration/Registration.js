import RegisterBGStyle from "./styles/register/RegisterBGStyle"
import React from "react";
import RegisterHeaderStyle from "./styles/register/RegisterHeaderStyle";
import "./styles/register/registration.css";
import {isDesktop, isMobile} from "react-device-detect";
import RegistrationDesktop from "./RegistrationDesktop";
import RegistrationMobile from "./RegistrationMobile";

const user = JSON.parse(sessionStorage.getItem("user"))

class Registration extends React.Component {
    async getAccessToken() {
        const response = await fetch(
            '/get-access',
            {
                method: 'POST',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json; charset=utf8',
                },
                body: this.props.code
            })

        return await response.json()
    }

    componentDidMount() {
        this.getAccessToken().then((data) => {
            if (!data.access_token) {
                window.location.assign(window.location.href.split("?")[0]);
            }

            user.acessToken = data.access_token;
        })
    }

    render() {
        return (
            <div style={RegisterBGStyle} id="Registration">
                <h1 style={RegisterHeaderStyle}>Регистрация</h1>

                {isMobile && <RegistrationMobile name={user.name} surname={user.surname}/>}
                {isDesktop && <RegistrationDesktop name={user.name} surname={user.surname}/>}
            </div>
        )
    }
}

export default Registration;
