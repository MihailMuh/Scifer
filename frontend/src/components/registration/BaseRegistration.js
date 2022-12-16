import React from "react";

class BaseRegistration extends React.Component {
    constructor(props) {
        super(props);

        this.refsToArticle = [];
        this.refsToQualifyingWorks = [];
        this.state = {
            clicked: false,
            userType: 0 // 0: non-selected, 1: student, 2: scientist
        };
        this.allNodeRefs = {
            "nameInput": React.createRef(),
            "surnameInput": React.createRef(),
            "patronymicInput": React.createRef(),
            "specializationInput": React.createRef(),
            "selectUserType": React.createRef(),
            "refsToArticle": {},
            "interestsTextarea": React.createRef(),
            "academicDegreeInput": React.createRef(),
            "academicTitleInput": React.createRef(),
            "positionInput": React.createRef(),
            "refsToQualifyingWorks": {},
        };
    }

    updateState = () => {
        this.setState(previousState => ({
            clicked: true,
            userType: previousState.userType
        }));
    }

    deleteRefToArticle = () => {
        this.refsToArticle.pop();
        delete this.allNodeRefs.refsToArticle[`refToArticle_${this.refsToArticle.length}`];

        this.updateState();
    }

    addRefToArticle = () => {
        const len = this.refsToArticle.length
        this.allNodeRefs.refsToArticle[`refToArticle_${len}`] = React.createRef();
        this.refsToArticle.push(len);

        this.updateState();
    }

    deleteRefToQualifyingWork = () => {
        this.refsToQualifyingWorks.pop();
        delete this.allNodeRefs.refsToQualifyingWorks[`refToArticle_${this.refsToQualifyingWorks.length}`];

        this.updateState();
    }

    addRefToQualifyingWork = () => {
        const len = this.refsToQualifyingWorks.length
        this.allNodeRefs.refsToQualifyingWorks[`refToQualifyingWork_${len}`] = React.createRef();
        this.refsToQualifyingWorks.push(len);

        this.updateState();
    }

    interpretUserSelect = () => {
        switch (this.allNodeRefs["selectUserType"].current.options.selectedIndex) {
            case 1:
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
            default:
                return 0;
        }
    }

    handleSelectUserType = () => {
        this.setState({
            clicked: true,
            userType: this.interpretUserSelect()
        });
    }
}

export default BaseRegistration;
