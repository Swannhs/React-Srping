import React, { Component } from "react";

class ProjectItem extends Component {
  render() {
    const { project } = this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <span className="mx-auto">{project.userIdentifier}</span>
            </div>
            <div className="col-lg-6 col-md-4 col-8">
              <h3>{project.title}</h3>
              <p>{project.content}</p>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ProjectItem;
