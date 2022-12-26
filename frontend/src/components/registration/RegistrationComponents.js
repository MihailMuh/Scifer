import RegistrationLayout from "./RegistrationLayout";
import deleteRefs from "../../img/delete.svg";
import React from "react";
import addRefs from "../../img/addRefs.svg";
import {isDesktop} from "react-device-detect";
import "./styles/textarea.css"

class RegistrationComponents extends RegistrationLayout {
    constructor(props) {
        super(props);

        this.addRefsImgClassName = isDesktop ? "addRefsDesktop" : "addRefsMobile";
    }

    createRefToArticle = (index) => {
        return (
            <tr key={`trRefToArticles_${index}`}>
                <td align="center" width={"100%"}>
                    <input type="url" ref={this.allNodeRefs.refsToArticle[`refToArticle_${index}`]}
                           placeholder="URL"/>
                </td>
                <td align="center">
                    <img className={"deleteRefs"} width={30} height={30} src={deleteRefs} alt={"deleteRefs"}
                         onClick={this.deleteRefToArticle}/>
                </td>
            </tr>
        );
    }

    createRefToQualifyingWork = (index) => {
        return (
            <tr key={`trRefToQualifyingWorks_${index}`}>
                <td align="center" width={"100%"}>
                    <input type="url" ref={this.allNodeRefs.refsToQualifyingWorks[`refToQualifyingWork_${index}`]}
                           placeholder="URL"/>
                </td>
                <td align="center">
                    <img className={"deleteRefs"} width={30} height={30} src={deleteRefs}
                         alt={"deleteRefs"} onClick={this.deleteRefToQualifyingWork}/>
                </td>
            </tr>
        );
    }

    getLayout = () => {
        return {
            "nameInput": <input type="text" ref={this.allNodeRefs["nameInput"]} placeholder="Имя"
                                defaultValue={this.props["name"]}/>,

            "surnameInput": <input type="text" ref={this.allNodeRefs["surnameInput"]} placeholder="Фамилия"
                                   defaultValue={this.props["surname"]}/>,

            "patronymicInput":
                <div className={"divTip"}>
                    <input type="text" ref={this.allNodeRefs["patronymicInput"]} placeholder="Отчество"
                           autoFocus={true}>
                    </input>
                    <span className={"tip"}>Необязательное поле</span>
                </div>,

            "specializationInput": <input type="text" ref={this.allNodeRefs["specializationInput"]}
                                          placeholder="Специальность"/>,

            "selectUserType":
                <select ref={this.allNodeRefs["selectUserType"]} onChange={this.handleSelectUserType}>
                    <option style={{color: "#7c6084"}} value="">Выберете свой статус</option>
                    <option value="student">Студент</option>
                    <option value="postgraduate">Студент-аспирант</option>
                    <option value="scientist">Научный сотрудник</option>
                    <option value="mentor">Научный руководитель</option>
                </select>,

            "addRefsImageForArticles": <img className={this.addRefsImgClassName} width={70} height={70} src={addRefs}
                                            alt={"addRefs"} align={"center"} onClick={this.addRefToArticle}/>,

            "interestsTextarea": <textarea ref={this.allNodeRefs["interestsTextarea"]}/>,

            "academicDegree":
                <div className={"divTip"}>
                    <input type="text" ref={this.allNodeRefs["academicDegree"]} placeholder="Ученое звание"/>
                    <span className={"tip"}>Необязательное поле</span>
                </div>,
            "academicTitle":
                <div className={"divTip"}>
                    <input type="text" ref={this.allNodeRefs["academicTitle"]} placeholder="Ученая степень"/>
                    <span className={"tip"}>Необязательное поле</span>
                </div>,
            "position":
                <input type="text" ref={this.allNodeRefs["position"]} placeholder="Должность"/>,

            "addRefsImageForWorks":
                <img className={this.addRefsImgClassName} width={70} height={70} src={addRefs}
                     alt={"addRefs"} align={"center"} onClick={this.addRefToQualifyingWork}/>,
        }
    }
}

export default RegistrationComponents;
