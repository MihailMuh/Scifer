import InputStyle from "./styles/InputStyle";
import RegisterMiniHeader from "./styles/RegisterMiniHeader";
import addRefs from "../../img/addRefs.svg";
import deleteRefs from "../../img/delete.svg";
import "./styles/addRefsDesktop.css";
import TextareaStyle from "./styles/TextareaStyle";
import BaseRegistration from "./BaseRegistration";

class RegistrationDesktop extends BaseRegistration {
    render() {
        return (
            <div>
                <table width={"100%"}>
                    <tr>
                        <td align="center">
                            <input type="text" id="name" placeholder="Имя" style={InputStyle} value={this.props.name}/>
                        </td>
                        <td align="center" colSpan={2}>
                            <input type="text" id="surname" placeholder="Фамилия" style={InputStyle}
                                   value={this.props.surname}/>
                        </td>
                        <td align="center">
                            <input type="text" id="patronymic" placeholder="Отчество" style={InputStyle}
                                   autoFocus={true}/>
                        </td>
                    </tr>

                    <tr>
                        <td align="center" colSpan={2}>
                            <input type="text" id="specialization" placeholder="Специальность" style={InputStyle}/>
                        </td>
                        <td align="right" colSpan={2}>
                            <select id="type" onChange={this.handleSelectUserType}>
                                <option value="">Выберете свой статус</option>
                                <option value="student">Студент</option>
                                <option value="postgraduate">Студент-аспирант</option>
                                <option value="scientist">Научный сотрудник</option>
                                <option value="mentor">Научный руководитель</option>
                            </select>
                        </td>
                    </tr>
                </table>

                <br/>
                <h1 style={RegisterMiniHeader}>Ссылки на публикации:</h1>
                <br/>
                <table>
                    {this.refsToArticle.map((item, index) =>
                        <tr>
                            <td align="center" width={"100%"}>
                                <input type="url" id={"refToArticle" + index} placeholder="URL" style={InputStyle}/>
                            </td>
                            <td align="center">
                                <img className={"deleteRefs"} width={30} height={30} src={deleteRefs}
                                     alt={"deleteRefs"} onClick={this.deleteRefToArticle}/>
                            </td>
                        </tr>
                    )}
                </table>
                <img className={"addRefsDesktop"} width={70} height={70} src={addRefs}
                     alt={"addRefs"} align={"center"} onClick={this.addRefToArticle}/>

                {this.state.userType === 1 &&
                    <div>
                        <br/>
                        <h1 style={RegisterMiniHeader}>Область научных интересов:</h1>
                        <textarea style={TextareaStyle} id={"interests"}/>
                    </div>
                }

                {this.state.userType === 2 &&
                    <div>
                        <br/><br/>
                        <table width={"100%"}>
                            <tr>
                                <td align="center" colSpan={3}>
                                    <input type="text" id="academicDegree" placeholder="Ученое звание"
                                           style={InputStyle}/>
                                </td>
                                <td align="center" colSpan={3}>
                                    <input type="text" id="academicTitle" placeholder="Ученая степень"
                                           style={InputStyle}/>
                                </td>
                            </tr>

                            <tr>
                                <td align="center" colSpan={6}>
                                    <input type="text" id="position" placeholder="Должность" style={InputStyle}/>
                                </td>
                            </tr>
                        </table>

                        <br/>
                        <h1 style={RegisterMiniHeader}>Ссылки на квалификационные работы:</h1>
                        <br/>
                        <table>
                            {this.refsToQualifyingWorks.map((item, index) =>
                                <tr>
                                    <td align="center" width={"100%"}>
                                        <input type="url" id={"refToQualifyingWork" + index} placeholder="URL"
                                               style={InputStyle}/>
                                    </td>
                                    <td align="center">
                                        <img className={"deleteRefs"} width={30} height={30} src={deleteRefs}
                                             alt={"deleteRefs"} onClick={this.deleteRefToQualifyingWork}/>
                                    </td>
                                </tr>
                            )}
                        </table>
                        <img className={"addRefsDesktop"} width={70} height={70} src={addRefs}
                             alt={"addRefs"} align={"center"} onClick={this.addRefToQualifyingWork}/>
                    </div>
                }
                <br/><br/><br/><br/>

                {this.state.userType !== 0 &&
                    <button>Подтвердить</button>
                }
            </div>
        )
    }
}

export default RegistrationDesktop;
