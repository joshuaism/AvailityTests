import React from 'react';
import { Grid, Row, Col } from 'react-flexbox-grid';

const initialState = {
  firstName: "",
  lastName: "",
  NPINumber: "",
  streetAddress: "",
  streetAddress2: "",
  city: "",
  state: "",
  zip: "",
  phoneNumber: "",
  ext: "",
  emailAddress: "",
  submitted: false,
}


class FormInput extends React.Component {
  constructor(props){
    super(props);
    this.state = initialState;

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(event){
    event.preventDefault();
    this.setState({...initialState, submitted: true});
  }

  handleChange(event){
    this.setState({[event.target.name]: event.target.value, submitted: false});
  }

  render() {
    return(
      <div>
        <form onSubmit = {this.handleSubmit}>
          <Grid>
            <Row>
              <Col>
                <label>
                  First Name:
                  <input type="test" name="firstName" value={this.state.firstName} onChange={this.handleChange} />
                </label>
              </Col>
              <Col xs={6} md={4}>
                <label>
                  Last Name:
                  <input type="test" name="lastName" value={this.state.lastName} onChange={this.handleChange} />
                </label>
              </Col>

              <Col xs={6} md={3}>
                <label>
                  NPI Number:
                  <input type="test" name="NPINumber" value={this.state.NPINumber} onChange={this.handleChange} />
                </label>
              </Col>
            </Row>
            <Row>
              <Col >
                <label>
                  Street Address:
                  <input type="test" name="streetAddress" value={this.state.streetAddress} onChange={this.handleChange} className="margin-right"/>
                </label>
              </Col>
              <Col xs={6} md={3}>
                <label>
                  Address Line 2:
                  <input type="test" name="streetAddress2" value={this.state.streetAddress2} onChange={this.handleChange} />
                </label>
              </Col>
            </Row>
            <Row>
              <Col>
                <label>
                  City:
                  <input type="test" name="city" value={this.state.city} onChange={this.handleChange} />
                </label>
              </Col>
              <Col xs={6} md={3}>
                <label>
                  State:
                  <input type="test" name="state" value={this.state.state} onChange={this.handleChange} />
                </label>
              </Col>
              <Col xs={6} md={3}>
                <label>
                  Zip:
                  <input type="test" name="zip" value={this.state.zip} onChange={this.handleChange} />
                </label>
              </Col>
            </Row>
            <Row>
              <Col>
                <label>
                  Phone:
                  <input type="test" name="phoneNumber" value={this.state.phoneNumber} onChange={this.handleChange} pattern/>
                </label>
              </Col>
              <Col xs={6} md={3}>
                <label>
                  Ext:
                  <input type="test" name="ext" value={this.state.ext} onChange={this.handleChange} />
                </label>
              </Col>
              <Col xs={6} md={3}>
                <label>
                  Email:
                  <input type="test" name="emailAddress" value={this.state.emailAddress} onChange={this.handleChange} />
                </label>
              </Col>
            </Row>
            <Row>
              <input type="submit" value="Submit" className="submit-button"/>
            </Row>
            <Row>
              {this.state.submitted && <div>Thank you for submitting.</div>}
            </Row>
          </Grid>
        </form>
      </div>
  )
  }
}

export default FormInput;
