import React, { Component, useState } from 'react';
import { withTranslation } from 'react-i18next';
import { Button, Card, CardBody, CardHeader, Col, FormGroup, Label, Input, Row, Dropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import CertificatesApi from '../../services/CertificatesApi';



class AddCertificate extends Component {

    constructor() {
        super();

        this.addCertificateHandler = this.addCertificateHandler.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

        this.state = {
            enterprises: [],
            selectedEnterprise: "",
            validationError: ""
        };
    }

    componentDidMount() {
        document.title = "Add Certificate";


        fetch(
            'api/client/getAllEnterprisesInSystem')
            .then(response => {
                return response.json();
            })
            .then(data => {
                let enterprisesFromApi = data.map(enterprise => {
                    return { value: enterprise.enterpriseId, display: enterprise.name };
                });
                this.setState({
                    enterprises: [
                        {
                            value: "",
                            display:
                                "(Select your enterprise)"
                        }
                    ].concat(enterprisesFromApi)
                });
            })
            .catch(error => {
                console.log(error);
            });
    }

    addCertificateHandler = (certificate, callback) => CertificatesApi.createCertificate(certificate, callback);

    handleSubmit = (event) => {
        event.preventDefault();

        var data = {
            enterpriseId: parseFloat(this.state.selectedEnterprise),
        };

        this.addCertificateHandler(data, () => this.props.history.push('/certificates'));
    }

    render() {
        const { t } = this.props;
        return (
            <div className="animated fadeIn">
                <Row>
                    <Col xs="12" md="7">
                        <Card>
                            <CardHeader>
                                <strong>{t("Add Certificate")}</strong>
                            </CardHeader>
                            <CardBody>
                                <form onSubmit={this.handleSubmit} className="form-horizontal">
                                    <FormGroup row>
                                        <Col md="3">
                                            <Label htmlFor="professional">{t("Enterprise Name")}</Label>
                                        </Col>
                                        <Col xs="12" md="9">
                                            <div>
                                                <select
                                                    value={this.state.selectedEnterprise}
                                                    onChange={e =>
                                                        this.setState({
                                                            selectedEnterprise: e.target.value,
                                                            validationError:
                                                                e.target.value === ""
                                                                    ? "You must select your enterprise"
                                                                    : ""
                                                        })
                                                    }

                                                >
                                                    {this.state.enterprises.map(enterprise => (
                                                        <option
                                                            key={enterprise.value}
                                                            value={enterprise.value}
                                                        >
                                                            {enterprise.display}
                                                        </option>
                                                    ))}
                                                </select>
                                                <div
                                                    style={{
                                                        color: "red",
                                                        marginTop: "5px"
                                                    }}
                                                >
                                                    {this.state.validationError}
                                                </div>
                                            </div>
                                        </Col>
                                    </FormGroup>
                                    
                                    <Button type="submit" color="primary">{t("Submit")}</Button>
                                </form>
                            </CardBody>
                        </Card>
                    </Col>
                </Row>
            </div>
        )
    }
}


export default withTranslation()(AddCertificate);
