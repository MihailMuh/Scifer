import React from "react";
import BaseRegistration from "./BaseRegistration";
import {isDesktop, isMobile} from "react-device-detect";
import RegisterMiniHeaderStyle from "./styles/register/RegisterMiniHeaderStyle";
import ApplyButton from "./components/ApplyButton";

class RegistrationLayout extends BaseRegistration {
    createRefToArticle = () => {
        return <tr></tr>
    }

    createRefToQualifyingWork = () => {
        return <tr></tr>
    }

    getLayout = () => {
        return {};
    }

    render() {
        const layout = this.getLayout();

        return (
            <div>
                {isDesktop &&
                    <div>
                        <table width={"100%"}>
                            <tbody>
                            <tr>
                                <td align="center">
                                    {layout["nameInput"]}
                                </td>
                                <td align="center" colSpan={2}>
                                    {layout["surnameInput"]}
                                </td>
                                <td align="center">
                                    {layout["patronymicInput"]}
                                </td>
                            </tr>

                            <tr>
                                <td align="center" colSpan={2}>
                                    {layout["specializationInput"]}
                                </td>
                                <td align="right" colSpan={2}>
                                    {layout["selectUserType"]}
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <br/>
                    </div>
                }
                {isMobile &&
                    <div>
                        {layout["nameInput"]}
                        <br/><br/>

                        {layout["surnameInput"]}
                        <br/><br/>

                        {layout["patronymicInput"]}
                        <br/><br/>

                        {layout["specializationInput"]}
                        <br/><br/>

                        {layout["selectUserType"]}
                        <br/><br/><br/>
                    </div>
                }
                <h1 style={RegisterMiniHeaderStyle}>Ссылки на публикации:</h1>
                <br/>
                <table>
                    <tbody>
                    {this.refsToArticle.map(this.createRefToArticle)}
                    </tbody>
                </table>
                {layout["addRefsImageForArticles"]}

                {isMobile && <div><br/><br/></div>}

                {this.state.userType === 1 &&
                    <div>
                        <br/>
                        <h1 style={RegisterMiniHeaderStyle}>Область научных интересов:</h1>
                        {layout["interestsTextarea"]}
                    </div>
                }

                {this.state.userType === 2 &&
                    <div>
                        <br/><br/>

                        {isDesktop &&
                            <table width={"100%"}>
                                <tbody>
                                <tr>
                                    <td align="center" colSpan={3}>
                                        {layout["academicDegree"]}
                                    </td>
                                    <td align="center" colSpan={3}>
                                        {layout["academicTitle"]}
                                    </td>
                                </tr>

                                <tr>
                                    <td align="center" colSpan={6}>
                                        {layout["position"]}
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        }

                        {isMobile &&
                            <div>
                                <br/><br/>
                                {layout["academicDegree"]}

                                <br/><br/>
                                {layout["academicTitle"]}

                                <br/><br/>
                                {layout["position"]}

                                <br/><br/>
                            </div>
                        }

                        <br/>
                        <h1 style={RegisterMiniHeaderStyle}>Ссылки на квалификационные работы:</h1>
                        <br/>
                        <table>
                            <tbody>
                            {this.refsToQualifyingWorks.map(this.createRefToQualifyingWork)}
                            </tbody>
                        </table>
                        {layout["addRefsImageForWorks"]}
                    </div>
                }

                <br/><br/><br/><br/>

                <ApplyButton allNodeRefs={this.allNodeRefs} interpretUserSelect={this.interpretUserSelect}/>
            </div>
        );
    }
}

export default RegistrationLayout;
