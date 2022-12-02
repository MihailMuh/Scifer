import React from "react";

class BaseRegistration extends React.Component {
    constructor(props) {
        super(props);

        this.refsToArticle = [];
        this.refsToQualifyingWorks = [];
        this.state = {
            clicked: false,
            userType: 0 // 0: non-selected, 1: student, 2: scientist
        }
    }

    updateState = () => {
        this.setState(previousState => ({
            clicked: true,
            userType: previousState.userType
        }));
    }

    deleteRefToArticle = () => {
        this.refsToArticle.pop();
        this.updateState();
    }

    addRefToArticle = () => {
        this.refsToArticle.push(0);
        this.updateState();
    }

    deleteRefToQualifyingWork = () => {
        this.refsToQualifyingWorks.pop();
        this.updateState();
    }

    addRefToQualifyingWork = () => {
        this.refsToQualifyingWorks.push(0);
        this.updateState();
    }

    interpretUserSelect = () => {
        switch (document.getElementById("type").options.selectedIndex) {
            case 1:
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
        }
        return 0;
    }

    handleSelectUserType = () => {
        this.setState({
            clicked: true,
            userType: this.interpretUserSelect()
        });
    }
}

export default BaseRegistration;
