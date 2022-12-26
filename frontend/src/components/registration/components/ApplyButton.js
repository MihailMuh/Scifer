import React from "react";

class ApplyButton extends React.Component {
    hasEmptyNodes = () => {
        const nodes = this.props.allNodeRefs;
        const userType = this.props.interpretUserSelect();

        return !(
            !nodes["nameInput"].current.value ||
            !nodes["surnameInput"].current.value ||
            !nodes["specializationInput"].current.value ||
            userType === 0 ||
            (userType === 1 && !nodes["interestsTextarea"].current.value) ||
            (userType === 2 && !nodes["positionInput"].current.value)
        );
    }

    isDataValid = () => {
        const nodes = this.props.allNodeRefs;

        return (
            !(/\d/.test(nodes["nameInput"].current.value)) &&
            !(/\d/.test(nodes["surnameInput"].current.value)) &&
            !(/\d/.test(nodes["patronymicInput"].current.value)) &&
            !(/\d/.test(nodes["specializationInput"].current.value))
        )
    }

    handleRegistration = () => {
    }

    render() {
        return (
            <div>
                <button onClick={this.handleRegistration}>Подтвердить</button>
                <br/><br/>
            </div>
        )
    }
}

export default ApplyButton;
